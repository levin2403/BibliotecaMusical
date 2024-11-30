/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.negocio;

import com.bdm.excepciones.DAOException;
import com.bmd.daoInterfaces.IUsuarioDAO;
import com.bmd.enums.Genero;
import com.bmn.convertidores.UsuarioCVR;
import com.bmn.dto.RestringidoDTO;
import com.bmn.excepciones.BOException;
import com.bmn.interfaces.IEliminarRestringidoBO;
import com.bmn.singletonUsuario.UsuarioST;

/**
 *
 * @author skevi
 */
public class EliminarRestringidoBO implements IEliminarRestringidoBO {
    
     private IUsuarioDAO usuarioDAO;
    private UsuarioCVR usuarioCVR;

    public EliminarRestringidoBO(IUsuarioDAO usuarioDAO, UsuarioCVR usuarioCVR) {
        this.usuarioDAO = usuarioDAO;
        this.usuarioCVR = usuarioCVR;
    }
    
    @Override
    public void eliminarRestringido(RestringidoDTO restringido) throws BOException {
        verificarRestringido(restringido);
    }
    
    private void verificarRestringido(RestringidoDTO restringido) throws BOException{
        try{
            //trensformamos a genero.
            Genero genero = Genero.valueOf(restringido.getGenero().name());
            
            //transformamos a usuario entidad.
            String usuario = UsuarioST.getInstance().getId();
            
            //si el genero no se encuentra restringido lo añadimos
            if (!usuarioDAO.verificarExistenciaRestringido(genero, usuario)) { 
                usuarioDAO.añadirRestringido(genero, usuario);
            }
            else{
                throw new BOException("El genero ya se encuentra restringido");
            }
        }
        catch(DAOException ex){
            throw new BOException(ex.getMessage());
        }
    }    
    
}
