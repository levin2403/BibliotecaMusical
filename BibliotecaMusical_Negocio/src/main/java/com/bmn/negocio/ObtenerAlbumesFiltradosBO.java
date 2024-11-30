/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.negocio;

import com.bdm.excepciones.DAOException;
import com.bmd.daoInterfaces.IAlbumDAO;
import com.bmd.entities.Album;
import com.bmd.enums.Genero;
import com.bmn.convertidores.AlbumCVR;
import com.bmn.dto.AlbumDTO;
import com.bmn.dto.UsuarioDTO;
import com.bmn.dto.constantes.GeneroDTO;
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
    private AlbumCVR albumCVR;

    public ObtenerAlbumesFiltradosBO(IAlbumDAO albumDAO, AlbumCVR albumCVR) {
        this.albumDAO = albumDAO;
        this.albumCVR = albumCVR;
    }
    
    @Override
    public List<AlbumDTO> BuscarPorFiltro(String nombre, LocalDate fecha, 
            GeneroDTO genero) throws BOException {
        
        return procesar(nombre, fecha, genero);
        
    }
    
    private List<AlbumDTO> procesar(String nombre, LocalDate fecha, 
            GeneroDTO generoDTO) throws BOException {
       try{
            //trasnformamos el genero
            Genero genero = Genero.valueOf(generoDTO.name());
            
            //obtenemos el id del usuario logeado
            String idUsuario = UsuarioST.getInstance().getId();
            
            //lista traida de la base de datos;
            List<Album> albumes = albumDAO.BuscarPorFiltro(nombre, fecha, genero, idUsuario);
            List<AlbumDTO> albumesDTO = new ArrayList<>();
            
            for (Album album : albumes) {
                albumesDTO.add(albumCVR.toAlbumDTO(album));
            }
            
            return albumesDTO;
        }
        catch(DAOException ex){
            throw new BOException(ex.getMessage());
        }
    }

}
