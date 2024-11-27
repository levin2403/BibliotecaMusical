/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmn.negocio;

import com.bmn.dto.UsuarioDTO;
import com.bmn.excepciones.BOException;

/**
 *
 * @author skevi
 */
public interface IInicioSesionBO {
    
    public UsuarioDTO iniciarSesion(String correo,String contrasena) throws BOException;
    
}
