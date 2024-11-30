/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmn.interfaces;

import com.bmn.dto.CancionDTO;
import com.bmn.dto.constantes.GeneroDTO;
import com.bmn.excepciones.BOException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IObtenerCancionesFavoritasBO {
    
    public List<CancionDTO> obtenerCancionesFavoritas(GeneroDTO genero, 
            LocalDate fechaAgregacion, String idUsuario) throws BOException;
    
}
