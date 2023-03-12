package com.company.model;

/*
Creator: Sam
Date: 09.02.2021
Version: 0.1
Description:

*/
public abstract class Elain extends MyClass{

    //Jäsenmuuttujat
private String nimi;


    //Constructorit

    public Elain(String nimi) {
        this.nimi = nimi;
    }

    public Elain() {
    }

//Getterit ja Setterit

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }


    //Metodit


    @Override
    public String toString() {
        return "Elain{" +
                "nimi='" + nimi + '\'' +
                '}';
    }
    public abstract void aantele();


}
