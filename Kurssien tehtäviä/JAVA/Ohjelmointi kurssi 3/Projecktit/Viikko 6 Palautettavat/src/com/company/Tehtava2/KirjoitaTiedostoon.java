package com.company.Tehtava2;

/*
Creator: Sam
Date: 22.02.2021
Version: 0.1
Description:

*/
public class KirjoitaTiedostoon implements Runnable{

    //Jäsenmuuttujat
    private String dir;
    private String data;

    //Constructorit

    public KirjoitaTiedostoon(String dir, String data) {
        this.dir = dir;
        this.data = data;
    }


    //Getterit ja Setterit




    //Metodit


    @Override
    public void run( ) {

        FileUtils.WriteToFile(dir,data);

    }
}
