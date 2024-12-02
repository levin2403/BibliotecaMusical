/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import com.bdm.conexion.ConexionMongo;
import com.bdm.excepciones.DAOException;
import com.bmd.conexionIntefaces.IConexionMongo;
import com.bmd.dao.FavoritoDAO;
import com.bmd.daoInterfaces.IFavoritoDAO;
import com.bmd.entities.Album;
import com.bmd.entities.Favorito;
import com.bmd.entities.Usuario;
import com.mongodb.client.MongoCollection;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author skevi
 */
public class pruebasFavoritos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DAOException {
        ConexionMongo conexionMongo = ConexionMongo.getInstance();
        MongoCollection<Usuario> collection = conexionMongo.getCollection("usuarios", Usuario.class);
        System.out.println("Conexión a MongoDB exitosa: " + (collection != null));
        
        IConexionMongo conexion = new ConexionMongo();
        IFavoritoDAO favoritoDAO = new FavoritoDAO(conexion);  
        
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
        
        Favorito favorito1 = new Favorito();
        favorito1.setIdUsuario("user3_id");
        favorito1.setIdReferencia("banda1_id");
        favorito1.setTipo("ARTISTA");
        favorito1.setGenero("Pop");
        favorito1.setNombreCancion(null); // No aplica para artistas
        favorito1.setFechaAgregacion(LocalDate.of(2023, 5, 10));

        Favorito favorito2 = new Favorito();
        favorito2.setIdUsuario("user3_id");
        favorito2.setIdReferencia("album1_id");
        favorito2.setTipo("ALBUM");
        favorito2.setGenero("Pop");
        favorito2.setNombreCancion(null); // No aplica para álbumes
        favorito2.setFechaAgregacion(LocalDate.of(2022, 3, 20));

        Favorito favorito3 = new Favorito();
        favorito3.setIdUsuario("user3_id");
        favorito3.setIdReferencia("album1_id");
        favorito3.setTipo("CANCION");
        favorito3.setGenero("Afrobeat");
        favorito3.setNombreCancion("Canción 1");
        favorito3.setFechaAgregacion(LocalDate.of(2021, 7, 15));

        Favorito favorito4 = new Favorito();
        favorito4.setIdUsuario("user3_id");
        favorito4.setIdReferencia("album1_id");
        favorito4.setTipo("CANCION");
        favorito4.setGenero("Afrobeat");
        favorito4.setNombreCancion("Canción 2"); // No aplica para artistas
        favorito4.setFechaAgregacion(LocalDate.of(2020, 11, 5));

        Favorito favorito5 = new Favorito();
        favorito5.setIdUsuario("user3_id");
        favorito5.setIdReferencia("album1_id");
        favorito5.setTipo("CANCION");
        favorito5.setGenero("Hip-Hop");
        favorito5.setNombreCancion("Canción 3");
        favorito5.setFechaAgregacion(LocalDate.of(2024, 1, 25));
        
        // todos los metodos de la clase funcionaron
        
        
//        List<Album> albumes = favoritoDAO.obtenerAlbumesFavoritos("Pop", null, "user3_id");
//        
//        for (Album album : albumes) {
//            System.out.println(album.toString());
//        }
//        
//        List<String> canciones = favoritoDAO.obtenerCancionesFavoritas("Hip-Hop", null, "user3_id");
//        
//        for (String cancion : canciones) {
//            System.out.println(cancion);
//        }
        
//        List<Artista> artistas = favoritoDAO.obtenerArtistasFavoritos("Afrobeat", LocalDate.of(2023, 5, 10), "user3_id");
        
//        for (Artista artista : artistas) {
//            System.out.println(artista.toString());
//        }
        
//        favoritoDAO.eliminarCancionFavorita("Canción 2", "user3_id");

//        favoritoDAO.eliminarFavoritoPorGenero("Pop", "user3_id");
        
//        favoritoDAO.eliminarFavorito("album1_id", "user3_id", "Album");
        
//        boolean favorito = favoritoDAO.verificarCancionFavorita("Canción ", "album1_id", "user3_id");
//        
//        if (favorito) {
//            System.out.println("si es favorito");
//        }
//        else{
//            System.out.println("no es");
//        }
        
//        boolean favorito = favoritoDAO.isFavorito("album1_i", "user3_id");
//        
//        if (favorito) {
//            System.out.println("si es favorito");
//        }
//        else{
//            System.out.println("no es");
//        }
            
//        favoritoDAO.agregarFavorito(favorito1);
//        favoritoDAO.agregarFavorito(favorito2);
//        favoritoDAO.agregarFavorito(favorito3);
//        favoritoDAO.agregarFavorito(favorito4);
//        favoritoDAO.agregarFavorito(favorito5);
        
    }
    
}
