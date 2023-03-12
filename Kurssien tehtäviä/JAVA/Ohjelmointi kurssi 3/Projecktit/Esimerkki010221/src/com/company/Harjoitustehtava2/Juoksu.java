package com.company.Harjoitustehtava2;

/*
Creator: Sam
Date: 02.02.2021
Version: 0.1
Description:

*/
public class Juoksu extends Matkaharjoitus{

    //Jäsenmuuttujat
    private int askelmaara;

    //Constructorit

    public Juoksu(String alkuAika, String loppuAika, int syke, String kuvaus, int kuljettuMatka, int askelmaara) {
        super(alkuAika, loppuAika, syke, kuvaus, kuljettuMatka);
        this.askelmaara = askelmaara;
    }


    //Getterit ja Setterit

    public int getAskelmaara() {
        return askelmaara;
    }

    public void setAskelmaara(int askelmaara) {
        this.askelmaara = askelmaara;
    }


    //Metodit


    @Override
    public String toString() {
        return super.toString() + " asklemaara:'" + askelmaara;
    }
}
