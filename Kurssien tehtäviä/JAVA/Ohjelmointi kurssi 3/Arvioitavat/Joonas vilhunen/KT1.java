package com.company;

import java.util.Scanner;

public class KT1 {
    /**
     * Tee ohjelma joka kysyy käyttäjältä osakkeen nimen (merkkijono),
     * osinkotuottoprosentin (desimaali) ja sijoitettava rahamäärän(kokonaisluku).
     * Sitten ohjelma tulostaa alla olevaan tapaan lauseen, jossa se käyttää näitä tietoja.
     *
     * Anna osake:Nordea
     * Anna osinkopros:3,5
     * Anna sijoitus:3400
     * Osakkeen Nordea tuotto pääomalle 3400 on 119.00
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String osake;
        float osinkopros;
        int sijoitus;


        System.out.print("Anna osake: ");
        osake = input.next();

        System.out.print("Anna osinkotuottoprosentti: ");
        osinkopros = input.nextFloat();

        System.out.print("Anna sijoitettava rahamäärä: ");
        sijoitus = input.nextInt();

        float tuotto = sijoitus / 100 * osinkopros;

        System.out.printf("Osakkeen %s tuotto pääomalle %d on %5.2f", osake, sijoitus, tuotto);
    }
}
