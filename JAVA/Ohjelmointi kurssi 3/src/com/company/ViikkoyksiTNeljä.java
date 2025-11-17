package com.company;

import javax.lang.model.util.SimpleAnnotationValueVisitor6;
import java.util.*;



    /*Tehtävä 4

    Tee ohjelma joka arpoo lottorivin ja vertaa ohjelman arpomaan toteutuneeseen lottoriviin.
    Aina vertauksen jälkeen ohjelma ilmoittaa montako oli oikein ja mitkä ne olivat.
    Ohjelmassa ei tarvitse välittää lisänumeroista. Esimerkiksi järjestelmän arpoma rivi voisi olla
    4, 6, 8, 11, 14, 25, 29. Ohjelman tulee kysyä käyttäjältä, haluaako se uuden arvottavan lottorivin.
    Jos vastaus on kyllä, niin  sen jälkeen ohjelma  suoríttaa arvonnan ja vertailun.Jos vastaus on ei,
    niin ohjelma päättyy. Ohjelman tulostus voisi näyttää kutakuinkin seuraavalta:


    Lottorivi on: 4, 6, 8, 11, 14, 25, 29.
    Haluatko arpoa rivin (k= kyllä, e = ei)? k
    Ohjelma arpoi rivin: 1, 4, 13, 14, 23, 27, 39
    Oikein oli  2 kpl, jotka olivat 4, 14
    Haluatko arpoa rivin (k= kyllä, e = ei)? e
    Kiitos ja hei hei!*/


public class ViikkoyksiTNeljä {
    public static void main(String[] args) {

        //Jäsen muuttujat
        ArrayList<Integer> lottolistasi = new ArrayList<>();
        ArrayList<Integer> arvotturivi = new ArrayList<>();
        Scanner scammer = new Scanner(System.in);
        int arvottu = 0;
        String jatko;


        // Arvotaan käyttäjälle oma lottorivi
        System.out.print("Lottorivi on: ");
        for (int i = 0; i < 7; i++) {
           arvottu = new Random().nextInt(40);
           // tarkistetaan sisältääkö lista jo arvotun numeron. Arvotaan uudelleen kunnes ei sisällä
           while(lottolistasi.contains(arvottu)){
               arvottu = new Random().nextInt(40);
           }
           lottolistasi.add(arvottu);

        }
        // Sortataan lista suuruus järjestykseen ja tulostetaan käyttäjälle
        Collections.sort(lottolistasi);
        for (int i :
                lottolistasi) {
            System.out.print(i +", ");
        }
        // Huolehtii että viimeinen piste tulostuu ja rivi vaihtuu
        System.out.println("\b\b.");

        // Muodostetaan ikilooppi jossa lottorivi arvotaan
        while (true)
        {
            System.out.print("Haluatko arpoa rivin (k=kyllä,e = ei)?");
            jatko = scammer.nextLine();
            // muutetaan kirjain pieneksi
            jatko = jatko.toLowerCase(Locale.ROOT);
            // breakataan loopista käyttäjän antaessa "e"
            if (jatko.equals("e"))
                break;
            // Arvotaan rivi jos käyttäjä antaa "k"
            else if (jatko.equals("k")) {
                System.out.print("Ohjelma arpoi rivin: ");
                //Hyödynnetään samoja muuttujia ja arvotaan lottorivi uuteen arraylistiin
                for (int i = 0; i < 7; i++) {
                    arvottu = new Random().nextInt(40) + 1;
                    // arvotaan uusiksi jos listassa on jo kyseinen numero
                    while (arvotturivi.contains(arvottu)) {
                        arvottu = new Random().nextInt(40);
                    }
                    arvotturivi.add(arvottu);
                }
                // Sortataan lista suuruus järjestykseen ja tulostetaan käyttäjälle
                Collections.sort(arvotturivi);
                for (int i :
                        arvotturivi) {
                    System.out.print(i + ", ");
                }
                System.out.println("\b\b.");
                // Käydään arvotturivi läpi ja poistetaan kaikki numerot joita ei ole käyttäjän rivillä
                for (int i = 0; i < arvotturivi.size(); i++) {
                    arvottu = arvotturivi.get(i);
                    if (!lottolistasi.contains(arvottu)) {
                        arvotturivi.remove(arvotturivi.indexOf(arvottu));
                        // lukuja poistaessa kierros mittaria on pienennettävä
                        i--;
                    }
                }
                // Tulostetaan jos käyttäjällä ei ole yhtään osumaa
                if (arvotturivi.size() == 0)
                    System.out.println("Ei yhtään osumaa.");
                else {
                    // Tulostetaan montako osumaa käyttäjä sai
                    System.out.print("Oikein oli  " + arvotturivi.size() + " kpl. Oikeat numerot: ");
                    for (int i :
                            arvotturivi) {
                        System.out.print(i + ", ");
                    }
                    System.out.println("\b\b.");
                }
                // Tyhjennetään arvottujen lista uutta kierrosta varten
                arvotturivi.clear();
            }
            // Tulostetaan jos käyttäjä syöttää muuta kuin "k" tai "e"
            else
                System.out.println("Virheellinen syöte");
        }
        System.out.println("Kiitos ja hei hei!");
    }
}
