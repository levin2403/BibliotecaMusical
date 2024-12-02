/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.negocio;

import com.bdm.excepciones.DAOException;
import com.bmd.daoInterfaces.IFavoritoDAO;
import com.bmd.enums.Genero;
import com.bmn.dto.CancionDTO;
import com.bmn.dto.constantes.Genero;
import com.bmn.excepciones.BOException;
import com.bmn.interfaces.IObtenerCancionesFavoritasBO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skevi
 */
public class ObtenerCancionesFavoritasBO implements IObtenerCancionesFavoritasBO {

     private IFavoritoDAO favoritoDAO;

    public ObtenerCancionesFavoritasBO(IFavoritoDAO favoritoDAO) {
        this.favoritoDAO = favoritoDAO;
    }
    
    @Override
    public List<CancionDTO> obtenerCancionesFavoritas(Genero genero, LocalDate fecha, String idUsuario) throws BOException {
        return procesar(genero, fecha, idUsuario);
    }
    
    private List<CancionDTO> procesar(Genero generoDTO, LocalDate fecha, String idUsuario) throws BOException {
        try{
            Genero genero = Genero.valueOf(generoDTO.name());
            
            List<String> canciones = favoritoDAO.obtenerCancionesFavoritas(genero, fecha, idUsuario);
            List<CancionDTO> cancionesDTO = new ArrayList<>();
            
            for (String cancion : canciones) {
                cancionesDTO.add(new CancionDTO(cancion));
            }
            
            for (CancionDTO cancionDTO : cancionesDTO) {
                cancionDTO.setFavorito(true);
            }
            
            return cancionesDTO;
        }
        catch(DAOException ex){
            throw new BOException(ex.getMessage());
        }   
    }
    
}

