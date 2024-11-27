package com.bdm.inserciones;

import com.bmd.entities.Artista;
import com.bmd.entities.Album;
//import com.bmd.entities.Cancion;
import com.bdm.conexion.ConexionMongo;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.List;

public class InsertEnlace {

    public static void main(String[] args) {
        // Obtener la instancia de la conexión
        ConexionMongo conexion = ConexionMongo.getInstance();

//        try {
//            // Obtener colecciones de MongoDB
//            MongoCollection<Document> artistasCollection = conexion.getCollection("artistas");
//            MongoCollection<Document> albumsCollection = conexion.getCollection("albums");
//            MongoCollection<Document> cancionesCollection = conexion.getCollection("canciones");
//
//            // Obtener datos de las clases de inserción
//            List<Artista> artistas = InsertArtistas.getArtistas();
//            Artista artistaPrincipal = artistas.get(0);
//
//            // Insertar artistas
//            for (Artista artista : artistas) {
//                Document artistaDoc = artistaToDocument(artista);
//                artistasCollection.insertOne(artistaDoc);
//            }
//
//            // Obtener y asociar álbumes
//            List<Album> albumes = InsertAlbums.getAlbums(artistaPrincipal);
//            artistaPrincipal.setAlbums(albumes);
//
//            for (Album album : albumes) {
//                Document albumDoc = albumToDocument(album);
//                albumsCollection.insertOne(albumDoc);
//
//                // Asociar canciones al álbum
//                List<Cancion> canciones = InsertCanciones.getCanciones();
//                album.setCanciones(canciones);
//
//                for (Cancion cancion : canciones) {
//                    Document cancionDoc = cancionToDocument(cancion);
//                    cancionesCollection.insertOne(cancionDoc);
//                }
//            }
//
//            // Verificar las relaciones en consola
//            imprimirRelaciones(artistaPrincipal);
//
//        } finally {
//            // Cerrar la conexión
//            conexion.closeConnection();
//        }
//    }

//    private static void imprimirRelaciones(Artista artista) {
//        System.out.println("Artista: " + artista.getNombre());
//        for (Album album : artista.getAlbums()) {
//            System.out.println("  Álbum: " + album.getNombre());
//            for (Cancion cancion : album.getCanciones()) {
//                System.out.println("    Canción: " + cancion.getTitulo());
//            }
//        }
//    }
//
//    private static Document artistaToDocument(Artista artista) {
//        return new Document("id", artista.getId())
//                .append("nombre", artista.getNombre())
//                .append("imagen", artista.getImagen())
//                .append("genero", artista.getGenero().toString());
//    }

//    private static Document albumToDocument(Album album) {
//        return new Document("id", album.getId())
//                .append("nombre", album.getNombre())
//                .append("imagenPortada", album.getImagenPortada())
//                .append("fechaLanzamiento", album.getFechaLanzamiento().toString())
//                .append("genero", album.getGenero().toString())
//                .append("artistaId", album.getArtista().getId());
//    }

//    private static Document cancionToDocument(Cancion cancion) {
//        return new Document("id", cancion.getId())
//                .append("titulo", cancion.getTitulo())
//                .append("duracion", cancion.getDuracion());
    }
}
