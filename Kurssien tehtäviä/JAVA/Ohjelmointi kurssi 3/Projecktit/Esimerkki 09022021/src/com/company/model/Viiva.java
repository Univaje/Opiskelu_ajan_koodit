package com.company.model;

/*
Creator: Sam
Date: 09.02.2021
Version: 0.1
Description:

*/
public class Viiva implements IKuvio{

    //Jäsenmuuttujat
    private int pituus;


    //Constructorit

    public Viiva(int pituus) {
        this.pituus = pituus;
    }


    //Getterit ja Setterit

    public int getPituus() {
        return pituus;
    }

    public void setPituus(int pituus) {
        this.pituus = pituus;
    }


    //Metodit


    @Override
    public double getAla() {
       return 0;
    }

    @Override
    public void piirra() {
        for (int i = 0; i < pituus; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
