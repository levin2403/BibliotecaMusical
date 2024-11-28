/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.negocio;

import com.bmd.daoInterfaces.IUsuarioDAO;
import com.bmn.dto.FavoritoDTO;
import com.bmn.excepciones.BOException;
import com.bmn.interfaces.IAgregarFavoritoBO;

/**
 *
 * @author skevi
 */
public class AgregarFavoritoBO implements IAgregarFavoritoBO {
    
    private IUsuarioDAO userDAO;

    public AgregarFavoritoBO(IUsuarioDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void agregarFavorito(FavoritoDTO favorito) throws BOException {
        verificarCampos(favorito);
        verificarFavorito(favorito);
    }
    
    private void verificarCampos(FavoritoDTO favorito)throws BOException {
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
    
    private void verificarFavorito(FavoritoDTO favorito) throws BOException {
        try{
            
        }catch(Exception e){
            
        }
    }
    
    
}
