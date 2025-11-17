package com.company;

import java.util.Scanner;

public class Lainanmaksu {
    public static void main(String[] args) {
        double korko, aika;
        int laina;

        Scanner scammer = new Scanner(System.in);

        System.out.println("anna laina määrä");
        laina = scammer.nextInt();
        System.out.println("Anna korko prosentti");
        korko = scammer.nextDouble();
        System.out.println("Anna laina aika vuosina");
        aika = scammer.nextInt();

        System.out.println("Kuukausi maksusi on: "+ ((laina*korko)/(1-(1/(1+Math.pow(korko,(aika*12)))))));
    }
}
