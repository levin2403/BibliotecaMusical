/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmd.dao;

import com.bdm.excepciones.DAOException;
import com.bmd.conexionIntefaces.IConexionMongo;
import com.bmd.daoInterfaces.IAlbumDAO;
import com.bmd.entities.Album;
import com.bmd.entities.Artista;
import com.bmd.enums.Genero;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author skevi
 */
public class AlbumDAO implements IAlbumDAO {
    
    private IConexionMongo conexion;

    public AlbumDAO(IConexionMongo conexion) {
        this.conexion = conexion;
    }

    @Override
    public Album obtenerAlbum(String id, String idUsuario) throws DAOException {
        return null;
    }

    @Override
    public List<Artista> BuscarPorFiltro(String nombre, LocalDate fecha, 
                                         Genero genero, String idUsuario) throws DAOException {
        return null;
    }


}
