/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmn.interfaces;

import com.bmn.dto.UsuarioDTO;
import com.bmn.excepciones.BOException;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IObtenerRestringidosBO {
    
    public List<String> obtenerRestringidos(UsuarioDTO usuario) 
            throws BOException;
    
}
