package com.company;

/*
Creator: Sam
Date: 15.02.2021
Version: 0.1
Description:

*/
public class MyThread2 extends Thread{

    //Jäsenmuuttujat
    private Tieto t;

    //Constructorit

    public MyThread2(Tieto t) {
        this.t = t;
    }

    //Getterit ja Setterit


    //Metodit


   /* @Override
    public void run() {
        int i =0;
        while (i++ <10){
            synchronized (this) {
                t.setTeksti("Heipat täältä toisesta säieluokasta");
                System.out.println(t.getTeksti());
            }
        try {

            Thread.sleep(1000);

        } catch (Exception e){

        }}*/
synchronized public void jatkaKunValmis(){
    while (!t.getTeksti().equals("valmis")){
        try{
            sleep(4000);
            wait();
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("Tulihan se valmiiksi!");
   }
}
    @Override
    public void run() {
        jatkaKunValmis();
    }
}
