package com.bdm.inserciones;

import com.bmd.entities.Artista;
import java.util.ArrayList;
import java.util.List;

public class InsertArtistas {
//
//    public static List<Artista> getArtistas() {
//        List<Artista> artistas = new ArrayList<>();
//        
//        // Artista Selena
//        artistas.add(new Artista.Builder()
//            .setId("1")
//            .setNombre("Selena Quintanilla")
//            .setImagen("selena.jpg")
//            .setGenero(Genero.Cumbia)
//            .build());
//
//        // Artista Shakira
//        artistas.add(new Artista.Builder()
//            .setId("2")
//            .setNombre("Shakira")
//            .setImagen("shakira.jpg")
//            .setGenero(Genero.Pop)
//            .build());
//
//        // Artista Enrique Iglesias
//        artistas.add(new Artista.Builder()
//            .setId("3")
//            .setNombre("Enrique Iglesias")
//            .setImagen("enrique_iglesias.jpg")
//            .setGenero(Genero.Pop)
//            .build());
//
//        // Artista Daddy Yankee
//        artistas.add(new Artista.Builder()
//            .setId("4")
//            .setNombre("Daddy Yankee")
//            .setImagen("daddy_yankee.jpg")
//            .setGenero(Genero.Reggeton)
//            .build());
//
//        // Artista Bad Bunny
//        artistas.add(new Artista.Builder()
//            .setId("5")
//            .setNombre("Bad Bunny")
//            .setImagen("bad_bunny.jpg")
//            .setGenero(Genero.Reggeton)
//            .build());
//
//        // Artista Ozuna
//        artistas.add(new Artista.Builder()
//            .setId("6")
//            .setNombre("Ozuna")
//            .setImagen("ozuna.jpg")
//            .setGenero(Genero.Reggeton)
//            .build());
//
//        // Artista Camila
//        artistas.add(new Artista.Builder()
//            .setId("7")
//            .setNombre("Camila")
//            .setImagen("camila.jpg")
//            .setGenero(Genero.Pop)
//            .build());
//
//        // Artista Ricky Martin
//        artistas.add(new Artista.Builder()
//            .setId("8")
//            .setNombre("Ricky Martin")
//            .setImagen("ricky_martin.jpg")
//            .setGenero(Genero.Pop)
//            .build());
//
//        // Artista Juanes
//        artistas.add(new Artista.Builder()
//            .setId("9")
//            .setNombre("Juanes")
//            .setImagen("juanes.jpg")
//            .setGenero(Genero.Rock)
//            .build());
//
//        // Artista Alejandro Sanz
//        artistas.add(new Artista.Builder()
//            .setId("10")
//            .setNombre("Alejandro Sanz")
//            .setImagen("alejandro_sanz.jpg")
//            .setGenero(Genero.Pop)
//            .build());
//
//        // Artista Marc Anthony
//        artistas.add(new Artista.Builder()
//            .setId("11")
//            .setNombre("Marc Anthony")
//            .setImagen("marc_anthony.jpg")
//            .setGenero(Genero.Salsa)
//            .build());
//
//        // Artista Jennifer Lopez
//        artistas.add(new Artista.Builder()
//            .setId("12")
//            .setNombre("Jennifer Lopez")
//            .setImagen("jennifer_lopez.jpg")
//            .setGenero(Genero.Pop)
//            .build());
//
//        // Artista Luis Fonsi
//        artistas.add(new Artista.Builder()
//            .setId("13")
//            .setNombre("Luis Fonsi")
//            .setImagen("luis_fonsi.jpg")
//            .setGenero(Genero.Pop)
//            .build());
//
//        // Artista Carlos Vives
//        artistas.add(new Artista.Builder()
//            .setId("14")
//            .setNombre("Carlos Vives")
//            .setImagen("carlos_vives.jpg")
//            .setGenero(Genero.Vallenato)
//            .build());
//
//        // Artista Juan Gabriel
//        artistas.add(new Artista.Builder()
//            .setId("15")
//            .setNombre("Juan Gabriel")
//            .setImagen("juan_gabriel.jpg")
//            .setGenero(Genero.Pop)
//            .build());
//
//        // Artista Alejandro Fernández
//        artistas.add(new Artista.Builder()
//            .setId("16")
//            .setNombre("Alejandro Fernández")
//            .setImagen("alejandro_fernandez.jpg")
//            .setGenero(Genero.Ranchera)
//            .build());
//
//        // Artista Vicente Fernández
//        artistas.add(new Artista.Builder()
//            .setId("17")
//            .setNombre("Vicente Fernández")
//            .setImagen("vicente_fernandez.jpg")
//            .setGenero(Genero.Ranchera)
//            .build());
//
//        // Artista Pedro Infante
//        artistas.add(new Artista.Builder()
//            .setId("18")
//            .setNombre("Pedro Infante")
//            .setImagen("pedro_infante.jpg")
//            .setGenero(Genero.Ranchera)
//            .build());
//
//        // Artista La India
//        artistas.add(new Artista.Builder()
//            .setId("19")
//            .setNombre("La India")
//            .setImagen("la_india.jpg")
//            .setGenero(Genero.Salsa)
//            .build());
//
//        // Artista Celia Cruz
//        artistas.add(new Artista.Builder()
//            .setId("20")
//            .setNombre("Celia Cruz")
//            .setImagen("celia_cruz.jpg")
//            .setGenero(Genero.Salsa)
//            .build());
//
//        // Artista Romeo Santos
//        artistas.add(new Artista.Builder()
//                .setId("21")
//                .setNombre("Romeo Santos")
//                .setImagen("romeo_santos.jpg")
//                .setGenero(Genero.Bachata)
//                .build());
//
//        // Artista Prince Royce
//        artistas.add(new Artista.Builder()
//                .setId("22")
//                .setNombre("Prince Royce")
//                .setImagen("prince_royce.jpg")
//                .setGenero(Genero.Bachata)
//                .build());
//
//        // Artista Karol G
//        artistas.add(new Artista.Builder()
//                .setId("23")
//                .setNombre("Karol G")
//                .setImagen("karol_g.jpg")
//                .setGenero(Genero.Reggeton)
//                .build());
//
//        // Artista J Balvin
//        artistas.add(new Artista.Builder()
//                .setId("24")
//                .setNombre("J Balvin")
//                .setImagen("j_balvin.jpg")
//                .setGenero(Genero.Reggeton)
//                .build());
//
//        // Artista Maluma
//        artistas.add(new Artista.Builder()
//                .setId("25")
//                .setNombre("Maluma")
//                .setImagen("maluma.jpg")
//                .setGenero(Genero.Reggeton)
//                .build());
//
//        // Artista Nicky Jam
//        artistas.add(new Artista.Builder()
//                .setId("26")
//                .setNombre("Nicky Jam")
//                .setImagen("nicky_jam.jpg")
//                .setGenero(Genero.Reggeton)
//                .build());
//
//        // Artista Zion & Lennox
//        artistas.add(new Artista.Builder()
//                .setId("27")
//                .setNombre("Zion & Lennox")
//                .setImagen("zion_lennox.jpg")
//                .setGenero(Genero.Reggeton)
//                .build());
//
//        // Artista Anuel AA
//        artistas.add(new Artista.Builder()
//                .setId("28")
//                .setNombre("Anuel AA")
//                .setImagen("anuel_aa.jpg")
//                .setGenero(Genero.Reggeton)
//                .build());
//
//        // Artista La Banda MS
//        artistas.add(new Artista.Builder()
//                .setId("29")
//                .setNombre("La Banda MS")
//                .setImagen("la_banda_ms.jpg")
//                .setGenero(Genero.Banda)
//                .build());
//
//        // Artista Intocable
//        artistas.add(new Artista.Builder()
//                .setId("30")
//                .setNombre("Intocable")
//                .setImagen("intocable.jpg")
//                .setGenero(Genero.Banda)
//                .build());
//
//        return artistas;
//    }
}
