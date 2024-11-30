/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmd.dao;

import com.bdm.excepciones.DAOException;
import com.bmd.conexionIntefaces.IConexionMongo;
import com.bmd.daoInterfaces.IArtistaDAO;
import com.bmd.entities.Artista;
import com.bmd.entities.Usuario;
import com.bmd.enums.Genero;
import java.util.List;

/**
 *
 * @author skevi
 */
public class ArtistaDAO implements IArtistaDAO {
    
    private IConexionMongo conexion;

    public ArtistaDAO(IConexionMongo conexion) {
        this.conexion = conexion;
    }

    @Override
    public Artista buscarPorId(String id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Artista> buscarPorFiltro(String nombre, Genero genero, String idUsuario) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
