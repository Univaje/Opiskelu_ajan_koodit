package com.company.Tehtava1ja2;

/*
Creator: Sam
Date: 09.02.2021
Version: 0.1
Description:

        Tuu luokka SuperSaastoTili, joka perii luokan Tili, sekä:
        -      Toteuttaa abstraktin metodin laskeVuosiKorkotuotto
        -      Vuosikoron laskennassa käytetään kaavaa:

        o  Tilin saldon 0-10000€ osuudelle käytetään asetettua korkoprosenttia.
        o  Tilin saldon 10001-> osuudelle käytetään asetettua korkoprosenttia, johon lisätään 3,0%.
        Eli jos asetettu korkoprosentti on 3,5% käytetään 10000€ ylittävälle säästölle korkona 6,5%.

        -      Toteuta tulostaTilinTiedot-metodi, joka käyttää laskeVuosiKorkotuotto -metodia ja tulostaa esim.
        ”Kalle Hakkarainen: Supersaastotilin saldo on 500 €, korkoprosentilla 4,5 vuosikorko on 22,5 €”


*/
public class SuperSaastotili extends Tili{

    //Jäsenmuuttujat
    private double vuosikorkosumma;

    //Constructorit

    public SuperSaastotili(String tilinumero, String omistaja, double saldoEuroa, double vuosikorko,double vuosikorkosumma) {
        super(tilinumero, omistaja, saldoEuroa, vuosikorko);
        setVuosikorkosumma(vuosikorkosumma);
    }

    public SuperSaastotili() {
    }
    //Getterit ja Setterit

    public double getVuosikorkosumma() {
        return vuosikorkosumma;
    }

    public void setVuosikorkosumma(double vuosikorkosumma) {
        this.vuosikorkosumma = vuosikorkosumma;
    }


    //Metodit


    @Override
    public void laskeVuosiKorkotuotto() {
        /* Tilin saldon 0-10000€ osuudelle käytetään asetettua korkoprosenttia.
           Tilin saldon 10001-> osuudelle käytetään asetettua korkoprosenttia, johon lisätään 3,0%.
           Eli jos asetettu korkoprosentti on 3,5% käytetään 10000€ ylittävälle säästölle korkona 6,5%.*/
        if (this.getSaldoEuroa() > 10000){
            setVuosikorkosumma(10000*(getVuosikorko()/100)+(getSaldoEuroa()-10000)*((getVuosikorko()+3)/100));
           // System.out.println("Laskettiin 10000 * (" + getVuosikorko() + "/100 + "+ getSaldoEuroa() +"-10000) * ("+(getVuosikorko()+"+3)/100)"));
        }
        else
            setVuosikorkosumma(getSaldoEuroa()*(getVuosikorko())/100);



    }

    @Override
    public void tulostaTilinTiedot() {
        laskeVuosiKorkotuotto();
        System.out.println(super.getOmistaja()+ ": SuperSaastotilin saldo on "+ super.getSaldoEuroa() +", korkoprosentilla"
                +super.getVuosikorko()+" vuosikorko on "+ getVuosikorkosumma() );
    }
}
