/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.dto;

import com.bmn.dto.constantes.Genero;

/**
 *
 * @author skevi
 */
public class RestringidoDTO {
    
    private Genero genero; 
    private UsuarioDTO usuario;

    public RestringidoDTO() {
    }

    public RestringidoDTO(Genero genero, UsuarioDTO usuario) {
        this.genero = genero;
        this.usuario = usuario;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
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
