package com.bdm.inserciones;

import com.bmd.entities.Album;
import com.bmd.entities.Artista;
import com.bmd.enums.Genero;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.bdm.inserciones.*;
public class InsertAlbums {

    public static List<Album> getAlbums(Artista artista) {
        List<Album> albumes = new ArrayList<>();
        
        albumes.add(new Album.Builder()
            .setId("1")
            .setNombre("Amor Prohibido")
            .setImagenPortada("amor_prohibido.jpg")
            .setFechaLanzamiento(LocalDate.of(1994, 3, 13))
            .setGenero(Genero.Cumbia)
            .setArtista(artista)
            .build());
        
        return albumes;
    }
}
