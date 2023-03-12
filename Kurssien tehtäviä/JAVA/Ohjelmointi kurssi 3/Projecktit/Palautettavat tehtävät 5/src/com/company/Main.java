package com.company;

import com.company.Tehtava1ja2.OmatjaYhteisetTilit;
import com.company.Tehtava1ja2.SaastoTili;
import com.company.Tehtava1ja2.SuperSaastotili;
import com.company.Tehtava1ja2.Tili;
import com.company.Tehtava3.ITelephoneMic;
import com.company.Tehtava3.ITelephoneSpeaker;
import com.company.Tehtava3.Kaiutin;
import com.company.Tehtava3.Mikrofoni;
import com.company.Tehtava4.*;

import javax.sound.midi.MidiUnavailableException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

	    /*Tehtävä 1 Kuvitteelliset pankit tarjoavat erilaisia säästötilejä, joiden korkoprosentin laskenta
	    toimii tiettyjen kaavojenmukaisesti. Jotta pääohjelman laskentaan voitaisiin tulevaisuudessakin helposti
	    liittää uuden tyyppisiä tilejä,on tehtävänäsi suunnitella luokkarakenne, jolla tämä voidaan toteuttaa.

        Tee luokkien toteutukset sekä lyhyt testiohjelma, jolla testaat niiden toimivuuden.
        Tehtävän tarkoituksena on opetella Javan abstraktien metodien esittely sekä toteuttaminen.

        ArrayList<Tili> tilit = new ArrayList<>();
        try {
            Tili tili1 = new SaastoTili("12-15-15", "Väpökki", 2345, 4.5, 0);
            SaastoTili tili3 = new SaastoTili("12-15-15", "Pöpökki", 2345, 10.0, 0);
            SuperSaastotili tili4 = new SuperSaastotili("12-15-16", "Häpökki", 12345, 1.0, 0);
            Tili tili2 = new SuperSaastotili("12-15-18", "Löpökki", 2345, 2.5, 0);
            tilit.add(tili1);
            tilit.add(tili2);
            tilit.add(tili3);
            tilit.add(tili4);

            for (Tili T : tilit) {
                T.tulostaTilinTiedot();
            }
        }
        catch (Exception Ex){
            System.out.println(Ex);
        }

*/
        /*Tehtävä 2

        Käytä edellisessä tehtävässä toteutettuja luokkia, mutta lisää Tili-luokkaan poikkeuskäsittely:
        -      Muuta Tili-luokan setVuosikorko-metodin esittely ja toteutus, niin että se heittää ”ArithmeticException”
        -poikkeuksen jos korkoprosentiksi yritetään asettaa negatiivinen luku.

        Tee ohjelma, jolla on koosteluokka(Luokka jossa o sisällä luokkia) OmatJaYhteisetTilit, jolla on julkiset attribuutit:
        -      omaTili (Saastoluokka-olio)
        -      yhteinenTili (SuperSaastoLuokka-olio)

        Ohjelman toiminta:
        -      Kysyy tilien numerot, omistajat, saldon sekä korkoprosentit.
        -      Jos tilin koroksi yritetään asettaa negatiivinen luku, käsitellään se pääohjelmassa try-catch
        -      mekanismilla sekä kysytään uutta korkoa niin kauan, kunnes syöte on nolla tai suurempi.
        -      Kun tiedot ovat syötetty, tulostetaan tilien tiedot.

        Tehtävän tarkoituksena on opetella abstraktien luokkien käyttöä, muokkaamista sekä virhetilanteen
        käsittelyä poikkeuksen avulla.



            OmatjaYhteisetTilit Perhetili = new OmatjaYhteisetTilit();
            Perhetili.Aloita();

*/












        /*Tehtävä 3  Suomalaisessa kännyköitä valmistavassa yrityksessä on kyllästytty piirisarjavalmistajan muuttuviin
        ratkaisuihin, jotka vaikuttavat koko ohjelmiston rakenteeseen. Ohjelmistoarkkitehti on antanut sinulle
        tehtäväksi suunnitella kaiutinta sekä mikrofonia ohjaavat rajapinnat, joita voidaan käyttää eri toteutusten
        kanssa, sekä se myös katkaisee ohjelmistopinon, joka helpottaa testausta.

        Tee ohjelma, joka esittelee mikrofoni ja kaiutin oliot, sekä kutsuu rajapinnan metodeja.
        Harjoituksen tarkoituksena on oppia kirjoittamaan ja toteuttamaan Javan rajapintaluokkia.



        Mikrofoni panasonic = new Mikrofoni(0);
        System.out.println(panasonic.getVolume());
        panasonic.setMicvolume(2);
        System.out.println(panasonic.getVolume());
        panasonic.setVolume(0);
        if (panasonic.micOff())
            System.out.println("Äänettömällä");
        panasonic.micOn();
        if(panasonic.micOff())
            System.out.println("Mikrofoni on kiinni ");
        System.out.println(panasonic.getVolume());

        Kaiutin JBL = new Kaiutin(1);
        System.out.println(JBL.getVolume());
        JBL.setVolume(2);
        System.out.println(JBL.getVolume());
        JBL.setVolume(0);
        if (JBL.Unmute())
            System.out.println("Äänet päällä");
        if(JBL.mute())
            System.out.println("äänet pois päältä");
        System.out.println(JBL.getVolume());

*/











        /*Tehtävä 4
        Koodikatselmmoinnissa edellisessä tehtävässä tekemäsi sekä esittämäsi rajapinnat hyväksyttiin ja työ on
        enää toteutusta vaille valmis. Tee ohjelma, jossa on luokat:

        Tee ohjelma, jolla käyttäjä voi koota haluamansa puhelimen kaiutin konfiguraation.
        Ohjelman toiminta:
        -      Ohjelmassa on koosteluokka Puhelin, jolla on yksityiset rajapinta-attribuutit Mikrofoni ja Kaiutin
        -      Ohjelma kysyy, millaisia mikrofonia ja kaiutinta käyttäjä haluaa käyttää puhelimessaan.
               Esim. ”Käytetään 1=Broadcom-kaiutinta 2=Qualcomm-kaiutinta?”. Valinnan jälkeen ohjelma alustaa asettaa
               puhelimelle valitun kaiuttimen sekä mikrofonin.
        -      Asettamisen jälkeen ohjelma kysyy äänenvoimakkuuden säätöä. Arvon syöttämisen jälkeen ohjelma tulostaa tiedon
               voidaanko syötetyllä arvolla mikrofoni avata tai sulkea ja voidaanko kaiutin vaimentaa tai laittaa päälle.
        -      Äänenvoimakkuuden arvo 0 lopettaa ohjelman.

        Tehtävän tarkoituksena on opetella käyttämään rajapintaluokkia Java-ohjelmassa
*/
        Scanner Input = new Scanner(System.in);
        int syote1, volume=0;
        //Esitellään rajapinnan muuttujat
        ITelephoneMic mikki = null;
        ITelephoneSpeaker Kaiutin = null;
        Puhelin Munluuri = new Puhelin();

        try {

            System.out.println("Valitse käytettävä mikrofoni Samnsung (1) vai Broadcom (2)?");
            syote1 = Input.nextInt();
            if (syote1 == 1) {
         // muutetaan rajapinnan muuttuja oikeanlaiseksi
                mikki = new SamsungMikrofoni();
                System.out.print("Asennetaan mikrofonia");
                // ohjelma asentantaa
                Munluuri.waiting();
            }
            else if (syote1 == 2) {
                mikki = new BroadcomMikrofoni();
                System.out.print("Asennetaan mikrofonia");
                Munluuri.waiting();
            }
            else
                System.out.println("Virheellinen syöte!");
        }

        catch (Exception ex){
            System.out.println(ex);
        }

        try {
            System.out.println("Valitse käytettävä kaijutin Qualcomm (1) vai Broadcom (2)?");
            syote1 = Input.nextInt();
            if (syote1 == 1) {
                //Muutetaan rajapinnan muuttuja oikeanlaiseksi
                Kaiutin = new QualcommKaiutin();
                System.out.print("Asennetaan kaiutinta");
                // ohjelma miettii hetken asentaessaan.
                Munluuri.waiting();
            }
            else if (syote1 == 2) {
                Kaiutin = new BroadcomKaiutin();
                System.out.print("Asennetaan kaiutinta");
                Munluuri.waiting();
            }
            else
                System.out.println("Virheellinen syöte!");
        }
        catch (Exception ex){
            System.out.println("virheelinen syöte! Anna luku 1 tai 2");
        }
        Munluuri = new Puhelin(mikki,Kaiutin);


        while(true) {
        try {
            System.out.println("Aseta äänenvoimakkuus?");
            volume = Input.nextInt();
            mikki.setVolume(volume);
            Kaiutin.setVolume(volume);
            if (mikki.micOn()){
                System.out.println("Mikrofoni on päällä!");
            }
            else
                System.out.println("Mikrofoni on kiinni");

            if (mikki.micOff()) {
                System.out.println("Mikrofoni voidaan sulkea");
            }
            if (Kaiutin.Unmute()){
                System.out.println("Kaiutin on päällä!");
            }
            else
                System.out.println("Kaijutin on kiinni");

            if (Kaiutin.mute()){
                System.out.println("Kaijutin voidaan sulkea!");
            }

            if (volume == 0)
                break;

        }
        catch (Exception ex){
            System.out.println(ex);
        }

        }

    }
}
