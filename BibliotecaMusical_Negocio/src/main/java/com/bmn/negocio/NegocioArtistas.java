package com.bmn.negocio;

import com.bmd.entities.Artista;
import com.bmd.entities.Album;
import com.bdm.conexion.ConexionMongo;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.List;

public class NegocioArtistas {

    private MongoCollection<Document> collectionArtista;
    private MongoCollection<Document> collectionAlbum;

    public NegocioArtistas() {
        ConexionMongo conexion = ConexionMongo.getInstance();
        collectionArtista = conexion.getCollection("artistas");
        collectionAlbum = conexion.getCollection("albums");
    }

    public void insertarArtistasYAlbums(List<Artista> artistas, List<Album> albums) {
        // Inserta los artistas en MongoDB
        for (Artista artista : artistas) {
            Document document = new Document()
                .append("_id", new ObjectId()) // Usar ObjectId para los IDs
                .append("tipoArtista", artista.getTipoArtista())
                .append("nombre", artista.getNombre())
                .append("imagen", artista.getImagen())
                .append("genero", artista.getGenero());
            collectionArtista.insertOne(document);
        }

        // Inserta los álbumes en MongoDB
        // Inserta los álbumes en MongoDB
for (Album album : albums) {
    try {
        Document document = new Document()
            .append("_id", new ObjectId()) // Usar ObjectId para los IDs
            .append("nombre", album.getNombre())
            .append("imagenPortada", album.getImagenPortada())
            .append("fechaLanzamiento", album.getFechaLanzamiento())
            .append("genero", album.getGenero())
            .append("artista", new Document("id", new ObjectId())
                                 .append("tipoArtista", album.getArtista().getTipoArtista())
                                 .append("nombre", album.getArtista().getNombre())
                                 .append("imagen", album.getArtista().getImagen())
                                 .append("genero", album.getArtista().getGenero()))
            .append("canciones", album.getCanciones());
        collectionAlbum.insertOne(document);
        System.out.println("Álbum insertado: " + album.getNombre());
    } catch (Exception e) {
        System.err.println("Error al insertar álbum: " + album.getNombre() + " - " + e.getMessage());
    }
}


        System.out.println("Inserción de artistas solistas y álbumes completada exitosamente");
    }
}
