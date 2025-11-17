package com.company.Tehtava3;

/*
Creator: Sam
Date: 10.02.2021
Version: 0.1
Description:
        Tee luokat:
        -      Mikrofoni, joka toteuttaa rajapinnan ITelephoneMic. Tee toteutus, että mikrofonia päälle laitettaessa
        toiminto ei koskaan epäonnistu.
*/
public class Mikrofoni implements ITelephoneMic{

    //Jäsenmuuttujat
    private int micvolume;

    //Constructorit

    public Mikrofoni(int micvolume) {
        this.micvolume = micvolume;
    }


    //Getterit ja Setterit

    public int getMicvolume() {
        return micvolume;
    }

    public void setMicvolume(int micvolume) {
        this.micvolume = micvolume;
    }


    //Metodit


    @Override
    public boolean micOn() {
        setVolume(1);
        return true;
    }

    @Override
    public boolean micOff() {
        if (micvolume <= 0)
            return true;
        else
            return false;
    }

    @Override
    public void setVolume(int i) {
        setMicvolume(i);
    }

    @Override
    public int getVolume() {
        return getMicvolume();
    }
}
