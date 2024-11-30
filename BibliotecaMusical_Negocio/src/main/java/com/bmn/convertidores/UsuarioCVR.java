/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.convertidores;

import com.bmd.entities.Usuario;
import com.bmn.dto.UsuarioDTO;
import com.bmn.dto.UsuarioRegistrarDTO;

/**
 *
 * @author skevi
 */
public class UsuarioCVR {

    public UsuarioCVR() {
    }
    
    public Usuario usuarioRegistrarToEntity(UsuarioRegistrarDTO usuarioDTO){
        
        if (usuarioDTO == null) {
            return null;
        }
        
        Usuario usuario = new Usuario.Builder().
                setId(null).
                setNombre(usuarioDTO.getNombre()).
                setCorreo(usuarioDTO.getCorreo()).
                setContrasena(usuarioDTO.getContrasena()).
                setImagenPerfil(usuarioDTO.getImagenPerfil()).
                setFavoritos(null).
                setGenerosBaneados(null).
                build();
        return usuario;
    }
    
    public Usuario toUsuario(UsuarioDTO usuarioDTO) {
        
        if (usuarioDTO == null) {
            return null;
        }
        
        Usuario usuario = new Usuario.Builder().
                setId(usuarioDTO.getId()).
                setNombre(usuarioDTO.getNombre()).
                setCorreo(usuarioDTO.getCorreo()).
                setContrasena(usuarioDTO.getContrasena()).
                setImagenPerfil(usuarioDTO.getImagenPerfil()).
                setFavoritos(null).
                setGenerosBaneados(null).
                build();
        return usuario;
    }            
    
    public UsuarioDTO toUsuarioDTO(Usuario usuario) {
        
        if (usuario == null) {
            return null;
        }
        
        UsuarioDTO usuarioDTO = new UsuarioDTO.Builder().
                setId(usuario.getId()).
                setNombre(usuario.getNombre()).
                setCorreo(usuario.getCorreo()).
                setContrasena(usuario.getContrasena()).
                setImagenPerfil(usuario.getImagenPerfil()).
                build();
        return usuarioDTO;
    }
    
}
