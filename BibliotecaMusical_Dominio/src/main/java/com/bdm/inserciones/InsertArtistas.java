package com.bdm.inserciones;

import com.bmd.entities.Artista;
import com.bmd.enums.Genero;
import java.util.ArrayList;
import java.util.List;


public class InsertArtistas {

    public static List<Artista> getArtistas() {
        List<Artista> artistas = new ArrayList<>();
        
        artistas.add(new Artista.Builder()
            .setId("1")
            .setNombre("Selena Quintanilla")
            .setImagen("selena.jpg")
            .setGenero(Genero.Cumbia)
            .build());
        
        return artistas;
    }
}
