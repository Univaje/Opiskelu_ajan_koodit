package com.company.ToisenAsteenYhtalo;

/*
Creator: Sam
Date: 02.02.2021
Version: 0.1
Description:

*/
public class Root extends Toinenaste{

    //Jäsenmuuttujat
    protected int x1;
    protected int x2;

    //Constructorit


    public Root() {

    }

    public Root(double a, double b, double c, int x1, int x2) {
        super(a, b, c);
        setX2(x2);
        setX1(x1);
    }


    //Getterit ja Setterit

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }


    //Metodit


}
