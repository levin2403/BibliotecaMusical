/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.negocio;

import com.bmd.daoInterfaces.IUsuarioDAO;
import com.bmn.dto.UsuarioRegistrarDTO;
import com.bmn.excepciones.BOException;
import com.bmn.interfaces.IRegistrarUsuarioBO;

/**
 *
 * @author skevi
 */
public class RegistrarUsuarioBO implements IRegistrarUsuarioBO{

    private IUsuarioDAO usuarioDAO;

    public RegistrarUsuarioBO(IUsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    
    @Override
    public void registrarUsuario(UsuarioRegistrarDTO usuario) throws BOException {
        validarCamposVacios(usuario);
        validarCorreo(usuario);
        validarContrasena(usuario);
        validarExistenciaCorreo(usuario);
        procesarRegistrarUsuario(usuario);
    }
    
    public void validarCamposVacios(UsuarioRegistrarDTO usuario) throws BOException {
        
    }
    
    private void validarCorreo(UsuarioRegistrarDTO usuario) throws BOException {
        
    }
    
    public void validarContrasena(UsuarioRegistrarDTO usuario) throws BOException {
        
    }
    
    public void validarExistenciaCorreo(UsuarioRegistrarDTO usuario) throws BOException {
        
    }
    
    public void procesarRegistrarUsuario(UsuarioRegistrarDTO usuario) throws BOException {
        
    }
    
}
