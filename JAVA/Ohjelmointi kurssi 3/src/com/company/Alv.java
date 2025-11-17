package com.company;

import java.util.Scanner;

public class Alv {
    public static void main(String[] args) {
        /**
         * Kysytään käyttäjältä tuotteen hinta ja alv%
         *
         * ohjelma tulostaa tuotteen lopullisen hnnan
         */

        double alv, hinta;
        Scanner input = new Scanner(System.in);
        System.out.print("Anna tuotteen hinta:");
        hinta = input.nextInt();
        System.out.print("Anna tuotteen alv%:");
        alv = input.nextDouble();

        System.out.printf("Tuotteen lopullinen hinta on %5.2f" +(hinta*(1+(alv/100))));
        //System.out.println("Tuotteen lopullinen hinta on " + (hinta*(1+(alv/100))));
    }
}
