/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmd.daoInterfaces;

import com.bdm.excepciones.DAOException;
import com.bmd.entities.Usuario;
import com.bmd.enums.Genero;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IUsuarioDAO {
    
    public void añadirUsuario(Usuario usuario) throws DAOException;
    
    public Usuario buscaPorCorreo(String correo) throws DAOException;
    
    public boolean verificarExistenciaCorreo(String correo) throws DAOException;
    
    public void actualizarUsuario(Usuario usuario) throws DAOException;
    
    public void añadirRestringido(Genero genero, Usuario usuario) throws DAOException;
    
    public void eliminarRestringido(Genero genero, Usuario usuario) throws DAOException;
    
    public List<String> obtenerRestringidos(Usuario usuario) throws DAOException;
    
    public boolean verificarExistenciaRestringido(Genero genero, Usuario usuario);
    
}
