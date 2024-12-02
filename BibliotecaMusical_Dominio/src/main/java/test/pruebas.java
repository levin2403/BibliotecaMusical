/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import com.bdm.conexion.ConexionMongo;
import com.bdm.excepciones.DAOException;
import com.bmd.conexionIntefaces.IConexionMongo;
import com.bmd.dao.UsuarioDAO;
import com.bmd.daoInterfaces.IUsuarioDAO;
import com.bmd.entities.Usuario;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author skevi
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DAOException {
        
        ConexionMongo conexionMongo = ConexionMongo.getInstance();
        MongoCollection<Usuario> collection = conexionMongo.getCollection("usuarios", Usuario.class);
        System.out.println("Conexión a MongoDB exitosa: " + (collection != null));
            
        IConexionMongo conexion = new ConexionMongo();
        IUsuarioDAO usuarioDAO = new UsuarioDAO(conexion);  
        
        Usuario usuario1 = new Usuario.Builder()
            .setId("user1-id")
            .setNombre("Juan Pérez")
            .setCorreo("juan.perez@example.com")
            .setContrasena("password123")
            .setImagenPerfil("url_to_image1.jpg")
            .setFavoritos(new ArrayList<>())
//            .setGenerosRestringidos(Arrays.asList("Hip_Hop"))
            .build();

        Usuario usuario2 = new Usuario.Builder()
            .setId("user2-id")
            .setNombre("María López")
            .setCorreo("maria.lopez@gmail.com")
            .setContrasena("password456")
            .setImagenPerfil("url_to_image2.jpg")
            .setFavoritos(new ArrayList<>())
//            .setGenerosRestringidos(Arrays.asList(Genero.Electronica))
            .build();

        Usuario usuario3 = new Usuario.Builder()
            .setId("user3_id")
            .setNombre("Carlos Gómez")
            .setCorreo("carlos.gomez@example.com")
            .setContrasena("password789")
            .setImagenPerfil("url_to_image3.jpg")
            .setFavoritos(new ArrayList<>())
            .setGenerosRestringidos(Arrays.asList("Afrobeat"))
            .build();

        //todaas las de usuarios ya funcionan
        
        
//        boolean existe = usuarioDAO.verificarExistenciaRestringido("Afrobeat", "user3_id");
//        
//         if (existe) {
//            System.out.println("si existe");
//        }
//        else{
//            System.out.println("no existe");
//        }
        
//        List<String> restringidos = usuarioDAO.obtenerRestringidos("user3_id");
//        
//        for (String restringido : restringidos) {
//            System.out.println(restringido.toString());
//        }
        
//        usuarioDAO.eliminarRestringido("Afrobeat", "user3_id");
        
//        usuarioDAO.añadirRestringido("Afrobeat", "user3_id");
        
//        usuarioDAO.actualizarUsuario(usuario4);
        
//        boolean existe = usuarioDAO.verificarExistenciaCorreo("carlos.gomez@example.com");
//        
//        if (existe) {
//            System.out.println("si existe");
//        }
//        else{
//            System.out.println("no existe");
//        }
        
//        Usuario usuario = usuarioDAO.buscaPorCorreo("maria.lopez@gmail.com");
//        System.out.println(usuario.toString());

//        usuarioDAO.añadirUsuario(usuario1);
//        usuarioDAO.añadirUsuario(usuario2);
        usuarioDAO.añadirUsuario(usuario3);

        
    }
    
}
