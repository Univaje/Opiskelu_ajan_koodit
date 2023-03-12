// TRAI_21_t8_9.java SJ
// Pääohjelma viikon 2 tehtäviin 8 ja 9

import java.lang.reflect.Array;
import java.util.*;


public class TRAI_21_t25_sampokaj {


    // Pääohjelman käyttö:
    // java TRAI_21_t25 [N] [N2] [S]
    // missä N on alkioiden määrä, N2 on alkoiden määrä toisessa taulukossa
    // ja S on satunnaislukusiemen
    public static void main(String[] args) {

        // alkioiden määrä
        int n1 = 15;
        if (args.length > 0)
            n1 = Integer.parseInt(args[0]);

        int pituus = 1; // merkkijonojen pituus
        if (n1 > 30)
            pituus = 2;

        // montaako eri merkkiä käytetään merkkijonoissa
        int merkisto = 4;

        // satunnaislukusiemen
        int siemen = 42;
        if (args.length > 2)
            siemen = Integer.parseInt(args[2]);


        // testataan vaihteeksi merkkijonoilla

        ArrayList<String> AL = new ArrayList<>(n1);

        // täytetään alkioilla
        Random r = new Random(siemen);
        for (int i = 0; i < n1; i++) {
            AL.add(randomString(r, pituus, merkisto));
        }

        // tulostetaan taulukot jos alkioita ei ole paljoa
        if (n1 <= 20) {
            System.out.println("AL: " + AL);
        }

        // otetaan listasta kopiot LinkedList:iä varten
        LinkedList<String> LL = new LinkedList<>(AL);


        // testataan tehtävää 25
        // vaihda LL tilalle AL jos testaat ArrayList-versiota

        poistaYliKesiintymat(LL, 3);

        System.out.print("Tehtävä 25, LL max 3 alkiota: ");
        if (n1 <= 20) {
            System.out.println(LL);
        } else {
            System.out.println(LL.size() + " alkiota");
        }

        poistaYliKesiintymat(LL, 1);

        System.out.print("Tehtävä 25, LL max 1 alkiota: ");
        if (n1 <= 20) {
            System.out.println(LL);
        } else {
            System.out.println(LL.size() + " alkiota");
        }

        poistaYliKesiintymat(LL, 0);

        System.out.print("Tehtävä 25, LL max 0 alkiota: ");
        if (n1 <= 20) {
            System.out.println(LL);
        } else {
            System.out.println(LL.size() + " alkiota");
        }




    } // main()


    // riittää tehdä näistä toinen, mutta toki molempien tekeminen on
    // hyödyllistä harjoitusta kerrata ArrayList:n ja LinkedList:n eroja

    /**
     * Poistaa listasta LL kunkin alkion ylimääräiset (yli k kpl) esiintymät.
     * @param LL muokattava lista
     * @param k montako kpl kutakin alkiota jätettään
     * @param <E> alkiotyyppi
     */
    public static <E> void poistaYliKesiintymat(LinkedList<E> LL, int k) {

        HashMap<E, Integer> esiintymat = new HashMap<>();
        ListIterator<E> Lista = LL.listIterator();
        while (Lista.hasNext()) {
            E raataja = Lista.next();
            if (k == 0)
                Lista.remove();
            if (esiintymat.containsKey(raataja)) {
                Integer arvo = esiintymat.get(raataja);
                arvo++;
                esiintymat.put(raataja, arvo);
                if (arvo > k)
                    Lista.remove();

            } else
                esiintymat.put(raataja, 1);

        }
    }

    /**
     * Poistaa listasta AL kunkin alkion ylimääräiset (yli k kpl) esiintymät.
     * @param AL muokattava lista
     * @param k montako kpl kutakin alkiota jätettään
     * @param <E> alkiotyyppi
     */
    public static <E> void poistaYliKesiintymat(ArrayList<E> AL, int k) {
    }

    /**
     * Palauttaa satunnaisen len mittaisen merkkijonon.
     *
     * @param r   satunnaislukugeneraattori
     * @param pituus merkkijonon pituus
     * @param merkisto
     * @return uusi merkkijono
     */
    public static String randomString(Random r, int pituus, int merkisto) {
        char[] C = new char[pituus];
        for (int i = 0; i < pituus; i++)
            C[i] = (char) (r.nextInt(merkisto) + 'a');
        return new String(C);
    }


} // class
