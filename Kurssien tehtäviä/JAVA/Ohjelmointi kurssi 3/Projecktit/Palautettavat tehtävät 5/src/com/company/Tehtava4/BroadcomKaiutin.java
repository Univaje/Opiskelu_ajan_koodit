package com.company.Tehtava4;

import com.company.Tehtava3.ITelephoneSpeaker;

/*
Creator: Sam
Date: 10.02.2021
Version: 0.1
Description:

        BroadcomKaiutin, joka toteuttaa rajapinnan ITelephoneSpeaker
        -      Toteuttaa rajapinnan metodit
        -      Tallentaa asetetun äänenvoimakkuuden arvon yksityiseen muuttujaan
        -      Jos äänenvoimakkuuden arvoksi on asetettu yli 100, palauttaa unMute-metodi arvon false.

*/
public class BroadcomKaiutin implements ITelephoneSpeaker {

    //Jäsenmuuttujat
private int volume;

    //Constructorit


    //Getterit ja Setterit


    //Metodit


    @Override
    public boolean mute() {
        return true;
    }

    @Override
    public boolean Unmute() {
        return volume >= 0 && volume < 100;
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
