/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import com.bdm.conexion.ConexionMongo;
import com.bmd.conexionIntefaces.IConexionMongo;
import com.bmd.dao.ArtistaDAO;
import com.bmd.daoInterfaces.IArtistaDAO;
import com.bmd.entities.Artista;
import com.bmd.entities.Usuario;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;

/**
 *
 * @author skevi
 */
public class pruebasArtista {
    
    public static void main(String[] args){
        
        ConexionMongo conexionMongo = ConexionMongo.getInstance();
        MongoCollection<Usuario> collection = conexionMongo.getCollection("usuarios", Usuario.class);
        System.out.println("Conexión a MongoDB exitosa: " + (collection != null));
        
        IConexionMongo conexion = new ConexionMongo();
        IArtistaDAO albumDAO = new ArtistaDAO(conexion);  
        
          //ids de usuarios
//        "user1-id"
//        "user2-id"
//        "user3_id"

        Artista banda1 = new Artista();
        banda1.setId("banda1_id");
        banda1.setTipoArtista("BANDA");
        banda1.setNombre("Los Hermanos Flores");
        banda1.setImagen("url_to_banda1_image.jpg");
        banda1.setGenero("Cumbia");
        banda1.setIntegrantes(new ArrayList<>());
        banda1.setAlbums(new ArrayList<>()); 

        Artista banda2 = new Artista();
        banda2.setId("banda2_id");
        banda2.setTipoArtista("BANDA");
        banda2.setNombre("Grupo Fantasma");
        banda2.setImagen("url_to_banda2_image.jpg");
        banda2.setGenero("Latin Funk");
        banda2.setIntegrantes(new ArrayList<>()); 
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
        solista2.setGenero("Tejano");
        solista2.setIntegrantes(new ArrayList<>()); 
        solista2.setAlbums(new ArrayList<>()); 

    }
    
}
