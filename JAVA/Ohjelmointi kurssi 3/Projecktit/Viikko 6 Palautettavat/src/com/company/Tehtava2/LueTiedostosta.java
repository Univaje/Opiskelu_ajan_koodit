package com.company.Tehtava2;

/*
Creator: Sam
Date: 22.02.2021
Version: 0.1
Description:

*/
public class LueTiedostosta implements Runnable{

    //Jäsenmuuttujat
    private String dir;
    private String data;

    //Constructorit

    public LueTiedostosta(String dir) {
        this.dir = dir;

    }


    //Getterit ja Setterit




    //Metodit


    @Override
    public void run( ) {

        FileUtils.ReadFromFile(dir);

    }
}
