/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.convertidores;

import com.bmd.entities.Album;
import com.bmn.dto.AlbumDTO;
import com.bmn.dto.CancionDTO;
import com.bmn.dto.constantes.GeneroDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skevi
 */
public class AlbumCVR {
    
    ArtistaCVR artistaCVR;

    public AlbumCVR(ArtistaCVR artistaCVR) {
        this.artistaCVR = artistaCVR;
    }
    
    public AlbumDTO toAlbumDTO(Album album){
        
        if (album == null) {
            return null;
        }
        
        AlbumDTO albumDTO = new AlbumDTO.Builder().
                setId(album.getId()).
                setNombre(album.getNombre()).
                setImagenPortada(album.getImagenPortada()).
                setFechaLanzamiento(album.getFechaLanzamiento()).
                setGenero(GeneroDTO.valueOf(album.getGenero().name())).
                setArtista(artistaCVR.toDTO(album.getArtista())).
                setCanciones(listaCanciones(album.getCanciones())).
                build();
        return albumDTO;
    }
    
    /**
     * aqui convertimos a dto para poder agregar despues si es fvorito
     * @return 
     */
    private List<CancionDTO> listaCanciones(List<String> canciones){
        
        List<CancionDTO> cancionesDTO = new ArrayList<>();
        
        for (int i = 0; i < canciones.size(); i++) {
            cancionesDTO.add(new CancionDTO(canciones.get(i)));
        }
        
        return cancionesDTO;
    }
    
}
