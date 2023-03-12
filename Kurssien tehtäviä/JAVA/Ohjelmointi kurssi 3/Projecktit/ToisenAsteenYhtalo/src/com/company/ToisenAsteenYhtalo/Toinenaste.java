package com.company.ToisenAsteenYhtalo;

/*
Creator: Sam
Date: 02.02.2021
Version: 0.1
Description:

*/
public class Toinenaste {
    //Jäsenmuuttujat
    private double a;
    private double b;
    private double c;
    //Constructorit

    public Toinenaste() {
    }

    public Toinenaste(double a, double b, double c) {
        setA(a);
        setB(b);
        setC(c);
    }


    //Getterit ja Setterit

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }


    //Metodit

    public Root rakaisu(int a,int b,int c){
    Root o = new Root();
        return o;
    }
}
