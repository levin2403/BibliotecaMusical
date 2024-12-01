/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmd.entities;

import com.bmd.enums.Tipo;
import java.time.LocalDate;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

/**
 *
 * @author skevi
 */
public class Favorito {
    
    @BsonId 
    private String id; 
    @BsonProperty("id_usuario") 
    private String idUsuario; 
    @BsonProperty("id_referencia") 
    private String idReferencia; 
    private Tipo tipo; // Artista, Album, Cancion 
    @BsonProperty("nombre_cancion")
    // nombre de la canción, nulo si no es una canción la seleccionada como favorito 
    private String Nombrecancion; 
    @BsonProperty("fecha_agregacion") 
    private LocalDate fechaAgregacion;

    public Favorito(Builder builder) {
        this.id = builder.id;
        this.idUsuario = builder.idUsuario;
        this.idReferencia = builder.idReferencia;
        this.tipo = builder.tipo;
        this.Nombrecancion = builder.Nombrecancion;
        this.fechaAgregacion = builder.fechaAgregacion;
    }

    public String getId() {
        return id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getIdReferencia() {
        return idReferencia;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public LocalDate getFechaAgregacion() {
        return fechaAgregacion;
    }

    @Override
    public String toString() {
        return "Favorito{" + "id=" + id + ", idUsuario=" + idUsuario + 
                ", idReferencia=" + idReferencia + ", tipo=" + tipo + 
                ", fechaAgregacion=" + fechaAgregacion + '}';
    }
    
    public static class Builder{
        String id;
        String idUsuario;
        String idReferencia;
        Tipo tipo;
        String Nombrecancion;
        LocalDate fechaAgregacion;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setIdUsuario(String idUsuario) {
            this.idUsuario = idUsuario;
            return this;
        }

        public Builder setIdReferencia(String idReferencia) {
            this.idReferencia = idReferencia;
            return this;
        }

        public Builder setTipo(Tipo tipo) {
            this.tipo = tipo;
            return this;
        }

        public Builder setNombrecancion(String Nombrecancion) {
            this.Nombrecancion = Nombrecancion;
            return this;
        }

        public Builder setFechaAgregacion(LocalDate fechaAgregacion) {
            this.fechaAgregacion = fechaAgregacion;
            return this;
        }
        
        public Favorito build(){
            return new Favorito(this);
        }
    }
    
}
