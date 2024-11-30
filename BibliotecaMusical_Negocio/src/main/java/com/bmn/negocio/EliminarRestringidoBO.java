/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.negocio;

import com.bdm.excepciones.DAOException;
import com.bmd.daoInterfaces.IUsuarioDAO;
import com.bmn.dto.RestringidoDTO;
import com.bmn.excepciones.BOException;
import com.bmn.interfaces.IEliminarRestringidoBO;

/**
 *
 * @author skevi
 */
public class EliminarRestringidoBO implements IEliminarRestringidoBO {
    
    private IUsuarioDAO usuarioDAO;

    public EliminarRestringidoBO(IUsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    
    @Override
    public void eliminarRestringido(RestringidoDTO restringido) throws BOException {
        procesarEliminarRestringido(restringido);
    }
    
    private void procesarEliminarRestringido(RestringidoDTO restringido) throws BOException{
        try{
            //trensformamos a genero.
            
            //transformamos a usuario entidad.
            
            //eliminamos el genero de restringidos
            usuarioDAO.eliminarRestringido(null, null);
        }
        catch(DAOException ex){
            throw new BOException(ex.getMessage());
        }
    }
    
}
