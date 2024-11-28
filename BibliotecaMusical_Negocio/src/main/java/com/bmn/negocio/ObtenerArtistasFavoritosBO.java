/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.negocio;

import com.bmd.daoInterfaces.IFavoritoDAO;
import com.bmn.dto.ArtistaDTO;
import com.bmn.dto.UsuarioDTO;
import com.bmn.dto.constantes.GeneroDTO;
import com.bmn.excepciones.BOException;
import com.bmn.interfaces.IObtenerArtistasFavoritosBO;

/**
 *
 * @author skevi
 */
public class ObtenerArtistasFavoritosBO implements IObtenerArtistasFavoritosBO {

    private IFavoritoDAO favoritoDAO;

    public ObtenerArtistasFavoritosBO(IFavoritoDAO favoritoDAO) {
        this.favoritoDAO = favoritoDAO;
    }
    
    @Override
    public ArtistaDTO buscarPorFiltro(String nombre, GeneroDTO genero, UsuarioDTO Usuario) throws BOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void verificarCampos(String nombre, GeneroDTO genero, 
            UsuarioDTO Usuario) throws BOException {
        
    }
    
    private ArtistaDTO procesar(String nombre, GeneroDTO genero, 
            UsuarioDTO Usuario) throws BOException{
        return null;
    }
    
}
