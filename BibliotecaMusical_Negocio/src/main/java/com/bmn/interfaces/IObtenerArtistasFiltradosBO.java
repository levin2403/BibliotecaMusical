/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmn.interfaces;

import com.bmn.dto.ArtistaDTO;
import com.bmn.dto.constantes.GeneroDTO;
import com.bmn.excepciones.BOException;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IObtenerArtistasFiltradosBO {
    
    public List<ArtistaDTO> obtenerArtistasFiltrados(String nombre, GeneroDTO genero, String idUsuario) throws BOException;
    
}
