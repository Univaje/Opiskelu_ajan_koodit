package com.company;

import java.util.Random;

public class ArvosanatTaulukkoon {
    public static void main(String[] args) {
        int[]taulukko = new int[100];
        int hylatty=0,hyvaksytty=0;
        for (int i = 0; i < 100; i++) {
            taulukko[i] = new Random().nextInt(5);
            if (taulukko[i] == 0)
                hylatty++;
            else
                hyvaksytty++;
        }
        System.out.println("Arvottiin arvosanoja 100 kappaletta. hylättyjä oli "+hylatty+ " ja hyväksyttyjä oli "+hyvaksytty);
    }
}
