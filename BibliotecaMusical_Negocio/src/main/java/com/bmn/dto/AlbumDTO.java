/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.dto;

import com.bmn.dto.constantes.GeneroDTO;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author skevi
 */
public class AlbumDTO {
    
    private String id;
    private String nombre;
    private String imagenPortada;
    private LocalDate fechaLanzamiento;
    private GeneroDTO genero;
    private ArtistaDTO artista;
    private List<CancionDTO> canciones;
    private boolean favorito;

    private AlbumDTO(Builder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.imagenPortada = builder.imagenPortada;
        this.fechaLanzamiento = builder.fechaLanzamiento;
        this.genero = builder.genero;
        this.artista = builder.artista;
        this.canciones = builder.canciones;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getImagenPortada() {
        return imagenPortada;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public GeneroDTO getGenero() {
        return genero;
    }

    public ArtistaDTO getArtista() {
        return artista;
    }

    public List<CancionDTO> getCanciones() {
        return canciones;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    @Override
    public String toString() {
        return "AlbumDTO{" + "id=" + id + ", nombre=" + nombre + 
                ", imagenPortada=" + imagenPortada + ", fechaLanzamiento=" + 
                fechaLanzamiento + ", genero=" + genero + ", artista=" + 
                artista + ", canciones=" + canciones + ", favorito=" + 
                favorito + '}';
    }

    public static class Builder {

        private String id;
        private String nombre;
        private String imagenPortada;
        private LocalDate fechaLanzamiento;
        private GeneroDTO genero;
        private ArtistaDTO artista;
        private List<CancionDTO> canciones;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setImagenPortada(String imagenPortada) {
            this.imagenPortada = imagenPortada;
            return this;
        }

        public Builder setFechaLanzamiento(LocalDate fechaLanzamiento) {
            this.fechaLanzamiento = fechaLanzamiento;
            return this;
        }

        public Builder setGenero(GeneroDTO genero) {
            this.genero = genero;
            return this;
        }

        public Builder setArtista(ArtistaDTO artista) {
            this.artista = artista;
            return this;
        }

        public Builder setCanciones(List<CancionDTO> canciones) {
            this.canciones = canciones;
            return this;
        }

        public AlbumDTO build() {
            return new AlbumDTO(this);
        }
    }
    
}
