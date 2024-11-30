/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.negocio;

import com.bmd.daoInterfaces.IArtistaDAO;
import com.bmn.dto.ArtistaDTO;
import com.bmn.dto.UsuarioDTO;
import com.bmn.dto.constantes.GeneroDTO;
import com.bmn.excepciones.BOException;
import com.bmn.interfaces.IObtenerArtistasFiltradosBO;

/**
 *
 * @author skevi
 */
public class ObtenerArtistasFiltradosBO implements IObtenerArtistasFiltradosBO {

    private IArtistaDAO artistaDAO;
    
    @Override
    public ArtistaDTO buscarPorFiltro(String nombre, GeneroDTO genero, 
            UsuarioDTO Usuario) throws BOException {
        validarCampos(nombre, genero, Usuario);
        return procesar(nombre, genero, Usuario);
    }
    
    private void validarCampos(String nombre, GeneroDTO genero, 
            UsuarioDTO Usuario) throws BOException {
        
    }
    
    private ArtistaDTO procesar(String nombre, GeneroDTO genero, 
            UsuarioDTO Usuario) throws BOException {
        return null;
    }
}
