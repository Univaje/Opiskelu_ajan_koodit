package com.company.Tehtava1ja2;

/*
Creator: Sam
Date: 09.02.2021
Version: 0.1
Description:
Suunnittele abstrakti luokka Tili, jolla on yksityiset attribuutit:
        -      Tilinumero (String) + (set/get)
        -      Omistaja (String) + (set/get)
        -      SaldoEuroa (double) + (set/get)
        -      Vuosikorko% (double) + (set/get)

        Tilillä on myös abstraktit metodin:
        -      laskeVuosiKorkotuotto, joka palauttaa (double) korkoprosentin mukaisen vuosikoron
        -      tulostaTilinTiedot, joka tulostaa tilin tiedot ruudulle

*/
public abstract class Tili {

    //Jäsenmuuttujat
   private String Tilinumero;
   private String Omistaja;
   private double  SaldoEuroa;
   private double Vuosikorko;

    //Constructorit

       public Tili(String tilinumero, String omistaja, double saldoEuroa, double vuosikorko) {
        setTilinumero(tilinumero);
        setOmistaja(omistaja);
        setSaldoEuroa(saldoEuroa);
        setVuosikorko(vuosikorko);
    }

    public Tili() {
    }
    //Getterit ja Setterit

    public String getTilinumero() {
        return Tilinumero;
    }

    public void setTilinumero(String tilinumero) {
        Tilinumero = tilinumero;
    }

    public String getOmistaja() {
        return Omistaja;
    }

    public void setOmistaja(String omistaja) {
        Omistaja = omistaja;
    }

    public double getSaldoEuroa() {
        return SaldoEuroa;
    }

    public void setSaldoEuroa(double saldoEuroa) {
        SaldoEuroa = saldoEuroa;
    }

    public double getVuosikorko() {
        return Vuosikorko;
    }

    public void setVuosikorko(double vuosikorko) {
           if (vuosikorko > 0 )
        Vuosikorko = vuosikorko;
           else
               throw new ArithmeticException("Virhe Tilinumerolla: "+ getTilinumero()+" negatiivinen korkokerroin");

    }


    //Metodit



public abstract void laskeVuosiKorkotuotto();
public abstract void tulostaTilinTiedot();
}

