package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class KT2 {
    /**
     * Tee ohjelma joka kysyy käyttäjältä suorakaiteen leveyden, korkeuden, piirtomerkin ja sen,
     * tulostetaanko se täytettynä vai ei. Ohjelma tulostaa sitten suorakaiteen annetulla merkillä
     *
     * Anna korkeus: 5
     * Anna leveys: 6
     * Anna piirtomerkki: *
     * Täytetty vai ei (k=kyllä, e=ei): k
     */
    public static void main(String[] args) {
        int korkeus, leveys;
        char piirtomerkki;
        char taytto;
        boolean vastausk = true;
        boolean vastause = true;

        Scanner input = new Scanner(System.in);

        System.out.print("Anna korkeus: ");
        korkeus = input.nextInt();
        System.out.print("Anna leveys: ");
        leveys = input.nextInt();
        System.out.print("Anna piirtomerkki: ");
        piirtomerkki = input.next().charAt(0);
        System.out.print("Täytetty vai ei (k=kyllä, e=ei): ");
        taytto = input.next().charAt(0);

        if (taytto == 'k')
            vastausk = true;
        else
            vastausk = false;
        if (taytto == 'e')
            vastause = true;
        else
            vastause = false;

        if (vastausk) { // Jos vastataan täytetty
            for (int i = 0; i < korkeus; i++) { // i laskee rivejä
                for (int j = 0; j < leveys; j++) { // j laskee sarakkeita
                    System.out.print(piirtomerkki);
                }
                System.out.println();
            }
        }
        if (vastause) // Jos vastataan tyhjä
        {
            for (int i = 1; i <= korkeus; i++) {
                for (int j = 0; j <= leveys; j++) {
                    if (i == 1 || i == korkeus ||j == 0 || j == leveys) // ensimmäinen ja viimeinen rivi täytetään
                        System.out.print(piirtomerkki);
                    else
                        System.out.print(" "); // muut rivit on tyhjiä sisältä
                }
                System.out.println();
            }
        }



    }
}
