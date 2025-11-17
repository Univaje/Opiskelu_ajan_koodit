package com.company;

import java.util.Objects;

/*
Creator: Sam
Date: 22.02.2021
Version: 0.1
Description:

*/
public class Lahetus {

    //Jäsenmuuttujat
    private int id;
private String maaranpaa;
private String asiakas;

    //Constructorit

    public Lahetus(int id, String maaranpaa, String asiakas) {
        this.id = id;
        this.maaranpaa = maaranpaa;
        this.asiakas = asiakas;
    }


    //Getterit ja Setterit

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaaranpaa() {
        return maaranpaa;
    }

    public void setMaaranpaa(String maaranpaa) {
        this.maaranpaa = maaranpaa;
    }

    public String getAsiakas() {
        return asiakas;
    }

    public void setAsiakas(String asiakas) {
        this.asiakas = asiakas;
    }


    //Metodit


    @Override
    public boolean equals(Object o) {
        Lahetus l = (Lahetus) o;
        if (this.id ==  l.id)
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maaranpaa, asiakas);
    }

    @Override
    public String toString() {
        return "Lahetus:" +  "id:" + id +  ", maaranpaa:'" + maaranpaa + ", asiakas:'" + asiakas;
    }
}
