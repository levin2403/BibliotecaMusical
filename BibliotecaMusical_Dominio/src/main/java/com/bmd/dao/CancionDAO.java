/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmd.dao;

import com.bmd.conexionIntefaces.IConexionMongo;
import com.bmd.daoInterfaces.ICancionDAO;

/**
 *
 * @author skevi
 */
public class CancionDAO implements ICancionDAO {
    
    private IConexionMongo conexion;

    public CancionDAO(IConexionMongo conexion) {
        this.conexion = conexion;
    }
    
}
