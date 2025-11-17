package com.company;
/*
  Creator: jukkakinnunen
  Date: 16.2.2021
  Version: 0.1
  Description:
  
  Updates:
  
*/

public class MyData {
    private String text;

    public MyData(String text) {
        this.text = text;
    }

    synchronized public void muuta(String text) {

        try {
            System.out.println("Odotellaan hetki ennenkuin teksti muutetaan... Text = " + text);
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Teksti muutettu. Text = " + text);

        this.text = text;
        notifyAll();
    }

    synchronized public void lueMuutos() {
        try {
            System.out.println("Odotelleen muutosta...Text = " + text);
            wait();
            System.out.println("Nysse muutos näkyy. Text = " + text);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
