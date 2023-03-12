package com.company;

import java.util.*;

public class KT4 {
    public static void main(String[] args) {
        ArrayList<Integer>luvut = new ArrayList<Integer>(7);
        Scanner input = new Scanner(System.in);
        Random rnd = new Random();
        ArrayList<Integer>tietokoneenluvut = new ArrayList<Integer>(7);
        char kyllavaiei;
        int luku1;
        int luku2;

        for (int i = 0; i < 8; i++) { // Arvotaan lukuja
            luku1 = rnd.nextInt(30);
            if (luvut.contains(luku1)){
                i--;
            }
            else{
                luvut.add(luku1);
            }



        }
        Collections.sort(luvut); // Laitetaan luvut oikeaan järjestykseen
        for (int luku : luvut)
        {
            System.out.print(" " + luku);
        }


        for (int i = 0; i < 8; i++) { // Arvotaan "tietokoneen" luvut
            luku2 = rnd.nextInt(30);
            if (tietokoneenluvut.contains(luku2)){
                i--;
            }
            else{
                tietokoneenluvut.add(luku2);
            }



        }
        Collections.sort(tietokoneenluvut); // sortataan tietokoneen luvut
        System.out.println();
        System.out.print(" Haluatko arpoa rivin (k= kyllä, e = ei)?: ");
        kyllavaiei = input.next().charAt(0);
        if (kyllavaiei == 'k') {
            for (int luku : tietokoneenluvut) {
                System.out.print(" " + luku);
            }
            Collection<Integer> samatluvut = new HashSet<Integer>(luvut); // Katsotaan löytyykö samoja lukuja
            samatluvut.retainAll(tietokoneenluvut);
            System.out.println();
            System.out.println("Samoja lukuja: " + samatluvut);
        }
        else if (kyllavaiei == 'e') {

        }





    }
}
