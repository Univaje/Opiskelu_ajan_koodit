package com.company;

/*
Creator: Sam
Date: 15.02.2021
Version: 0.1
Description:

*/
public class MyThread extends Thread{



    //Jäsenmuuttujat
    private Tieto t;

    //Constructorit

    public MyThread(Tieto t) {
        this.t = t;
    }


    //Getterit ja Setterit


    //Metodit


/*    @Override
    public void run() {
        int i =0;
        while (i++ <10){
            synchronized (this){
            t.setTeksti("Heippa täältäkin");
        System.out.println(t.getTeksti());
            }
        try {

            Thread.sleep(1000);

        } catch (Exception e){

        }}*/
    synchronized public void muuta(){
    t.setTeksti("valmis");
    notifyAll();
}
    @Override
    public void run() {

        try {
            Thread.sleep(3000);
        } catch (Exception e){
        }
        muuta();

    }
}
