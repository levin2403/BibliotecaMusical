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
import com.bmd.enums.Genero;
import java.time.LocalDate;
import java.util.List;

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
    public void agregarFavorito(Favorito favorito, String idUsuario) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isFavorito(String idReferencia, String idUsuario) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarFavorito(Favorito favorito, String idUsuario) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarFavoritoPorGenero(Genero genero, String idUsuario) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Artista> obtenerArtistasFavoritos(Genero genero, LocalDate fechaAgregacion, String idUsuario) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<String> obtenerCancionesFavoritas(Genero genero, LocalDate fechaAgregacion, String idUsuario) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Album> obtenerAlbumesFavoritos(Genero genero, LocalDate fechaAgregacion, String idUsuario) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean verificarCancionFavorita(String nombreUsuario, String idReferencia, String idUsuario) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean verificarExistenciaFavorito(Favorito favorito, String idUsuario) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
