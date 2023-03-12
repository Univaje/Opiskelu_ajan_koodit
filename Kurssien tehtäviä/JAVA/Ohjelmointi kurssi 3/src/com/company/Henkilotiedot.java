package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Henkilotiedot {
    public static void main(String[] args) {
        String henkilo, kotikunta;
        int ika;
        Scanner input = new Scanner(System.in);

        System.out.print("Anna nimesi:");
        henkilo = input.nextLine();
        System.out.print("Anna ikäsi:");
        ika = input.nextInt();
        input.nextLine(); // luetaan numeron jälkeen tyhjä rivi
        System.out.print("Anna kotikuntasi:");
        kotikunta = input.nextLine();
        System.out.println(henkilo +" "+ ika + " " +kotikunta);
    }
}
