package com.bdm.inserciones;

import com.bmd.entities.Album;
import com.bmd.entities.Artista;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InsertAlbums {
//     
//     public static List<Album> getAlbums(Artista artistas) {
//        List<Album> albumes = new ArrayList<>();
//
//        // Agregar álbum de Selena
//        albumes.add(new Album.Builder()
//                .setId("1")
//                .setNombre("Amor Prohibido")
//                .setImagenPortada("amor_prohibido.jpg")
//                .setFechaLanzamiento(LocalDate.of(1994, 3, 13))
//                .setGenero(Genero.Cumbia)
//                .setArtista( artistas) // Selena Quintanilla
//                .setCanciones(List.of("Amor Prohibido", "Baila Esta Cumbia", "La Carcacha"))
//                .build());
//
//        // Agregar álbum de Shakira
//        albumes.add(new Album.Builder()
//                .setId("2")
//                .setNombre("Pies Descalzos")
//                .setImagenPortada("pies_descalzos.jpg")
//                .setFechaLanzamiento(LocalDate.of(1995, 2, 13))
//                .setGenero(Genero.Pop)
//                .setArtista( artistas) // Shakira
//                .setCanciones(List.of("Estoy Aquí", "Pies Descalzos", "Antología"))
//                .build());
//
//        // Agregar álbum de Enrique Iglesias
//        albumes.add(new Album.Builder()
//                .setId("3")
//                .setNombre("Enrique Iglesias")
//                .setImagenPortada("enrique_iglesias.jpg")
//                .setFechaLanzamiento(LocalDate.of(1995, 11, 21))
//                .setGenero(Genero.Pop)
//                .setArtista( artistas) // Enrique Iglesias
//                .setCanciones(List.of("Bailamos", "Experiencia Religiosa", "Si Tú Te Vas"))
//                .build());
//
//        // Agregar álbum de Daddy Yankee
//        albumes.add(new Album.Builder()
//                .setId("4")
//                .setNombre("Barrio Fino")
//                .setImagenPortada("barrio_fino.jpg")
//                .setFechaLanzamiento(LocalDate.of(2004, 5, 25))
//                .setGenero(Genero.Reggeton)
//                .setArtista( artistas) // Daddy Yankee
//                .setCanciones(List.of("Gasolina", "Lo Que Pasó, Pasó", "Rompe"))
//                .build());
//
//        // Agregar álbum de Bad Bunny
//        albumes.add(new Album.Builder()
//                .setId("5")
//                .setNombre("YHLQMDLG")
//                .setImagenPortada("yhlqmdlg.jpg")
//                .setFechaLanzamiento(LocalDate.of(2020, 2, 29))
//                .setGenero(Genero.Reggeton)
//                .setArtista( artistas) // Bad Bunny
//                .setCanciones(List.of("Vete", "Safaera", "Yo Perreo Sola"))
//                .build());
//
//        // Agregar álbum de Ozuna
//        albumes.add(new Album.Builder()
//                .setId("6")
//                .setNombre("Odisea")
//                .setImagenPortada("odisea.jpg")
//                .setFechaLanzamiento(LocalDate.of(2017, 8, 25))
//                .setGenero(Genero.Reggeton)
//                .setArtista( artistas) // Ozuna
//                .setCanciones(List.of("Dile Que Tú Me Quieres", "Se Preparó", "Tu Foto"))
//                .build());
//
//        // Agregar álbum de Camila
//        albumes.add(new Album.Builder()
//                .setId("7")
//                .setNombre("Todo Cambió")
//                .setImagenPortada("todo_cambio.jpg")
//                .setFechaLanzamiento(LocalDate.of(2005, 11, 9))
//                .setGenero(Genero.Pop)
//               .setArtista( artistas)// Camila
//                .setCanciones(List.of("Todo Cambió", "Mientes", "Alejate de Mí"))
//                .build());
//
//        // Agregar álbum de Ricky Martin
//        albumes.add(new Album.Builder()
//                .setId("8")
//                .setNombre("Vuelve")
//                .setImagenPortada("vuelve.jpg")
//                .setFechaLanzamiento(LocalDate.of(1998, 5, 26))
//                .setGenero(Genero.Pop)
//                .setArtista( artistas) // Ricky Martin
//                .setCanciones(List.of("La Copa de la Vida", "Vuelve", "Volverás"))
//                .build());
//
//        // Agregar álbum de Juanes
//        albumes.add(new Album.Builder()
//                .setId("9")
//                .setNombre("Fíjate Bien")
//                .setImagenPortada("fijate_bien.jpg")
//                .setFechaLanzamiento(LocalDate.of(2000, 2, 29))
//                .setGenero(Genero.Rock)
//                .setArtista( artistas)// Juanes
//                .setCanciones(List.of("A Dios le Pido", "Es Por Ti", "Para Tu Amor"))
//                .build());
//
//        // Agregar álbum de Alejandro Sanz
//        albumes.add(new Album.Builder()
//                .setId("10")
//                .setNombre("Más")
//                .setImagenPortada("mas.jpg")
//                .setFechaLanzamiento(LocalDate.of(1997, 2, 3))
//                .setGenero(Genero.Pop)
//                .setArtista( artistas)// Alejandro Sanz
//                .setCanciones(List.of("Corazón Partío", "Amiga Mía", "Y, ¿Si Fuera Ella?"))
//                .build());
//
//        // Agregar álbum de Marc Anthony
//        albumes.add(new Album.Builder()
//                .setId("11")
//                .setNombre("Otra Nota")
//                .setImagenPortada("otra_nota.jpg")
//                .setFechaLanzamiento(LocalDate.of(1993, 11, 9))
//                .setGenero(Genero.Salsa)
//                .setArtista( artistas) // Marc Anthony
//                .setCanciones(List.of("Vivir lo Nuestro", "Te Conozco Bien", "Que Precio Tiene el Cielo"))
//                .build());
//
//        // Agregar álbum de Jennifer Lopez
//        albumes.add(new Album.Builder()
//                .setId("12")
//                .setNombre("On the 6")
//                .setImagenPortada("on_the_6.jpg")
//                .setFechaLanzamiento(LocalDate.of(1999, 6, 1))
//                .setGenero(Genero.Pop)
//                .setArtista( artistas) // Jennifer Lopez
//                .setCanciones(List.of("If You Had My Love", "Waiting for Tonight", "No Me Ames"))
//                .build());
//
//        // Agregar álbum de Luis Fonsi
//        albumes.add(new Album.Builder()
//                .setId("13")
//                .setNombre("Comenzaré")
//                .setImagenPortada("comenzare.jpg")
//                .setFechaLanzamiento(LocalDate.of(1998, 4, 13))
//                .setGenero(Genero.Pop)
//                .setArtista( artistas)// Luis Fonsi
//                .setCanciones(List.of("Échame la Culpa", "Dime Cómo Quieres", "No Te Vayas"))
//                .build());
//
//        // Agregar álbum de Carlos Vives
//        albumes.add(new Album.Builder()
//                .setId("14")
//                .setNombre("Clásicos de la Provincia")
//                .setImagenPortada("clasicos_de_la_provincia.jpg")
//                .setFechaLanzamiento(LocalDate.of(2001, 4, 10))
//                .setGenero(Genero.Vallenato)
//                .setArtista( artistas) // Carlos Vives
//                .setCanciones(List.of("La Tierra del Olvido", "Fruta Fresca", "Como le Gusta a Tu Cuerpo"))
//                .build());
//
//        // Agregar álbum de Juan Gabriel
//        albumes.add(new Album.Builder()
//                .setId("15")
//                .setNombre("Querida")
//                .setImagenPortada("querida.jpg")
//                .setFechaLanzamiento(LocalDate.of(1984, 11, 15))
//                .setGenero(Genero.Pop)
//                .setArtista( artistas)// Juan Gabriel
//                .setCanciones(List.of("Querida", "La Farsa", "No Tengo Dinero"))
//                .build());
//
//        // Agregar álbum de Alejandro Fernández
//        albumes.add(new Album.Builder()
//                .setId("16")
//                .setNombre("Me Volvieron Loco Tus Besos")
//                .setImagenPortada("me_volvieron_loco.jpg")
//                .setFechaLanzamiento(LocalDate.of(1999, 8, 23))
//                .setGenero(Genero.Ranchera)
//                .setArtista( artistas) // Alejandro Fernández
//                .setCanciones(List.of("Me Volvieron Loco Tus Besos", "Que Manera de Quererte", "Te Voy a Perder"))
//                .build());
//
//        // Agregar álbum de Vicente Fernández
//        albumes.add(new Album.Builder()
//                .setId("17")
//                .setNombre("La Voz Que Te Conquista")
//                .setImagenPortada("la_voz_que_te_conquista.jpg")
//                .setFechaLanzamiento(LocalDate.of(1992, 5, 1))
//                .setGenero(Genero.Ranchera)
//                .setArtista( artistas) // Vicente Fernández
//                .setCanciones(List.of("El Son de la Negra", "Volver Volver", "La Ley del Monte"))
//                .build());
//
//        // Agregar álbum de Pedro Infante
//        albumes.add(new Album.Builder()
//                .setId("18")
//                .setNombre("El Inmortal")
//                .setImagenPortada("el_inmortal.jpg")
//                .setFechaLanzamiento(LocalDate.of(1954, 3, 25))
//                .setGenero(Genero.Ranchera)
//                .setArtista( artistas) // Pedro Infante
//                .setCanciones(List.of("Amorcito Corazón", "Cien Años", "La Que Se Fue"))
//                .build());
//
//        // Agregar álbum de La India
//        albumes.add(new Album.Builder()
//                .setId("19")
//                .setNombre("Sobre el Fuego")
//                .setImagenPortada("sobre_el_fuego.jpg")
//                .setFechaLanzamiento(LocalDate.of(1994, 6, 21))
//                .setGenero(Genero.Salsa)
//                .setArtista( artistas) // La India
//                .setCanciones(List.of("Nunca Voy a Olvidarte", "Mi Mayor Venganza", "Me Voy"))
//                .build());
//
//        // Agregar álbum de Celia Cruz
//        albumes.add(new Album.Builder()
//                .setId("20")
//                .setNombre("La Negra Tiene Tumbao")
//                .setImagenPortada("la_negra_tiene_tumbao.jpg")
//                .setFechaLanzamiento(LocalDate.of(2001, 5, 1))
//                .setGenero(Genero.Salsa)
//                .setArtista( artistas) // Celia Cruz
//                .setCanciones(List.of("La Negra Tiene Tumbao", "Ríe y Llora", "Quimbara"))
//                .build());
//        // Agregar álbum de Romeo Santos
//        albumes.add(new Album.Builder()
//                .setId("21")
//                .setNombre("Fórmula, Vol. 1")
//                .setImagenPortada("formula_vol_1.jpg")
//                .setFechaLanzamiento(LocalDate.of(2011, 11, 8))
//                .setGenero(Genero.Bachata)
//                .setArtista( artistas) // Romeo Santos
//                .setCanciones(List.of("You", "Promise", "El Amor Que Perdimos"))
//                .build());
//
//        // Agregar álbum de Prince Royce
//        albumes.add(new Album.Builder()
//                .setId("22")
//                .setNombre("Prince Royce")
//                .setImagenPortada("prince_roye.jpg")
//                .setFechaLanzamiento(LocalDate.of(2010, 2, 1))
//                .setGenero(Genero.Bachata)
//                .setArtista( artistas) // Prince Royce
//                .setCanciones(List.of("Stand by Me", "Corazón Sin Cara", "El Amor Que Perdimos"))
//                .build());
//
//        // Agregar álbum de Karol G
//        albumes.add(new Album.Builder()
//                .setId("23")
//                .setNombre("Ocean")
//                .setImagenPortada("ocean.jpg")
//                .setFechaLanzamiento(LocalDate.of(2019, 10, 25))
//                .setGenero(Genero.Reggeton)
//                .setArtista( artistas) // Karol G
//                .setCanciones(List.of("Tusa", "Pineapple", "Bichota"))
//                .build());
//
//        // Agregar álbum de J Balvin
//        albumes.add(new Album.Builder()
//                .setId("24")
//                .setNombre("Vibras")
//                .setImagenPortada("vibras.jpg")
//                .setFechaLanzamiento(LocalDate.of(2018, 5, 25))
//                .setGenero(Genero.Reggeton)
//                .setArtista( artistas) // J Balvin
//                .setCanciones(List.of("Mi Gente", "Ahora Me Llama", "Bobo"))
//                .build());
//
//        // Agregar álbum de Maluma
//        albumes.add(new Album.Builder()
//                .setId("25")
//                .setNombre("F.A.M.E.")
//                .setImagenPortada("fame.jpg")
//                .setFechaLanzamiento(LocalDate.of(2018, 5, 18))
//                .setGenero(Genero.Reggeton)
//                .setArtista( artistas) // Maluma
//                .setCanciones(List.of("Felices los 4", "Corazón", "El Préstamo"))
//                .build());
//
//        // Agregar álbum de Nicky Jam
//        albumes.add(new Album.Builder()
//                .setId("26")
//                .setNombre("Fénix")
//                .setImagenPortada("fenix.jpg")
//                .setFechaLanzamiento(LocalDate.of(2017, 1, 20))
//                .setGenero(Genero.Reggeton)
//                .setArtista( artistas) // Nicky Jam
//                .setCanciones(List.of("El Perdón", "Hasta el Amanecer", "Travesuras"))
//                .build());
//
//        // Agregar álbum de Zion & Lennox
//        albumes.add(new Album.Builder()
//                .setId("27")
//                .setNombre("Motivan2")
//                .setImagenPortada("motivan2.jpg")
//                .setFechaLanzamiento(LocalDate.of(2016, 11, 25))
//                .setGenero(Genero.Reggeton)
//                .setArtista( artistas) // Zion & Lennox
//                .setCanciones(List.of("Otra Vez", "Si Tu Me Dices", "Me Llamas"))
//                .build());
//
//        // Agregar álbum de Anuel AA
//        albumes.add(new Album.Builder()
//                .setId("28")
//                .setNombre("Real Hasta la Muerte")
//                .setImagenPortada("real_hasta_la_muerte.jpg")
//                .setFechaLanzamiento(LocalDate.of(2018, 7, 17))
//                .setGenero(Genero.Reggeton)
//                .setArtista( artistas)// Anuel AA
//                .setCanciones(List.of("Ella Quiere Beber", "Secreto", "Brindemos"))
//                .build());
//
//        // Agregar álbum de La Banda MS
//        albumes.add(new Album.Builder()
//                .setId("29")
//                .setNombre("La Mejor Banda del Mundo")
//                .setImagenPortada("la_mejor_banda.jpg")
//                .setFechaLanzamiento(LocalDate.of(2014, 10, 7))
//                .setGenero(Genero.Banda)
//               .setArtista( artistas) // La Banda MS
//                .setCanciones(List.of("No Me Pidas Perdón", "Hermosa Experiencia", "El Mechón"))
//                .build());
//
//        // Agregar álbum de Intocable
//        albumes.add(new Album.Builder()
//                .setId("30")
//                .setNombre("Intocable 20 Aniversario")
//                .setImagenPortada("intocable_20.jpg")
//                .setFechaLanzamiento(LocalDate.of(2014, 4, 29))
//                .setGenero(Genero.Banda)
//                .setArtista( artistas) // Intocable
//                .setCanciones(List.of("Aire", "Eres Mi Droga", "Te Amo Y Te Amo"))
//                .build());
//
//        return albumes;
//    }
}
