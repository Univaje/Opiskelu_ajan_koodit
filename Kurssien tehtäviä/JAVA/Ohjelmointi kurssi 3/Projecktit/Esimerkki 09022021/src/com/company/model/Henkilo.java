package com.company.model;

/*
Creator: Sam
Date: 09.02.2021
Version: 0.1
Description:

*/
public class Henkilo implements Comparable {

    //Jäsenmuuttujat
    private String etunimi;
    private String sukunimi;
    private int ika;
    //Constructorit


    public Henkilo() {
    }

    public Henkilo(String etunimi) {
        this.etunimi = etunimi;
    }

    public Henkilo(String etunimi, String sukunimi, int ika) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.ika = ika;
    }


    //Getterit ja Setterit

    public String getEtunimi() {
        return etunimi;
    }

    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public int getIka() {
        return ika;
    }

    public void setIka(int ika) {
        this.ika = ika;
    }


    //Metodit


    @Override
    public String toString() {
        return "Henkilo{" +
                "etunimi='" + etunimi + '\r' +
                ", sukunimi='" + sukunimi + '\'' +
                ", ika=" + ika +
                '}';
    }

 /*   @Override
    public int compareTo(Object o) {
        Henkilo h = (Henkilo) o;
        if (this.getIka() == h.getIka())
            return 0;
        else if (this.getIka() < h.getIka())
            return -1;
        else
            return 1;
    }*/
 @Override
 public int compareTo(Object o) {
     Henkilo h = (Henkilo) o;
     int vast = this.getSukunimi().compareTo(h.getSukunimi());
     if (vast != 0)
         return vast;
     else
         return this.getEtunimi().compareTo(h.getEtunimi());
 }
}
