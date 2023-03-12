package com.company.TraI_21_t4;

import java.util.ArrayList;
/**
 * 5. Kertaa Olio-ohjelmointi -kurssilla käsitelty ArrayList
 * * -luokka. Lisätietoa: http://docs. oracle.com/javase/8/docs/api/java/util/ArrayList.html. Muuta
 * edellisen tehtävän algoritmi toimimaan taulukoiden sijaan ArrayList -kokoelmilla. Mikä on
 * algoritmisi aika- vaativuus?
 *  Algorimtin aikavaativuus T(n)= O(n^2). Emme voi tietää kumpi syöttetyistä listoista on suurempi
 *  mutta kun syötteet kasvavat tarpeeksi suuriksi vai isomman listan syötteiden käsittelyn aikavaativuus on merkittävä.
 *
 * Voisiko sitä parantaa?
 * Mahdollisesti mutta oma osaaminen ei siihen riitä.
 */
public class Tral_21_t5_Sampokaj {
    /**
     * 5. Palauttaa taulukkopohjaisten listojen yhdisteen uutena listana.
     *
     * @param L1 ensimmäinen lista
     * @param L2 toinen lista
     * @return erotus listana
     */
    public static ArrayList<Integer> yhdiste5(ArrayList<Integer> L1, ArrayList<Integer> L2) {

        ArrayList<Integer> tulos = new ArrayList<>();

        for (Integer I : L1) {
            if (!tulos.contains(I))
                tulos.add(I);
        }
        for (Integer I : L2) {
            if (!tulos.contains(I))
                tulos.add(I);
        }
        return tulos;
    }
}