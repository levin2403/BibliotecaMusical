/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmd.dao;

import com.bdm.excepciones.DAOException;
import com.bmd.conexionIntefaces.IConexionMongo;
import com.bmd.daoInterfaces.IUsuarioDAO;
import com.bmd.entities.Usuario;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Updates;
import java.util.List;

/**
 *
 * @author skevi
 */
public class UsuarioDAO implements IUsuarioDAO {
    
    private IConexionMongo conexion;

    public UsuarioDAO(IConexionMongo conexion) {
        this.conexion = conexion;
    }

    /**
     * Metodo para agregar un usuario 
     * 
     * @param usuario
     * @throws DAOException 
     */
    @Override
    public void añadirUsuario(Usuario usuario) throws DAOException {
        try {
            MongoCollection<Usuario> collection = conexion.getCollection("usuarios", Usuario.class);
            collection.insertOne(usuario);
        } catch (Exception e) {
            throw new DAOException("Error al añadir el usuario", e);
        }
    }


    /**
     * Metodo para buscar un usuario por correo
     * 
     * @param correo
     * @return
     * @throws DAOException 
     */
    @Override
    public Usuario buscaPorCorreo(String correo) throws DAOException {
        try {
            MongoCollection<Usuario> collection = conexion.getCollection("usuarios", Usuario.class);
            Usuario usuario = collection.find(eq("correo", correo)).first();
            return usuario;
        } catch (Exception e) {
            throw new DAOException("Error al buscar el usuario por correo", e);
        }
    }

    /**
     * Verifica si el correo existe dentro de la base de datos.
     * 
     * @param correo
     * @return
     * @throws DAOException 
     */
    @Override
    public boolean verificarExistenciaCorreo(String correo) throws DAOException {
        try {
            MongoCollection<Usuario> collection = conexion.getCollection("usuarios", Usuario.class);
            long count = collection.countDocuments(eq("correo", correo));
            return count > 0;
        } catch (Exception e) {
            throw new DAOException("Error al verificar la existencia del correo", e);
        }
    }


    /**
     * Metodo que actualiza el usuario.
     * 
     * @param usuario
     * @throws DAOException 
     */
    @Override
    public void actualizarUsuario(Usuario usuario) throws DAOException {
        try {
            MongoCollection<Usuario> collection = conexion.getCollection("usuarios", Usuario.class);
            collection.replaceOne(eq("_id", usuario.getId()), usuario);
        } catch (Exception e) {
            throw new DAOException("Error al actualizar el usuario", e);
        }
    }


    /**
     * Añade un genero restringido a la lista de restringidos del usuario.
     * 
     * @param genero
     * @param idUsuario
     * @throws DAOException 
     */
    @Override
    public void añadirRestringido(String genero, String idUsuario) throws DAOException {
        try {
            MongoCollection<Usuario> collection = conexion.getCollection("usuarios", Usuario.class);
            collection.updateOne(eq("_id", idUsuario), 
                                 Updates.addToSet("restringidos", genero));
        } catch (Exception e) {
            throw new DAOException("Error al añadir el género restringido", e);
        }
    }


    /**
     * Elimina un genero restringido de la lista de restringidos del usuario
     * 
     * @param genero
     * @param idUsuario
     * @throws DAOException 
     */
    @Override
    public void eliminarRestringido(String genero, String idUsuario) throws DAOException {
        try {
            MongoCollection<Usuario> collection = conexion.getCollection("usuarios", Usuario.class);
            collection.updateOne(eq("_id", idUsuario), 
                                 Updates.pull("restringidos", genero));
        } catch (Exception e) {
            throw new DAOException("Error al eliminar el género restringido", e);
        }
    }

    /**
     * Obtiene una lista de todos los generos baneados por el usuario.
     * 
     * @param idUsuario
     * @return
     * @throws DAOException 
     */
    @Override
    public List<String> obtenerRestringidos(String idUsuario) throws DAOException {
        try {
            MongoCollection<Usuario> collection = conexion.getCollection("usuarios", Usuario.class);
            Usuario usuario = collection.find(eq("_id", idUsuario)).first();
            if (usuario == null) {
                throw new DAOException("Usuario no encontrado");
            }
            return usuario.getGenerosRestringidos();
        } catch (Exception e) {
            throw new DAOException("Error al obtener los géneros restringidos", e);
        }
    }

    /**
     * Verifica si el genero dado en el parametro ya existe dentro de la 
     * lista de restringidos del usuario.
     * 
     * @param genero
     * @param idUsuario
     * @return 
     * @throws com.bdm.excepciones.DAOException 
     */
    @Override
    public boolean verificarExistenciaRestringido(String genero, String idUsuario) throws DAOException {
        try {
            MongoCollection<Usuario> collection = conexion.getCollection("usuarios", Usuario.class);
            Usuario usuario = collection.find(eq("_id", idUsuario)).first();
            if (usuario == null) {
                throw new DAOException("Usuario no encontrado");
            }
            return usuario.getGenerosRestringidos().contains(genero);
        } catch (Exception e) {
            throw new DAOException("Error al verificar la existencia del género restringido", e);
        }
    }

    
}
