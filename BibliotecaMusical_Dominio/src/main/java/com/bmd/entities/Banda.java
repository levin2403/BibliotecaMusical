/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmd.entities;

import com.bmd.enums.Genero;
import java.util.List;

/**
 *
 * @author skevi
 */
public class Banda {
    
    private final String id;
    private final String nombre;
    private final String imagen;
    private final Genero genero;
    private final List<Integrante> integrantes;
    private final List<Album> albumes;

    private Banda(Builder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.imagen = builder.imagen;
        this.genero = builder.genero;
        this.integrantes = builder.integrantes;
        this.albumes = builder.albumes;
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

    public List<Integrante> getIntegrantes() {
        return integrantes;
    }

    public List<Album> getAlbumes() {
        return albumes;
    }

    @Override
    public String toString() {
        return "Banda{" +
               "id='" + id + '\'' +
               ", nombre='" + nombre + '\'' +
               ", imagen='" + imagen + '\'' +
               ", genero=" + genero +
               ", integrantes=" + integrantes +
               ", albumes=" + albumes +
               '}';
    }
    
    public static class Builder {
        private String id;
        private String nombre;
        private String imagen;
        private Genero genero;
        private List<Integrante> integrantes;
        private List<Album> albumes;

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

        public Builder setIntegrantes(List<Integrante> integrantes) {
            this.integrantes = integrantes;
            return this;
        }

        public Builder setAlbumes(List<Album> albumes) {
            this.albumes = albumes;
            return this;
        }

        public Banda build() {
            return new Banda(this);
        }
    }

}

