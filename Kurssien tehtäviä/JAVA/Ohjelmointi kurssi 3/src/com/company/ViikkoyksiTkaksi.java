package com.company;

import java.util.Scanner;

/*
* Tehtävä 2

    Tee ohjelma, joka kysyy käyttäjältä suorakaiteen leveyden, korkeuden, piirtomerkin ja sen, tulostetaanko se täytettynä vai ei.
    * Ohjelma tulostaa sitten suorakaiteen annetulla merkillä

    Anna korkeus: 5
    Anna leveys: 6
    Anna piirtomerkki: *
    Täytetty vai ei (k=kyllä, e=ei): k

    ******
    ******
    ******
    ******
    ******
    Toinen ajoesimerkki

    Anna korkeus: 5
    Anna leveys: 6
    Anna piirtomerkki: *
    Täytetty vai ei (k=kyllä, e=ei): e

    ******
    *    *
    *    *
    *    *
    ******
    */




public class ViikkoyksiTkaksi {
    public static void main(String[] args) {

        // Jäsenmuuttujat
        Scanner input = new Scanner(System.in);
        int korkeus, leveys;
        char merkki;
        String merkkiStr, taytto;
        boolean tautetty;


        // pyydetään käyttäjältä tarvittavat tiedot
        System.out.print("Anna korkeus:");
        korkeus = input.nextInt();
        System.out.print("Anna Leveys:");
        leveys = input.nextInt();
        input.nextLine();
        System.out.print("Anna piirtomerkki:");
        // Otetaan piirtomerkki string muuttujaan ja kaapataan se sieltä charriksi
        merkkiStr =input.next();
        merkki = merkkiStr.charAt(0);
        input.nextLine();
        System.out.print("Täytetty vai ei (k=kyllä, e=ei):");
        taytto = input.nextLine();

        // Toteutetaan piirtäminen kahdella sisäkkäisellä for loopilla
        for (int i = 0; i < korkeus; i++){
            for (int j = 0; j < leveys; j++) {
                // Jos täyttöä ei haluta sisimmät piirtomerkit korvataan tyhjällä merkillä
                // jos halutaan niin piirretään kaikki merkit
                if (taytto.equals("e")){
                    if (i > 0 && i < korkeus-1 && j >0 && j < leveys-1){
                        System.out.print(" ");
                    }
                    else
                        System.out.print(merkki);
                }
                else
                    System.out.print(merkki);

            }
            System.out.println("");
        }
    }
}

