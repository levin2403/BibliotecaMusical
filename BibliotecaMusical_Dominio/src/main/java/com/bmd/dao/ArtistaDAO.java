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
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.nin;
import com.mongodb.client.model.Projections;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;

/**
 *
 * @author skevi
 */
public class ArtistaDAO implements IArtistaDAO {
    
    /**
     * Interfaz de la conexion a mongo
     */
    private IConexionMongo conexion;

    public ArtistaDAO(IConexionMongo conexion) {
        this.conexion = conexion;
    }

    /**
     * Metodo para obtener el artista por id.
     * La informacion del artista se obtiene por completo y la informacion
     * del objeto Album unicamente contendra: id, nombre y imagen.
     * 
     * @param idArtista id del artista a consultar.
     * @return Objeto de tipo album con la informacion completa del album.
     * @throws DAOException En caso de excepcion en la consulta.
     */
    @Override
    public Artista buscarPorId(String idArtista) throws DAOException {
        try {
            MongoCollection<Artista> collection = conexion.getCollection("artistas", Artista.class);

            // Proyección para incluir solo los campos necesarios del Album
            Bson projection = fields(
                include("id", "tipo_artista", "nombre", "imagen", "genero", "integrantes", "estado_actividad"),
                Projections.computed("albums", fields(include("id", "nombre", "imagen_portada")))
            );

            // Consulta del artista por ID
            Artista artista = collection.find(eq("_id", idArtista))
                                       .projection(projection)
                                       .first();

            return artista;
        } catch (Exception e) {
            throw new DAOException("Error al obtener el artista", e);
        }
    }


    @Override
    public List<Artista> buscarPorFiltro(String nombre, String genero, String idUsuario) throws DAOException {
        try {
            MongoCollection<Artista> collection = conexion.getCollection("artistas", Artista.class);

            List<Bson> filtros = new ArrayList<>();

            // Añadir filtros opcionales
            if (nombre != null && !nombre.isEmpty()) {
                filtros.add(eq("nombre", nombre));
            }
            if (genero != null && !genero.isEmpty()) {
                filtros.add(eq("genero", genero));
            }
            if (idUsuario != null && !idUsuario.isEmpty()) {
                // Filtro para excluir géneros restringidos por el usuario
                MongoCollection<Usuario> usuarioCollection = conexion.getCollection("usuarios", Usuario.class);
                Usuario usuario = usuarioCollection.find(eq("_id", idUsuario)).first();
                if (usuario != null && usuario.getGenerosRestringidos() != null && !usuario.getGenerosRestringidos().isEmpty()) {
                    filtros.add(nin("genero", usuario.getGenerosRestringidos()));
                }
            }

            // Proyección para incluir solo los campos necesarios del Artista
            Bson projection = fields(
                include("id", "nombre", "imagen")
            );

            // Consulta con los filtros y la proyección
            List<Artista> artistas;
            if (filtros.isEmpty()) {
                // Si no hay filtros, hacer una consulta sin filtros
                artistas = collection.find()
                                     .projection(projection)
                                     .into(new ArrayList<>());
            } else {
                // Consulta con filtros y proyección
                artistas = collection.find(and(filtros))
                                     .projection(projection)
                                     .into(new ArrayList<>());
            }

            return artistas;
        } catch (Exception e) {
            throw new DAOException("Error al buscar artistas por filtro", e);
        }
    }



    /**
     * 
     * @param artista
     * @throws DAOException 
     */
    @Override
    public void añadirArtista(Artista artista) throws DAOException {
        try {
            MongoCollection<Artista> collection = conexion.getCollection("artistas", Artista.class);
            collection.insertOne(artista);
        } catch (Exception e) {
            throw new DAOException("Error al añadir el artista", e);
        }
    }
    
}
