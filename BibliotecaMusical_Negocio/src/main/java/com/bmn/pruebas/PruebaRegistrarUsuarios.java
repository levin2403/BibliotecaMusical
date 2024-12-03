/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.bmn.pruebas;

import com.bmn.dto.UsuarioRegistrarDTO;
import com.bmn.excepciones.BOException;
import com.bmn.factories.BOFactory;
import com.bmn.negocio.RegistrarUsuarioBO;

/**
 *
 * @author skevi
 */
public class PruebaRegistrarUsuarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        RegistrarUsuarioBO registrar =  BOFactory.registrarUsuarioFactory();
        
        UsuarioRegistrarDTO usuario = new UsuarioRegistrarDTO.Builder()
        .setNombre("Juan Pérez")
        .setCorreo("kevin.sanchez@gmail.com")
        .setContrasena("password123")
        .setContrasenaConfirmar("password143")
        .setImagenPerfil("url_to_profile_image.jpg")
        .build();

        registrar.registrarUsuario(usuario);
        }
        catch(BOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
