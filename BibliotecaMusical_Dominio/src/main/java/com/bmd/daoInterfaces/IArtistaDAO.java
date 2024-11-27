/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmd.daoInterfaces;

import com.bdm.excepciones.DAOException;
import com.bmd.entities.Artista;
import com.bmd.entities.Usuario;
import com.bmd.enums.Genero;


/**
 *
 * @author skevi
 */
public interface IArtistaDAO {
    
    public Artista buscarPorId() throws DAOException;
    
    public Artista buscarPorFiltro(String nombre, Genero genero, Usuario Usuario) 
            throws DAOException;
            
}
