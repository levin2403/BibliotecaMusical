/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmn.interfaces;

import com.bmn.dto.AlbumDTO;
import com.bmn.dto.constantes.GeneroDTO;
import com.bmn.excepciones.BOException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IObtenerAlbumesFiltradosBO {
    
    public List<AlbumDTO> BuscarPorFiltro(String nombre, LocalDate fecha, 
            GeneroDTO genero) throws BOException; 
    
}
