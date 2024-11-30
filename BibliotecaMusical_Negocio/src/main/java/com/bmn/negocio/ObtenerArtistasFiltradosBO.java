/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.negocio;

import com.bdm.excepciones.DAOException;
import com.bmd.daoInterfaces.IArtistaDAO;
import com.bmd.entities.Artista;
import com.bmd.enums.Genero;
import com.bmn.convertidores.ArtistaCVR;
import com.bmn.dto.ArtistaDTO;
import com.bmn.dto.constantes.GeneroDTO;
import com.bmn.excepciones.BOException;
import com.bmn.interfaces.IObtenerArtistasFiltradosBO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skevi
 */
public class ObtenerArtistasFiltradosBO implements IObtenerArtistasFiltradosBO {

    private IArtistaDAO artistaDAO;
    private ArtistaCVR artistaCVR;

    public ObtenerArtistasFiltradosBO(IArtistaDAO artistaDAO, ArtistaCVR artistaCVR) {
        this.artistaDAO = artistaDAO;
        this.artistaCVR = artistaCVR;
    }
    
    /**
     * 
     * @param nombre
     * @param genero
     * @param idUsuario
     * @return
     * @throws BOException 
     */
    @Override
    public List<ArtistaDTO> obtenerArtistasFiltrados(String nombre, GeneroDTO genero, String idUsuario) throws BOException {
        return procesar(nombre, genero, idUsuario);
    }
    
    
    private List<ArtistaDTO> procesar(String nombre, GeneroDTO generoDTO, String idUsuario) throws BOException {
        try{
            
            Genero genero = Genero.valueOf(generoDTO.name());
            
            List<Artista> artistas = artistaDAO.buscarPorFiltro(nombre, genero, idUsuario);
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
