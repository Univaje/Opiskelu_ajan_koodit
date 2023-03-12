package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Heippa!");

        Tieto t = new Tieto("Alkuteksti");

        MyThread mt1 = new MyThread(t);
        mt1.start();

        MyThread2 mt2 = new MyThread2(t);
        mt2.start();

        //MyThread2 mt3 = new MyThread2(t);
        //mt3.start();

        System.out.println("Heippa taas!");
        Strint paska;
        int i;
        Tieto t = new()

    }
}
