package com.company;

import com.company.Tehtava3.Asunto;
import com.company.Tehtava3.AsuntoUtils;
import com.company.Tehtava3.Henkilo;
import com.company.Tehtava4.Juhlatakki;
import com.company.Tehtava4.Takki;
import com.company.Tehtava4.Ulkoilutakki;
import com.company.Tehtava5.HaminalahdenMetsastysseura;
import com.company.Tehtava5.Jasen;
import com.company.Tehtava5.TurmiolanEra;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	/*
	* Taloyhtiön As oy Mustikkarinne puheenjohtajalla on ollut kovin kankea sovellus, jossa järjestelmään on syötetty
	* asunnoissa asuvat henkilöt. Se on näyttänyt jotakuinkin seuraavalta

        Anna asunnon numero (0 = Lopettaa syötön): A1
        Anna asujan etunimi: Ami
        Anna asujan sukunimi: Asujainen
        Anna asujan ikä kuluvana vuonna: 23
        Anna asunnon numero (0 = Lopettaa syötön): A1
        Anna asujan etunimi: Anu
        Anna asujan sukunimi: Asujainen
        Annaa asujan ikä kuluvana vuonna: 31
        Anna asunnon numero (0 = Lopettaa syötön): B12
        Anna asujan etunimi: Aimo
        Anna asujan sukunimi: Korhonen
        Anna asujan ikä kuluvana vuonna: 55
        Anna asunnon numero (0 = Lopettaa syötön): 0



        Asujat:
        Ami Asuja, Asunto: A1, Ikä: 23
        Anu Asuja, Asunto: A1, Ikä: 31
        Aimo Korhonen, Asunto: B12, Ikä: 55



        1. vaihe :Tee Java-ohjelma, jossa on sama toiminnallisuus. Käytä luokkia ja sopivia tietorakenteita
        * ja koodaa pääohjelma. Huolehdi luokan (luokkien) perusmetodien koodauksesta. Syötteiden järkevyys-
        * ja tyyppitarkistuksia ei tarvitse toteuttaa. (luokka/luokat 3p, pääohjelma 2 p)


        //Ohjelman sisäisiä muuttujia
        // Testi dataa
        ArrayList<Asunto> asukkaat = new ArrayList<>();
        Henkilo h1 = new Henkilo("Ami","Asujainen",23);
        Henkilo h2 = new Henkilo("Anu","Asujainen",31);
        Henkilo h3 = new Henkilo("Aimo","Korhonen",55);
        Asunto a1 = new Asunto(h1,"A1");
        Asunto a2 = new Asunto(h2,"A2");
        Asunto a3 = new Asunto(h3,"B12");
        asukkaat.add(a1);
        asukkaat.add(a2);
        asukkaat.add(a3);
        Scanner input = new Scanner(System.in);
        String syote, asunnonNumero = "";
        Henkilo asuja;
        Asunto asunto;

        // Loopataan asiakkaan lisäämistä
        while (true){
            System.out.print("Syötetäänkö uusi asukas? (k/e)");
            syote = input.nextLine();
            if (syote.equals("k")){
                //Luodaan uudet asukas ja asunto oliot
                asuja = new Henkilo();
                asunto = new Asunto();
                //Täytetään asunto tiedot
                asunto.kysyAsunnonTiedot(asuja);
                ///////////////////////////////
                     //Testausta varten//
                System.out.println(asuja);
                System.out.println(asunto);
                ///////////////////////////////
                //Lisätään asunto listaan
                asukkaat.add(asunto);

            }
            // poistutaan loopistä syöttämällä e
            else if (syote.equals("e")){
                break;
            }
            else
                // ei hyvväksytä muita syötteitä
                System.out.println("Virheellinen syöte!");
        }
        // Tulostetaan asukkaat
        for (Asunto a: asukkaat ) {
            System.out.println(a);
        }
        //ASuntoutils luokan testaus
        System.out.print("Etsi asiakas syöttämällä asunnon numero:");
        asunnonNumero = input.nextLine();
        AsuntoUtils.palautaAsujat(asunnonNumero,asukkaat);

        // keskiIan testaus
        System.out.print("Asukkaiden keski ikä on: ");
        System.out.println(AsuntoUtils.KeskiIka(asukkaat));*/

