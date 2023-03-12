package com.company.Tehtava4;

import com.company.Tehtava3.ITelephoneMic;

/*
Creator: Sam
Date: 10.02.2021
Version: 0.1
Description:

        BroadcomMikrofoni, joka toteuttaa rajapinnan ITelephoneMic
        -      Toteuttaa rajapinnan metodit
        -      Tallentaa asetetun äänenvoimakkuuden arvon yksityiseen muuttujaan
        -      Jos äänenvoimakkuuden arvoksi on asetettu yli 100, palauttaa micOn-metodi arvon false.

*/
public class BroadcomMikrofoni implements ITelephoneMic {

    //Jäsenmuuttujat
private int volume;

    //Constructorit


    //Getterit ja Setterit


    //Metodit


    @Override
    public boolean micOn() {
        if( volume >= 0 && volume < 100)
            return true;
        else
            return false;
    }



    @Override
    public boolean micOff() {

        return true;
    }

    @Override
    public void setVolume(int i) {
        volume = i;
    }

    @Override
    public int getVolume() {
        return volume;
    }
}
