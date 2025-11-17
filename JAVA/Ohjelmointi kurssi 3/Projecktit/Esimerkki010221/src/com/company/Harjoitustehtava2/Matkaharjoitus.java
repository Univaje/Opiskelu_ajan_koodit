package com.company.Harjoitustehtava2;

/*
Creator: Sam
Date: 02.02.2021
Version: 0.1
Description:

*/
public class Matkaharjoitus extends Urheilusuoritus{

    //Jäsenmuuttujat
    private int kuljettuMatka;

    //Constructorit

    public Matkaharjoitus(String alkuAika, String loppuAika, int syke, String kuvaus, int kuljettuMatka) {
        super(alkuAika, loppuAika, syke, kuvaus);
        this.kuljettuMatka = kuljettuMatka;
    }


    //Getterit ja Setterit

    public int getKuljettuMatka() {
        return kuljettuMatka;
    }

    public void setKuljettuMatka(int kuljettuMatka) {
        this.kuljettuMatka = kuljettuMatka;
    }


    //Metodit


    @Override
    public String toString() {
        return super.toString() + "kuljettuMatka: " + kuljettuMatka;
    }
}
