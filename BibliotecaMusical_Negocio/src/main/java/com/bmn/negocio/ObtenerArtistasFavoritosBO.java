/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.negocio;

import com.bdm.excepciones.DAOException;
import com.bmd.daoInterfaces.IFavoritoDAO;
import com.bmd.entities.Artista;
import com.bmd.enums.Genero;
import com.bmn.convertidores.ArtistaCVR;
import com.bmn.dto.ArtistaDTO;
import com.bmn.dto.constantes.Genero;
import com.bmn.excepciones.BOException;
import com.bmn.interfaces.IObtenerArtistasFavoritosBO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skevi
 */
public class ObtenerArtistasFavoritosBO implements IObtenerArtistasFavoritosBO {

    private IFavoritoDAO favoritoDAO;
    private ArtistaCVR artistaCVR;

    public ObtenerArtistasFavoritosBO(IFavoritoDAO favoritoDAO, ArtistaCVR artistaCVR) {
        this.favoritoDAO = favoritoDAO;
        this.artistaCVR = artistaCVR;
    }
    
    @Override
    public List<ArtistaDTO> obtenerArtistasFavoritos(Genero genero, LocalDate fecha, String idUsuario) throws BOException {
        return procesar(genero, fecha, idUsuario);
    }
    
    private List<ArtistaDTO> procesar(Genero generoDTO, LocalDate fecha, String idUsuario) throws BOException{
        try{
            
            Genero genero = Genero.valueOf(generoDTO.name());
            
            List<Artista> artistas = favoritoDAO.obtenerArtistasFavoritos(genero, fecha, idUsuario);
            List<ArtistaDTO> artistasDTO = new ArrayList<>();
            
            for (Artista artista : artistas) {
                artistasDTO.add(artistaCVR.toDTO(artista));
            }
            
            for (ArtistaDTO artistaDTO : artistasDTO) {
                artistaDTO.setFavorito(true);
            }
            
            return artistasDTO;
            
        }
        catch(DAOException ex){
            throw new BOException(ex.getMessage());
        }
    }
    
}
