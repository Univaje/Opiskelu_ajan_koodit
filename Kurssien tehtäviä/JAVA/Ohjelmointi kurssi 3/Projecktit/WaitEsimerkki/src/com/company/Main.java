package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MyData md = new MyData("Heippa");
        Thread muuttaja = new Thread(new Thread1(md));
        Thread lukija = new Thread(new Thread2(md));

        lukija.start();
        muuttaja.start();

    }
}
