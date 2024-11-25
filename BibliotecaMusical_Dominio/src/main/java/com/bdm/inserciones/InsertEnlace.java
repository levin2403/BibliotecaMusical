package com.bdm.inserciones;

import com.bmd.entities.Artista;
import com.bmd.entities.Album;
import com.bmd.entities.Cancion;

import java.util.List;

public class InsertEnlace {

    public static void main(String[] args) {
        // Obtener datos de las clases de inserción
        List<Artista> artistas = InsertArtistas.getArtistas();
        Artista artistaPrincipal = artistas.get(0); // Seleccionar el primer artista (puedes cambiar según sea necesario)

        // Obtener álbumes asociados al artista principal
        List<Album> albumes = InsertAlbums.getAlbums(artistaPrincipal);
        artistaPrincipal.setAlbums(albumes);

        // Obtener canciones y asociarlas al álbum principal
        Album albumPrincipal = albumes.get(0); // Seleccionar el primer álbum
        List<Cancion> canciones = InsertCanciones.getCanciones();
        albumPrincipal.setCanciones(canciones);

        // Mostrar relaciones para verificar
        imprimirRelaciones(artistaPrincipal);
    }

    private static void imprimirRelaciones(Artista artista) {
        System.out.println("Artista: " + artista.getNombre());
        for (Album album : artista.getAlbums()) {
            System.out.println("  Álbum: " + album.getNombre());
            for (Cancion cancion : album.getCanciones()) {
                System.out.println("    Canción: " + cancion.getTitulo());
            }
        }
    }
}
