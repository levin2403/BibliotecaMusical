/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmd.dao;

import com.bdm.excepciones.DAOException;
import com.bmd.conexionIntefaces.IConexionMongo;
import com.bmd.daoInterfaces.IUsuarioDAO;
import com.bmd.entities.Favorito;
import com.bmd.entities.Usuario;
import com.bmd.enums.Genero;
import com.bmd.enums.Tipo;
import com.mongodb.client.MongoCollection;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.bson.Document;

/**
 *
 * @author skevi
 */
public class UsuarioDAO implements IUsuarioDAO {
    
    private IConexionMongo conexion;

    public UsuarioDAO(IConexionMongo conexion) {
        this.conexion = conexion;
    }

    @Override
    public void añadirUsuario(Usuario usuario) throws DAOException {
        try {
            MongoCollection<Document> collection = conexion.getCollection("usuarios");
            Document document = new Document("_id", usuario.getId())
                .append("nombre", usuario.getNombre())
                .append("correo", usuario.getCorreo())
                .append("contrasena", usuario.getContrasena())
                .append("imagen_perfil", usuario.getImagenPerfil())
                .append("favoritos", usuario.getFavoritos().stream()
                    .map(fav -> new Document("tipo", fav.getTipo())
                        .append("id_referencia", fav.getIdReferencia())
                        .append("fecha_agregacion", fav.getFechaAgregacion().toString()))
                    .collect(Collectors.toList()))
                .append("restringidos", usuario.getGenerosBaneados().stream()
                    .map(Genero::toString)
                    .collect(Collectors.toList()));
            collection.insertOne(document);
        } catch (Exception e) {
            throw new DAOException("Error al insertar el usuario.", e);
        }
    }

    
    @Override
    public Usuario buscaPorCorreo(String correo) throws DAOException {
        return null;
    }

    @Override
    public void actualizarUsuario(Usuario usuario) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void añadirRestringido(Genero genero, Usuario usuario) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void eliminarRestringido(Genero genero, Usuario usuario) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean verificarExistenciaCorreo(String correo) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean verificarExistenciaRestringido(Genero genero, Usuario usuario) {
        return false;
    }

    @Override
    public List<String> obtenerRestringidos(Usuario usuario) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
