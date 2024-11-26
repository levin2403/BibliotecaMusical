/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmd.dao;

import com.bdm.excepciones.DAOException;
import com.bmd.conexionIntefaces.IConexionMongo;
import com.bmd.daoInterfaces.IFavoritoDAO;
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
public class FavoritoDAO implements IFavoritoDAO {
    
    private IConexionMongo conexion;

    public FavoritoDAO(IConexionMongo conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public void agregarFavorito(Favorito favorito, Usuario usuario) throws DAOException {
        
    }

    @Override
    public boolean isFavorito(String idElemento, Usuario usuario) throws DAOException {
        return true;
    }

    @Override
    public void eliminarFavorito(Favorito favorito, Usuario usuario) throws DAOException {
        
    }

    @Override
    public void eliminarFavoritoPorGenero(Genero genero, Usuario usuario) throws DAOException {
        
    }

    @Override
    public Artista obtenerArtistasFavoritos(Genero genero, LocalDate fechaAgregacion) throws DAOException {
        return null;
    }

    @Override
    public String obtenerCancionesFavoritas(Genero genero, LocalDate fechaAgregacion) throws DAOException {
        return null;
    }

    @Override
    public Album obtenerAlbumesFavoritos(Genero genero, LocalDate fechaAgregacion) throws DAOException {
        return null;
    }
    
}
