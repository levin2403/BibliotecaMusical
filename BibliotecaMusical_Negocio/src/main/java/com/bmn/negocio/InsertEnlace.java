package com.bmn.negocio;

import com.bdm.inserciones.InsertAlbums;
import com.bdm.inserciones.InsertArtistas;
import com.bmd.entities.Artista;
import com.bmd.entities.Album;

import java.util.List;

public class InsertEnlace {

    public static void main(String[] args) {
        // Crear instancia de InsertArtistas y obtener la lista de artistas
        InsertArtistas insertArtistas = new InsertArtistas();
        List<Artista> artistas = insertArtistas.crearArtistas();

        // Crear instancia de InsertAlbums y obtener la lista de álbumes
        InsertAlbums insertAlbums = new InsertAlbums();
        List<Album> albums = insertAlbums.crearAlbums(artistas);

        // Crear instancia de NegocioArtistas para manejar las inserciones
        NegocioArtistas negocioArtistas = new NegocioArtistas();
        negocioArtistas.insertarArtistasYAlbums(artistas, albums);
    }
}
