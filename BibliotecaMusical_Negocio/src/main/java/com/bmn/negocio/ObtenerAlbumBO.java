/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.negocio;

import com.bmd.dao.FavoritoDAO;
import com.bmd.daoInterfaces.IAlbumDAO;
import com.bmn.dto.AlbumDTO;
import com.bmn.dto.UsuarioDTO;
import com.bmn.excepciones.BOException;
import com.bmn.interfaces.IObtenerAlbumBO;

/**
 *
 * @author skevi
 */
public class ObtenerAlbumBO implements IObtenerAlbumBO {
    
    private IAlbumDAO albumDAO;
    private FavoritoDAO favorito;

    public ObtenerAlbumBO(IAlbumDAO albumDAO) {
        this.albumDAO = albumDAO;
    }

    @Override
    public AlbumDTO obtenerAlbum(String id, UsuarioDTO usuario) throws BOException {
        validarCampos(id, usuario);
        return procesarObtenerAlbum(id, usuario);
    }
    
    private void validarCampos(String id, UsuarioDTO usuario) throws BOException {
        
    }
    
    private AlbumDTO procesarObtenerAlbum(String id, UsuarioDTO usuario) throws BOException {
        return null;
    }
    
    private void verificarFavorito(AlbumDTO album) throws BOException{
        
    }
    
    private void verificarCancionFavorita() throws BOException {
        
    }
    
}
