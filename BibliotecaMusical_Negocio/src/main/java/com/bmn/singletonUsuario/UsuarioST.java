/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.singletonUsuario;

import com.bmn.dto.UsuarioDTO;

/**
 *
 * @author skevi
 */
public class UsuarioST {
    
    private static UsuarioDTO usuario;
    
    private UsuarioST(){
    }
    
    public static UsuarioDTO getInstance(){
        if (usuario == null) {
            return new UsuarioDTO();
        }
        else{
            return usuario;
        }
    }

    public static void setUsuario(UsuarioDTO usuario) {
        UsuarioST.usuario = usuario;
    }
    
}
