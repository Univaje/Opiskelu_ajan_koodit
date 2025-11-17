package com.company.Tehtava3ja4;

/*
Creator: Sam
Date: 02.02.2021
Version: 0.1
Description:
        Tietokone-luokka, joka perii Tuote-luokan sekä on yksityiset attribuutit:
        - Merkki (String)
        - Malli (String)

        Tee Tietokone- sekä Tuote-luokille eri kuormituksella (overload) olevat alustajat:
        public Tietokone()
        public Tietokone(final String merkki, final String malli)
        public Tietokone(final String merkki, final String malli, final String tuotenumero)
        public Tietokone(final String merkki, final String malli, final String tuotenumero, final int maara,
        final int tuotepaikka)

         Muista varmistaa, että jos alustajassa syötetään yliluokan tietoja,
        * niin ne välitetään yliluokan alustajalle.
*/
public class Tietokone extends Tuote{

    //Jäsenmuuttujat
    private String Merkki ="Unknown";
    private String Malli = "Unknown";

    //Constructorit

    public Tietokone() {
    }

    public Tietokone(String merkki, String malli) {
        Merkki = merkki;
        Malli = malli;
    }

    public Tietokone(String tuotenumero, String merkki, String malli) {
        super(tuotenumero);
        Merkki = merkki;
        Malli = malli;
    }

    public Tietokone(final String merkki, final String malli, final String tuotenumero,  final int tuotepaikka,final int maara) {
        super(tuotenumero, maara, tuotepaikka);
        Merkki = merkki;
        Malli = malli;
    }


    //Getterit ja Setterit
    @Override
    public int getTuotepaikka() {

        int tuotepaikka = super.getTuotepaikka();
        if(tuotepaikka < 10)
            tuotepaikka += 10;
        else if(tuotepaikka >10 && tuotepaikka < 100)
            tuotepaikka += 100;
        else
            tuotepaikka +=500;

        return tuotepaikka;
    }


    public String getMerkki() {
        return Merkki;
    }

    public void setMerkki(String merkki) {
        Merkki = merkki;
    }

    public String getMalli() {
        return Malli;
    }

    public void setMalli(String malli) {
        Malli = malli;
    }
    //Metodit


    @Override
    public String toString() {
        return "Tietokone: " + "Merkki: " + Merkki + ", Malli: " + Malli +" "+ super.toString();
    }
}
