package com.company;

import java.util.Scanner;

public class LaskuSovellus {
    public static void main(String[] args) {
        int luku1;
        int luku2;

        // Laske syötteinä annetut luvut yhteen2

        while(true) {
            Scanner input = new Scanner(System.in);
            System.out.print("Anna eka luku: ");
            luku1 = input.nextInt();

            if (luku1 <= -100)
                break;

            System.out.print("Anna toka luku: ");
            luku2 = input.nextInt();
            System.out.println("Lukujen summa on " + (luku1 + luku2));
            System.out.printf("Lukujen osamäärä on %5.2f",  ((double) luku1 / luku2));

        }
    }
}
