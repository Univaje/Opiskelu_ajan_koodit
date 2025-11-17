package com.company.Tehtava3;
/*
Creator: Sam
Date: 10.02.2021
Version: 0.1
Description:

        ITelephoneSpeaker, jossa on metodit:
        -      mute, joka palauttaa boolean arvon onnistuiko mikrofonin vaimentaminen
        -      unMute, joka palauttaa boolean arvon, onnistuiko mikrofonin avaaminen
        -      setVolume, joka ottaa vastaan äänenvoimakkuudesta kertovan kokonaisluvun
        -      getVolume, joka palauttaa äänenvoimakkuudesta kertovan kokonaisluvun
*/
public interface ITelephoneSpeaker {
    public boolean mute();
    public boolean Unmute();
    public void setVolume(int i);
    public int getVolume();

}
