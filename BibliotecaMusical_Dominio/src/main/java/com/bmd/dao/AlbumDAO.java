/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmd.dao;

import com.bmd.conexionIntefaces.IConexionMongo;
import com.bmd.daoInterfaces.IAlbumDAO;

/**
 *
 * @author skevi
 */
public class AlbumDAO implements IAlbumDAO {
    
    private IConexionMongo conexion;

    public AlbumDAO(IConexionMongo conexion) {
        this.conexion = conexion;
    }

    
    
}
