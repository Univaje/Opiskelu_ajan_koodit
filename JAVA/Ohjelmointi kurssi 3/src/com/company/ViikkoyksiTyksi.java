package com.company;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class ViikkoyksiTyksi {
    /**
     * Tehtävä 1
     *
     * Tee ohjelma joka kysyy käyttäjältä yhden osakkeen nimen (merkkijono),
     * osinkotuottoprosentin (desimaali) ja sijoitettava rahamäärän(kokonaisluku) .
     * Sitten ohjelma tulostaa alla olevaan tapaan lauseen, jossa se käyttää näitä tietoja.
     *
     * Anna osake:Nordea
     * Anna osinkopros:3,5
     * Anna sijoitus:3400
     * Osakkeen Nordea tuotto pääomalle 3400 on 119.00
     * @param
     */



    public static void main(String[] args) {

        // Jäsenmuuttujat
        double osinko = 1;
        int sijoitus = 1;
        String osake = "";
        Scanner input = new Scanner(System.in);

        // Pyydetään käyttäjältä arvot muuttujiin
        System.out.print("Anna osake:");
        osake =input.nextLine();
        System.out.print("Anna osinkopros:");
        osinko = input.nextDouble();
        System.out.print("Anna sijoitus:");
        sijoitus = input.nextInt();

        // Tulostetaan osakkeen tuotto laskukaavalla  sijoitus * osinko/100
        /*Vastaus tulostettuna ikkunalla.
         JOptionPane.showMessageDialog(null,"Osakkeen"+ osake +" tuotto pääomalle " + sijoitus + " on " + (sijoitus*(osinko/100)),
         "Osakkeen tuotto",JOptionPane.INFORMATION_MESSAGE);
         */
        System.out.println("Osakkeen "+ osake +" tuotto pääomalle " + sijoitus + " on " + (sijoitus*(osinko/100)));
    }


}
