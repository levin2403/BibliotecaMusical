/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import com.bdm.conexion.ConexionMongo;
import com.bmd.conexionIntefaces.IConexionMongo;
import com.bmd.dao.FavoritoDAO;
import com.bmd.daoInterfaces.IFavoritoDAO;
import com.bmd.entities.Usuario;
import com.mongodb.client.MongoCollection;

/**
 *
 * @author skevi
 */
public class pruebasFavoritos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConexionMongo conexionMongo = ConexionMongo.getInstance();
        MongoCollection<Usuario> collection = conexionMongo.getCollection("usuarios", Usuario.class);
        System.out.println("Conexión a MongoDB exitosa: " + (collection != null));
        
        IConexionMongo conexion = new ConexionMongo();
        IFavoritoDAO favoritoDAO = new FavoritoDAO(conexion);  
        
        
    }
    
}
