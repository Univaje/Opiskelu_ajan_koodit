package com.company;

import com.company.Tehtava1ja2.Henkilo;
import com.company.Tehtava1ja2.Henkilokunta;
import com.company.Tehtava1ja2.Opiskelija;
import com.company.Tehtava3ja4.Tietokone;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	/*
	* Tehtävä 1
	* Erinomainen työsi on huomattu ja olet saanut ylennyksen opiskelijajärjestön henkilöstön
	* ylläpitäjästä koko koulun henkilöstön ylläpitäjäksi. Henkilöstön tiedot ovat vielä paperilla mapeissa,
	* mutta päätät suunnitella yksinkertaisen sähköisen henkilörekisterin.
	* Aloitat suunnittelun miettimällä luokkarakenteita.

    Toteuta luokkarakenne ja varmista, että Opiskelija- ja Henkilokunta-luokista on näkyvyys Henkilo-luokan tietoihin.
    * Pääohjelmassa riittää, että testaat, että luokat toimivat oikein. Mitään erityistä käyttöliittymää
    * ei tarvitse tehdä. Se tehdään seuraavassa tehtävässä.
*/
        Henkilo h1 = new Henkilo("Aku","Ankka","1234455-2314");
	    Opiskelija o1 = new Opiskelija("Iines" ,"Ankka","12443355-4567",123,"12-12-2020");
        Henkilokunta henk1 = new Henkilokunta("Roope","Ankka","1531253-1256",
                "458","ankkalinnan kuoulu","Lehtori");

        System.out.println("Henkilon tiedot:");
        System.out.println(h1);
        System.out.println("Opiskelijan tiedot:");
        System.out.println(o1.tulostaOpiskelija());
        System.out.println("Henkilokunnan tiedot:");
        System.out.println(henk1.tulostaHenkilokunta());
/*
    Tehtävä 2

    Suunnitelmasi uudesta henkilörekisteristä hyväksyttiin oppilaitoksen
    * johtokunnassa ja pääset tekemään oikeaa toteutusta.
    Tee ohjelma, joka käyttää ensimmäisessä tehtävässä toteutettua luokkarakennetta:
               - Ohjelma kysyy syötetäänkö uuden henkilön tiedot (k/e)
               - Ohjelma kysyy onko henkilö opiskelija vaiko henkilökuntaa
               - Ohjelma kysyy valitun tyyppisen luokan tiedot (opiskelija tai
               henkilökunta) sekä tallentaa tiedot yhteen listaan. Huom! Opiskelijat ja
               henkilökunta ovat siis yhdessä samassa listassa.
               - Kun uusia henkilöitä ei haluta enää syöttää listaan, tulostetaan
               listalta ensin opiskelijat ja sen jälkeen henkilökuntaan kuuluvat
               henkilöt. Käytä luokan tunnistamisessa instanceof -operaattoria.

                Vinkki:
                    for (Object o: henkilot) {
                        // tunnistetaan opiskelija
                        if (o instanceof Opiskelija) {
                            final Opiskelija op = (Opiskelija) o;
                            System.out.println(op.getNimi());
                              // TODO: loppujen tietojen tulostus
                             }
                             }
                             // TODO: seuraavaksi pitäisi tunnistaa henkilökunta ja tulostaa tiedot.
*/

    Henkilo h3 = new Henkilo();
    ArrayList<Object> osakkaat = new ArrayList<>();
    // Tietojen kysely tapahtuu henkilö classissa
    h3.AlkuKysely(osakkaat);
        for (Object o: osakkaat) {
            // tunnistetaan opiskelija
            if (o instanceof Opiskelija) {
                final Opiskelija op = (Opiskelija) o;
                System.out.println(op.tulostaOpiskelija());

            }
            // tunnistetaan Henkilokunta
            if (o instanceof Henkilokunta) {
                final Henkilokunta op = (Henkilokunta) o;
                System.out.println(op.tulostaHenkilokunta());
            }


        }






