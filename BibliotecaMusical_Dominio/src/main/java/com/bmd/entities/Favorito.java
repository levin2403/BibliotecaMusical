/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmd.entities;

import com.bmd.enums.Tipo;
import java.time.LocalDate;

/**
 *
 * @author skevi
 */
public class Favorito {
    
    private String id;
    private String idUsuario;
    private String idReferencia;
    private Tipo tipo;
    private LocalDate fechaAgregacion;

    public Favorito() {
    }

    public Favorito(String idUsuario, String idReferencia, Tipo tipo, 
            LocalDate fechaAgregacion) {
        this.idUsuario = idUsuario;
        this.idReferencia = idReferencia;
        this.tipo = tipo;
        this.fechaAgregacion = fechaAgregacion;
    }

    public Favorito(String id, String idUsuario, 
            String idReferencia, Tipo tipo, LocalDate fechaAgregacion) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idReferencia = idReferencia;
        this.tipo = tipo;
        this.fechaAgregacion = fechaAgregacion;
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
    
}
