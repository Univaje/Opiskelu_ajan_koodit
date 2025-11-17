package com.company;

import java.util.Scanner;

public class KT3 {
    /** Laadi ohjelma, joka kysyy kuukauden tulot ja
     * laskee sekä tulostaa näytölle tuloista yhteenlasketun tulon,
     * keskitulon kuukautta kohti, sekä suurimman kuukausikohtaisen tulon.
     * Jos syötetty kuukausitulo on negatiivinen, ohjelma tulostaa kysytyt arvot ja päättää toimintansa.
      */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double tulot = 1;
        double koktulot = 0;
        double suurintulo = 0;
        int i;
        System.out.println("Ohjelma laskee kuukaisen kokonaistulon, keskimääräisen kuukausikohtaisen " + '\n' +
                "tulon ja suurimman kuukausikohtaisen tulon antamiesi tietojen perusteella," + '\n');

        for (i = 1; tulot > 0; i++) {
            System.out.print("Anna " + i + ". kuukauden tulo: ");
            tulot = input.nextDouble();
            if (tulot > suurintulo) // Otetaan suurin luku suurimmaksi kuukausituloksi
                suurintulo = tulot;
            if (tulot > 0)
            koktulot += tulot; // lisätään tulot yhteen keskiarvoksi laskettavaksi
            else
                break;
        }
        System.out.println("Kokonaistulot ovat " + koktulot);
        System.out.println("Keskiarvoinen kuukausikohtainen tulo on " + koktulot/(i-1));
        System.out.println("Suurin kuukausikohtainen tulo on " + suurintulo);

    }
}
