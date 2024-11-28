/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.dto;

import java.util.List;

/**
 *
 * @author skevi
 */
public class UsuarioDTO {
    
    private String id;
    private String nombre;
    private String correo;
    private String contrasena;
    private String imagenPerfil;
//    private List<Favorito> favoritos;
//    private List<String> generosBaneados;

    public UsuarioDTO() {
    }
    
    private UsuarioDTO (Builder builder) { 
        this.id = builder.id;
        this.nombre = builder.nombre; 
        this.correo = builder.correo; 
        this.contrasena = builder.contrasena; 
        this.imagenPerfil = builder.imagenPerfil; 
//        this.favoritos = builder.favoritos; 
//        this.generosBaneados = builder.generosBaneados;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getImagenPerfil() {
        return imagenPerfil;
    }

    
//    public List<Favorito> getFavoritos() {
//        return favoritos;
//    }

//    public List<String> getGenerosBaneados() {
//        return generosBaneados;
//    }

    public void setId(String id) {
        this.id = id;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    
    
    public static class Builder {
        private String id;
        private String nombre;
        private String correo;
        private String contrasena;
        private String imagenPerfil;
//        private List<Favorito> favoritos;
//        private List<String> generosBaneados;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setCorreo(String correo) {
            this.correo = correo;
            return this;
        }

        public Builder setContrasena(String contrasena) {
            this.contrasena = contrasena;
            return this;
        }

        public Builder setImagenPerfil(String imagenPerfil) {
            this.imagenPerfil = imagenPerfil;
            return this;
        }

//        public Builder setFavoritos(List<Favorito> favoritos) {
//            this.favoritos = favoritos;
//            return this;
//        }

//        public Builder setGenerosBaneados(List<String> generosBaneados) {
//            this.generosBaneados = generosBaneados;
//            return this;
//        }

        public UsuarioDTO build() {
            return new UsuarioDTO (this);
        }
    }
    
}