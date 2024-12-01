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
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author skevi
 */
public class FavoritoDAO implements IFavoritoDAO {
    
    /**
     * Interfaz de la conexion a mongo
     */
    private IConexionMongo conexion;

    public FavoritoDAO(IConexionMongo conexion) {
        this.conexion = conexion;
    }

    /**
     * Metodo que agrega un favorito a la base de datos.
     * 
     * 
     * @param favorito
     * @throws DAOException 
     */
    @Override
    public void agregarFavorito(Favorito favorito) throws DAOException {
        try {
            MongoCollection<Favorito> collection = conexion.getCollection("favoritos", Favorito.class);
            collection.insertOne(favorito);
        } catch (Exception e) {
            throw new DAOException("Error al agregar el favorito", e);
        }
    }


    /**
     * Metodo que verifica si ya hay algun registro en favorito con el id de 
     * referencia y id del usuario dados en el parametro, si si hay un registro
     * que coincida con ambos se devuelve true y si no se devuelve false.
     * 
     * @param idReferencia Identificador de la referencia (puede ser un elemento Album o artista)
     * @param idUsuario Identificador del usuario 
     * @return Verdadero en caso de existir falso en caso contrario
     * @throws DAOException En caso de excepcion en la consulta.
     */
    @Override
    public boolean isFavorito(String idReferencia, String idUsuario) throws DAOException {
        try {
            MongoCollection<Favorito> collection = conexion.getCollection("favoritos", Favorito.class);
            long count = collection.countDocuments(and(eq("idReferencia", idReferencia), eq("idUsuario", idUsuario)));
            return count > 0;
        } catch (Exception e) {
            throw new DAOException("Error al verificar si es favorito", e);
        }
    }


    /**
     * 
     * @param favorito
     * @param idUsuario
     * @throws DAOException En caso de excepcion en la consulta.
     */
    @Override
    public void eliminarFavorito(Favorito favorito, String idUsuario) throws DAOException {
        
    }

    /**
     * 
     * @param genero
     * @param idUsuario
     * @throws DAOException En caso de excepcion en la consulta.
     */
    @Override
    public void eliminarFavoritoPorGenero(Genero genero, String idUsuario) throws DAOException {
        
    }

    /**
     * 
     * @param genero
     * @param fechaAgregacion
     * @param idUsuario
     * @return
     * @throws DAOException En caso de excepcion en la consulta.
     */
    @Override
    public List<Artista> obtenerArtistasFavoritos(Genero genero, LocalDate fechaAgregacion, String idUsuario) throws DAOException {
        return null;
    }

    /**
     * 
     * @param genero
     * @param fechaAgregacion
     * @param idUsuario
     * @return
     * @throws DAOException En caso de excepcion en la consulta.
     */
    @Override
    public List<String> obtenerCancionesFavoritas(Genero genero, LocalDate fechaAgregacion, String idUsuario) throws DAOException {
        return null;
    }

    /**
     * 
     * @param genero
     * @param fechaAgregacion
     * @param idUsuario
     * @return
     * @throws DAOException En caso de excepcion en la consulta.
     */
    @Override
    public List<Album> obtenerAlbumesFavoritos(Genero genero, LocalDate fechaAgregacion, String idUsuario) throws DAOException {
        return null;
    }

    /**
     * 
     * @param nombreCancion
     * @param idReferencia
     * @param idUsuario
     * @return
     * @throws DAOException En caso de excepcion en la consulta.
     */
    @Override
    public boolean verificarCancionFavorita(String nombreCancion, String idReferencia, String idUsuario) throws DAOException {
        return false;
    }

    /**
     * 
     * @param favorito
     * @param idUsuario
     * @return
     * @throws DAOException En caso de excepcion en la consulta.
     */
    @Override
    public boolean verificarExistenciaFavorito(Favorito favorito, String idUsuario) throws DAOException {
        return false;
    }

}
