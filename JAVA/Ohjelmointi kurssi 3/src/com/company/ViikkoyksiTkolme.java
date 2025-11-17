package com.company;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

    /*Laadi ohjelma, joka kysyy kuukauden tulot ja laskee sekä tulostaa näytölle tuloista yhteenlasketun tulon,
    keskitulon kuukautta kohti, sekä suurimman kuukausikohtaisen tulon. Jos syötetty kuukausitulo on negatiivinen,
    ohjelma tulostaa kysytyt arvot ja päättää toimintansa.

    Esimerkkitulostus:

    Ohjelma laskee kuukausien kokonaistulon, keskimääräisen kuukausikohtaisen tulon
    ja suurimman kuukausikohtaisen tulon antamiesi tietojen perusteella.

    Syötä kuukausikohtaiset tulot.
    Anna 1. kuukauden tulo: 2000
    Anna 2. kuukauden tulo: 2000
    Anna 3. kuukauden tulo: 2000
    Anna 4. kuukauden tulo: 2200
    Anna 5. kuukauden tulo: 2400
    Anna 6. kuukauden tulo: 2400
    Anna 7. kuukauden tulo: 2000
    Anna 8. kuukauden tulo: 2000
    Anna 9. kuukauden tulo: 2000
    Anna 10. kuukauden tulo: 2100
    Anna 11. kuukauden tulo: 2100
    Anna 12. kuukauden tulo: 2000

    Anna 13. kuukauden tulo: -1

    Kokonaistulot ovat 25200.0
    Keskiarvoinen kuukausikohtainen tulo on 2100.0
    Suurin kuukausikohtainen tulo on 2400.0*/

public class ViikkoyksiTkolme {
    public static void main(String[] args) {

        //Jäsen muuttujat
        Scanner scammer = new Scanner(System.in);
        int tulo = 0, laskuri = 1, max=0,summa =0;

        // Pyydetään käyttäjältä tulot ja tallennetaan ne muuttujaan
        // samalla kerrytetään laskuria ( kertoo monesko kuukausi ja tätä voidaan käyttää keskiansiota laskiessa
        // käyttäjän antaessa -luku poistutaan loopista
        System.out.println("Syötä kuukausikohtaiset tulot:");
        while (tulo >=0){
            System.out.print("Anna "+laskuri+". kuukauden tulo:");
            tulo = scammer.nextInt();
            if (tulo >=0){
                summa += tulo;

                // jos kuukauden tulo on suurempi kuin aikaisempi maksimi, maksimi korvataan.
                if (tulo > max)
                    max = tulo;
            laskuri++;
            }
        }
        // vähennetään viimeisin kuukausi ( miinus merkkinen) pois laskurista
        laskuri--;

        // Tulostetaan käyttäjälle halutut tiedot
        System.out.println("Kokonaistulot ovat "+summa);
        System.out.println("Keskiarvoinen kuukausikohtainen tulo on "+((double)summa/laskuri));
        System.out.println("Suurin kuukausikohtainen tulo on " + max);



    }
}
