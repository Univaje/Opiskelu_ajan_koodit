package com.company.Tehtava4;

/*
Creator: Sam
Date: 23.02.2021
Version: 0.1
Description:

        Luokassa Juhlatakki on kenttinä
        materiaali (merkkijono)
        kuvio (merkkijono).
        Luokassa on muodostin
        (alustaja) sekä kentille get- ja set-metodit.
        Luokassa on toString-metodi olion kaikkien tietojen tulostamista varten.

*/
public class Juhlatakki extends Takki{

    //Jäsenmuuttujat
    private String materiaali;
    private String kuvio;

    //Constructorit

    public Juhlatakki(String vari, String koko, String materiaali, String kuvio) {
        super(vari, koko);
        setMateriaali(materiaali);
        setKuvio(kuvio);
    }


    //Getterit ja Setterit

    public String getMateriaali() {
        return materiaali;
    }

    public void setMateriaali(String materiaali) {
        this.materiaali = materiaali;
    }

    public String getKuvio() {
        return kuvio;
    }

    public void setKuvio(String kuvio) {
        this.kuvio = kuvio;
    }


    //Metodit


    @Override
    public String toString() {
        return super.toString() + " Juhlatakki materiaali:" + materiaali + ", kuvio:" + kuvio;
    }
}
