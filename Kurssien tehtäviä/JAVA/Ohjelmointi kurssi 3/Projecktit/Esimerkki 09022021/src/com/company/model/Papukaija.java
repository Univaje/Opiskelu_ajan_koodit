package com.company.model;

/*
Creator: Sam
Date: 09.02.2021
Version: 0.1
Description:

*/
public final class Papukaija extends Lintu {

    //Jäsenmuuttujat


    //Constructorit

    public Papukaija(String nimi, int siipienvali) {
        super(nimi, siipienvali);
    }


    //Getterit ja Setterit


    //Metodit


    @Override
    public void aantele() {
        System.out.println("Polly tahtoo keksin!");
        System.out.println("Polly vetää sua pataan!");
    }

    @Override
    public void TeeJotain() {

    }
}
