package com.company.Harjoitustehtava2;

import java.util.Objects;

/*
Creator: Sam
Date: 02.02.2021
Version: 0.1
Description:

*/
public class Urheilusuoritus {

    //Jäsenmuuttujat
    private String alkuAika;
    private String loppuAika;
    private int syke;
    private String Kuvaus;

    //Constructorit

    public Urheilusuoritus() {
    }

    public Urheilusuoritus(String alkuAika, String loppuAika, int syke, String kuvaus) {
        this.alkuAika = alkuAika;
        this.loppuAika = loppuAika;
        this.syke = syke;
        Kuvaus = kuvaus;
    }
    //Getterit ja Setterit

    public String getAlkuAika() {
        return alkuAika;
    }

    public void setAlkuAika(String alkuAika) {
        this.alkuAika = alkuAika;
    }

    public String getLoppuAika() {
        return loppuAika;
    }

    public void setLoppuAika(String loppuAika) {
        this.loppuAika = loppuAika;
    }

    public int getSyke() {
        return syke;
    }

    public void setSyke(int syke) {
        this.syke = syke;
    }

    public String getKuvaus() {
        return Kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        Kuvaus = kuvaus;
    }


    //Metodit

    @Override
    public String toString() {
        return "Urheilusuoritus: "+ "alkuAika: " + alkuAika+ ", loppuAika: " + loppuAika + ", syke: " + syke +
                ", Kuvaus: " + Kuvaus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Urheilusuoritus that = (Urheilusuoritus) o;
        return Objects.equals(alkuAika, that.alkuAika);
    }


}
