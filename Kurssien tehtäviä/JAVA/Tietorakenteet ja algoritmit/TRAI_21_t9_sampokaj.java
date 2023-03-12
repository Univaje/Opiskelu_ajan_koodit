// TRAI_21_t8_9.java SJ
// Pääohjelma viikon 2 tehtäviin 8 ja 9

import java.util.*;

/**
 * 8. Kirjoita algoritmi joka saa parametrinaan kaksi järjestämätöntä listaa A ja B (ArrayList)
 * ja joka poistaa listasta A kaikki ne alkiot jotka esiintyvät listassa B. Ã„lä käytä valmista
 * removeAll() -operaatioita. Aikavaativuus? Miten aikavaativuutta voisi parantaa?
 * <p>
 * 9. Kirjoita algoritmi joka saa parametrinaan kaksi järjestämätöntä listaa A ja B (LinkedList)
 * ja joka poistaa listasta A kaikki ne alkiot jotka esiintyvät listassa B. Algoritmi palauttaa
 * poistettujen alkioiden määrän. Nyt ei siis luoda uutta listaa, vaan muokataan parametrina
 * saatua. Ã„lä käytä valmista remove(Object) tai removeAll() -operaatiota. Aikavaativuus?
 * Miten aikavaativuutta voisi parantaa?

 * Aikavaativuus tehtävässä on neliöllinen (O=(n^2). Nykyisillä työkaluillani en usko että tätä voisin parantaa.
 * Todennäköisesti tätäkin voidaan parantaa samoilla menetelmillä kuin edellinen tehtävä mutta tämä on minulle vielä 
 * epäselvää. Algoritmin tuottaminen oli helppoa.
 **/

public class TRAI_21_t9 {


    // Pääohjelman käyttö:
    // java TRAI_21_t8_9 [N] [N2] [S]
    // missä N on alkioiden määrä, N2 on alkoiden määrä toisessa taulukossa
    // ja S on satunnaislukusiemen
    public static void main(String[] args) {

        // alkioiden määrä
        int n1 = 10;
        if (args.length > 0)
            n1 = Integer.parseInt(args[0]);

        int n2 = n1 + 2;
        if (args.length > 1)
            n2 = Integer.parseInt(args[1]);

        int pituus = 1; // merkkijonojen pituus
        if (n1 > 30)
            pituus = 2;

        // satunnaislukusiemen
        int siemen = 42;
        if (args.length > 2)
            siemen = Integer.parseInt(args[2]);


        // testataan vaihteeksi merkkijonoilla

        ArrayList<String> AL1 = new ArrayList<>(n1);
        ArrayList<String> AL2 = new ArrayList<>(n2);

        // täytetään alkioilla
        Random r = new Random(siemen);
        for (int i = 0; i < n1; i++) {
            AL1.add(randomString(r, pituus));
        }

        for (int i = 0; i < n2; i++) {
            AL2.add(randomString(r, pituus));
        }

        // tulostetaan taulukot jos alkioita ei ole paljoa
        if (n1 <= 20 && n2 <= 20) {
            System.out.println("AL1: " + AL1);
            System.out.println("AL2: " + AL2);
        }

        // otetaan listoista kopiot tehtävään 9
        LinkedList<String> LL1 = new LinkedList<>(AL1);
        LinkedList<String> LL2 = new LinkedList<>(AL2);


        // testataan tehtävää 9

        poistaKaikki9(LL1, LL2);

        System.out.print("Tehtävä 9, LL1-LL2: ");
        if (n1 <= 20 && n2 <= 20) {
            System.out.println(LL1);
        } else {
            System.out.println(LL1.size() + " alkiota");
        }


    } // main()


    /**
     * Palauttaa satunnaisen len mittaisen merkkijonon.
     *
     * @param r   satunnaislukugeneraattori
     * @param len merkkijonon pituus
     * @return uusi merkkijono
     */
    public static String randomString(Random r, int len) {
        char[] C = new char[len];
        for (int i = 0; i < len; i++)
            C[i] = (char) (r.nextInt(26) + 'a');
        return new String(C);
    }



    /**
     * Poista kaikki B alkioiden esiintymät listasta A.
     *
     * @param A lista josta poistetaan
     * @param B alkiot jotka poistetaan
     * @return
     */
    /* triviaali neliöllinen versio */
    public static <E> int poistaKaikki9(LinkedList<E> A, LinkedList<E> B) {
        int poistettu = 0;

        for (int i = 0; i < B.size(); i++) {
            ListIterator<E> Ia = A.listIterator();
            while (Ia.hasNext()) {
                E tarkasteltava = Ia.next();

                E poisto = B.get(i);
                if (tarkasteltava.equals(poisto))
                    Ia.remove();
            }
        }
        return poistettu;
    }
}


