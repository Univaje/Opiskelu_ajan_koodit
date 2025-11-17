// TRAI_21_t8_9.java SJ
// Pääohjelma viikon 2 tehtäviin 8 ja 9

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;


public class TRAI_21_t24_sampokaj {


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

        int merkisto = 25;

        // tämä antaa aina erilaisen syötteen:
        Random r = new Random(System.currentTimeMillis());
        // Random r = new Random(n1); // tämä antaa aina saman syötteen

        // testataan vaihteeksi merkkijonoilla
        LinkedList<String> LL = new LinkedList<>();
        // täytetään alkioilla
        for (int i = 0; i < n1; i++) {
            LL.add(randomString(r, pituus, merkisto));
        }

        Collections.sort(LL);

        // tulostetaan lista jos alkioita ei ole paljoa
        if (n1 <= 20) {
            System.out.println("LL: " + LL);
        }

        // tehdään toinen kokoelma

        int n2 = r.nextInt((int)Math.sqrt(n1)+2);
        // int n2 = (int)Math.sqrt(n1)+2; // jos haluat aina samanmittaisen syötteen
        ArrayList<String> AL = new ArrayList<>(n2);
        for (int i = 0; i < n2; i++) {
            AL.add(randomString(r, pituus, merkisto));
        }
        if (n2 <= 20) {
            System.out.println("AL: " + AL);
        }


        lisaaJarjestettyyn(LL, AL);

        if (n1 <= 20) {
            System.out.println("LL: " + LL);
        }




    } // main()

    /**
     * Lisää järjestettyy listaan järjestämättömän kokoelman alkiot
     * siten, että lista pysyy järjestyksessä.
     * @param L järjestetty lista johon lisätään
     * @param C kokoelma jonka alkiot lisätään
     * @param <E> alkiotyyppi
     */
    public static <E extends Comparable<? super E>> void lisaaJarjestettyyn(LinkedList<E> L, Collection<E> C) {


        E  kurkkija = null;
        ListIterator<E> raataja = L.listIterator();                      //O(n)
        if (!C.isEmpty()){
        PriorityQueue<E> orja = new PriorityQueue<>(C);          //O(mlogm)
        while(raataja.hasNext()){
            E touhottaja = raataja.next();
            if (!orja.isEmpty())
                kurkkija = orja.peek();
            else
                break;
            int vertailija = touhottaja.compareTo(kurkkija);
            // pienempi
            if(vertailija > 0){
                kurkkija = orja.poll();
                raataja.previous();
                raataja.add(kurkkija);
            }
            else if (!raataja.hasNext() && !orja.isEmpty()){
                kurkkija = orja.poll();
                raataja.add(kurkkija);
                raataja.previous();
            }

        }

    }}


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
