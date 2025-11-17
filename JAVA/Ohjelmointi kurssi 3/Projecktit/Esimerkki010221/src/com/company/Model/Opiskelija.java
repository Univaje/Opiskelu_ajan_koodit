package com.company.Model;

import java.util.Objects;

/*
Creator: Sam
Date: 01.02.2021
Version: 0.1
Description:

*/
public class Opiskelija  extends Henkilo{

    //Jäsenmuuttujat
    private String paaAine;
    private  int Opiskelijanumero;


    //Constructorit


    public Opiskelija(){

    }

    public Opiskelija(String etunimi, String sukunimi, String sotu, String paaAine, int opiskelijanumero) {
        super(etunimi, sukunimi, sotu);
        this.paaAine = paaAine;
        Opiskelijanumero = opiskelijanumero;
    }


    //Getterit ja Setterit

    public String getPaaAine() {
        return paaAine;
    }


    public void setPaaAine(String paaAine) {
        this.paaAine = paaAine;
    }

    public int getOpiskelijanumero() {
        return Opiskelijanumero;
    }

    public final void setOpiskelijanumero(final int  opiskelijanumero) {
        Opiskelijanumero = opiskelijanumero;
    }


    //Metodit


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Opiskelija that = (Opiskelija) o;
        return Opiskelijanumero == that.Opiskelijanumero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), paaAine, Opiskelijanumero);
    }

    @Override
    public String toString() {
        return "Opiskelija{" + super.toString() +
                "paaAine='" + paaAine + '\'' +
                ", Opiskelijanumero=" + Opiskelijanumero +
                '}';
    }
    @Override
    public int teejoitan(){
        return 2;
    }

    @Override
    public String tulosta(){
        return super.tulosta() + " "+ sotu;
    }
}
