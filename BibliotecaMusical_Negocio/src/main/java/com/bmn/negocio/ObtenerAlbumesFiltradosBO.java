/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.negocio;

import com.bmd.daoInterfaces.IAlbumDAO;
import com.bmn.dto.ArtistaDTO;
import com.bmn.dto.UsuarioDTO;
import com.bmn.dto.constantes.GeneroDTO;
import com.bmn.excepciones.BOException;
import com.bmn.interfaces.IObtenerAlbumesFiltradosBO;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author skevi
 */
public class ObtenerAlbumesFiltradosBO implements IObtenerAlbumesFiltradosBO {

    private IAlbumDAO albumDAO;

    public ObtenerAlbumesFiltradosBO(IAlbumDAO albumDAO) {
        this.albumDAO = albumDAO;
    }
    
    @Override
    public List<ArtistaDTO> BuscarPorFiltro(String nombre, LocalDate fecha, 
            GeneroDTO genero, UsuarioDTO usuario) throws BOException {
        
        verificarCampos(nombre, fecha, genero, usuario);
        return procesar(nombre, fecha, genero, usuario);
        
    }
    
    private void verificarCampos(String nombre, LocalDate fecha, 
            GeneroDTO genero, UsuarioDTO usuario) throws BOException {
        
    }
    
    private List<ArtistaDTO> procesar(String nombre, LocalDate fecha, 
            GeneroDTO genero, UsuarioDTO usuario) throws BOException {
        return null;
    }
}
