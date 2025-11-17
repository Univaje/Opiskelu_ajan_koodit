package com.company.Tehtava1;

/*
Creator: Sam
Date: 21.02.2021
Version: 0.1
Description:

*/
public class Threading implements Runnable{

    //Jäsenmuuttujat
    private PrintDiamond Diam;

    //Constructorit

    public Threading(PrintDiamond diam) {
        Diam = diam;
    }


    //Getterit ja Setterit


    //Metodit


    @Override
    public void run() { Diam.PrintDiamond();

    }
}
