/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.negocio;

import com.bdm.excepciones.DAOException;
import com.bmd.daoInterfaces.IAlbumDAO;
import com.bmd.entities.Album;
import com.bmn.dto.AlbumVistaDTO;
import com.bmn.dto.ArtistaVistaDTO;
import com.bmn.dto.constantes.Genero;
import com.bmn.excepciones.BOException;
import com.bmn.interfaces.IObtenerAlbumesFiltradosBO;
import com.bmn.singletonUsuario.UsuarioST;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skevi
 */
public class ObtenerAlbumesFiltradosBO implements IObtenerAlbumesFiltradosBO {

    private IAlbumDAO albumDAO;

    public ObtenerAlbumesFiltradosBO(IAlbumDAO albumDAO) {
        this.albumDAO = albumDAO;
    }
    
    @Override
    public List<AlbumVistaDTO> BuscarPorFiltro(String nombre, LocalDate fecha, 
            Genero genero) throws BOException {
        
        return procesar(nombre, fecha, genero);
        
    }
    
    private List<AlbumVistaDTO> procesar(String nombre, LocalDate fecha, 
            Genero genero) throws BOException {
       try{
            //trasnformamos el genero
            String genero1 = genero.name();
            
            //obtenemos el id del usuario logeado
            String idUsuario = UsuarioST.getInstance().getId().toString();
            
            //lista traida de la base de datos;
            List<Album> albumes = albumDAO.BuscarPorFiltro(nombre, fecha, 
                    genero1, idUsuario);
            List<AlbumVistaDTO> albumesDTO = new ArrayList<>();
            
            for (Album album : albumes) {
                albumesDTO.add(toAlbumvistaDTO(album));
            }
            
            return albumesDTO;
        }
        catch(DAOException ex){
            throw new BOException(ex.getMessage());
        }
    }

    private AlbumVistaDTO toAlbumvistaDTO(Album album){
        return new AlbumVistaDTO(
            album.getId().toString(),
            album.getNombre(),
            album.getImagenPortada(),
                new ArtistaVistaDTO(
                    album.getArtista().getId().toString(),
                    album.getArtista().getNombre(),
                    album.getArtista().getImagen()
                )
        );
    }
    
}
