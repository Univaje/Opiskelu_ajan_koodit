package com.company.Tehtava1ja2;

import java.util.Scanner;

/*
Creator: Sam
Date: 09.02.2021
Version: 0.1
Description:
        Tee ohjelma, jolla on koosteluokka(Luokka jossa o sisällä luokkia) OmatJaYhteisetTilit, jolla on julkiset attribuutit:
        -      omaTili (Saastoluokka-olio)
        -      yhteinenTili (SuperSaastoLuokka-olio)

        Ohjelman toiminta:
        -      Kysyy tilien numerot, omistajat, saldon sekä korkoprosentit.
        -      Jos tilin koroksi yritetään asettaa negatiivinen luku, käsitellään se pääohjelmassa try-catch
        -      mekanismilla sekä kysytään uutta korkoa niin kauan, kunnes syöte on nolla tai suurempi.
        -      Kun tiedot ovat syötetty, tulostetaan tilien tiedot.

*/
public class OmatjaYhteisetTilit {

    //Jäsenmuuttujat
    public SaastoTili omaTili;
    public SuperSaastotili yhteinenTili;
    Scanner input = new Scanner(System.in);
    //Constructorit

    public OmatjaYhteisetTilit() {
    }

    public OmatjaYhteisetTilit(SaastoTili omaTili, SuperSaastotili yhteinenTili) {
        this.omaTili = omaTili;
        this.yhteinenTili = yhteinenTili;
    }


//Getterit ja Setterit


    public SaastoTili getOmaTili() {
        return omaTili;
    }

    public void setOmaTili(SaastoTili omaTili) {
        this.omaTili = omaTili;
    }

    public SuperSaastotili getYhteinenTili() {
        return yhteinenTili;
    }

    public void setYhteinenTili(SuperSaastotili yhteinenTili) {
        this.yhteinenTili = yhteinenTili;
    }

    //Metodit


    @Override
    public String toString() {
        return "OmatjaYhteisetTilit{" +
                "omaTili=" + omaTili +
                ", yhteinenTili=" + yhteinenTili +
                '}';
    }

    public void Aloita(){
        // luodaan null arvoinen abstraktiluokka joka muokataan oikeaksi luokaksi valinnan mukaan
        Tili Ss = null;
        OmatjaYhteisetTilit tilit = new OmatjaYhteisetTilit();
        while (true) {

            String kumpi;
        while (true) {
            System.out.println("Lisätäänkö yhteinentili (1) vai yksityinentili (2) ensin?");
            kumpi = input.nextLine();
            if (kumpi.equals("1")) {
                // muutetaan tili oikeaan muotoon ja pyydetään tarvittavat tiedot
                Ss = new SuperSaastotili();
                break;
                }
            else if (kumpi.equals("2")) {
                Ss = new SaastoTili();
                break;
                }
            else
                System.out.println("virheellinen syöte!");
                }

                System.out.println("Syötä Omistaja:");
                Ss.setOmistaja(input.nextLine());
                System.out.println("Syötä Tilinumero");
                Ss.setTilinumero(input.nextLine());
            while (true) {
                try {
                    System.out.println("Syötä Tilinsaldo");
                    Ss.setSaldoEuroa(input.nextDouble());
                    break;
                } catch (Exception Ex) {
                    System.out.println("Virheellinen syöte! anna luku muodossa 0,00 ");
                }
            }
                while (true) {
                    try {
                        System.out.println("Syötä korkoprosentti: ");
                        double korko = input.nextDouble();
                        input.nextLine();
                        Ss.setVuosikorko(korko);

                        break;
                    } catch (Exception Ex) {
                        System.out.println("Virheellinen syöte! anna luku muodossa 0,00 ");
                    }
                }
                // valinnan mukaan castataan tili oikeaan muotoon ja asetetaan oikeaan muuttujaan
                if (kumpi.equals("1"))
                    tilit.setYhteinenTili((SuperSaastotili) Ss);

                else
                    tilit.setOmaTili((SaastoTili) Ss);
        // kierretään looppia kunnes molemmissa muuttujissa on syötetty arvot
        if (tilit.yhteinenTili != null && tilit.omaTili != null)
            break;
        }
        tilit.omaTili.tulostaTilinTiedot();
        tilit.yhteinenTili.tulostaTilinTiedot();

        }

}


