package com.company.Tehtava3;
/*
Creator: Sam
Date: 10.02.2021
Version: 0.1
Description:

        Tee luokka:
        -      Kaiutin, joka toteuttaa rajapinnan ITelephoneSpeaker. Toteutettavat metodit eivät vielä sisällä
        mitään logiikkaa, paitsi asetettava äänenvoimakkuuden arvo talletetaan luokan jäsenmuuttujaan.
*/

public class Kaiutin implements ITelephoneSpeaker{

    //Jäsenmuuttujat
    private int aanenvoimakkuus;


    //Constructorit

    public Kaiutin(int aanenvoimakkuus) {
        this.aanenvoimakkuus = aanenvoimakkuus;
    }


    //Getterit ja Setterit

    //Metodit


    @Override
    public boolean mute() {
        if (aanenvoimakkuus >= 0)
            return true;
        else
            return  false;
    }

    @Override
    public boolean Unmute() {
        if (aanenvoimakkuus < 0)
            return true;
        else
            return  false;
    }

    @Override
    public void setVolume(int i) {
        this.aanenvoimakkuus = i;
    }

    @Override
    public int getVolume() {
        return aanenvoimakkuus;
    }
}
