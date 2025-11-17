package com.company.Tehtava1ja2;

import java.awt.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

/*
Creator: Sam
Date: 02.02.2021
Version: 0.1
Description:
* Tee luokat Henkilo, Opiskelija sekä Henkilokunta.
    Henkilo-luokalla on yksityiset attribuutit:
                             - Nimi (String)
                             - Osoite (String)
                             - Syntymaaika (String)
    sekä methodi:
                             - getHenkilonTiedot, joka palauttaa yhdessä Stringissä pilkulla erotettuna nimen,
                             * osoitteen sekä syntymaäjan, mutta metodi näkyy vain luokan perillisille.



-----vuosi
-------kasvu prosentti

 1. lopullinensumma  = ostohinta  <--- tämä on tiedossa ostohinta =100 kasvuprosentti = 10%
 vuodentuotto = Laskevuodentuotto(lopullisensumman prosentin)

 2. lasketaan ensimmäisen vuoden arvo lasketaan ostohinta *kasvuprosentti 100*0,1 = 10
 lisätään lopulliseen summaan ensimmäisen vuoden kasvu ( ostohinta+ekanvuoden tuotto) 100+10 = 110
 tokan vuoden tuotto = lasketaan toisen vuoden arvo = lopullinen summa * kasvuprosentti 110 *10% =11

 lisätään lopulliseen summaan toisen vuoden tuotto ( lopullinen summa = osthinta+ekanvuoden tuotto
 +tokavuoden tuotto)


*/
public class Henkilo {

    //Jäsenmuuttujat
    private String nimi;
    private String osoite;
    private String syntymapaiva;
    Scanner input = new Scanner(System.in);

    //Constructorit

    public Henkilo(String nimi, String osoite, String syntymapaiva) {
        this.nimi = nimi;
        this.osoite = osoite;
        this.syntymapaiva = syntymapaiva;
    }

    public Henkilo() {
    }
//Getterit ja Setterit

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getOsoite() {
        return osoite;
    }

    public void setOsoite(String osoite) {
        this.osoite = osoite;
    }

    public String getSyntymapaiva() {
        return syntymapaiva;
    }

    public void setSyntymapaiva(String syntymapaiva) {
        this.syntymapaiva = syntymapaiva;
    }


    //Metodit

    protected String getHenkilonTiedot(){
        return this.nimi + ", "+ this.osoite + ", "+ this.syntymapaiva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Henkilo henkilo = (Henkilo) o;
        return Objects.equals(nimi, henkilo.nimi) && Objects.equals(osoite, henkilo.osoite) && Objects.equals(syntymapaiva, henkilo.syntymapaiva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nimi, osoite, syntymapaiva);
    }

    @Override
    public String toString() {
        return nimi +", " + osoite +", " + syntymapaiva;
    }

    public void HenkiloTiedot(Object o){

        System.out.print("Anna Nimi: ");
        setNimi(input.nextLine());
        System.out.print("Anna Osoite:");
        setOsoite(input.nextLine());
        System.out.print("Anna syntymäpäivä: ");
        setSyntymapaiva(input.nextLine());

    }
    // Tietojen kysymistä varten tehty metodi
    public void AlkuKysely(ArrayList<Object> op){
        String k;
        Scanner input = new Scanner(System.in);
        // Pyydetään tiedot käyttäjältä oikeaan olioon ja tallennetaan se arraylistiin
        while (true){

        System.out.print("syötetäänkö uuden henkilön tiedot (k/e)");
        k = input.nextLine().toUpperCase();
            if (k.equals("K")){
                System.out.print("henkilokunta vai opiskelija?");
                k = input.nextLine().toLowerCase();
                if (k.equals("henkilokunta")){
                Henkilokunta henk1 = new Henkilokunta();
                henk1.KyseleTiedot(henk1);
                op.add(henk1);
                }
                else if (k.equals("opiskelija")){
                Opiskelija op1 = new Opiskelija();
                op1.KyseleTiedot(op1);
                op.add(op1);
                }
                else
                System.out.println("Syötä 'henkilokunta' tai 'opiskelija'");
            }
            else if (k.equals("E") )
                break;
            else
                System.out.println("virheelinen syöte!");
        }
    }
}
