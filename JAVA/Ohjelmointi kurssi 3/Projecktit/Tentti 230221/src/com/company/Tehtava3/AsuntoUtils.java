package com.company.Tehtava3;

import java.util.ArrayList;

/*
Creator: Sam
Date: 23.02.2021
Version: 0.1
Description:
2. vaihe. Tee erillinen luokka (esim AsuntoUtils), jossa kaksi  static -tyyppistä metodia

- palautaAsujat (param1, param2). Metodi palauttaa sopivassa tietorakenteessa kaikki parametrina annetun asunnon asujat,
  Testaa toiminta pääohjelmassa. Yllä olevassa  esimerkkikäyttöliittymässä ei ole esitetty sitä, miten testaat ko
  metodin toimintaa. Param1 on asunnon nimi merkkijonona, josta etsitään, Param2 sisältää kaikki asujat,
  jotka on syötetty järjestelmään (1 p)

- keskiIka (param). Metodi palauttaa kaikkien asukkaiden keski-iän  Testaa toiminta pääohjelmassa.
Yllä olevassa  esimerkkikäyttöliittymässä ei ole esitetty sitä, miten testaat ko metodin toimintaa.
Param sisältää kaikki asujat. (1 p)
*/
public class AsuntoUtils {

    //Jäsenmuuttujat


    //Constructorit


    //Getterit ja Setterit


    //Metodit
    public static void palautaAsujat (String asunnonnimi, ArrayList<Asunto> Asunnot){

        for (Asunto a : Asunnot) {
            if (a.getAsunnonNro().equals(asunnonnimi) ){
                System.out.println("Asukas löytyi:");
                System.out.println(a);
            }
        }
    }
    public static int KeskiIka(ArrayList<Asunto> Asunnot){
        int i= 0,summa = 0;
        for (Asunto a : Asunnot) {
            summa+= a.getAsukas().getIka();
            i++;

            }
        summa = summa/i;
        return summa;
        }

    }


