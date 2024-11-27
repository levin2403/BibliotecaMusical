/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmd.dao;

import com.bdm.excepciones.DAOException;
import com.bmd.conexionIntefaces.IConexionMongo;
import com.bmd.daoInterfaces.IAlbumDAO;
import com.bmd.entities.Album;
import com.bmd.entities.Artista;
import com.bmd.entities.Usuario;
import com.bmd.enums.Genero;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author skevi
 */
public class AlbumDAO implements IAlbumDAO {
    
    private IConexionMongo conexion;

    public AlbumDAO(IConexionMongo conexion) {
        this.conexion = conexion;
    }

    @Override
    public Album obtenerPorTitulo(String titulo, Usuario usuario) throws DAOException {
        try {
            MongoCollection<Document> userCollection = conexion.getCollection("usuarios");
            MongoCollection<Document> albumCollection = conexion.getCollection("albums");
            MongoCollection<Document> artistaCollection = conexion.getCollection("artistas");

            // Buscar el usuario por ID para obtener la lista actualizada de géneros baneados
            Document queryUser = new Document("_id", usuario.getId());
            Document resultUser = userCollection.find(queryUser).first();

            if (resultUser == null) {
                throw new DAOException("Usuario no encontrado.");
            }

            // Obtener la lista de géneros baneados actualizada
            List<String> generosRestringidos = resultUser.getList("restringidos", String.class);

            // Crear la consulta para buscar el álbum por título
            Document queryAlbum = new Document("nombre", titulo);

            // Encontrar el álbum
            Document resultAlbum = albumCollection.find(queryAlbum).first();

            if (resultAlbum != null) {
                // Verificar si el género del álbum está restringido para el usuario
                String generoAlbum = resultAlbum.getString("género");
                if (generosRestringidos.contains(generoAlbum)) {
                    return null; // Retornar null si el álbum pertenece a un género restringido
                }

                // Buscar el artista por ID
                String artistaId = resultAlbum.getString("artista_id");
                Document queryArtista = new Document("_id", artistaId);
                Document resultArtista = artistaCollection.find(queryArtista).first();

                Artista artista = null;
                if (resultArtista != null) {
                    // Construir el objeto Artista con los atributos requeridos
                    artista = new Artista.Builder()
                        .setId(resultArtista.getString("_id"))
                        .setNombre(resultArtista.getString("nombre"))
                        .setImagen(resultArtista.getString("imagen"))
                        .setGenero(Genero.valueOf(resultArtista.getString("género")))
                        .build();
                }

                // Construir y devolver el objeto Album con la información del artista
                return new Album.Builder()
                    .setId(resultAlbum.getString("_id"))
                    .setNombre(resultAlbum.getString("nombre"))
                    .setImagenPortada(resultAlbum.getString("imagen_portada"))
                    .setFechaLanzamiento(LocalDate.parse(resultAlbum.getString("fechaLanzamiento")))
                    .setGenero(Genero.valueOf(resultAlbum.getString("género")))
                    .setArtista(artista)
                    .setCanciones(resultAlbum.getList("canciones", String.class))
                    .build();
            }

            return null;
        } catch (Exception e) {
            throw new DAOException("Error al obtener el álbum por título.", e);
        }
    }




    @Override
    public List<Artista> BuscarPorFiltro(String nombre, LocalDate inicio, LocalDate fin, 
                                         Genero genero, Usuario usuario) throws DAOException {
        try {
            MongoCollection<Document> userCollection = conexion.getCollection("usuarios");
            MongoCollection<Document> artistCollection = conexion.getCollection("artistas");

            // Buscar el usuario por ID para obtener la lista actualizada de géneros baneados
            Document queryUser = new Document("_id", usuario.getId());
            Document resultUser = userCollection.find(queryUser).first();

            if (resultUser == null) {
                throw new DAOException("Usuario no encontrado.");
            }

            // Obtener la lista de géneros baneados actualizada
            List<String> generosRestringidos = resultUser.getList("restringidos", String.class);

            List<Bson> filters = new ArrayList<>();

            if (nombre != null && !nombre.isEmpty()) {
                filters.add(Filters.regex("nombre", nombre, "i")); 
            }

            if (genero != null) {
                filters.add(Filters.eq("género", genero.toString())); 
            }

            if (inicio != null && fin != null) {
                filters.add(Filters.and(
                    Filters.gte("fecha_ingreso", inicio.toString()), 
                    Filters.lte("fecha_ingreso", fin.toString())
                ));
            }

            filters.add(Filters.nin("género", generosRestringidos)); 

            Bson query = filters.isEmpty() ? new Document() : Filters.and(filters);

            List<Artista> artistas = new ArrayList<>();
            for (Document doc : artistCollection.find(query)) {
                Artista artista = new Artista.Builder()
                    .setId(doc.getString("_id"))
                    .setNombre(doc.getString("nombre"))
                    .setImagen(doc.getString("imagen"))
                    .setGenero(Genero.valueOf(doc.getString("género")))
                    .build();
                artistas.add(artista);
            }

            return artistas;
        } catch (Exception e) {
            throw new DAOException("Error al buscar artistas por filtro.", e);
        }
    }


}
