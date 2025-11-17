package com.company.Model;

import java.util.Objects;

/*
Creator: Sam
Date: 01.02.2021
Version: 0.1
Description:

*/
public class Henkilo {/* extends Object*/

    //Jäsenmuuttujat
    protected String etunimi;
    protected String sukunimi;
    protected String sotu;

    //Constructorit


    public Henkilo() {
    }

    public Henkilo(String etunimi, String sukunimi, String sotu) {
        this.etunimi = etunimi ;
        this.sukunimi = sukunimi;
        this.sotu = sotu;
    }


    //Getterit ja Setterit

    public final String getEtunimi() {
        return etunimi;
    }

    public final void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public final String getSukunimi() {
        return sukunimi;
    }

    public final void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public final String getSotu() {
        return sotu;
    }

    public final void setSotu(String sotu) {
        this.sotu = sotu;
    }


    //Metodit


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Henkilo henkilo = (Henkilo) o;
        return  Objects.equals(sotu, henkilo.sotu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(etunimi, sukunimi, sotu);
    }

    @Override
    public String toString() {
        return "Henkilo{" +
                "etunimi='" + etunimi + '\'' +
                ", sukunimi='" + sukunimi + '\'' +
                ", sotu='" + sotu + '\'' +
                '}';


    }
    public int teejoitan(){
        return 1;
    }

    public String tulosta(){
        return ""+ sotu + " " + sukunimi;
    }
}
