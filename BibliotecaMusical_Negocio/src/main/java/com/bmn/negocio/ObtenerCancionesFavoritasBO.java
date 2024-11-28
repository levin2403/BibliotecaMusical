/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.negocio;

import com.bmd.daoInterfaces.IFavoritoDAO;
import com.bmn.dto.constantes.GeneroDTO;
import com.bmn.excepciones.BOException;
import com.bmn.interfaces.IObtenerCancionesFavoritasBO;
import java.time.LocalDate;

/**
 *
 * @author skevi
 */
public class ObtenerCancionesFavoritasBO implements IObtenerCancionesFavoritasBO {

    private IFavoritoDAO favorito;
    
    @Override
    public String obtenerCancionesFavoritas(GeneroDTO genero, 
            LocalDate fechaAgregacion) throws BOException {
        
        return procesar(genero, fechaAgregacion);
        
    }
    
    private String procesar(GeneroDTO genero, 
            LocalDate fechaAgregacion) throws BOException {
        return null;
    }
    
}
