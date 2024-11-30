/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.negocio;

import com.bdm.excepciones.DAOException;
import com.bmd.daoInterfaces.IFavoritoDAO;
import com.bmd.entities.Album;
import com.bmd.enums.Genero;
import com.bmn.convertidores.AlbumCVR;
import com.bmn.dto.AlbumDTO;
import com.bmn.dto.constantes.GeneroDTO;
import com.bmn.excepciones.BOException;
import com.bmn.interfaces.IObtenerAlbumesFavoritosBO;
import com.bmn.singletonUsuario.UsuarioST;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skevi
 */
public class ObtenerAlbumesFavoritosBO implements IObtenerAlbumesFavoritosBO {
   
    private IFavoritoDAO favoritoDAO;
    private AlbumCVR albumCVR;

    public void setFavoritoDAO(IFavoritoDAO favoritoDAO, AlbumCVR albumCVR) {
        this.favoritoDAO = favoritoDAO;
        this.albumCVR = albumCVR;
        
    }

    @Override
    public List<AlbumDTO> obtenerAlbumesFavoritos(GeneroDTO genero, LocalDate fechaAgregacion) throws BOException {
        return procesar(genero, fechaAgregacion);
    }
    
    //aqui obtendras y convertiras los albumes
    private List<AlbumDTO> procesar(GeneroDTO generoDTO, LocalDate fechaAgregacion) throws BOException {
        try{
            //trasnformamos el genero
            Genero genero = Genero.valueOf(generoDTO.name());
            
            //obtenemos el id del usuario logeado
            String idUsuario = UsuarioST.getInstance().getId();
            
            //lista traida de la base de datos;
            List<Album> albumes = favoritoDAO.obtenerAlbumesFavoritos(genero, fechaAgregacion, idUsuario);
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
