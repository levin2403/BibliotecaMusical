/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmn.interfaces;

import com.bmn.dto.RestringidoDTO;
import com.bmn.excepciones.BOException;

/**
 *
 * @author skevi
 */
public interface IEliminarRestringidoBO {
    
    public void eliminarRestringido(RestringidoDTO restringido) throws BOException;
    
}
