package com.company.Harjoitustehtava2;

/*
Creator: Sam
Date: 02.02.2021
Version: 0.1
Description:

*/
public class Hiihto extends Matkaharjoitus{

    //Jäsenmuuttujat
    private String tyyli;

    //Constructorit

    public Hiihto(String alkuAika, String loppuAika, int syke, String kuvaus, int kuljettuMatka, String tyyli) {
        super(alkuAika, loppuAika, syke, kuvaus, kuljettuMatka);
        this.tyyli = tyyli;
    }


    //Getterit ja Setterit

    public String getTyyli() {
        return tyyli;
    }

    public void setTyyli(String tyyli) {
        this.tyyli = tyyli;
    }


    //Metodit


    @Override
    public String toString() {
        return super.toString()+ "tyyli:'" + tyyli ;
    }
}
