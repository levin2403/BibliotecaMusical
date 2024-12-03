package com.bdm.inserciones;

import com.bmd.entities.Album;
import com.bmd.entities.Artista;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InsertAlbums {

    public List<Album> crearAlbums(List<Artista> artistas) {
        List<Album> albums = new ArrayList<>();

        // Crea manualmente los álbumes para los artistas
        for (Artista artista : artistas) {
            if ("Selena Quintanilla".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S1A1")
                        .setNombre("Amor Prohibido")
                        .setImagenPortada("amor_prohibido.jpg")
                        .setFechaLanzamiento(LocalDate.of(1994, 3, 13))
                        .setGenero("Cumbia")
                        .setArtista(artista)
                        .setCanciones(List.of("Amor Prohibido", "Baila Esta Cumbia", "La Carcacha"))
                        .build());

                albums.add(new Album.Builder()
                        .setId("S1A2")
                        .setNombre("Entre a Mi Mundo")
                        .setImagenPortada("entre_a_mi_mundo.jpg")
                        .setFechaLanzamiento(LocalDate.of(1992, 5, 6))
                        .setGenero("Cumbia")
                        .setArtista(artista)
                        .setCanciones(List.of("Como La Flor", "La Carcacha", "¿Qué Creías?"))
                        .build());
            } else if ("Shakira".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S2A1")
                        .setNombre("Pies Descalzos")
                        .setImagenPortada("pies_descalzos.jpg")
                        .setFechaLanzamiento(LocalDate.of(1995, 2, 13))
                        .setGenero("Pop")
                        .setArtista(artista)
                        .setCanciones(List.of("Estoy Aquí", "Pies Descalzos", "Antología"))
                        .build());

                albums.add(new Album.Builder()
                        .setId("S2A2")
                        .setNombre("Dónde Están los Ladrones?")
                        .setImagenPortada("donde_estan_los_ladrones.jpg")
                        .setFechaLanzamiento(LocalDate.of(1998, 9, 29))
                        .setGenero("Pop")
                        .setArtista(artista)
                        .setCanciones(List.of("Ciega, Sordomuda", "Si Te Vas", "Moscas En La Casa"))
                        .build());
            } else if ("Enrique Iglesias".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S3A1")
                        .setNombre("Enrique Iglesias")
                        .setImagenPortada("enrique_iglesias.jpg")
                        .setFechaLanzamiento(LocalDate.of(1995, 11, 21))
                        .setGenero("Pop")
                        .setArtista(artista)
                        .setCanciones(List.of("Bailamos", "Experiencia Religiosa", "Si Tú Te Vas"))
                        .build());

                albums.add(new Album.Builder()
                        .setId("S3A2")
                        .setNombre("Escape")
                        .setImagenPortada("escape.jpg")
                        .setFechaLanzamiento(LocalDate.of(2001, 10, 30))
                        .setGenero("Pop")
                        .setArtista(artista)
                        .setCanciones(List.of("Escape", "Hero", "Don't Turn Off the Lights"))
                        .build());
            } else if ("Daddy Yankee".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S4A1")
                        .setNombre("Barrio Fino")
                        .setImagenPortada("barrio_fino.jpg")
                        .setFechaLanzamiento(LocalDate.of(2004, 5, 25))
                        .setGenero("Reggaeton")
                        .setArtista(artista)
                        .setCanciones(List.of("Gasolina", "Lo Que Pasó, Pasó", "Rompe"))
                        .build());

                albums.add(new Album.Builder()
                        .setId("S4A2")
                        .setNombre("El Cartel: The Big Boss")
                        .setImagenPortada("el_cartel_the_big_boss.jpg")
                        .setFechaLanzamiento(LocalDate.of(2007, 6, 5))
                        .setGenero("Reggaeton")
                        .setArtista(artista)
                        .setCanciones(List.of("Impacto", "Ella Me Levantó", "Fuera de Control"))
                        .build());
            } else if ("Bad Bunny".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S5A1")
                        .setNombre("YHLQMDLG")
                        .setImagenPortada("yhlqmdlg.jpg")
                        .setFechaLanzamiento(LocalDate.of(2020, 2, 29))
                        .setGenero("Reggaeton").setArtista(artista)
                        .setCanciones(List.of("Vete", "Safaera", "Yo Perreo Sola"))
                        .build());
                albums.add(new Album.Builder()
                        .setId("S5A2")
                        .setNombre("El Último Tour Del Mundo")
                        .setImagenPortada("el_ultimo_tour_del_mundo.jpg")
                        .setFechaLanzamiento(LocalDate.of(2020, 11, 27))
                        .setGenero("Reggaeton")
                        .setArtista(artista)
                        .setCanciones(List.of("Dákiti", "Booker T", "La Noche de Anoche"))
                        .build());
            } else if ("Ozuna".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S6A1")
                        .setNombre("Odisea")
                        .setImagenPortada("odisea.jpg")
                        .setFechaLanzamiento(LocalDate.of(2017, 8, 25))
                        .setGenero("Reggaeton")
                        .setArtista(artista)
                        .setCanciones(List.of("Dile Que Tú Me Quieres", "Se Preparó", "Tu Foto"))
                        .build());
                albums.add(new Album.Builder()
                        .setId("S6A2")
                        .setNombre("Aura")
                        .setImagenPortada("aura.jpg")
                        .setFechaLanzamiento(LocalDate.of(2018, 8, 24))
                        .setGenero("Reggaeton")
                        .setArtista(artista)
                        .setCanciones(List.of("Vaina Loca", "Ibiza", "Hola"))
                        .build());
            } else if ("Camila".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S7A1")
                        .setNombre("Todo Cambió")
                        .setImagenPortada("todo_cambio.jpg")
                        .setFechaLanzamiento(LocalDate.of(2005, 11, 9))
                        .setGenero("Pop")
                        .setArtista(artista)
                        .setCanciones(List.of("Todo Cambió", "Mientes", "Alejate de Mí"))
                        .build());
                albums.add(new Album.Builder()
                        .setId("S7A2")
                        .setNombre("Dejarte de Amar")
                        .setImagenPortada("dejarte_de_amar.jpg")
                        .setFechaLanzamiento(LocalDate.of(2010, 2, 9))
                        .setGenero("Pop")
                        .setArtista(artista)
                        .setCanciones(List.of("Bésame", "Entre Tus Alas", "Maya"))
                        .build());
            } else if ("Ricky Martin".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S8A1")
                        .setNombre("Vuelve")
                        .setImagenPortada("vuelve.jpg")
                        .setFechaLanzamiento(LocalDate.of(1998, 5, 26))
                        .setGenero("Pop")
                        .setArtista(artista)
                        .setCanciones(List.of("La Copa de la Vida", "Vuelve", "Volverás"))
                        .build());
                albums.add(new Album.Builder()
                        .setId("S8A2")
                        .setNombre("Livin' la Vida Loca")
                        .setImagenPortada("livin_la_vida_loca.jpg")
                        .setFechaLanzamiento(LocalDate.of(1999, 3, 23))
                        .setGenero("Pop")
                        .setArtista(artista)
                        .setCanciones(List.of("Livin' la Vida Loca", "She's All I Ever Had", "Shake Your Bon-Bon"))
                        .build());
            } else if ("Juanes".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S9A1")
                        .setNombre("Fíjate Bien")
                        .setImagenPortada("fijate_bien.jpg")
                        .setFechaLanzamiento(LocalDate.of(2000, 2, 29))
                        .setGenero("Rock")
                        .setArtista(artista)
                        .setCanciones(List.of("A Dios le Pido", "Es Por Ti", "Para Tu Amor"))
                        .build());
                albums.add(new Album.Builder()
                        .setId("S9A2")
                        .setNombre("Un Día Normal")
                        .setImagenPortada("un_dia_normal.jpg")
                        .setFechaLanzamiento(LocalDate.of(2002, 5, 21))
                        .setGenero("Rock")
                        .setArtista(artista)
                        .setCanciones(List.of("A Dios le Pido", "Un Día Normal", "La Paga"))
                        .build());
            } else if ("Alejandro Sanz".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S10A1")
                        .setNombre("Más")
                        .setImagenPortada("mas.jpg")
                        .setFechaLanzamiento(LocalDate.of(1997, 2, 3))
                        .setGenero("Pop")
                        .setArtista(artista)
                        .setCanciones(List.of("Corazón Partío", "Amiga Mía", "Y, ¿Si Fuera Ella?"))
                        .build());
                albums.add(new Album.Builder()
                        .setId("S10A2")
                        .setNombre("El Alma al Aire")
                        .setImagenPortada("el_alma_al_aire.jpg")
                        .setFechaLanzamiento(LocalDate.of(2000, 9, 26))
                        .setGenero("Pop")
                        .setArtista(artista)
                        .setCanciones(List.of("Cuando Nadie Me Ve", "Quisiera Ser", "El Alma al Aire"))
                        .build());
            } else if ("Marc Anthony".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S11A1")
                        .setNombre("Otra Nota")
                        .setImagenPortada("otra_nota.jpg")
                        .setFechaLanzamiento(LocalDate.of(1993, 11, 9))
                        .setGenero("Salsa")
                        .setArtista(artista)
                        .setCanciones(List.of("Vivir lo Nuestro", "Te Conozco Bien", "Que Precio Tiene el Cielo"))
                        .build());
                albums.add(new Album.Builder()
                        .setId("S11A2")
                        .setNombre("Contra la Corriente")
                        .setImagenPortada("contra_la_corriente.jpg")
                        .setFechaLanzamiento(LocalDate.of(1997, 10, 21))
                        .setGenero("Salsa")
                        .setArtista(artista)
                        .setCanciones(List.of("Y Hubo Alguien", "Contra la Corriente", "Me Voy a Regalar"))
                        .build());
            } else if ("Jennifer Lopez".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S12A1")
                        .setNombre("On the 6")
                        .setImagenPortada("on_the_6.jpg")
                        .setFechaLanzamiento(LocalDate.of(1999, 6, 1))
                        .setGenero("Pop")
                        .setArtista(artista)
                        .setCanciones(List.of("If You Had My Love", "Waiting for Tonight", "No Me Ames"))
                        .build());
                albums.add(new Album.Builder()
                        .setId("S12A2")
                        .setNombre("J.Lo")
                        .setImagenPortada("jlo.jpg")
                        .setFechaLanzamiento(LocalDate.of(2001, 1, 23))
                        .setGenero("Pop")
                        .setArtista(artista)
                        .setCanciones(List.of("Love Don't Cost a Thing", "Play", "Ain't It Funny"))
                        .build());
            } else if ("Luis Fonsi".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S13A1")
                        .setNombre("Comenzaré")
                        .setImagenPortada("comenzare.jpg")
                        .setFechaLanzamiento(LocalDate.of(1998, 4, 13))
                        .setGenero("Pop")
                        .setArtista(artista)
                        .setCanciones(List.of("Échame la Culpa", "Dime Cómo Quieres", "No Te Vayas"))
                        .build());
                albums.add(new Album.Builder()
                        .setId("S13A2")
                        .setNombre("Palabras del Silencio")
                        .setImagenPortada("palabras_del_silencio.jpg")
                        .setFechaLanzamiento(LocalDate.of(2008, 8, 26))
                        .setGenero("Pop")
                        .setArtista(artista)
                        .setCanciones(List.of("Aquí Estoy Yo", "No Me Doy Por Vencido", "Llueve Por Dentro"))
                        .build());
            } else if ("Carlos Vives".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S14A1")
                        .setNombre("Clásicos de la Provincia")
                        .setImagenPortada("clasicos_de_la_provincia.jpg")
                        .setFechaLanzamiento(LocalDate.of(2001, 4, 10))
                        .setGenero("Vallenato")
                        .setArtista(artista)
                        .setCanciones(List.of("La Tierra del Olvido", "Fruta Fresca", "Como le Gusta a Tu Cuerpo"))
                        .build());
                albums.add(new Album.Builder()
                        .setId("S14A2")
                        .setNombre("Déjame Entrar")
                        .setImagenPortada("dejame_entrar.jpg")
                        .setFechaLanzamiento(LocalDate.of(2001, 10, 6))
                        .setGenero("Vallenato")
                        .setArtista(artista)
                        .setCanciones(List.of("Déjame Entrar", "Amor Sensible", "Papadio"))
                        .build());
            } else if ("Juan Gabriel".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S15A1")
                        .setNombre("Querida")
                        .setImagenPortada("querida.jpg")
                        .setFechaLanzamiento(LocalDate.of(1984, 11, 15))
                        .setGenero("Pop")
                        .setArtista(artista)
                        .setCanciones(List.of("Querida", "La Farsa", "No Tengo Dinero"))
                        .build());

                albums.add(new Album.Builder()
                        .setId("S15A2")
                        .setNombre("Recuerdos, Vol. II")
                        .setImagenPortada("recuerdos_vol_ii.jpg")
                        .setFechaLanzamiento(LocalDate.of(1986, 2, 15))
                        .setGenero("Pop")
                        .setArtista(artista)
                        .setCanciones(List.of("Te lo Pido por Favor", "No Me Vuelvo a Enamorar", "Caray"))
                        .build());
            } else if ("Alejandro Fernández".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S16A1")
                        .setNombre("Me Volvieron Loco Tus Besos")
                        .setImagenPortada("me_volvieron_loco.jpg")
                        .setFechaLanzamiento(LocalDate.of(1999, 8, 23))
                        .setGenero("Ranchera")
                        .setArtista(artista)
                        .setCanciones(List.of("Me Volvieron Loco Tus Besos", "Que Manera de Quererte", "Te Voy a Perder"))
                        .build());

                albums.add(new Album.Builder()
                        .setId("S16A2")
                        .setNombre("Muy Dentro de Mi Corazón")
                        .setImagenPortada("muy_dentro_de_mi_corazon.jpg")
                        .setFechaLanzamiento(LocalDate.of(1996, 11, 19))
                        .setGenero("Ranchera")
                        .setArtista(artista)
                        .setCanciones(List.of("Como Quien Pierde una Estrella", "Abrazame", "Nube Viajera"))
                        .build());
            } else if ("Vicente Fernández".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S17A1")
                        .setNombre("La Voz Que Te Conquista")
                        .setImagenPortada("la_voz_que_te_conquista.jpg")
                        .setFechaLanzamiento(LocalDate.of(1992, 5, 1))
                        .setGenero("Ranchera")
                        .setArtista(artista)
                        .setCanciones(List.of("El Son de la Negra", "Volver Volver", "La Ley del Monte"))
                        .build());

                albums.add(new Album.Builder()
                        .setId("S17A2")
                        .setNombre("Para Siempre")
                        .setImagenPortada("para_siempre.jpg")
                        .setFechaLanzamiento(LocalDate.of(2007, 9, 11))
                        .setGenero("Ranchera")
                        .setArtista(artista)
                        .setCanciones(List.of("Estos Celos", "La Derrota", "El Último Beso"))
                        .build());
            } else if ("Pedro Infante".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S18A1")
                        .setNombre("El Inmortal")
                        .setImagenPortada("el_inmortal.jpg")
                        .setFechaLanzamiento(LocalDate.of(1954, 3, 25))
                        .setGenero("Ranchera")
                        .setArtista(artista)
                        .setCanciones(List.of("Amorcito Corazón", "Cien Años", "La Que Se Fue"))
                        .build());

                albums.add(new Album.Builder()
                        .setId("S18A2")
                        .setNombre("Las Mañanitas a Pedro Infante")
                        .setImagenPortada("las_mananitas_a_pedro_infante.jpg")
                        .setFechaLanzamiento(LocalDate.of(1957, 4, 15))
                        .setGenero("Ranchera")
                        .setArtista(artista)
                        .setCanciones(List.of("Las Mañanitas", "Serenata Huasteca", "La Calandria"))
                        .build());
            } else if ("La India".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S19A1")
                        .setNombre("Sobre el Fuego")
                        .setImagenPortada("sobre_el_fuego.jpg")
                        .setFechaLanzamiento(LocalDate.of(1994, 6, 21))
                        .setGenero("Salsa")
                        .setArtista(artista)
                        .setCanciones(List.of("Nunca Voy a Olvidarte", "Mi Mayor Venganza", "Me Voy"))
                        .build());

                albums.add(new Album.Builder()
                        .setId("S19A2")
                        .setNombre("Dicen Que Soy")
                        .setImagenPortada("dicen_que_soy.jpg")
                        .setFechaLanzamiento(LocalDate.of(1994, 10, 25))
                        .setGenero("Salsa")
                        .setArtista(artista)
                        .setCanciones(List.of("Dicen Que Soy", "Ese Hombre", "Vivir Lo Nuestro"))
                        .build());
            } else if ("Celia Cruz".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S20A1")
                        .setNombre("La Negra Tiene Tumbao")
                        .setImagenPortada("la_negra_tiene_tumbao.jpg")
                        .setFechaLanzamiento(LocalDate.of(2001, 5, 1))
                        .setGenero("Salsa")
                        .setArtista(artista)
                        .setCanciones(List.of("La Negra Tiene Tumbao", "Ríe y Llora", "Quimbara"))
                        .build());

                albums.add(new Album.Builder()
                        .setId("S20A2")
                        .setNombre("Regalo del Alma")
                        .setImagenPortada("regalo_del_alma.jpg")
                        .setFechaLanzamiento(LocalDate.of(2003, 8, 5))
                        .setGenero("Salsa")
                        .setArtista(artista)
                        .setCanciones(List.of("Rie y Llora", "Ella Tiene Fuego", "Pa' Arriba no Va"))
                        .build());
            } else if ("Romeo Santos".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S21A1")
                        .setNombre("Fórmula, Vol. 1")
                        .setImagenPortada("formula_vol_1.jpg")
                        .setFechaLanzamiento(LocalDate.of(2011, 11, 8))
                        .setGenero("Bachata")
                        .setArtista(artista)
                        .setCanciones(List.of("You", "Promise", "El Amor Que Perdimos"))
                        .build());

                albums.add(new Album.Builder()
                        .setId("S21A2")
                        .setNombre("Fórmula, Vol. 2")
                        .setImagenPortada("formula_vol_2.jpg")
                        .setFechaLanzamiento(LocalDate.of(2014, 2, 25))
                        .setGenero("Bachata")
                        .setArtista(artista)
                        .setCanciones(List.of("Propuesta Indecente", "Odio", "Eres Mía"))
                        .build());
            } else if ("Prince Royce".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S22A1")
                        .setNombre("Prince Royce")
                        .setImagenPortada("prince_roye.jpg")
                        .setFechaLanzamiento(LocalDate.of(2010, 2, 1))
                        .setGenero("Bachata")
                        .setArtista(artista)
                        .setCanciones(List.of("Stand by Me", "Corazón Sin Cara", "El Amor Que Perdimos"))
                        .build());

                albums.add(new Album.Builder()
                        .setId("S22A2")
                        .setNombre("Phase II")
                        .setImagenPortada("phase_ii.jpg")
                        .setFechaLanzamiento(LocalDate.of(2012, 4, 10))
                        .setGenero("Bachata")
                        .setArtista(artista)
                        .setCanciones(List.of("Las Cosas Pequeñas", "Incondicional", "Te Me Vas"))
                        .build());
            } else if ("Karol G".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S23A1")
                        .setNombre("Ocean")
                        .setImagenPortada("ocean.jpg")
                        .setFechaLanzamiento(LocalDate.of(2019, 10, 25))
                        .setGenero("Reggaeton")
                        .setArtista(artista)
                        .setCanciones(List.of("Tusa", "Pineapple", "Bichota"))
                        .build());

                albums.add(new Album.Builder()
                        .setId("S23A2")
                        .setNombre("KG0516")
                        .setImagenPortada("kg0516.jpg")
                        .setFechaLanzamiento(LocalDate.of(2021, 3, 25))
                        .setGenero("Reggaeton")
                        .setArtista(artista)
                        .setCanciones(List.of("El Makinon", "200 Copas", "Location"))
                        .build());
            } else if ("J Balvin".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S24A1")
                        .setNombre("Vibras")
                        .setImagenPortada("vibras.jpg")
                        .setFechaLanzamiento(LocalDate.of(2018, 5, 25))
                        .setGenero("Reggaeton")
                        .setArtista(artista)
                        .setCanciones(List.of("Mi Gente", "Ahora Me Llama", "Bobo"))
                        .build());

                albums.add(new Album.Builder()
                        .setId("S24A2")
                        .setNombre("Colores")
                        .setImagenPortada("colores.jpg")
                        .setFechaLanzamiento(LocalDate.of(2020, 3, 19))
                        .setGenero("Reggaeton")
                        .setArtista(artista)
                        .setCanciones(List.of("Blanco", "Morado", "Rojo"))
                        .build());
            } else if ("Maluma".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S25A1")
                        .setNombre("F.A.M.E.")
                        .setImagenPortada("fame.jpg")
                        .setFechaLanzamiento(LocalDate.of(2018, 5, 18))
                        .setGenero("Reggaeton")
                        .setArtista(artista)
                        .setCanciones(List.of("Felices los 4", "Corazón", "El Préstamo"))
                        .build());

                albums.add(new Album.Builder()
                        .setId("S25A2")
                        .setNombre("11:11")
                        .setImagenPortada("1111.jpg")
                        .setFechaLanzamiento(LocalDate.of(2019, 5, 17))
                        .setGenero("Reggaeton")
                        .setArtista(artista)
                        .setCanciones(List.of("HP", "11 PM", "Instinto Natural"))
                        .build());
            } else if ("Nicky Jam".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S26A1")
                        .setNombre("Fénix")
                        .setImagenPortada("fenix.jpg")
                        .setFechaLanzamiento(LocalDate.of(2017, 1, 20))
                        .setGenero("Reggaeton")
                        .setArtista(artista)
                        .setCanciones(List.of("El Perdón", "Hasta el Amanecer", "Travesuras"))
                        .build());

                albums.add(new Album.Builder()
                        .setId("S26A2")
                        .setNombre("Íntimo")
                        .setImagenPortada("intimo.jpg")
                        .setFechaLanzamiento(LocalDate.of(2019, 11, 1))
                        .setGenero("Reggaeton")
                        .setArtista(artista)
                        .setCanciones(List.of("Whine Up", "Te Robaré", "X"))
                        .build());
            } else if ("Zion & Lennox".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S27A1")
                        .setNombre("Motivan2")
                        .setImagenPortada("motivan2.jpg")
                        .setFechaLanzamiento(LocalDate.of(2016, 11, 25))
                        .setGenero("Reggaeton")
                        .setArtista(artista)
                        .setCanciones(List.of("Otra Vez", "Si Tu Me Dices", "Me Llamas"))
                        .build());

                albums.add(new Album.Builder()
                        .setId("S27A2")
                        .setNombre("Los Verdaderos")
                        .setImagenPortada("los_verdaderos.jpg")
                        .setFechaLanzamiento(LocalDate.of(2010, 11, 2))
                        .setGenero("Reggaeton")
                        .setArtista(artista)
                        .setCanciones(List.of("Te Hago el Amor", "Hoy Lo Siento", "Dame tu Amor"))
                        .build());
            } else if ("Anuel AA".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S28A1")
                        .setNombre("Real Hasta la Muerte")
                        .setImagenPortada("real_hasta_la_muerte.jpg")
                        .setFechaLanzamiento(LocalDate.of(2018, 7, 17))
                        .setGenero("Reggaeton")
                        .setArtista(artista)
                        .setCanciones(List.of("Ella Quiere Beber", "Secreto", "Brindemos"))
                        .build());

                albums.add(new Album.Builder()
                        .setId("S28A2")
                        .setNombre("Emmanuel")
                        .setImagenPortada("emmanuel.jpg")
                        .setFechaLanzamiento(LocalDate.of(2020, 5, 29))
                        .setGenero("Reggaeton")
                        .setArtista(artista)
                        .setCanciones(List.of("China", "Emmanuel", "Hasta Que Dios Diga"))
                        .build());
            } else if ("La Banda MS".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S29A1")
                        .setNombre("La Mejor Banda del Mundo")
                        .setImagenPortada("la_mejor_banda.jpg")
                        .setFechaLanzamiento(LocalDate.of(2014, 10, 7))
                        .setGenero("Banda")
                        .setArtista(artista)
                        .setCanciones(List.of("No Me Pidas Perdón", "Hermosa Experiencia", "El Mechón"))
                        .build());

                albums.add(new Album.Builder()
                        .setId("S29A2")
                        .setNombre("En Vivo")
                        .setImagenPortada("en_vivo.jpg")
                        .setFechaLanzamiento(LocalDate.of(2016, 4, 22))
                        .setGenero("Banda")
                        .setArtista(artista)
                        .setCanciones(List.of("Solo Con Verte", "Háblame de Ti", "Hermosa Experiencia"))
                        .build());
            } else if ("Intocable".equals(artista.getNombre())) {
                albums.add(new Album.Builder()
                        .setId("S30A1")
                        .setNombre("Intocable 20 Aniversario")
                        .setImagenPortada("intocable_20.jpg")
                        .setFechaLanzamiento(LocalDate.of(2014, 4, 29))
                        .setGenero("Banda")
                        .setArtista(artista)
                        .setCanciones(List.of("Aire", "Eres Mi Droga", "Te Amo Y Te Amo"))
                        .build());

                albums.add(new Album.Builder()
                        .setId("S30A2")
                        .setNombre("Highway")
                        .setImagenPortada("highway.jpg")
                        .setFechaLanzamiento(LocalDate.of(2016, 7, 1))
                        .setGenero("Banda")
                        .setArtista(artista)
                        .setCanciones(List.of("Quédate Conmigo", "Quiéreme", "Dímelo"))
                        .build());
            }

        }

        return albums;
    }
}
