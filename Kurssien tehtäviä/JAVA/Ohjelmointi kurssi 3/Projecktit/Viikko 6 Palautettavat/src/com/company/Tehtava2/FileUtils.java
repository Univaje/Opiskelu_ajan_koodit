package com.company.Tehtava2;

import java.io.File;
import java.io.FileWriter;
import java.io.Reader;
import java.util.Scanner;

/*
Creator: Sam
Date: 22.02.2021
Version: 0.1
Description:
    Tee luokka FileUtils, jolla on staattiset metodit ReadFromFile sekä WriteToFile:

    - WriteToFile-metodi ottaa vastaan tiedoston nimen, johon kirjoitetaan, sekä tässä tapauksessa käyttäjän
      antaman String-muotoisen syötteen. Kun metodia kutsutaan se käynnistää säikeen, jossa käyttäjän syöte kirjoitetaan
      tiedostoon taustalla. Edellinen syöte kirjoitetaan aina yli, joten ns. append-toimintoa ei tarvitse toteuttaa.

    - ReadFromFile-metodi ottaa vastaan tiedoston nimen, josta sisältöä luetaan ja palauttaa sisällön String-muotoisena
      käyttäjälle. Huom! Lukemista ei tässä tapauksessa tehdä taustalla.

*/
public class FileUtils {

    //Jäsenmuuttujat


    //Constructorit


    //Getterit ja Setterit


    //Metodit

public static void WriteToFile(String Dir,String data){
    Scanner input = new Scanner(System.in);
    String tiedostonimi;
    try {

        File Polku = new File(Dir);
        if(Polku.createNewFile()){
            System.out.println("Tiedosto tallennettu!");
        }
        else{
            System.out.println("Tiedosto on jo olemassa!");
            System.out.println("Päivitetään teksti tieodostoon!");
        }
        FileWriter Writer = new FileWriter(Dir);
        Writer.write(data);
        Writer.close();

    }catch (Exception ex) {
        System.out.println("Virhe!");
        ex.printStackTrace();
    }
}

public static String ReadFromFile(String TiedostoPolku) {
    String Luetut = "Ei Dataa!";

    File Polku = new File(TiedostoPolku);
    try {
        Thread.sleep(1000);
        Scanner Reader = new Scanner(Polku);
        while (Reader.hasNextLine()) {
            Luetut = Reader.nextLine();
            System.out.println(Luetut);
        }
        Reader.close();

    } catch (Exception ex) {
        System.out.println(ex);
    }
    return Luetut;
    }
}

