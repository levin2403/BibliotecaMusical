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
import java.util.ArrayList;
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
        
        List<IntegranteDTO> integrantesDTO = new ArrayList<>();
        
        for (int i = 0; i < integrantes.size(); i++) {
            
            IntegranteDTO integranteDTO = integranteCVR.toIntegranteDTO(integrantes.get(i));
            
            integrantesDTO.add(integranteDTO);
        }
        
        return integrantesDTO;
    }
    
    private List<AlbumDTO> convertirAlbumes(List<Album> albumes){

        List<AlbumDTO> albumesDTO = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            
            AlbumDTO albumDTO = albumCVR.toAlbumDTO(albumes.get(i));
            
            albumesDTO.add(albumDTO);
        }
        
        return albumesDTO;
    }
    
}
