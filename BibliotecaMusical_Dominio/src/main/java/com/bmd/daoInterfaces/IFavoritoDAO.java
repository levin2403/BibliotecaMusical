/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmd.daoInterfaces;

import com.bdm.excepciones.DAOException;
import com.bmd.entities.Album;
import com.bmd.entities.Artista;
import com.bmd.entities.Favorito;
import com.bmd.enums.Genero;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IFavoritoDAO {
    
    public void agregarFavorito(Favorito favorito) throws DAOException;
    
    public boolean isFavorito(String idReferencia, String idUsuario) 
            throws DAOException;
    
    public boolean verificarCancionFavorita(String nombreCancion, 
            String idReferencia, String idUsuario) throws DAOException;
    
    public void eliminarFavorito(String idReferencia, String idUsuario) 
            throws DAOException;
    
    public void eliminarFavoritoPorGenero(Genero genero, String idUsuario) 
            throws DAOException;
    
    public List<Artista> obtenerArtistasFavoritos(Genero genero, 
            LocalDate fechaAgregacion, String idUsuario) throws DAOException;
    
    public List<String> obtenerCancionesFavoritas(Genero genero, 
            LocalDate fechaAgregacion, String idUsuario) throws DAOException;
    
    public List<Album> obtenerAlbumesFavoritos(Genero genero, 
            LocalDate fechaAgregacion, String idUsuario) throws DAOException;
    
    public void eliminarCancionFavorita(String nombreCancion, 
            String idUsuario) throws DAOException;
    
}
