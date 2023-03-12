package com.company.Tehtava5;

import java.util.ArrayList;

/*
Creator: Sam
Date: 23.02.2021
Version: 0.1
Description:
         Rajapintaa testataan seuraaville seuroilla eli TurmiolanErä ja HaminalahdenMetsästysseura.
         Niille tehdään siis erilliset luokat.  Molempien seurojen luokat, jotka toteuttavat eo rajapintaa,
         palauttavat testimielessä esim kolme jäsenen tiedot. Kovakoodaat jäsenet ko metodiin.
*/
public class HaminalahdenMetsastysseura implements JasenTiedot{


    @Override
    public ArrayList<Jasen> getJasenTiedot() {

        ArrayList<Jasen> jasenet = new ArrayList<>();
        Jasen Jsn1 = new Jasen("HaminalahdenMetsastysseura",546840,"Teppo","Tulppu",
                "Teppo.Tulppu@Ankkalinna.com");
        Jasen Jsn2 = new Jasen("HaminalahdenMetsastysseura",853215,"Hannu","Hanhi",
                "Onnen.Onkija@Hillopulla.com");
        Jasen Jsn3 = new Jasen("HaminalahdenMetsastysseura",156344,"Toope","Ankka",
                "Tohelo@Täystuho.com");
        jasenet.add(Jsn1);
        jasenet.add(Jsn2);
        jasenet.add(Jsn3);
        return jasenet;
    }

    //Metodit


}
