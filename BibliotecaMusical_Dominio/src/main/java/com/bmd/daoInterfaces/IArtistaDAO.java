/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmd.daoInterfaces;

import com.bdm.excepciones.DAOException;
import com.bmd.entities.Artista;
import java.util.List;


/**
 *
 * @author skevi
 */
public interface IArtistaDAO {
    
    public void añadirArtista(Artista artista) throws DAOException;
    
    public Artista buscarPorId(String id) throws DAOException;
    
    public List<Artista> buscarPorFiltro(String nombre, String genero, String idUsuario) 
            throws DAOException;
            
}
