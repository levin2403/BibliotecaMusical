/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmd.daoInterfaces;

import com.bdm.excepciones.DAOException;
import com.bmd.entities.Album;
import com.bmd.entities.Artista;
import com.bmd.entities.Usuario;
import com.bmd.enums.Genero;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IAlbumDAO {
    
    public Album obtenerPorTitulo(String titulo, Usuario usuario) throws DAOException;
    
    public List<Artista>  BuscarPorFiltro(String nombre, LocalDate fecha, LocalDate fin, 
            Genero genero,Usuario usuario) throws DAOException;
    
}
