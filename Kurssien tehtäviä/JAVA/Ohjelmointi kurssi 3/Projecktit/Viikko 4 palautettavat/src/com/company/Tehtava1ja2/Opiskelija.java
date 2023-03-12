package com.company.Tehtava1ja2;

import java.util.Scanner;

/*
Creator: Sam
Date: 02.02.2021
Version: 0.1
Description:

   Opiskelija-luokka perii Henkilo-luokan, mutta sillä on lisäksi omat yksityiset attribuutit:
                             - Opiskelijanumero (int)
                             - Aloituspaiva (String)
                               sekä julkinen metodi:
                             - tulostaOpiskelija, joka tulostaa getHenkilonTiedot-metodin antamat tiedot
                             * sekä opiskejanumeron  ja aloituspäivän.


*/
public class Opiskelija extends Henkilo{




    //Jäsenmuuttujat
    private int Opiskelijanumero;
    private String Aloituspaiva;
    Scanner input = new Scanner(System.in);
    //Constructorit

    public Opiskelija(String nimi, String osoite, String syntymapaiva, int opiskelijanumero, String aloituspaiva) {
        super(nimi, osoite, syntymapaiva);
        Opiskelijanumero = opiskelijanumero;
        Aloituspaiva = aloituspaiva;
    }

    public Opiskelija() {
    }

    //Getterit ja Setterit

    public int getOpiskelijanumero() {
        return Opiskelijanumero;
    }

    public void setOpiskelijanumero(int opiskelijanumero) {
        Opiskelijanumero = opiskelijanumero;
    }

    public String getAloituspaiva() {
        return Aloituspaiva;
    }

    public void setAloituspaiva(String aloituspaiva) {
        Aloituspaiva = aloituspaiva;
    }


    //Metodit

    public String tulostaOpiskelija(){
        return super.getHenkilonTiedot() + ", " + this.Opiskelijanumero+ ", "+ this.Aloituspaiva;
    }


    public void KyseleTiedot(Opiskelija op1){
        super.HenkiloTiedot(op1);
        System.out.print("Anna Aloituspäivä: ");
        setAloituspaiva(input.nextLine());
        System.out.print("Anna Opiskelijanumero: ");
        setOpiskelijanumero(input.nextInt());
        input.nextLine();

    }
}
