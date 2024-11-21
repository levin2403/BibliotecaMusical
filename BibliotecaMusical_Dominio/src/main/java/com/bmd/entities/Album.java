/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmd.entities;

import com.bmd.enums.Genero;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author skevi
 */
public class Album {
    
    private String id;
    private String nombre;
    private String imagenPortada;
    private LocalDate fechaLanzamiento;
    private Genero genero;
    private Artista artista;
    private List<Cancion> canciones;

    private Album(Builder builder) { 
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

    public Genero getGenero() {
        return genero;
    }

    public Artista getArtista() {
        return artista;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    @Override
    public String toString() {
        return "Album{" + "id=" + id + ", nombre=" + nombre + 
                ", imagenPortada=" + imagenPortada + 
                ", fechaLanzamiento=" + fechaLanzamiento + 
                ", genero=" + genero + ", artista=" + artista + 
                ", canciones=" + canciones + '}';
    }
    
public static class Builder { 
    private String id;
    private String nombre; 
    private String imagenPortada; 
    private LocalDate fechaLanzamiento; 
    private Genero genero; 
    private Artista artista; 
    private List<Cancion> canciones; 
    
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
    
    public Builder setGenero(Genero genero) { 
        this.genero = genero;
        return this; 
    } 
    
    public Builder setArtista(Artista artista) { 
        this.artista = artista;
        return this; 
    } 
    
    public Builder setCanciones(List<Cancion> canciones) { 
        this.canciones = canciones;
        return this; 
    } 
    
    public Album build() { 
        return new Album(this);
    }
    
  }


}
