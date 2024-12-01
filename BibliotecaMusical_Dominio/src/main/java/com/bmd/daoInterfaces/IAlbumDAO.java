/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmd.daoInterfaces;

import com.bdm.excepciones.DAOException;
import com.bmd.entities.Album;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IAlbumDAO {
    
    public void añadirAlbum(Album album) throws DAOException;
    
    public Album obtenerAlbum(String idAlbum) throws DAOException;
    
    public List<Album>  BuscarPorFiltro(String nombre, LocalDate fecha, 
            String genero, String idUsuario) throws DAOException;
    
}
