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
import com.bmn.singletonUsuario.UsuarioST;

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
    public void agregarRestringido(Genero genero) throws BOException {
        verificarRestringido(genero);
    }
    
    private void verificarRestringido(Genero genero) throws BOException{
        try{
            //trensformamos a genero.
            String genero1 = genero.name();
            
            //transformamos a usuario entidad.
            String usuario = UsuarioST.getInstance().getId();
            
            //si el genero no se encuentra restringido lo añadimos
            if (!usuarioDAO.verificarExistenciaRestringido(genero1, usuario)) { 
                usuarioDAO.añadirRestringido(genero1, usuario);
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
