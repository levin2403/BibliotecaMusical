/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.dto;

import com.bmn.dto.constantes.GeneroDTO;

/**
 *
 * @author skevi
 */
public class RestringidoDTO {
    
    private GeneroDTO genero; 
    private UsuarioDTO usuario;

    public RestringidoDTO() {
    }

    public RestringidoDTO(GeneroDTO genero, UsuarioDTO usuario) {
        this.genero = genero;
        this.usuario = usuario;
    }

    public GeneroDTO getGenero() {
        return genero;
    }

    public void setGenero(GeneroDTO genero) {
        this.genero = genero;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "RestringidoDTO{" + "genero=" + genero + ", usuario=" + usuario + '}';
    }
    
}
