package com.company.Tehtava4;

/*
Creator: Sam
Date: 23.02.2021
Version: 0.1
Description:

*/
public class Takki {

    //Jäsenmuuttujat

    String vari;
    String koko;
    //Constructorit

    public Takki(String vari, String koko) {
        this.vari = vari;
        this.koko = koko;
    }


    //Getterit ja Setterit

    public String getVari() {
        return vari;
    }

    public void setVari(String vari) {
        this.vari = vari;
    }

    public String getKoko() {
        return koko;
    }

    public void setKoko(String koko) {
        this.koko = koko;
    }


    //Metodit


    @Override
    public String toString() {
        return "Takki:" +" koko:" + koko + ", väri:" + vari ;
    }
}
