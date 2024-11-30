
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.dto;

import com.bmn.dto.constantes.GeneroDTO;
import java.util.List;

/**
 *
 * @author skevi
 */
public class ArtistaDTO {
    
    private String id;
    private String tipoArtista;
    private String nombre;
    private String imagen;
    private GeneroDTO genero;
    private List<IntegranteDTO> integrantes;
    private List<AlbumDTO> albums;
    private boolean favorito;

    private ArtistaDTO(Builder builder) {
        this.id = builder.id;
        this.tipoArtista = builder.tipoArtista;
        this.nombre = builder.nombre;
        this.imagen = builder.imagen;
        this.genero = builder.genero;
    }

    public String getId() {
        return id;
    }

    public String getTipoArtista() {
        return tipoArtista;
    }

    public String getNombre() {
        return nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public GeneroDTO getGenero() {
        return genero;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    @Override
    public String toString() {
        return "id: " + id + 
                ", tipoArtista: " + tipoArtista + 
                ", nombre: " + nombre + 
                ", imagen: " + imagen + 
                ", genero: " + genero;
    }
    
    public static class Builder {
        private String id;
        private String tipoArtista;
        private String nombre;
        private String imagen;
        private GeneroDTO genero;
        private List<IntegranteDTO> integrantes;
        private List<AlbumDTO> albums;
        
        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setTipoArtista(String tipoArtista){
            this.tipoArtista = tipoArtista;
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

        public Builder setGenero(GeneroDTO genero) {
            this.genero = genero;
            return this;
        }

        public Builder setIntegrantes(List<IntegranteDTO> integrantes) {
            this.integrantes = integrantes;
            return this;
        }

        public Builder setAlbums(List<AlbumDTO> albums) {
            this.albums = albums;
            return this;
        }

        public ArtistaDTO build() {
            return new ArtistaDTO(this);
        }
    }

}
