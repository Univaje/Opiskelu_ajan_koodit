package com.company.Tehtava3;
/*
Creator: Sam
Date: 10.02.2021
Version: 0.1
Description:

        ITelephoneMic, jossa on metodit:
        -      micOn, joka palauttaa booleanin onnistuiko mikrofonin avaaminen.
        -      micOff, joka palauttaa booleanin onnistuiko mikrofonin sulkeminen.
        -      setVolume, joka ottaa vastaan äänenvoimakkuudesta kertovan kokonaisluvun
        -      getVolume, joka palauttaa äänenvoimakkuudesta kertovan kokonaisluvun
*/
public interface ITelephoneMic {

    public boolean micOn();
    public boolean micOff();
    public void setVolume(int i);
    public int getVolume();


}
