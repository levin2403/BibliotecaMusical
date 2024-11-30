/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.negocio;

import com.bdm.excepciones.DAOException;
import com.bmd.daoInterfaces.IUsuarioDAO;
import com.bmd.enums.Genero;
import com.bmn.dto.constantes.GeneroDTO;
import com.bmn.excepciones.BOException;
import com.bmn.interfaces.IObtenerRestringidosBO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skevi
 */
public class ObtenerRestringidosBO implements IObtenerRestringidosBO {

    private IUsuarioDAO usuarioDAO;

    public ObtenerRestringidosBO(IUsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    
    @Override
    public List<GeneroDTO> obtenerRestringidos(String idUsuario) throws BOException {
        return procesar(idUsuario);
    }
    
    private List<GeneroDTO> procesar(String idUsuario) throws BOException {
        try{
            
            List<Genero> baneados = usuarioDAO.obtenerRestringidos(idUsuario);
            List<GeneroDTO> baneadosDTO = new ArrayList<>();
            
            for (Genero genero : baneados) {
                baneadosDTO.add(GeneroDTO.valueOf(genero.name()));
            }
            
            return baneadosDTO;
            
        }
        catch(DAOException ex){
            throw new BOException(ex.getMessage());
        }
    } 
    
}
