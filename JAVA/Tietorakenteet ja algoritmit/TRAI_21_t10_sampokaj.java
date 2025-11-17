import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class TRAI_21_t10 {

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

        LinkedList<String> LL1 = new LinkedList<>();
        LinkedList<String> LL2 = new LinkedList<>();

        // täytetään alkioilla
        Random r = new Random(siemen);
        for (int i = 0; i < n1; i++) {
            LL1.add(randomString(r, pituus));
        }

        for (int i = 0; i < n2; i++) {
            LL2.add(randomString(r, pituus));
        }

        Collections.sort(LL1);
        Collections.sort(LL2);

        // tulostetaan listat jos alkioita ei ole paljoa
        if (n1 <= 20 && n2 <= 20) {
            System.out.println("LL1: " + LL1);
            System.out.println("LL2: " + LL2);
        }

        // kutsutaan tehtävää 10
        lomitaKasvavat(LL1, LL2);

        // tulostetaan listat jos alkioita ei ole paljoa
        if (n1 <= 20 && n2 <= 20) {
            System.out.println("LL1: " + LL1);
            System.out.println("LL2: " + LL2);
        }


    }

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
     * Kasvavien listojen lomitus.
     * Lisää B:n alkiot listaan A siten, että A säilyy järjestyksessä.
     * @param A kasvava lista johon lisätään
     * @param B kasvava lista jonka alkiot lisätään
     * @param <E> alkiotyyppi
     */
    static <E extends Comparable<? super E>> void lomitaKasvavat(LinkedList<E> A, LinkedList<E> B) {


        /* Algoritmin aikavaativuus on lineaarinen, mikäli Compare on O(1)*/

        ListIterator<E> Ia = A.listIterator();
        ListIterator<E> Ib = B.listIterator();
        boolean check=true;
        E a=null,b=null;
        int i=0;
        // Haetaan listaan ekat alkiot
        if (Ia.hasNext())
            a = Ia.next();
        if (Ib.hasNext())
            b = Ib.next();
        // ikilooppi
        while (check){
            //Kun listat ovat loppu poistutaan loopista
            if (!Ia.hasNext()&&!Ib.hasNext())
                check= false;
            //jos alkioita vertaillaan
            i = a.compareTo(b);

            if (i < 0){
                // Hypätään aalla eteenpäin
                if(Ia.hasNext())
                    a = Ia.next();
                else // B listan viimeisen alkion lisääminen kun A on jo loppu ja B:ssä on vielä jäljellä
                    Ia.add(b);
            }
            // Jos B on isompi kuin A, Liikutaan A:lla edelliseen lisätään B ja hypätään takaisin eteenpäin
            else if (i> 0){
                Ia.previous();
                Ia.add(b);
                Ia.next();
                if(Ib.hasNext())
                    b = Ib.next();
            }
            // Alkioiden ollessa yhtä suuria lisätään A listaan ja hypätään B listassa eteenpäin
            else{
                Ia.add(b);
                if(Ib.hasNext())
                    b = Ib.next();
            }
        }
    }
}
