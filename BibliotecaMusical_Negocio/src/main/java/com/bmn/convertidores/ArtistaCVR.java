/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.convertidores;

import com.bmd.entities.Album;
import com.bmd.entities.Artista;
import com.bmd.entities.Integrante;
import com.bmn.dto.AlbumDTO;
import com.bmn.dto.ArtistaDTO;
import com.bmn.dto.IntegranteDTO;
import com.bmn.dto.constantes.GeneroDTO;
import java.util.List;

/**
 *
 * @author skevi
 */
public class ArtistaCVR {
    
    private IntegranteCVR integranteCVR;
    private AlbumCVR albumCVR;

    public ArtistaCVR(IntegranteCVR integranteCVR, AlbumCVR albumCVR) {
        this.integranteCVR = integranteCVR;
        this.albumCVR = albumCVR;
    }
    
    public ArtistaDTO toDTO(Artista artista){
        
        if (artista == null) {
            return null;
        }
        
        ArtistaDTO artistaDTO = new ArtistaDTO.Builder().
                setId(artista.getId()).
                setTipoArtista(artista.getTipoArtista().name()).
                setNombre(artista.getNombre()).
                setImagen(artista.getImagen()).
                setGenero(GeneroDTO.valueOf(artista.getGenero().name())).
                setIntegrantes(convertirIntegrantes(artista.getIntegrantes())).
                setAlbums(convertirAlbumes(artista.getAlbums())).
                build();
        return artistaDTO;
    }
    
    
    private List<IntegranteDTO> convertirIntegrantes(List<Integrante> integrantes){
        for (Integrante integrante : integrantes) {
            
        }
        return null;
    }
    
    private List<AlbumDTO> convertirAlbumes(List<Album> albumes){
        for (Album albume : albumes) {
            
        }
        return null;
    }
    
}
