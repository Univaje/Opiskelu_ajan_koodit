// TRAI_21_t19_20_21.java SJ

import java.util.*;

public class TRAI_21_t21 {

    public static void main(String[] args) {

        int N = 6;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);

        Set<Set<Integer>> SS = new HashSet<>();

        Random r = new Random(N + 1);
        System.out.println("Syötejoukot:");
        for (int i = 0; i < N; i++) {
            Set<Integer> S = new HashSet<>();
            for (int j = 0; j < N; j++) {
                S.add(r.nextInt(N * 2));
            }
            SS.add(S);
            System.out.println("S" + i + ": " + S);
        }

        Set<Integer> tulos = yhdiste(SS);
        System.out.println("\nKaikkien yhdiste: " + tulos);
        System.out.println();

        tulos = vainYhdessa(SS);
        System.out.println("Vain yhdessä: " + tulos);
        System.out.println();


        LinkedList<Set<Integer>> LS = new LinkedList<>(SS);
        System.out.println("Joukkojen lista:");
        tulostaRiveittain(LS);

        lajitteleAlkiomaaranMukaan((LS));

        System.out.println("Lista lajiteltuna joukkojen alkiomäärän mukaan:");
        tulostaRiveittain(LS);

    } // main()

    /**
     * Tulosta kokoelma riveittäin.
     *
     * @param CC  syötekokoelma
     * @param <E> alkiotyyppi
     */
    static <E> void tulostaRiveittain(Collection<E> CC) {
        System.out.println("(");
        for (E x : CC) {
            System.out.println(x.toString());
        }
        System.out.println(")");
    }

    /**
     * 19. Kirjoita algoritmi joka saa parametrinaan joukkojen joukon (Set<Set<E>>) ja joka pa- lauttaa joukkona
     * (Set<E>) kaikki ne alkiot jossakin (tai joissakin) syötejoukoissa. Siis yhdisteen. Vihje: iteraattori ja
     * joukko-operaatiot. Mikä on algoritmisi aikavaativuus?
     *
     * @param SS  joukkojen joukko
     * @param <E> joukkojen alkioiden tyyppi
     * @return kaikki jossain joukossa esiintyneet alkiot
     *
     * 19. Kirjoita algoritmi joka saa parametrinaan joukkojen joukon (Set<Set<E>>) ja joka palauttaa joukkona
     * (Set<E>) kaikki ne alkiot jotka ovat jossakin (tai joissakin) syötejoukoissa.
     * Siis yhdisteen. Vihje: iteraattori ja joukko-operaatiot. Mikä on algoritmisi aikavaativuus?
     *
     *              O(n*m) == O(n)
     */
    public static <E> Set<E> yhdiste(Set<Set<E>> SS) {
        Set<E> tulos = new HashSet<>();                 //O(1)
        Iterator<Set<E>> Raataja = SS.iterator();       //O(1)
        while (Raataja.hasNext()){                      //O(n)
            Set<E> tutkittava = Raataja.next();         //O(1)
            tulos.addAll(tutkittava);                   //O(m)
        }
        return tulos;
    }

    /**
     * 20. Kirjoita algoritmi joka saa parametrinaan joukkojen joukon (Set<Set<E>>) ja joka pa- lauttaa joukkona
     * (Set<E>) kaikki ne alkiot jotka ovat tasan yhdessä syötejoukoista. Ne alkiot jotka ovat useammassa kuin yhdessä
     * syötejoukoista eivät tule tulokseen. Ã„lä muuta syötejoukkoja. Vihje: iteraattori ja joukko-operaatiot. Mikä on
     * algoritmisi aikavaativuus?
     *
     * @param SS  joukkojen joukko
     * @param <E> joukkojen alkioiden tyyppi
     * @return kaikki ne alkiot jotka esiintyvät vain yhdessä joukossa
     *
     *20. Kirjoita algoritmi joka saa parametrinaan joukkojen joukon (Set<Set<E>>) ja joka palauttaa joukkona
     * (Set<E>) kaikki ne alkiot jotka ovat tasan yhdessä syötejoukoista. Ne
     * alkiot jotka ovat useammassa kuin yhdessä syötejoukoista eivät tule tulokseen. Älä muuta
     * syötejoukkoja. Vihje: iteraattori ja joukko-operaatiot. Mikä on algoritmisi aikavaativuus?
     *
     *              O(n^2*m^2) == O(n^2)
     */
    public static <E> Set<E> vainYhdessa(Set<Set<E>> SS) {
        Set<E> tulos = new HashSet<>();                 //O(1)
        Set<E> verrokki;                                //O(1)
        Iterator<Set<E>> Raataja = SS.iterator();       //O(1)
        while (Raataja.hasNext()){ // 11,5,2            //O(n)
            Set<E> tutkittava = Raataja.next();         //O(1)
            verrokki =new HashSet<>(tutkittava);        //O(1)
            for (Set<E> vali : SS) {                    //O(m)
                Set<E> verrokki2 = new HashSet<>(vali); //O(1)
                if (!tutkittava.equals(verrokki2))      //O(1)
                    verrokki.removeAll(verrokki2);          //O(m)
            }
            tulos.addAll(verrokki);                     //O(n)


        }

        // TODO

        return tulos;
    } // vainYhdessa()


    /**
     * 21. Kirjoita algoritmi joka saa parametrinaan joukkojen listan (List<Set<E>>) ja lajittelee listan joukkojen
     * alkiomäärän mukaiseen järjestykseen. Vihje: Collections.sort() ja Compa- rator<Set>. Mikä on algoritmisi
     * aikavaativuus?
     *
     * @param LS  lista
     * @param <E> joukkojen alkiotyyppi (ei käytetä)
     *
     * 21. Kirjoita algoritmi joka saa parametrinaan joukkojen listan (List<Set<E>>) ja lajittelee
     * listan joukkojen alkiomäärän mukaiseen järjestykseen. Vihje: Collections.sort() ja Comparator<Set>.
     * Mikä on algoritmisi aikavaativuus?
     *           O(n)
     */
    public static <E> void lajitteleAlkiomaaranMukaan(List<Set<E>> LS) {
        Collections.sort(LS, new kokoVertailija<>());       //O(n)
    }

    static class kokoVertailija<T extends Set> implements Comparator<T> {
        /**
         * Compares its two arguments for order.  Returns a negative integer, zero, or a positive integer as the first
         * argument is less than, equal to, or greater than the second.
         *
         * @param o1 the first object to be compared.
         * @param o2 the second object to be compared.
         * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or
         * greater than the second.
         * @throws NullPointerException if an argument is null and this comparator does not permit null arguments
         * @throws ClassCastException   if the arguments' types prevent them from being compared by this comparator.
         */
        @Override
        public int compare(T o1, T o2) {
            int eka = o1.size();    //O(1)
            int toka = o2.size();   //O(1)
            return eka-toka;        //O(1)
        }

    }

} // class