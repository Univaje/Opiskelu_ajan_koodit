package com.company;

import com.company.Tehtava1.PrintDiamond;
import com.company.Tehtava1.Threading;
import com.company.Tehtava2.KirjoitaTiedostoon;
import com.company.Tehtava2.LueTiedostosta;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input;
	/*
	Tehtävä 1
	Tee ohjelma, joka käynnistää useita eri säikeitä yhtäaikaiseen ajoon. Toteuta ratkaisu joko käyttäen
	Runnable-rajapintaa tai Thread-luokkaa käyttämällä. Ohjelman toiminta:


    - Toteuta säie, joka käyttää PrintDiamond-luokkaa kuvion tulostamiseen.
    - Ohjelma kysyy käyttäjältä kuinka montako säiettä käynnistetään.
    - Ohjelma käynnistää säikeitä halutun määrän, jolloin kuviot tulostuvat ruudulle (mahdollisesti mielivaltaisen sekaisin)

    Tehtävän tarkoituksena on oppia toteuttamaan säikeitä sekä huomata, että niitä täytyy pystyä hallitsemaan.
    */
        PrintDiamond pr = new PrintDiamond();
        input = new Scanner(System.in);
        Thread TR;
        int montako;
        try{
            System.out.println("Montako threadia aloitetaan?");
            montako = input.nextInt();
            for (int i = 0; i < montako; i++) {
                TR = new Thread(new Threading(pr));
                TR.start();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
/*  Tehtävä 2
    Olet selvitellyt yrityksen järjestelmässä piilevää suorituskykyyn liittyvää ongelmaa ja on selvinnyt,
    että tiedostoon kirjoittaminen pysäyttää ohjelmistojen ajamisen liian pitkäksi aikaa. Päätit ratkaista
    pulman tekemällä ratkaisun, jossa tiedostoon kirjoittaminen hoidetaan säikeessä taustalla.

    Ohjelman toteutus:

    Pääohjelma kysyy käyttäjältä tiedoston nimen, johon tietoa halutaan kirjoittaa sekä syötteen.
    Kun käyttäjä on antanut tiedot, kirjoitetaan syöte tiedostoon käyttäen FileUtils-luokan WriteToFile-metodia.
    Kun kirjoitus on tehty, käynnistetään pääohjelmassa uusi säie, joka odottaa ensin sekunnin ja sen jälkeen tulostaa
    tiedoston sisällön käyttäen FileUtils-luokan ReadFromFile-methodia.

    Huom! Tässä ohjelmassa käytetään keinotekoista odottamista ennen tiedostosta lukemista.
    Keinotekoiset odottamiset ovat huonoa ohjelmointia ja tässäkin tapauksessa luku pitäisi
    tehdä heti kun tiedetään, että kirjoitus on onnistunut (esim. callbackin jälkeen). Kurssilla ei
    kuitenkaan ole vielä käsitelty asioita riittävästi, jotta tämä olisi harjoituksen kannalta järkevää.
*/
        input = new Scanner(System.in);
        String tiedostonimi, Tekstia;
        try {

            System.out.print("Anna Tiedosto nimi:");
            tiedostonimi = input.nextLine()+ ".txt";
            System.out.print("Anna Tallennettava teksti:");
            Tekstia = input.nextLine() ;
            Thread kirjoitus = new Thread(new KirjoitaTiedostoon(tiedostonimi,Tekstia));
            kirjoitus.start();
            Thread luku = new Thread(new LueTiedostosta(tiedostonimi));
            luku.start();


        }catch (Exception ex) {
            System.out.println("Virhe!");
            ex.printStackTrace();
        }
    }
}
