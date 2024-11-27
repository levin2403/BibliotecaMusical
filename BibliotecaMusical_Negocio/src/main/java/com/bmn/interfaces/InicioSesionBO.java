/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.interfaces;

import com.bmn.dto.UsuarioDTO;
import com.bmn.excepciones.BOException;
import com.bmn.negocio.IInicioSesionBO;

/**
 *
 * @author skevi
 */
public class InicioSesionBO implements IInicioSesionBO {

    @Override
    public UsuarioDTO iniciarSesion(String correo, String contrasena) throws BOException {
        return null;
    }
    
    public void validarCamposVacios(String correo, String contrasena) throws BOException {
        
    }
    
    public UsuarioDTO buscarCorreo(String correo) throws BOException {
        return null;
    }
    
    public UsuarioDTO verificarContrasena(UsuarioDTO usuario){
        return null;
    }
    
    private void guardarUsuario(UsuarioDTO usuario) {
        
    }
}
