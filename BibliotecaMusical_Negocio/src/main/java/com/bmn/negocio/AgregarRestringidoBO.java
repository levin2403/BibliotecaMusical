/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.negocio;

import com.bdm.excepciones.DAOException;
import com.bmd.daoInterfaces.IUsuarioDAO;
import com.bmn.dto.RestringidoDTO;
import com.bmn.excepciones.BOException;
import com.bmn.interfaces.IAgregarRestringidoBO;

/**
 *
 * @author skevi
 */
public class AgregarRestringidoBO implements IAgregarRestringidoBO {

    private IUsuarioDAO usuarioDAO;

    public AgregarRestringidoBO(IUsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    
    @Override
    public void agregarRestringido(RestringidoDTO restringido) throws BOException {
        verificarRestringido(restringido);
    }
    
    private void verificarRestringido(RestringidoDTO restringido) throws BOException{
        try{
            //trensformamos a genero.
            
            //transformamos a usuario entidad.
            
            if (!usuarioDAO.verificarExistenciaRestringido(null, null)) { // genero, Usuario
                usuarioDAO.añadirRestringido(null, null);
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
