/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmd.daoInterfaces;

import com.bdm.excepciones.DAOException;
import com.bmd.entities.Album;
import com.bmd.entities.Artista;
import com.bmd.entities.Favorito;
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
    
    public void eliminarFavorito(String idReferencia, String idUsuario, String tipo) 
            throws DAOException;
    
    public void eliminarFavoritoPorGenero(String genero, String idUsuario) 
            throws DAOException;
    
    public List<Artista> obtenerArtistasFavoritos(String genero, 
            LocalDate fechaAgregacion, String idUsuario) throws DAOException;
    
    public List<String> obtenerCancionesFavoritas(String genero, 
            LocalDate fechaAgregacion, String idUsuario) throws DAOException;
    
    public List<Album> obtenerAlbumesFavoritos(String genero, 
            LocalDate fechaAgregacion, String idUsuario) throws DAOException;
    
    public void eliminarCancionFavorita(String nombreCancion, 
            String idUsuario) throws DAOException;
    
}
