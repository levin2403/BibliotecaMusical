/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.negocio;

import com.bmd.daoInterfaces.IUsuarioDAO;
import com.bmd.entities.Usuario;
import com.bmn.dto.UsuarioDTO;
import com.bmn.dto.constantes.GeneroDTO;
import com.bmn.excepciones.BOException;
import com.bmn.interfaces.IObtenerRestringidosBO;
import java.util.List;

/**
 *
 * @author skevi
 */
public class ObtenerRestringidosBO implements IObtenerRestringidosBO {

    private IUsuarioDAO usuarioBO;

    public ObtenerRestringidosBO(IUsuarioDAO usuarioBO) {
        this.usuarioBO = usuarioBO;
    }
    
    @Override
    public List<String> obtenerRestringidos(UsuarioDTO usuario) throws BOException {
        return procesar(usuario);
    }
    
    private List<String> procesar(UsuarioDTO usuario) throws BOException {
        return null;
    } 
    
}
