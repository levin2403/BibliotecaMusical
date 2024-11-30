/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bdm.conexion;

import com.bmd.conexionIntefaces.IConexionMongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Clase ConexionMongo implementa la interfaz IConexionMongo.
 * Esta clase utiliza el patrón Singleton para manejar la conexión con MongoDB.
 *
 * @author skevi
 */
public class ConexionMongo implements IConexionMongo {

    // Instancia única de la clase para implementar el patrón Singleton
    private static ConexionMongo instance;
    
    // Cliente de MongoDB
    private MongoClient mongoClient;
    
    // Base de datos de MongoDB
    private MongoDatabase database;
    
    /**
     * Constructor privado para evitar la creación de nuevas instancias.
     * Conecta a la base de datos usando la URI proporcionada.
     */
    public ConexionMongo() {
        // Conecta a la base de datos usando la URI proporcionada
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        // Selecciona la base de datos
        database = mongoClient.getDatabase("bibliotecaMusical#");
    }

    /**
     * Método estático para obtener la instancia única de la clase.
     * Utiliza doble verificación para asegurar que solo se crea una instancia.
     *
     * @return La instancia única de ConexionMongo.
     */
    public static ConexionMongo getInstance() {
        if (instance == null) {
            synchronized (ConexionMongo.class) {
                if (instance == null) {
                    instance = new ConexionMongo();
                }
            }
        }
        return instance;
    }

    /**
     * Obtiene una colección específica de la base de datos.
     *
     * @param collectionName Nombre de la colección.
     * @return La colección de documentos de MongoDB.
     */
    @Override
    public MongoCollection<Document> getCollection(String collectionName) {
        return database.getCollection(collectionName);
    }

    /**
     * Cierra la conexión con la base de datos.
     */
    @Override
    public void closeConnection() {
        mongoClient.close();
    }
    
}

