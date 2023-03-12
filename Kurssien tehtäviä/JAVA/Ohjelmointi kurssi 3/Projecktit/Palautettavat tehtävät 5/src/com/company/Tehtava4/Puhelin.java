package com.company.Tehtava4;

import com.company.Tehtava3.ITelephoneMic;
import com.company.Tehtava3.ITelephoneSpeaker;

import java.util.concurrent.TimeUnit;

/*
Creator: Sam
Date: 11.02.2021
Version: 0.1
Description:

*/
public class Puhelin {

    //Jäsenmuuttujat
    private ITelephoneMic Mikrofoni;
    private ITelephoneSpeaker Kaijutin;

    //Constructorit

    public Puhelin() {
    }

    public Puhelin(ITelephoneMic mikrofoni, ITelephoneSpeaker kaijutin) {
        Mikrofoni = mikrofoni;
        Kaijutin = kaijutin;
    }
//Getterit ja Setterit


    //Metodit
        // piirretään piseet joka sekuntti
    public void waiting(){
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            System.out.println();
        }
        catch(Exception ex){
            System.out.println("Aikatoiminto vittuilee");
        }

    }
}
