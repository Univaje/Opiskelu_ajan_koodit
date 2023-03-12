// TRAI_21_t17.java SJ

import java.util.*;

public class TRAI_21_t17_Sampokaj {

    // kannattaa testata monipuolisesti erilaisilla syötteillä ja vaikka
    // tehdä eri versioita syötteen generoinnista

    public static void main(String[] args) {

        // listojen koko
        int N1 = 10;
        if (args.length > 0)
            N1 = Integer.parseInt(args[0]);

        int N2 = N1 + 2;
        if (args.length > 0)
            N2 = Integer.parseInt(args[1]);

        // satunnaislukusiemen
        int siemen = N1 + N2;
        if (args.length > 2)
            siemen = Integer.parseInt(args[2]);

        // saako olla samoja alkioita
        int eri = 0;
        if (args.length > 3)
            eri = 1;

        Random r = new Random(siemen);

        LinkedList<Integer> L1 = new LinkedList<>();
        LinkedList<Integer> L2 = new LinkedList<>();

        for (int i = 0; i < N1; i++) {
            L1.add(r.nextInt(N1 / 2));
        }
        for (int i = 0; i < N1; i++) {
            L2.add(r.nextInt((N2 / 2) + eri * N1));
        }

        // tulostetaan listat jos alkioita ei ole paljoa
        if (N1 <= 20 && N2 <= 20) {
            System.out.println("L1: " + L1);
            System.out.println("L2: " + L2);
        }


        System.out.println();

        // kutsutaan tehtävää 17
        List<Integer> xorTulos = listaXor(L1, L2);

        if (N1 <= 20 && N2 <= 20) {
            System.out.println("\nTehtävä 17, vain toisessa = " + xorTulos);
        } else {
            System.out.println(xorTulos.size() + " alkiota");
        }


    } // main()


    /**
     * 17. Kirjoita algoritmi joka saa parametrinaan kaksi järjestämätöntä listaa ja joka muodostaa
     * ja palauttaa uuden listan joka sisältää kaikki ne alkiot jotka ovat vain jommastakummassa listassa
     * siis niiden joko-tai -yhdisteen (xor)). Jos jokin alkio esiintyy jommassakummassa listassa useasti,
     * mutta ei toisessa listassa, niin se tulee tuloslistaan vain kerran. Käytä jouk- ko(j)a (Set) apuna
     * ja pyri lineaariseen aikavaativuuteen. Vihje: mieti ensin tarkasti miten käytät joukko(j)a hyödyksi
     * ja ryhdy tarkentamaan algoritmiasi vasta sitten.
     *
     * @param L1  syötelista
     * @param L2  syötelista
     * @param <E> parametrityyppi
     * @return alkiot jotka ovat vain toisessa listassa
     */
    public static <E> List<E> listaXor(List<E> L1, List<E> L2) {

        // tehdään samantyyppinen tuloslista kuin mitä on lista L1
        List<E> tulos = null;
        try {
            tulos = L1.getClass().getConstructor().newInstance();
        } catch (Exception e) {
            System.out.println("Pieleen meni vaikka ei pitänyt...");
            return null;
        }
        Set<E> Leikkaus = new HashSet<>(L1);
        Set<E> lisattavat = new HashSet<>(L2);
        Leikkaus.addAll(lisattavat);
        tulos.addAll(Leikkaus);
        // TODO

        return tulos;

    }

} // class
