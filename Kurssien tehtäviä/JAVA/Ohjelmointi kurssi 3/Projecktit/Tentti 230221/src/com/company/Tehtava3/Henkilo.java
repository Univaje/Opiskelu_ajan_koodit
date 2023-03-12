package com.company.Tehtava3;

import java.util.Scanner;

/*
Creator: Sam
Date: 23.02.2021
Version: 0.1
Description:
        Anna asunnon numero (0 = Lopettaa syötön): A1
        Anna asujan etunimi: Ami
        Anna asujan sukunimi: Asujainen
        Anna asujan ikä kuluvana vuonna: 23

*/
public class Henkilo {

    //Jäsenmuuttujat
    private String etunimi;
    private String sukunimi;
    private int ika;

    //Constructorit


    public Henkilo() {
    }

    public Henkilo(String etunimi, String sukunimi, int ika) {
        setEtunimi(etunimi);
        setSukunimi(sukunimi);
        setIka(ika);
    }


    //Getterit ja Setterit

    public String getEtunimi() {
        return etunimi;
    }

    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public int getIka() {
        return ika;
    }

    public void setIka(int ika) {
        this.ika = ika;
    }


    //Metodit
    public void kysyHenkilonTiedot(){
        Scanner input = new Scanner(System.in);
        System.out.print("Anna Asukkaan etunimi:");
        setEtunimi(input.nextLine());
        System.out.print("Anna Asukkaan sukunnimi:");
        setSukunimi(input.nextLine());
        System.out.print("Anna Asukkaan ika:");
        setIka(input.nextInt());
    }

    @Override
    public String toString() {
        return "Etunimi: " + etunimi +", sukunimi: " + sukunimi + " ika: " + ika;
    }
}