/*
    Tehtävä 3



        Olet palannut töihin IT-tuen keskusvarastolle ja uudet tuulet puhaltavat yrityksen sisäisessä järjestelyssä.


        Tee ohjelma, joka luo kaksi Tietokone-luokan oliota ja
        * täyttää kaikki tiedot alustajia käyttäen (tietoja ei tarvitse kysyä käyttäjältä,
        * voit keksiä ne itse). Ohjelma tulostaa lopuksi näiden kahden olion tiedot.
*/

            Tietokone t1 = new Tietokone();
            System.out.println(t1);
            Tietokone t2 = new Tietokone("Dell", "Paska");
            System.out.println(t2);
            t1 = new Tietokone("HP", "Romu", "666", 33, 12);
            System.out.println(t1);
            t2 = new Tietokone("669", "Lenovo", "Melkee toimii");
            System.out.println(t2);
/*
    Tehtävä 4

    Käytä edellisen tehtävän luokkarakennetta ja tee ohjelma, jolla on lista Tietokone-luokan olioita tiedoilla:
            - Merkki: Asus, Malli: ER443, Tuotenumero: 212232, Tuotepaikka: 12, Maara: 3
            - Merkki: Lenovo, Malli: HH544, Tuotenumero: 3233, Tuotepaikka: 15, Maara: 21
            - Merkki: Fujitsu, Malli: 3323F, Tuotenumero: 9888, Tuotepaikka: 2, Maara: 5
            - Merkki: IBM, Malli: IBM3444, Tuotenumero: 343, Tuotepaikka: 150, Maara: 2

    Sait tiedon johtoportaalta, että tietokoneiden tuotepaikat ovat muuttuneet, eikä vanhoja voida enää käyttää.
    Tietokoneiden tuotepaikat ovat kuitenkin muutettu loogisesti niin, että:
            - Alle kymmenen tuotepaikoilla olleiden tietokoneiden tuotepaikkojen numeroon lisätään 10
            (Esim. vanha paikka 5, niin uusi paikka on 15).
            - 10-100 tuotepaikoilla olleiden tietokoneiden tuotepaikkojen numeroon lisätään 30
            - Yli sata tuotepaikoilla olleiden tietokoneiden tuotepaikkoihin lisätään 500

    Korvaa (override) Tuote-luokan getTuotepaikka-metodi Tietokone-luokassa.
    Vinkki: hae alkuperäinen tuotenumero käyttämällä super-käskyä Tietokoneluokassa: super.getTuotepaikka();
    Tee ohjelma, joka tulostaa tuotteiden tiedot uusilla tuotepaikoilla.*/
            ArrayList<Tietokone> koneet = new ArrayList<>();
            Tietokone ti1 = new Tietokone("Asus", "ER443", "212232", 12, 3);
            Tietokone ti2 = new Tietokone("Lenovo", " HH544", "3233", 15, 21);
            Tietokone ti3 = new Tietokone("Fujitsu", "3323F", "9888", 2, 5);
            Tietokone ti4 = new Tietokone("IBM", "IBM3444", "343", 150, 2);
            
            koneet.add(ti1);
            koneet.add(ti2);
            koneet.add(ti3);
            koneet.add(ti4);

            for (Tietokone t : koneet) {
                System.out.println(t);
            }



        Ostos O3 = new Ostos();
        ArrayList<Object> Ostoslista = new ArrayList<>();


        for (Object o: Ostoslista) {
            if (o instanceof Ruoka) {
                final Ruoka ost1 = (Ruoka) o;
                System.out.println(op.tulostaOpiskelija());

            }

            if (o instanceof Vaate) {
                final Henkilokunta op = (Henkilokunta) o;
                System.out.println(op.tulostaHenkilokunta());
    }
            if (o instanceof Kodinkone) {
                final Henkilokunta op = (Henkilokunta) o;
                System.out.println(op.tulostaHenkilokunta());
            }
}
