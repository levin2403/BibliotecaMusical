/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.negocio;

import com.bmd.daoInterfaces.IFavoritoDAO;
import com.bmn.dto.AlbumDTO;
import com.bmn.dto.constantes.GeneroDTO;
import com.bmn.excepciones.BOException;
import com.bmn.interfaces.IObtenerAlbumesFavoritosBO;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author skevi
 */
public class ObtenerAlbumesFavoritosBO implements IObtenerAlbumesFavoritosBO {
   
    private IFavoritoDAO favoritoDAO;

    public IFavoritoDAO getFavoritoDAO() {
        return favoritoDAO;
    }

    public void setFavoritoDAO(IFavoritoDAO favoritoDAO) {
        this.favoritoDAO = favoritoDAO;
    }

    @Override
    public AlbumDTO obtenerAlbumesFavoritos(GeneroDTO genero, LocalDate fechaAgregacion) throws BOException {
        return procesar(genero, fechaAgregacion);
    }
    
    //aqui obtendras y convertiras los albumes
    private AlbumDTO procesar(GeneroDTO genero, LocalDate fechaAgregacion) throws BOException {
        return null;
    }
    
    //aqui les añadiras que si es favorito
    //lo usaras dentro del metodo de arriba
    private void añadirFavorito(List<AlbumDTO> albumes) throws BOException {
        
    }
    
    private void verificarCancionFavorita() throws BOException {
        
    }
    
}
