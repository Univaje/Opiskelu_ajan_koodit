package com.company;

import java.util.Scanner;

public class ArvausLeikki {
    public static void main(String[] args) {
        /**
         *
         */
        Scanner input = new Scanner(System.in);
        int luku = (int) (Math.random()*100);
        int arvaus = 101, laskuri =1;
        while (true){
            System.out.print("Arvaa luku:");
            arvaus = input.nextInt();
            if (arvaus < luku)
                System.out.println("Lukusi on liian pieni");
            else if (arvaus > luku)
                System.out.println("Lukusi on liian iso");
            else{
                System.out.println("Jee! " + laskuri + ":s Arvaus oli oikea");
                break;
            }
            laskuri++;

        }
    }
}
