package com.company.model;

/*
Creator: Sam
Date: 09.02.2021
Version: 0.1
Description:

*/
public abstract class MyClass {

    //Jäsenmuuttujat
    private  int ID;

    //Constructorit

    public MyClass() {
    }

    public MyClass(int ID) {
        this.ID = ID;
    }

    //Getterit ja Setterit

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    //Metodit
public abstract void TeeJotain();

}
