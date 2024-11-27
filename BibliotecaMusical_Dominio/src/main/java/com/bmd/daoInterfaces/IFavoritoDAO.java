/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmd.daoInterfaces;

import com.bdm.excepciones.DAOException;
import com.bmd.entities.Album;
import com.bmd.entities.Artista;
import com.bmd.entities.Favorito;
import com.bmd.entities.Usuario;
import com.bmd.enums.Genero;
import java.time.LocalDate;

/**
 *
 * @author skevi
 */
public interface IFavoritoDAO {
    
    public void agregarFavorito(Favorito favorito, Usuario usuario) throws DAOException;
    
    public boolean isFavorito(String idElemento, Usuario usuario) throws DAOException;
    
    public void eliminarFavorito(Favorito favorito, Usuario usuario) throws DAOException;
    
    public void eliminarFavoritoPorGenero(Genero genero, Usuario usuario) throws DAOException;
    
    public Artista obtenerArtistasFavoritos(Genero genero, LocalDate fechaAgregacion) throws DAOException;
    
    public String obtenerCancionesFavoritas(Genero genero, LocalDate fechaAgregacion) throws DAOException;
    
    public Album obtenerAlbumesFavoritos(Genero genero, LocalDate fechaAgregacion) throws DAOException;
    
}
