/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmd.entities;

import com.bmd.enums.Genero;

/**
 *
 * @author skevi
 */
import java.util.List;

public class Artista {
    private final String id;
    private final String nombre;
    private final String imagen;
    private final Genero genero;
    private final List<Album> albums;

    private Artista(Builder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.imagen = builder.imagen;
        this.genero = builder.genero;
        this.albums = builder.albums;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public Genero getGenero() {
        return genero;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    @Override
    public String toString() {
        return "Artista{" +
               "id='" + id + '\'' +
               ", nombre='" + nombre + '\'' +
               ", imagen='" + imagen + '\'' +
               ", genero=" + genero +
               ", albums=" + albums +
               '}';
    }
    
    public static class Builder {
        private String id;
        private String nombre;
        private String imagen;
        private Genero genero;
        private List<Album> albums;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setImagen(String imagen) {
            this.imagen = imagen;
            return this;
        }

        public Builder setGenero(Genero genero) {
            this.genero = genero;
            return this;
        }

        public Builder setAlbums(List<Album> albums) {
            this.albums = albums;
            return this;
        }

        public Artista build() {
            return new Artista(this);
        }
    }

}

