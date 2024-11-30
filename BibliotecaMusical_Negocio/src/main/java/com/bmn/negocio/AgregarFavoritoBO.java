/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.negocio;

import com.bdm.excepciones.DAOException;
import com.bmd.daoInterfaces.IFavoritoDAO;
import com.bmd.entities.Favorito;
import com.bmn.convertidores.FavoritoCVR;
import com.bmn.dto.FavoritoDTO;
import com.bmn.dto.UsuarioDTO;
import com.bmn.excepciones.BOException;
import com.bmn.interfaces.IAgregarFavoritoBO;
import com.bmn.singletonUsuario.UsuarioST;

/**
 *
 * @author skevi
 */
public class AgregarFavoritoBO implements IAgregarFavoritoBO {
    
    private IFavoritoDAO favoritoDAO;
    private FavoritoCVR favoritoCVR;

    public AgregarFavoritoBO(IFavoritoDAO favoritoDAO, FavoritoCVR favoritoCVR) {
        this.favoritoDAO = favoritoDAO;
        this.favoritoCVR = favoritoCVR;
    }

    @Override
    public boolean agregarFavorito(FavoritoDTO favorito, UsuarioDTO usuario) throws BOException {
        verificarCampos(favorito, usuario);
        return verificarFavorito(favorito, usuario);
    }
    
    private void verificarCampos(FavoritoDTO favorito, UsuarioDTO usuarioDTO)throws BOException {
        if (favorito.getIdUsuario().isEmpty()) {
            throw new BOException("La referencia al usuario no puede estar vacia.");
        }
        if (favorito.getIdReferencia().isEmpty()) {
            throw new BOException("La referencia no puede estar vacia.");
        }
        if (favorito.getTipo().name().isEmpty()) {
            throw new BOException("El tipo no puede estar vacio.");
        }
        if (favorito.getFechaAgregacion() == null) {
            throw new BOException("La fecha de agregacion no puede estar vacia.");
        }
    }
    
    private boolean verificarFavorito(FavoritoDTO favoritoDTO, UsuarioDTO usuarioDTO) throws BOException {
        try{
            //transformo de dto a entidad.
            Favorito favorito = favoritoCVR.toFavorito(favoritoDTO);
            
            //transformamos al dto a entidad al usuario.
            String idUsuario = UsuarioST.getInstance().getId();
            
            // si no existe dentro de los favoritos del usuario 
            // lo guardamos
            if (favoritoDAO.verificarExistenciaFavorito(favorito, idUsuario)) { 
                favoritoDAO.agregarFavorito(favorito, idUsuario); 
                return true; //retornamos verdadero porque se agrego.
            }
            else{
                //si no esta en los favoritos del usuario lo eliminamos.
                favoritoDAO.eliminarFavorito(favorito, idUsuario); 
                return false;// retornamos falso porque se elimino.
            }
        }catch(DAOException ex){
            throw new BOException(ex.getMessage());
        }
    }
    
}
