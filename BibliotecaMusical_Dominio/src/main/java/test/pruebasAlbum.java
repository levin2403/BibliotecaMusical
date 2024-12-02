/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import com.bdm.conexion.ConexionMongo;
import com.bdm.excepciones.DAOException;
import com.bmd.conexionIntefaces.IConexionMongo;
import com.bmd.dao.AlbumDAO;
import com.bmd.daoInterfaces.IAlbumDAO;
import com.bmd.entities.Album;
import com.bmd.entities.Artista;
import com.bmd.entities.Usuario;
import com.mongodb.client.MongoCollection;
import java.time.LocalDate;
import java.util.Arrays;

/**
 *
 * @author skevi
 */
public class pruebasAlbum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DAOException {
        ConexionMongo conexionMongo = ConexionMongo.getInstance();
        MongoCollection<Usuario> collection = conexionMongo.getCollection("usuarios", Usuario.class);
        System.out.println("Conexión a MongoDB exitosa: " + (collection != null));
        
        IConexionMongo conexion = new ConexionMongo();
        IAlbumDAO albumDAO = new AlbumDAO(conexion);  
        
          //ids de usuarios
//        "user1-id"
//        "user2-id"
//        "user3_id"

          //ids de artistas
//         "banda1_id"
//         "banda2_id"
//         "solista1_id"
//         "solista2_id"

          //ids de albumes
//         "album1_id"
//         "album2_id"     

        Album album1 = new Album();
        album1.setId("album1_id");
        album1.setNombre("Éxitos de Cumbia");
        album1.setImagenPortada("url_to_album1_cover.jpg");
        album1.setFechaLanzamiento(LocalDate.of(2020, 1, 15));
        album1.setGenero("Cumbia");
        album1.setArtista(new Artista.Builder().setId("banda2_id").setNombre("the killa").build());
        album1.setCanciones(Arrays.asList("Canción 1", "Canción 2", "Canción 3"));

        Album album2 = new Album();
        album2.setId("album2_id");
        album2.setNombre("Clásicos del Rock");
        album2.setImagenPortada("url_to_album2_cover.jpg");
        album2.setFechaLanzamiento(LocalDate.of(2018, 10, 5));
        album2.setGenero("Afrobeat");
        album2.setArtista(new Artista.Builder().setId("solista1_id").setNombre("the strokes").build()); 
        album2.setCanciones(Arrays.asList("Canción A", "Canción B", "Canción C"));
        
        
        // ya todos los metodos jalan
//        
//        List<Album> albumes = albumDAO.BuscarPorFiltro("", LocalDate.of(2018, 10, 5), "", "user3_id");
//        
//        for (Album album : albumes) {
//            System.out.println(album.toString());
//        }
//
//        albumDAO.añadirAlbum(album1);
//        albumDAO.añadirAlbum(album2);
//
//        Album album = albumDAO.obtenerAlbum("album1_id");
//        System.out.println(album.toString());
        
    }
    
}
