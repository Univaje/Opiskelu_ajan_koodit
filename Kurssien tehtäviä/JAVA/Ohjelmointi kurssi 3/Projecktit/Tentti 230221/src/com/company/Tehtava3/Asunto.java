package com.company.Tehtava3;

import java.util.Scanner;

/*
Creator: Sam
Date: 23.02.2021
Version: 0.1
Description:

*/
public class Asunto {

    //Jäsenmuuttujat

    private Henkilo asukas;
    private String asunnonNro;

    //Constructorit

    public Asunto(Henkilo asukas, String asunnonNro) {
        setAsukas(asukas);
        setAsunnonNro(asunnonNro);
    }

    public Asunto() {
    }
    //Getterit ja Setterit

    public Henkilo getAsukas() {
        return asukas;
    }

    public void setAsukas(Henkilo asukas) {
        this.asukas = asukas;
    }

    public String getAsunnonNro() {
        return asunnonNro;
    }

    public void setAsunnonNro(String asunnonNro) {
        this.asunnonNro = asunnonNro;
    }


    //Metodit

public void kysyAsunnonTiedot(Henkilo h){
    Scanner input = new Scanner(System.in);
        System.out.print("Anna Asunnon numero:");
        String tarkiste = input.nextLine();
        if (tarkiste.equals("0"))
            return;
        setAsunnonNro(tarkiste);
        h.kysyHenkilonTiedot();
        setAsukas(h);
}
    @Override
    public String toString() {
        return "Asunnon numero: " + asunnonNro +" Asukas:" + asukas;
    }
}
