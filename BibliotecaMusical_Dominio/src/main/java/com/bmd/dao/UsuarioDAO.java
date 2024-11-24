/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmd.dao;

import com.bmd.conexionIntefaces.IConexionMongo;
import com.bmd.daoInterfaces.IUsuarioDAO;

/**
 *
 * @author skevi
 */
public class UsuarioDAO implements IUsuarioDAO {
    
    private IConexionMongo conexion;

    public UsuarioDAO(IConexionMongo conexion) {
        this.conexion = conexion;
    }
    
}
