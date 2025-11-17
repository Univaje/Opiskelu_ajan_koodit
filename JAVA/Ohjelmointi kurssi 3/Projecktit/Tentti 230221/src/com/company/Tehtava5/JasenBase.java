package com.company.Tehtava5;

/*
Creator: Sam
Date: 23.02.2021
Version: 0.1
Description:

        Jasen-luokkaa (liitteenä) tulee lisäksi laajentaa niin, että se perii abstraktin luokan JäsenBase,
        jonka toteutat laajennuksen yhteydessä. JasenBase-luokassa on  jäsenseura (String) ja vakuutusnro (int)
        sekä abstrakti metodi tulostaJäsenTiedot. Toteuta abstrakti metodi oikeassa paikassa, niin, että se tulostaa
        jäsenen tiedot oikein.
*/
public abstract class JasenBase {

    //Jäsenmuuttujat
private String jasenseura;
private int vakuutusnro;

    //Constructorit

    public JasenBase(String jasenseura, int vakuutusnro) {
        setJasenseura(jasenseura);
        setVakuutusnro(vakuutusnro);
    }


    //Getterit ja Setterit


    public String getJasenseura() {
        return jasenseura;
    }

    public void setJasenseura(String jasenseura) {
        this.jasenseura = jasenseura;
    }

    public int getVakuutusnro() {
        return vakuutusnro;
    }

    public void setVakuutusnro(int vakuutusnro) {
        this.vakuutusnro = vakuutusnro;
    }

    //Metodit
public abstract void tulostaJasenTiedot();

}
