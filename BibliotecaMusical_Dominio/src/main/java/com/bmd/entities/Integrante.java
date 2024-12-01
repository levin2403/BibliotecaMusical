/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmd.entities;

import com.bmd.enums.Rol;
import org.bson.codecs.pojo.annotations.BsonProperty;
import java.time.LocalDate;

public class Integrante {
    
    @BsonProperty("nombre")
    private final String nombre;
    @BsonProperty("fecha_ingreso")
    private final LocalDate fechaIngreso;
    @BsonProperty("fecha_salida")
    private final LocalDate fechaSalida;
    private final Rol rol;
    @BsonProperty("estado_actividad")
    private final boolean estadoActividad;

    private Integrante(Builder builder) {
        this.nombre = builder.nombre;
        this.fechaIngreso = builder.fechaIngreso;
        this.fechaSalida = builder.fechaSalida;
        this.rol = builder.rol;
        this.estadoActividad = builder.estadoActividad;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public Rol getRol() {
        return rol;
    }

    public boolean isEstadoActividad() {
        return estadoActividad;
    }
    
    @Override
    public String toString() {
        return "Integrante{" +
               "nombre='" + nombre + '\'' +
               ", fechaIngreso=" + fechaIngreso +
               ", fechaSalida=" + fechaSalida +
               ", rol=" + rol +
               ", estadoActividad=" + estadoActividad +
               '}';
    }

    public static class Builder {
        private String nombre;
        private LocalDate fechaIngreso;
        private LocalDate fechaSalida;
        private Rol rol;
        private boolean estadoActividad;

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setFechaIngreso(LocalDate fechaIngreso) {
            this.fechaIngreso = fechaIngreso;
            return this;
        }

        public Builder setFechaSalida(LocalDate fechaSalida) {
            this.fechaSalida = fechaSalida;
            return this;
        }

        public Builder setRol(Rol rol) {
            this.rol = rol;
            return this;
        }

        public Builder setEstadoActividad(boolean estadoActividad) {
            this.estadoActividad = estadoActividad;
            return this;
        }

        public Integrante build() {
            return new Integrante(this);
        }
    }

}

