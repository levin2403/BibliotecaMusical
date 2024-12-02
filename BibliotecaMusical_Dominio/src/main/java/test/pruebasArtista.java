/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import com.bdm.conexion.ConexionMongo;
import com.bdm.excepciones.DAOException;
import com.bmd.conexionIntefaces.IConexionMongo;
import com.bmd.dao.ArtistaDAO;
import com.bmd.daoInterfaces.IArtistaDAO;
import com.bmd.entities.Artista;
import com.bmd.entities.Integrante;
import com.bmd.entities.Usuario;
import com.mongodb.client.MongoCollection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skevi
 */
public class pruebasArtista {
    
    public static void main(String[] args) throws DAOException{
        
        ConexionMongo conexionMongo = ConexionMongo.getInstance();
        MongoCollection<Usuario> collection = conexionMongo.getCollection("usuarios", Usuario.class);
        System.out.println("Conexión a MongoDB exitosa: " + (collection != null));
        
        IConexionMongo conexion = new ConexionMongo();
        IArtistaDAO artistaDAO = new ArtistaDAO(conexion);  
        
          //ids de usuarios
//        "user1-id"
//        "user2-id"
//        "user3_id"

         //ids de artistas
//         "banda1_id"
//         "banda2_id"
//         "solista1_id"
//         "solista2_id"

        Integrante integrante1 = new Integrante();
        integrante1.setNombre("Carlos García");
        integrante1.setFechaIngreso(LocalDate.of(2015, 6, 1));
        integrante1.setFechaSalida(null); // Actualmente en la banda
        integrante1.setRol("Vocalista");
        integrante1.setEstadoActividad(true);
        
        Integrante integrante2 = new Integrante();
        integrante2.setNombre("Luis Rodríguez");
        integrante2.setFechaIngreso(LocalDate.of(2018, 3, 15));
        integrante2.setFechaSalida(LocalDate.of(2022, 12, 31)); // Ex-integrante
        integrante2.setRol("Guitarrista");
        integrante2.setEstadoActividad(false);

        List<Integrante> integrantes = new ArrayList<>();
        integrantes.add(integrante1);
        integrantes.add(integrante2);
        
        Artista banda1 = new Artista();
        banda1.setId("banda1_id");
        banda1.setTipoArtista("BANDA");
        banda1.setNombre("Los Hermanos Flores");
        banda1.setImagen("url_to_banda1_image.jpg");
        banda1.setGenero("Cumbia");
        banda1.setIntegrantes(integrantes);
        banda1.setAlbums(new ArrayList<>()); 

        Artista banda2 = new Artista();
        banda2.setId("banda2_id");
        banda2.setTipoArtista("BANDA");
        banda2.setNombre("Grupo Fantasma");
        banda2.setImagen("url_to_banda2_image.jpg");
        banda2.setGenero("Latin Funk");
        banda2.setIntegrantes(integrantes); 
        banda2.setAlbums(new ArrayList<>()); 
            
        Artista solista1 = new Artista();
        solista1.setId("solista1_id");
        solista1.setTipoArtista("SOLISTA");
        solista1.setNombre("Juan Gabriel");
        solista1.setImagen("url_to_solista1_image.jpg");
        solista1.setGenero("Ranchera");
        solista1.setIntegrantes(new ArrayList<>()); 
        solista1.setAlbums(new ArrayList<>()); 

        Artista solista2 = new Artista();
        solista2.setId("solista2_id");
        solista2.setTipoArtista("SOLISTA");
        solista2.setNombre("Selena");
        solista2.setImagen("url_to_solista2_image.jpg");
        solista2.setGenero("Afrobeat");
        solista2.setIntegrantes(new ArrayList<>()); 
        solista2.setAlbums(new ArrayList<>()); 
        
        
        // todos los metodos de album funcionan
        
//         List<Artista> artistas = artistaDAO.buscarPorFiltro("Juan Gabriel", "Afrobeat", "user1_id");
//        
//         for (Artista artista : artistas) {
//             System.out.println(artista.toString());
//        }

//        Artista artista1 = artistaDAO.buscarPorId("solista2_id");
//        System.out.println(artista1.toString());
//        
//        Artista artista2 = artistaDAO.buscarPorId("banda2_id");
//        System.out.println(artista2.toString());
        
//        artistaDAO.añadirArtista(banda1);
//        artistaDAO.añadirArtista(banda2);
//        artistaDAO.añadirArtista(solista1);
//        artistaDAO.añadirArtista(solista2);
        
    }
    
}
