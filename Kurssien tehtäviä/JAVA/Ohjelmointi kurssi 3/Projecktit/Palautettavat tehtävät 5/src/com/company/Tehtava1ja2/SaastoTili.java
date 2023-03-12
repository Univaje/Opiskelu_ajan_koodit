package com.company.Tehtava1ja2;

/*
Creator: Sam
Date: 09.02.2021
Version: 0.1
Description:

        Tee luokka Saastotili, joka perii luokan Tili, sekä:
        -      Toteuttaa abstraktin metodin laskeVuosiKorkotuotto
        -      Tilille lasketaan annetun korkoprosentin mukainen tuotto.
        -      Toteuta tulostaTilinTiedot-metodi, joka käyttää laskeVuosiKorkotuotto -metodia ja tulostaa esim.
        ”Maiju Matikainen: Saastotilin saldo on 500 €, korkoprosentilla 4,5 vuosikorko on 22,5 €”



*/
public class SaastoTili extends Tili {

    //Jäsenmuuttujat
    private double vuosikorkosumma;

    //Constructorit

    public SaastoTili(String tilinumero, String omistaja, double saldoEuroa, double vuosikorko, double vuosikorkosumma) {
        super(tilinumero, omistaja, saldoEuroa, vuosikorko);
        setVuosikorkoSumma(vuosikorkosumma);
    }

    public SaastoTili() {
    }
    //Getterit ja Setterit


    public double getVuosikorkoSumma() {
        return vuosikorkosumma;
    }


    public void setVuosikorkoSumma(double vuosikorko) {
        this.vuosikorkosumma = vuosikorko;
    }


    //Metodit


    @Override
    public void laskeVuosiKorkotuotto() {
        setVuosikorkoSumma(getSaldoEuroa()*(getVuosikorko()/100));
       // System.out.println(getSaldoEuroa()+"*"+getVuosikorko());
    }

    @Override
    public void tulostaTilinTiedot() {
        laskeVuosiKorkotuotto();
        System.out.println(super.getOmistaja()+ ": Saastotilin saldo on "+ super.getSaldoEuroa() +", korkoprosentilla"
                +super.getVuosikorko()+" vuosikorko on " + getVuosikorkoSumma());
    }


}
