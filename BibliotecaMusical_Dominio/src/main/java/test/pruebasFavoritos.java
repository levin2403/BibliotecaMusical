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
import com.bmd.entities.Favorito;
import com.bmd.entities.Usuario;
import com.mongodb.client.MongoCollection;
import java.time.LocalDate;
import org.bson.types.ObjectId;

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
        
        Favorito favorito1 = new Favorito();
        favorito1.setIdUsuario(new ObjectId("674eb761ad364c7a812e45fe"));
        favorito1.setIdReferencia("604c77f2a1b5b7844c8b4583");
        favorito1.setTipo("ARTISTA");
        favorito1.setGenero("Pop");
        favorito1.setNombreCancion(null); // No aplica para artistas
        favorito1.setFechaAgregacion(LocalDate.of(2023, 5, 10));

        Favorito favorito2 = new Favorito();
        favorito2.setIdUsuario(new ObjectId("604c77f2a1b5b7844c8b4571"));
        favorito2.setIdReferencia("604c77f2a1b5b7844c8b4581");
        favorito2.setTipo("ALBUM");
        favorito2.setGenero("Pop");
        favorito2.setNombreCancion(null); // No aplica para álbumes
        favorito2.setFechaAgregacion(LocalDate.of(2022, 3, 20));

        Favorito favorito3 = new Favorito();
        favorito3.setIdUsuario(new ObjectId("674eb761ad364c7a812e45fe"));
        favorito3.setIdReferencia("604c77f2a1b5b7844c8b4571");
        favorito3.setTipo("CANCION");
        favorito3.setGenero("Afrobeat");
        favorito3.setNombreCancion("Canción 1");
        favorito3.setFechaAgregacion(LocalDate.of(2021, 7, 15));

        Favorito favorito4 = new Favorito();
        favorito4.setIdUsuario(new ObjectId("674eb761ad364c7a812e45fe"));
        favorito4.setIdReferencia("604c77f2a1b5b7844c8b4571");
        favorito4.setTipo("CANCION");
        favorito4.setGenero("Afrobeat");
        favorito4.setNombreCancion("Canción 2"); // No aplica para artistas
        favorito4.setFechaAgregacion(LocalDate.of(2020, 11, 5));

        Favorito favorito5 = new Favorito();
        favorito5.setIdUsuario(new ObjectId("674eb761ad364c7a812e45fe"));
        favorito5.setIdReferencia("604c77f2a1b5b7844c8b4571");
        favorito5.setTipo("CANCION");
        favorito5.setGenero("Hip-Hop");
        favorito5.setNombreCancion("Canción 3");
        favorito5.setFechaAgregacion(LocalDate.of(2024, 1, 25));
        
            
        favoritoDAO.agregarFavorito(favorito1);
        favoritoDAO.agregarFavorito(favorito2);
        favoritoDAO.agregarFavorito(favorito3);
        favoritoDAO.agregarFavorito(favorito4);
        favoritoDAO.agregarFavorito(favorito5);
        
    }
    
}
