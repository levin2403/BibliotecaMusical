/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmd.entities;

/**
 *
 * @author skevi
 */
public class Cancion {
    
    private final String id;
    private final String titulo;
    private final String duracion;
    private final Album album;

    private Cancion(Builder builder) {
        this.id = builder.id;
        this.titulo = builder.titulo;
        this.duracion = builder.duracion;
        this.album = builder.album;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public Album getAlbum() {
        return album;
    }

    @Override
    public String toString() {
        return "Cancion{" +
               "id='" + id + '\'' +
               ", titulo='" + titulo + '\'' +
               ", duracion='" + duracion + '\'' +
               ", album=" + album +
               '}';
    }
    
    public static class Builder {
        private String id;
        private String titulo;
        private String duracion;
        private Album album;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setTitulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public Builder setDuracion(String duracion) {
            this.duracion = duracion;
            return this;
        }

        public Builder setAlbum(Album album) {
            this.album = album;
            return this;
        }

        public Cancion build() {
            return new Cancion(this);
        }
    }

}

