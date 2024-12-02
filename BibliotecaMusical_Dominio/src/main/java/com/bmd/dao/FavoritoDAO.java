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
import com.bmd.entities.Usuario;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.elemMatch;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Projections;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

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
            MongoCollection<Usuario> collection = conexion.
                    getCollection("usuarios", Usuario.class);
            collection.updateOne(eq("_id", favorito.getIdUsuario()), 
                                 Updates.addToSet("favoritos", favorito));
        } catch (Exception e) {
            throw new DAOException("Error al agregar el favorito", e);
        }
    }

    /**
     * Metodo que verifica si ya hay algun registro en favorito con el id de 
     * referencia y id del usuario dados en el parametro, si si hay un registro
     * que coincida con ambos se devuelve true y si no se devuelve false.
     * 
     * @param idReferencia Identificador de la referencia (puede ser un 
     *                     elemento Album o artista)
     * @param idUsuario Identificador del usuario 
     * @return Verdadero en caso de existir falso en caso contrario
     * @throws DAOException En caso de excepcion en la consulta.
     */
    @Override
    public boolean isFavorito(String idReferencia, String idUsuario) 
            throws DAOException {
        try {
            MongoCollection<Usuario> collection = conexion.
                    getCollection("usuarios", Usuario.class);
            Usuario usuario = collection.find(and(eq("_id", idUsuario), 
                    elemMatch("favoritos", eq("id_referencia", 
                            idReferencia)))).first();
            return usuario != null;
        } catch (Exception e) {
            throw new DAOException("Error al verificar si es favorito", e);
        }
    }

    /**
     * Elimina de la lista de favoritos del usuario el elemento que contiene
     * la referencia especificada y el tipo especificado.
     * 
     * @param idReferencia Identificador de la referencia del favorito.
     * @param idUsuario Identificador del usuario.
     * @param tipo Tipo de favorito (Artista, Album, Cancion).
     * @throws DAOException En caso de excepción en la consulta.
     */
    @Override
    public void eliminarFavorito(String idReferencia, String idUsuario, 
            String tipo) throws DAOException {
        try {
            // Obtener la colección de usuarios
            MongoCollection<Usuario> collection = conexion.
                    getCollection("usuarios", Usuario.class);

            // Construir el filtro y la actualización
            Bson filtro = eq("_id", idUsuario);
            Bson update = Updates.pull("favoritos", 
                new Document("id_referencia", idReferencia).append("tipo", 
                        tipo));

            // Realizar la actualización
            UpdateResult result = collection.updateOne(filtro, update);

            // Verificar si se modificó algún documento
            if (result.getModifiedCount() == 0) {
                throw new DAOException("No se encontró el favorito con la "
                        + "referencia y tipo especificados");
            }

        } catch (Exception e) {
            throw new DAOException("Error al eliminar el favorito", e);
        }
    }





    /**
     * Metodo encargado de eliminar los favoritos del usuario(cuyo id esta 
     * especificado en el parametro).
     * Verififica mediante el id de referencia si el album o artista(cuyo id 
     * es el id de referencia) es del mismo genero que el especificado 
     * si si lo es, se elimina.
     * 
     * @param genero
     * @param idUsuario
     * @throws DAOException En caso de excepcion en la consulta.
     */
    @Override
    public void eliminarFavoritoPorGenero(String genero, String idUsuario) 
            throws DAOException {
        try {
            MongoCollection<Usuario> collection = conexion.
                    getCollection("usuarios", Usuario.class);
            Usuario usuario = collection.find(eq("_id", idUsuario)).first();
            if (usuario == null) {
                throw new DAOException("Usuario no encontrado");
            }

            List<Favorito> favoritosActualizados = new ArrayList<>();
            for (Favorito favorito : usuario.getFavoritos()) {
                if (!favorito.getGenero().equals(genero)) {
                    favoritosActualizados.add(favorito);
                }
            }

            collection.updateOne(eq("_id", idUsuario), Updates.set("favoritos", 
                    favoritosActualizados));
        } catch (Exception e) {
            throw new DAOException("Error al eliminar favoritos por género", e);
        }
    }

    /**
     * Metodo para obtener una lista de Artistas que se encuentren marcados
     * como favoritos por parte del usuario(id especidicado en el parametro).
     * 
     * Las busquedas se realizan de manera filtrada, por lo que si alguno
     * de los parametros es nulo no se incluye en la busqueda.
     * 
     * Para esta busqueda se obtene toda la informacion del artista menos 
     * los integrantes y de los albumes unicamente se trae la informacion 
     * necesaria como id, nombre y imagen.
     * 
     * @param genero Genero del Artista buscado
     * @param fechaAgregacion Fecha en la que fue agregado a favoritos.
     * @param idUsuario Id del usuario logeado.
     * @return Lista de artistas Favoritos.
     * @throws DAOException En caso de excepcion en la consulta.
     */ 
    @Override
    public List<Artista> obtenerArtistasFavoritos(String genero, LocalDate fechaAgregacion, String idUsuario) throws DAOException {
        try {
            MongoCollection<Usuario> collection = conexion.getCollection("usuarios", Usuario.class);

            Usuario usuario = collection.find(eq("_id", idUsuario)).first();
            if (usuario == null) {
                throw new DAOException("Usuario no encontrado");
            }

            List<Artista> artistasFavoritos = new ArrayList<>();
            for (Favorito favorito : usuario.getFavoritos()) {
                if ("ARTISTA".equals(favorito.getTipo()) && 
                    (genero == null || genero.isEmpty() || genero.equals(favorito.getGenero())) && 
                    (fechaAgregacion == null || fechaAgregacion.equals(favorito.getFechaAgregacion()))) {

                    MongoCollection<Artista> artistaCollection = conexion.getCollection("artistas", Artista.class);
                    
                    Bson projection = fields(
                        include("id", "nombre", "imagen"),
                        Projections.computed("albums", fields(include("id", "nombre", "imagen_portada")))
                    );
                    
                    Artista artista = artistaCollection.find(eq("_id", favorito.getIdReferencia()))
                                                       .projection(projection)
                                                       .first();
                    if (artista != null) {
                        artistasFavoritos.add(artista);
                    }
                }
            }

            return artistasFavoritos;
        } catch (Exception e) {
            throw new DAOException("Error al obtener los artistas favoritos", e);
        }
    }


    /**
     * Metodo para obtener una lista de canciones que se encuentren marcados
     * como favoritos por parte del usuario(id especidicado en el parametro).
     * 
     * Si alguno de los filtros del parametro no esta vacio o nulo no se 
     * incluira en los filtros.
     * 
     * @param genero Genero del album donde esta presente la cancion.
     * @param fechaAgregacion Fecha en la que se agrego la cancion
     * @param idUsuario Id del usuario logeado.
     * @return Lista de canciones favoritas filtrada.
     * @throws DAOException En caso de excepcion en la consulta.
     */
    @Override
    public List<String> obtenerCancionesFavoritas(String genero, LocalDate fechaAgregacion, String idUsuario) throws DAOException {
        try {
            MongoCollection<Usuario> collection = conexion.getCollection("usuarios", Usuario.class);

            Usuario usuario = collection.find(eq("_id", idUsuario)).first();
            if (usuario == null) {
                throw new DAOException("Usuario no encontrado");
            }

            List<String> cancionesFavoritas = new ArrayList<>();
            for (Favorito favorito : usuario.getFavoritos()) {
                if ("CANCION".equals(favorito.getTipo()) && 
                    (genero == null || genero.isEmpty() || genero.equals(favorito.getGenero())) && 
                    (fechaAgregacion == null || fechaAgregacion.equals(favorito.getFechaAgregacion()))) {

                    cancionesFavoritas.add(favorito.getNombreCancion());
                }
            }
            return cancionesFavoritas;
        } catch (Exception e) {
            throw new DAOException("Error al obtener las canciones favoritas", e);
        }
    }

    /**
     * 
     * @param genero Genero del album donde esta presente la cancion.
     * @param fechaAgregacion Fecha en la que se agrego la cancion
     * @param idUsuario Id del usuario logeado.
     * @return Lista de canciones favoritas filtrada.
     * @throws DAOException En caso de excepcion en la consulta.
     */
    @Override
    public List<Album> obtenerAlbumesFavoritos(String genero, LocalDate fechaAgregacion, String idUsuario) throws DAOException {
        try {
            MongoCollection<Usuario> collection = conexion.getCollection("usuarios", Usuario.class);

            Usuario usuario = collection.find(eq("_id", idUsuario)).first();
            if (usuario == null) {
                throw new DAOException("Usuario no encontrado");
            }

            List<Album> albumesFavoritos = new ArrayList<>();
            for (Favorito favorito : usuario.getFavoritos()) {
                if ("ALBUM".equals(favorito.getTipo()) && 
                    (genero == null || genero.isEmpty() || genero.equals(favorito.getGenero())) && 
                    (fechaAgregacion == null || fechaAgregacion.equals(favorito.getFechaAgregacion()))) {

                    MongoCollection<Album> albumCollection = conexion.getCollection("albumes", Album.class);
                    // Proyección para incluir solo los campos necesarios del Álbum y del Artista
                    Bson projection = fields(
                        include("id", "nombre", "imagen_portada"),
                        Projections.computed("artista", fields(include("id", "nombre", "imagen")))
                    );
                    Album album = albumCollection.find(eq("_id", favorito.getIdReferencia()))
                                                 .projection(projection)
                                                 .first();
                    if (album != null) {
                        albumesFavoritos.add(album);
                    }
                }
            }

            return albumesFavoritos;
        } catch (Exception e) {
            throw new DAOException("Error al obtener los álbumes favoritos", e);
        }
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
    public boolean verificarCancionFavorita(String nombreCancion, 
            String idReferencia, String idUsuario) throws DAOException {
        try {
            MongoCollection<Usuario> collection = conexion.
                    getCollection("usuarios", Usuario.class);
            Usuario usuario = collection.find(and(eq("_id", idUsuario), 
                    elemMatch("favoritos", and(eq("id_referencia", 
                            idReferencia), eq("nombre_cancion", 
                                    nombreCancion))))).first();
            return usuario != null;
        } catch (Exception e) {
            throw new DAOException("Error al verificar si la canción"
                    + " es favorita", e);
        }
    }

    @Override
    public void eliminarCancionFavorita(String nombreCancion, String idUsuario) 
            throws DAOException {
        try {
            MongoCollection<Usuario> collection = conexion.
                    getCollection("usuarios", Usuario.class);

            // Filtrar el usuario por su ID y buscar la canción 
            // específica en sus favoritos
            collection.updateOne(eq("_id", idUsuario), 
                    Updates.pull("favoritos", Filters.
                            and(eq("nombre_cancion", nombreCancion), 
                                    eq("tipo", "CANCION"))));
        } catch (Exception e) {
            throw new DAOException("Error al eliminar la canción favorita", e);
        }
    }


}
