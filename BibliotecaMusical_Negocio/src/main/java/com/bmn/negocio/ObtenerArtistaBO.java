/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.negocio;

import com.bmd.daoInterfaces.IArtistaDAO;
import com.bmn.dto.ArtistaDTO;
import com.bmn.excepciones.BOException;
import com.bmn.interfaces.IObtenerArtistaBO;

/**
 *
 * @author skevi
 */
public class ObtenerArtistaBO implements IObtenerArtistaBO {
    
    private IArtistaDAO artistaDAO;

    public ObtenerArtistaBO(IArtistaDAO artistaDAO) {
        this.artistaDAO = artistaDAO;
    }

    @Override
    public ArtistaDTO ObtenerArtista(String id) throws BOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void verificarCampos(String id) throws BOException {
        
    }
    
    private ArtistaDTO procesar(String id) throws BOException {
        return null;
    }
    
    private void verificarFavorito(ArtistaDTO artista) throws BOException {
        
    }
    
}
