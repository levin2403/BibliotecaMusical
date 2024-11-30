/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.convertidores;

import com.bmd.entities.Integrante;
import com.bmn.dto.IntegranteDTO;

/**
 *
 * @author skevi
 */
public class IntegranteCVR {
    
   public IntegranteDTO toIntegranteDTO(Integrante integrante) {
        if (integrante == null) {
            return null; // Manejar el caso donde 'integrante' sea null
        }

        IntegranteDTO integranteDTO = new IntegranteDTO.Builder()
            .setNombre(integrante.getNombre())
            .setFechaIngreso(integrante.getFechaIngreso())
            .setFechaSalida(integrante.getFechaSalida() != null ? integrante.getFechaSalida() : null)
            .setRol(integrante.getRol().name())
            .setEstadoActividad(integrante.isEstadoActividad())
            .build();

        return integranteDTO;
    }

    
}
