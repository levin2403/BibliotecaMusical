/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmd.dao;

import com.bmd.conexionIntefaces.IConexionMongo;
import com.bmd.daoInterfaces.IArtistaDAO;

/**
 *
 * @author skevi
 */
public class ArtistaDAO implements IArtistaDAO {
    
    private IConexionMongo conexion;

    public ArtistaDAO(IConexionMongo conexion) {
        this.conexion = conexion;
    }
    
}
