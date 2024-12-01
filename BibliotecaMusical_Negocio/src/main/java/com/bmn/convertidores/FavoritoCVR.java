/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.convertidores;

import com.bmd.entities.Favorito;
import com.bmd.enums.Tipo;
import com.bmn.dto.FavoritoDTO;

/**
 *
 * @author skevi
 */
public class FavoritoCVR { 
    
    
    public Favorito toFavorito(FavoritoDTO favoritoDTO){
        if (favoritoDTO == null) {
            return null;
        }
        
        Favorito favorito = new Favorito.Builder().
                setIdUsuario(favoritoDTO.getIdUsuario()).
                setIdReferencia(favoritoDTO.getIdReferencia()).
                setTipo(Tipo.valueOf(favoritoDTO.getTipo().name())).
                setFechaAgregacion(favoritoDTO.getFechaAgregacion()).
                build();
        return favorito;
    }
    
}
