package com.bdm.inserciones;

import com.bmd.entities.Artista;
import com.bmd.entities.Album;
import com.bdm.conexion.ConexionMongo;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.List;

public class InsertEnlace {

    public static void main(String[] args) {
//        // Obtener la lista de artistas
//        List<Artista> artistas = InsertArtistas.getArtistas();
//        
//        // Crear una instancia de ConexionMongo
//        ConexionMongo conexionMongo = new ConexionMongo();
//
//        // Obtener las colecciones
//        MongoCollection<Document> artistasCollection = conexionMongo.getCollection("artistas");
//        MongoCollection<Document> albumsCollection = conexionMongo.getCollection("albums");
//
//        // Recorrer la lista de artistas y asociar sus álbumes
//        for (Artista artista : artistas) {
//            // Insertar el artista en la colección de artistas
//            Document artistaDocument = new Document("id", artista.getId())
//                    .append("nombre", artista.getNombre())
//                    .append("imagen", artista.getImagen())
//                    .append("genero", artista.getGenero().toString());
//            artistasCollection.insertOne(artistaDocument);
//
//            // Obtener los álbumes de cada artista
//            List<Album> albums = InsertAlbums.getAlbums(artista); // Pasa un solo objeto Artista
//
//            // Insertar los álbumes del artista en la colección de albums
//            for (Album album : albums) {
//                Document albumDocument = new Document("id", album.getId())
//                        .append("nombre", album.getNombre())
//                        .append("imagenPortada", album.getImagenPortada())
//                        .append("fechaLanzamiento", album.getFechaLanzamiento().toString())
//                        .append("genero", album.getGenero().toString())
//                        .append("canciones", album.getCanciones())
//                        .append("idArtista", artista.getId()); // Referencia al id del artista
//                albumsCollection.insertOne(albumDocument);
//            }
//        }
//
//        System.out.println("Datos insertados exitosamente.");
    }
}
