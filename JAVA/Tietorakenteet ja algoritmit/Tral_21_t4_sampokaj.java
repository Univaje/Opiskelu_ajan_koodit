
package com.company.TraI_21_t4;

// TraI_21_t4_5_pohja.java SJ
// Pohja viikon 1 tehtäviin 4-5

/**
 * 4. Kirjoita algoritmi (Java-metodi) joka saa parametrinaan kaksi kokonaislukutaulukkoa (In-
 * teger[] A, Integer[] B) ja joka luo ja palauttaa uuden kokonaislukutaulukon jossa on kaikki ne
 * alkiot jotka löytyvät jommastakummasta taulukosta (siis niiden yhdisteen). Kukin alkio
 * (.equals() palauttaa toden) tulee kuitenkin tulostaulukkoon vain yhden kerran vaikka se
 * esiintyisi toisessa tai molemmissa taulukoissa useamman kerran. Mikä on algoritmisi
 * aikavaativuus? Voisiko sitä parantaa?
 *
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Kirjoita algoritmi (Java-metodi) joka saa parametrinaan kaksi kokonaislukutaulukkoa
 * (Integer[] A, Integer[] B) ja joka luo ja palauttaa uuden kokonaislukutaulukon jossa
 * on kaikki ne alkiot jotka löytyvät jommastakummasta taulukosta (siis niiden yhdisteen).
 * Kukin alkio (.equals() palauttaa toden) tulee kuitenkin tulostaulukkoon vain yhden kerran
 * vaikka se esiintyisi toisessa tai molemmissa taulukoissa useamman kerran. Mikä on algoritmisi
 * aikavaativuus? Voisiko sitä parantaa?
 *
 * Olen lopettanut taulukoiden käyttämisen koulun ensimmäisellä ohjelmoinnin kurssilla niiden käytön
 * hankaluuden johdosta. Toteutin ohjelman käyttämällä Listejä. Taulujen käyttö on lähtökohtaisesti
 * minulle vierasta ja vaikeaa. Periaatteena tämä toisimi niin että ensin yhdistetään listat
 * kolmanneksi listaksi josta tarkistetaan kaksois kappaleet ja siirretään duplikaatit loppuun ja samalla
 * merkataan uniikit luvut erikseen. Tehdään uusi taulukko joka on uniikkien määrän mukainen. ja siirretään
 * yhdiste taulun alusta duplikaatteihin asti luvut uuteen tauluun. Tämän tekemiseen tuhrautui useampi päivä
 * enkä lopulta saanut sitä edes toimimaan oikein. Tästä johdosta koin helpoimmaksi siirtää luvut listaan ja kääntää
 * lista takaisin taulukoksi.
 *
 * Mikä on algoritmisi aikavaativuus?
 * Aika vaativuus algoritmissa on 3n+n^2.
 * Algoritmi lisää parametrit ensin listalle. (2n)
 * algoritmi käy oman syötteensä jokaista alkiota vertailemassa muihin alkioihin. (n^2)
 * lisää uniikit numerot listaan (1)
 * lisää listan arvot taulukkoon. (n)
 * Syötteiden kasvaessa erittäin suureksi voimme unohtaa pienimmät syötteet koska n^2 kasvaa muihin nähden paljon nopeammin.
 * näin ollen algoritmin lopullinen aikavaativuus on T(n)=O(n^2)

 * Voisiko sitä parantaa?
 * Algoritmi on paranneltu versio taulukoiden käytöstä. Algoritmia voisi parantaa siten ettei taulukoita käytettäsii
 * ollenkaan.
 *
 * @param T1 ensimmäinen taulukko
 * @param T2 toinen taulukko
 * @return yhdiste taulukkona
 *
 *
 */

public class Tral_21_t4_sampokaj {

    public static Integer[] yhdiste4(Integer[] T1, Integer[] T2) {

        List<Integer> Lista = new ArrayList<>();
        List<Integer> Tulos = new ArrayList<>();

        Collections.addAll(Lista, T1);
        Collections.addAll(Lista, T2);
        for (Integer E :
                Lista) {
            if (!Tulos.contains(E))
                Tulos.add(E);
        }
        int n = Tulos.size();
        Integer[] tulos = new Integer[n];
        for (int i = 0; i < tulos.length; i++) {
            tulos[i] = Tulos.get(i);
        }
        return tulos;

    }
}






