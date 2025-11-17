package com.company.model;

/*
Creator: Sam
Date: 09.02.2021
Version: 0.1
Description:

*/
public class SuoraKulmio extends MyClass implements IKuvio, ICompare{

    //Jäsenmuuttujat

private int leveys;
private int korkeus;

    //Constructorit

    public SuoraKulmio(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
    }


    //Getterit ja Setterit

    public int getLeveys() {
        return leveys;
    }

    public void setLeveys(int leveys) {
        this.leveys = leveys;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public void setKorkeus(int korkeus) {
        this.korkeus = korkeus;
    }


    //Metodit


    @Override
    public double getAla() {
        return (double) leveys*korkeus;
    }

    @Override
    public int compare(ICompare c) {
        SuoraKulmio s = (SuoraKulmio) c;
        if (this.getAla() == s.getAla())
            return 0;
        else if (this.getAla() < s.getAla())
            return -1;
        else
            return 1;

    }

    @Override
    public void piirra() {
        for (int i = 0; i <korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    @Override
    public void TeeJotain() {

    }
}
