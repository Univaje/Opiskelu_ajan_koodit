package com.company.Tehtava1ja2;

import java.util.Scanner;

/*
Creator: Sam
Date: 02.02.2021
Version: 0.1
Description:

    Henkilokunta-luokka perii myös Henkilo-luokan, mutta siinä on lisäksi omat yksityiset attribuutit:
                             - Tyontekijanumero (String)
                             - Toimipaikka (String)
                             - Titteli (String)
                             - tulostaHenkilokuta, joka tulostaa getHenkilonTiedot-metodin antamat tiedot sekä
                               työntekijänumeron, toimipaikan ja tittelin.

*/
public class Henkilokunta extends Henkilo{



    //Jäsenmuuttujat
    private String Tyontekijanumero;
    private String Toimipaikka;
    private String Titteli;
    Scanner input = new Scanner(System.in);
    //Constructorit

    public Henkilokunta(String nimi, String osoite, String syntymapaiva, String tyontekijanumero, String toimipaikka, String titteli) {
        super(nimi, osoite, syntymapaiva);
        Tyontekijanumero = tyontekijanumero;
        Toimipaikka = toimipaikka;
        Titteli = titteli;
    }

    public Henkilokunta() {
    }
//Getterit ja Setterit

    public String getTyontekijanumero() {
        return Tyontekijanumero;
    }

    public void setTyontekijanumero(String tyontekijanumero) {
        Tyontekijanumero = tyontekijanumero;
    }

    public String getToimipaikka() {
        return Toimipaikka;
    }

    public void setToimipaikka(String toimipaikka) {
        Toimipaikka = toimipaikka;
    }

    public String getTitteli() {
        return Titteli;
    }

    public void setTitteli(String titteli) {
        Titteli = titteli;
    }


    //Metodit

    public String tulostaHenkilokunta(){
        return super.getHenkilonTiedot() +", "+ this.Titteli +", "+ this.Toimipaikka +", "+this.Tyontekijanumero;
    }

    public void KyseleTiedot(Henkilokunta henk){
        super.HenkiloTiedot(henk);
        System.out.print("Anna työntekijä numero: ");
        setTyontekijanumero(input.nextLine());
        System.out.print("Anna titteli: ");
        setTitteli(input.nextLine());
        System.out.print("Anna Toimipaikka: ");
        setToimipaikka(input.nextLine());
    }

}
