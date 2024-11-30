/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmn.interfaces;

import com.bmn.dto.constantes.GeneroDTO;
import com.bmn.excepciones.BOException;
import java.time.LocalDate;

/**
 *
 * @author skevi
 */
public interface IObtenerCancionesFavoritasBO {
    
    public String obtenerCancionesFavoritas(GeneroDTO genero, 
            LocalDate fechaAgregacion) throws BOException;
    
}
