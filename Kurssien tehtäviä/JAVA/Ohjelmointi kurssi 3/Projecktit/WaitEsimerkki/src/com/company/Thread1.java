package com.company;
/*
  Creator: jukkakinnunen
  Date: 16.2.2021
  Version: 0.1
  Description:
  
  Updates:
  
*/

public class Thread1 implements Runnable {
    // Muuttujat
    private MyData md;

    // Muodostimet

    public Thread1(MyData md) {
        this.md = md;
    }

    // Getterita ja setterit

    // Metodit


    @Override
    public void run() {
        md.muuta("Juu");
    }
}
