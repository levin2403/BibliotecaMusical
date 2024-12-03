/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.negocio;

import com.bdm.excepciones.DAOException;
import com.bmd.daoInterfaces.IUsuarioDAO;
import com.bmn.dto.constantes.Genero;
import com.bmn.excepciones.BOException;
import com.bmn.interfaces.IAgregarRestringidoBO;
import org.bson.types.ObjectId;

/**
 * Clase para agregar géneros restringidos a un usuario.
 * 
 * @autor skevi
 */
public class AgregarRestringidoBO implements IAgregarRestringidoBO {

    private IUsuarioDAO usuarioDAO;

    public AgregarRestringidoBO(IUsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    
    @Override
    public void agregarRestringido(Genero genero) throws BOException {
        verificarRestringido(genero);
    }
    
    private void verificarRestringido(Genero genero) throws BOException {
        try {
            // Transformamos el género a su representación en cadena.
            String genero1 = genero.name();
            
            // Obtener el ID del usuario. Este valor debe ser dinámico según tu implementación.
            ObjectId idUsuario = new ObjectId("674eb761ad364c7a812e45fe"); // Asegúrate de que este ID es correcto
            
            // Si el género no se encuentra restringido, lo añadimos
            if (usuarioDAO.verificarExistenciaRestringido(genero1, idUsuario)) { 
                usuarioDAO.añadirRestringido(genero1, idUsuario);
            } else {
                throw new BOException("El género ya se encuentra restringido");
            }
        } catch (DAOException ex) {
            throw new BOException(ex.getMessage(), ex);
        }
    }
}

