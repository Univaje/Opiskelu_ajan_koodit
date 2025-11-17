package com.company.Tehtava4;

/*
Creator: Sam
Date: 23.02.2021
Version: 0.1
Description:
        Luokassa Ulkoilutakki on uusina kenttinä
            vedenpitavyys (kokonaisluku jonka mahdolliset arvot 1000, 3000, 5000 ja 10000) ja
            hengittavyys  (kokonaisluku jonka mahdolliset arvot välillä 0-5000).
            Luokassa on alustaja sekä kentille get- ja set-metodit.

        Jos vedenpitävyys ei ole mikään noista, set-metodi huolehtii siitä, että arvoksi tulee 1000.
        Samoin toimitaan hengittävyyden kanssa ( arvoksi tulee 0).
        Luokassa on toString-metodi olion kaikkien tietojen tulostamista varten.

*/
public class Ulkoilutakki extends Takki{

    //Jäsenmuuttujat
    private int vedenpitavuus;
    private int hengittavuus;

    //Constructorit

    public Ulkoilutakki(String vari, String koko, int vedenpitavuus, int hengittavuus) {
        super(vari, koko);
        setVedenpitavuus(vedenpitavuus);
        setHengittavuus(hengittavuus);
    }



    //Getterit ja Setterit

    public int getVedenpitavuus() {
        return vedenpitavuus;
    }

    public void setVedenpitavuus(int vedenpitavuus) {

        if(vedenpitavuus == 1000 || vedenpitavuus == 3000 ||vedenpitavuus == 5000 ||vedenpitavuus == 10000)
            this.vedenpitavuus = vedenpitavuus;
        else
            this.vedenpitavuus = 1000;
    }

    public int getHengittavuus() {
        return hengittavuus;
    }

    public void setHengittavuus(int hengittavuus) {
        if (hengittavuus <= 0||hengittavuus>5000)
            this.hengittavuus = 0;
        else
            this.hengittavuus = hengittavuus;
    }


    //Metodit


    @Override
    public String toString() {
        return super.toString()+ " Ulkoilutakki vedenpitavuus:" + vedenpitavuus +", hengittavuus:" + hengittavuus;
    }
}
