/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.negocio;

import com.bdm.excepciones.DAOException;
import com.bmd.dao.FavoritoDAO;
import com.bmd.daoInterfaces.IArtistaDAO;
import com.bmd.entities.Artista;
import com.bmn.convertidores.ArtistaCVR;
import com.bmn.dto.ArtistaDTO;
import com.bmn.excepciones.BOException;
import com.bmn.interfaces.IObtenerArtistaBO;
import com.bmn.singletonUsuario.UsuarioST;

/**
 *
 * @author skevi
 */
public class ObtenerArtistaBO implements IObtenerArtistaBO {
    
    private IArtistaDAO artistaDAO;
    private FavoritoDAO favoritoDAO;
    private ArtistaCVR artistaCVR;

    public ObtenerArtistaBO(IArtistaDAO artistaDAO, FavoritoDAO favoritoDAO, ArtistaCVR artistaCVR) {
        this.artistaDAO = artistaDAO;
        this.favoritoDAO = favoritoDAO;
        this.artistaCVR = artistaCVR;
    }

    @Override
    public ArtistaDTO ObtenerArtista(String idArtista) throws BOException {
        verificarCampos(idArtista);
        return procesar(idArtista);
    }
    
    private void verificarCampos(String idArtista) throws BOException {
        if (idArtista.isEmpty()) {
            throw new BOException("El id no puede estar vacio.");
        }
    }
    
    private ArtistaDTO procesar(String idArtista) throws BOException {
        try{
            //obtenemos el artista 
            Artista artista = artistaDAO.buscarPorId(idArtista);
            
            //obtenemos el id del usuario registrado
            String idUsuario = UsuarioST.getInstance().getId();
            
            boolean favorito = verificarFavorito(idArtista, idUsuario);
            
            ArtistaDTO artistaDTO = artistaCVR.toDTO(artista);
            artistaDTO.setFavorito(favorito);
            return artistaDTO;
            
        }
        catch(DAOException ex){
            throw new BOException(ex.getMessage());
        }
    }
    
    private boolean verificarFavorito(String idArtista, String idUsuario) throws BOException {
        try{
            if (favoritoDAO.isFavorito(idArtista, idUsuario)) {
                return true;
            }
            else{
                return false;
            }
        }
        catch(DAOException ex){
            throw new BOException(ex.getMessage());
        }
    }
    
}
