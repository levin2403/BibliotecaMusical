/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.negocio;

import com.bdm.excepciones.DAOException;
import com.bmd.dao.FavoritoDAO;
import com.bmd.daoInterfaces.IAlbumDAO;
import com.bmd.entities.Album;
import com.bmn.convertidores.AlbumCVR;
import com.bmn.dto.AlbumDTO;
import com.bmn.dto.CancionDTO;
import com.bmn.excepciones.BOException;
import com.bmn.interfaces.IObtenerAlbumBO;
import com.bmn.singletonUsuario.UsuarioST;

/**
 *
 * @author skevi
 */
public class ObtenerAlbumBO implements IObtenerAlbumBO {
    
    private IAlbumDAO albumDAO;
    private FavoritoDAO favoritoDAO;
    private AlbumCVR albumCVR;

    public ObtenerAlbumBO(IAlbumDAO albumDAO, FavoritoDAO favoritoDAO, AlbumCVR albumCVR) {
        this.albumDAO = albumDAO;
        this.favoritoDAO = favoritoDAO;
        this.albumCVR = albumCVR;
    }

    @Override
    public AlbumDTO obtenerAlbum(String idAlbum, String idUsuario) throws BOException {
        validarCampos(idAlbum, idUsuario);
        return procesarObtenerAlbum(idAlbum, idUsuario);
    }
    
    private void validarCampos(String id, String idUsuario) throws BOException {
        if (id == null) {
            throw new BOException("El id no puede ser nulo");
        }
        if (idUsuario == null) {
            throw new BOException("El id del usuario no puede ser nulo");
        }
    }
    
    private AlbumDTO procesarObtenerAlbum(String idAlbum, String idUsuario) throws BOException {
        try{
            //obtenemos el album
            Album album = albumDAO.obtenerAlbum(idAlbum, idUsuario);
            
            //convertimos a dto
            AlbumDTO albumDTO = albumCVR.toAlbumDTO(album);
            
            //en caso de que no regrese nada regresamos nulo.
            if (albumDTO == null) {
                return null;
            }
            
            //obtenemos el id del usuario que se encuentra loggeado.
            String usuarioId = UsuarioST.getInstance().getId();
            
            //verificamos si el album es favorito
            verificarFavorito(albumDTO, usuarioId);
            
            //verificamos si algunas de las canciones en el album es favorita
            verificarCancionFavorita(albumDTO, usuarioId);
            
            return albumDTO;
            
        }
        catch(DAOException ex){
            throw new BOException(ex.getMessage());
        }
    }
    
    /**
     * verifica si el album esta en favoritos 
     * @param album
     * @param idUsuario
     * @throws BOException 
     */
    private void verificarFavorito(AlbumDTO album, String idUsuario) throws BOException{
        try{
            if (favoritoDAO.isFavorito(album.getId(), idUsuario)) {
                album.setFavorito(true);
            }
            else{
                album.setFavorito(false);
            }
        }catch(DAOException ex){
            throw new BOException(ex.getMessage());
        }
    }
    
    /**
     * verifica si la cacion esta en favoritos
     * 
     * @param cancion
     * @param idUsuario
     * @throws BOException 
     */
    private void verificarCancionFavorita(AlbumDTO album, String idUsuario) throws BOException {
        try{
            
            for (CancionDTO cancion : album.getCanciones()) {
                if (favoritoDAO.verificarCancionFavorita(cancion.getNombre(), album.getId(), idUsuario)) {
                    cancion.setFavorito(true);
                }
                else{
                    cancion.setFavorito(false);
                }
            }
            
        }catch(DAOException ex){
            throw new BOException(ex.getMessage());
        }
    }
    
}
