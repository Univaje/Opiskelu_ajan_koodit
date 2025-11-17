package com.company.model;

/*
Creator: Sam
Date: 09.02.2021
Version: 0.1
Description:

*/
public abstract class Lintu extends Elain{

    //Jäsenmuuttujat
    private int siipienvali;


    //Constructorit

    public Lintu() {
    }

    public Lintu(String nimi, int siipienvali) {
        super(nimi);
        this.siipienvali = siipienvali;
    }
//Getterit ja Setterit


    public int getSiipienvali() {
        return siipienvali;
    }

    public void setSiipienvali(int siipienvali) {
        this.siipienvali = siipienvali;
    }

    //Metodit


    @Override
    public String toString() {
        return super.toString() +"siipienvali: " + siipienvali;
    }
}