/*
        Oheinen varsin suppean koodi sisältävä määrittelee luokan Takki olion.
        Tee luokalle aliluokat Ulkoilutakki ja Juhlatakki.

            public class Takki {
            String vari;
            String koko;

            public Takki() {
            }
        }
         Tee pääohjelma, joka käsittelee luokan Takki ja sen aliluokkien olioita taulukossa (tai ArrayList-rakenteessa).
         Lisää taulukkoon vähintään 2 oliota luokista Ulkoilutakki ja Juhlatakki.
         Ei siis tarvitse koodata käyttöliittymää vaan riittää, että "kovakoodaat" takit listaan.
         Ohjelma tulostaa taulukon olioiden tiedot luettavassa muodossa näkyville.

        (Arvostelu: Aliluokat (3 p), pääohjelma  (2 p) (yht 5 p)




        //Luodaan Arraylist objekteille ja lisätään siihen objekteja
        ArrayList<Object> Takit = new ArrayList<>();
        Takki T1 = new Ulkoilutakki("Sininen","M",10000,4950);
        Takki T2 = new Juhlatakki("Punainen","L","Silkki","Pitsi");
        Ulkoilutakki T3 = new Ulkoilutakki("Keltainen","S",3000,1);
        Juhlatakki T4 = new Juhlatakki("Musta","XL","Villa","Kuvioton");
        Ulkoilutakki T5 = new Ulkoilutakki("Oranssi","XXXXL",99,5001);
        Juhlatakki T6 = new Juhlatakki("Violetti","M","Vakosametti","Ruutu");
        Ulkoilutakki T7 = new Ulkoilutakki("Purppura","L",3001,-1);
        Juhlatakki T8 = new Juhlatakki("Ruskea","S","Puuvilla","Liituraita");
        Takit.add(T1);
        Takit.add(T2);
        Takit.add(T3);
        Takit.add(T4);
        Takit.add(T5);
        Takit.add(T6);
        Takit.add(T7);
        Takit.add(T8);
        // käydään objektit instance of:lla ja muutetaan jokainen oikeanlaiseksi tulostusta varten
        for (Object O :Takit) {
            if (O instanceof Ulkoilutakki) {
                Ulkoilutakki UT = (Ulkoilutakki) O;
                System.out.println(UT);
            }
                if (O instanceof Juhlatakki) {
                    Juhlatakki JT = (Juhlatakki) O;
                    System.out.println(JT);
                }

        }*/
  /*
        Pohjois-Savon Riistanhoitoyhdistys on päättänyt parantaa yleistä tiedotustaan alueen metsästysseurojen
        jäsenille. Niinpä se tarvitsee tiedot kaikista eri metsästysseurojen jäsenistä. Ohjelmistoon tarvitaan
        siis laajennus, jotta se voi hakea jäsentiedot eri seurojen käyttämistä järjestelmistäOhjelmistossa
        on laajennus, joilla pelaajien tietoja voidaan noutaa eri urheiluseurojen järjestelmistä. Tietojen
        nouto toteutetaan käyttäen rajapintaa, jossa on yksi metodi:

                          public ArrayList<Jasen> getJasenTiedot();

        Rajapintaa testataan seuraaville seuroilla eli TurmiolanErä ja HaminalahdenMetsästysseura.
        Niille tehdään siis erilliset luokat.  Molempien seurojen luokat, jotka toteuttavat eo rajapintaa,
        palauttavat testimielessä esim kolme jäsenen tiedot. Kovakoodaat jäsenet ko metodiin.

        Jasen-luokkaa (liitteenä) tulee lisäksi  laajentaa niin, että se perii abstraktin luokan JäsenBase,
        jonka toteutat laajennuksen yhteydessä. JasenBase-luokassa on  jäsenseura (String) ja vakuutusnro (int)
        sekä abstrakti metodi tulostaJäsenTiedot. Toteuta abstrakti metodi oikeassa paikassa, niin, että se
        tulostaa jäsenen tiedot oikein.

        Tee ohjelma, joka hakee jäsenet molemmista seuroista sekä tulostaa jäsenten kaikki tiedot ruudulle.
        Pitäisi tulostua siis kuuden eri jäsenen tiedot. Jäsenten tiedot voit itse keksiä rajapinnat toteuttavien
        luokkien toteutukseen.

        Jasen.java:
        public class Jasen{
                             private String etunimi;
                             private String sukunimi;
                             private String email;
         }


        Arviointi: Rajapinta 1 p, Toteuttavat (seurojen) luokat 2 p,
        Jasen-luokan muunnokset 1p, JasenBase- luokka 1 p, Pääohjelma 2 p, Yht  7p,

       //////////////////////////////////////
       //Harvinaisen sekava tehtäväksianto!//
       //////////////////////////////////////
         */


        // Luodaan lista johon haetaan Metsästysseurojen tiedot
        ArrayList<Jasen> Tietokanta = new ArrayList<>();
        // luodaan metsästys seuraoliot
        TurmiolanEra T1 = new TurmiolanEra();
        HaminalahdenMetsastysseura H1 = new HaminalahdenMetsastysseura();
        //Käytetään rajapinnan metodia ja lisätään palautuvat tiedot tietokantaan
        Tietokanta.addAll(T1.getJasenTiedot());
        Tietokanta.addAll(H1.getJasenTiedot());
        // Tulostetaan seuroilta saadut tiedot
        System.out.println("HaminalahdenMetsästysseura:");
        for (Jasen K : Tietokanta) {
            if (K.getJasenseura().equals("HaminalahdenMetsastysseura"))
                K.tulostaJasenTiedot();
        }
        System.out.println("TurmiolanErä:");
        for (Jasen J : Tietokanta) {
            if (J.getJasenseura().equals("TurmiolanEra"))
                J.tulostaJasenTiedot();
        }
    }
            }