/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import com.bdm.conexion.ConexionMongo;
import com.bmd.conexionIntefaces.IConexionMongo;
import com.bmd.dao.AlbumDAO;
import com.bmd.daoInterfaces.IAlbumDAO;
import com.bmd.entities.Usuario;
import com.mongodb.client.MongoCollection;

/**
 *
 * @author skevi
 */
public class pruebasAlbum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConexionMongo conexionMongo = ConexionMongo.getInstance();
        MongoCollection<Usuario> collection = conexionMongo.getCollection("usuarios", Usuario.class);
        System.out.println("Conexión a MongoDB exitosa: " + (collection != null));
        
        IConexionMongo conexion = new ConexionMongo();
        IAlbumDAO albumDAO = new AlbumDAO(conexion);  
        
          //ids de usuarios
//        "user1-id"
//        "user2-id"
//        "user3_id"


    }
    
}
