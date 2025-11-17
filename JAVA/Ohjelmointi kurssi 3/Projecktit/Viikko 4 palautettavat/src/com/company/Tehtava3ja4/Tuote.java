package com.company.Tehtava3ja4;

/*
Creator: Sam
Date: 02.02.2021
Version: 0.1
Description:
        Tuote-luokka, jolla on yksityiset attribuutit:
        - Tuotenumero (String)
        - Tuotepaikka (int)
        - Maara (int)

        Tee Tietokone- sekä Tuote-luokille eri kuormituksella (overload) olevat alustajat:
        public Tuote()
        public Tuote(final String tuotenumero)
        public Tuote(final String tuotenumero, final int maara, final int tuotepaikka)

        Muista varmistaa, että jos alustajassa syötetään yliluokan tietoja,
        niin ne välitetään yliluokan alustajalle.
*/
public class Tuote {

    //Jäsenmuuttujat
    protected String Tuotenumero ="Unknown";
    protected int Tuotepaikka = 0;
    protected int Maara = 0;

    //Constructorit

    public Tuote() {
    }

    public Tuote(final String  tuotenumero) {
        Tuotenumero = tuotenumero;
    }

    public Tuote(final String tuotenumero, final int maara, final int tuotepaikka) {
        setTuotenumero(tuotenumero);
        Tuotepaikka = tuotepaikka;
        Maara = maara;
    }

    public Tuote(String tuotenumero, int maara) {
        Tuotenumero = tuotenumero;
        Maara = maara;
    }
//Getterit ja Setterit

    public String getTuotenumero() {
        return Tuotenumero;
    }

    public void setTuotenumero(String tuotenumero) {
        Tuotenumero = tuotenumero;
    }

    public int getTuotepaikka() {
        return Tuotepaikka;
    }

    public void setTuotepaikka(int tuotepaikka) {
        Tuotepaikka = tuotepaikka;
    }

    public int getMaara() {
        return Maara;
    }

    public void setMaara(int maara) {
        Maara = maara;
    }


    //Metodit


    @Override
    public String toString() {
        return "Tuote: " + "Tuotenumero: " + Tuotenumero + ", Tuotepaikka: " + getTuotepaikka() + ", Maara: " + Maara;
    }
}
