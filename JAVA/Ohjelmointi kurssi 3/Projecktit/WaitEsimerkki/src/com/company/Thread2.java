package com.company;
/*
  Creator: jukkakinnunen
  Date: 16.2.2021
  Version: 0.1
  Description:
  
  Updates:
  
*/

public class Thread2 implements Runnable {
    // Muuttujat
    private MyData md;

    // Muodostimet

    public Thread2(MyData md) {
        this.md = md;
    }



    @Override
    public void run() {
        md.lueMuutos();
    }
}