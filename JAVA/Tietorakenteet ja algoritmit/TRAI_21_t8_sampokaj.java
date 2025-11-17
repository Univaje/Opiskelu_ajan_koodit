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
 **/
 /*Aikavaativuus ohjelmassa on neliöllinen (n^2). Nykyisillä työkaluilla ei ohjelmaa voida luoda
 * lineaariseksi mutta parannus voisi onnistua mapilla tai hash setillä tietääkseni.
 * Ohjelman luominen oli vaikea. Ymmärrys toiminnasta oli suhteellisen selkeä rakentaa mutta poiston
 * tekeminen ilman ylimääräistä looppia oli vaikeaa.*/
public class TRAI_21_t8 {


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


        // testataan tehtävää 8

        poistaKaikki8(AL1, AL2);

        System.out.print("Tehtävä 8, AL1-AL2: ");
        if (n1 <= 20 && n2 <= 20) {
            System.out.println(AL1);
        } else {
            System.out.println(AL1.size() + " alkiota");
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
     * @return poistettujen alkioiden määrä
     */
    public static <E> int poistaKaikki8(ArrayList<E> A, ArrayList<E> B) {
        int poistettu = 0;
        E a = null, b = null;
        int nonunigue = 0;
        for (int i = 0; i < B.size(); i++) {
            int unique = 0;
            for (int j = 0; j < A.size(); j++) {
                a = A.get(j);
                b = B.get(i);
                if (!a.equals(b) && unique <= B.size()) {
                    A.set(unique, A.get(j));
                    unique++;
                } else {
                    nonunigue++;
                }
            }
            if (nonunigue > 0) {
                A.remove(A.size() - 1);
                nonunigue--;
                if (i > nonunigue + 1) {
                    i -= nonunigue + 1;
                }
            }
        }
        return poistettu;

    }

}


