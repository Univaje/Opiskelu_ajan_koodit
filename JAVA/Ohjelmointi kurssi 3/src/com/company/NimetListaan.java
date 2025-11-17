package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NimetListaan {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String syote ;
        ArrayList<String> taulukko = new ArrayList<>();
        while(true){
            System.out.print("Anna nimi:");
            syote = input.nextLine();
            if (syote.equals("#"))
                break;
            taulukko.add(syote);
        }
        for (String n :taulukko) {
            if (n.startsWith("matti")){
                System.out.println(n);
            }

        }
        




    }
}
