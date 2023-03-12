package com.company;

import com.company.model.*;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
    Elain e1 = new Papukaija("Polly",12);
    Papukaija p1 = new Papukaija("Matti",15);

    e1.aantele();
    p1.aantele();

        SuoraKulmio sk1 = new SuoraKulmio(10,5);
        System.out.println(sk1.getAla());
        sk1.piirra();

        SuoraKulmio sk2 = new SuoraKulmio(5,10);
        System.out.println(sk2.getAla());
        if (sk1.compare(sk2) == 0);
        System.out.println("Saman kokoiset");

        ICompare sk3 = new SuoraKulmio(3,2);
        ((SuoraKulmio) sk3).piirra();
        sk3.compare(sk2);
        Henkilo h9 = new Henkilö("KALLE");
        Henkilo h1 = new Henkilo("Aku","Ankka",21);

        Henkilo h2 = new Henkilo("Iines","Ankka",20);
        Henkilo h4 = new Henkilo("Kultu","Kimallus",65);
        Henkilo h3 = new Henkilo("Roope","Ankka",68);
        ArrayList<Henkilo> Henkilot = new ArrayList<>();

        Henkilot.add(h1);
        Henkilot.add(h2);
        Henkilot.add(h4);
        Henkilot.add(h3);
        for (Henkilo h: Henkilot){
            System.out.println(h.getEtunimi() +" " + h.getIka());
        }

        Collections.sort(Henkilot);
        for (Henkilo h: Henkilot){
            System.out.println(h.getEtunimi() +" " + h.getIka());
        }

    }
}

