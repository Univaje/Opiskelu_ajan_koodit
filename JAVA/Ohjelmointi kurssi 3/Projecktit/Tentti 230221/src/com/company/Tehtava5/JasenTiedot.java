package com.company.Tehtava5;/*
Creator: Sam
Date: 23.02.2021
Version: 0.1
Description:
         Ohjelmistoon tarvitaan siis laajennus,
         jotta se voi hakea jäsentiedot eri seurojen käyttämistä järjestelmistä Ohjelmistossa on laajennus,
         joilla pelaajien tietoja voidaan noutaa eri urheiluseurojen järjestelmistä. Tietojen nouto toteutetaan
         käyttäen rajapintaa, jossa on yksi metodi:

        public ArrayList<Jasen> getJasenTiedot();
*/

import java.util.ArrayList;

public interface JasenTiedot {

    public ArrayList<Jasen> getJasenTiedot();

}
