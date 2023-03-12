
import fi.uef.cs.tra.ListNode;
import fi.uef.cs.tra.TraLinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TRAI_21_t11 {

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
        Random r = new Random(siemen);
        ArrayList<String> AL1 = new ArrayList<>();
        ArrayList<String> AL2 = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            AL1.add(randomString(r, pituus));
        }

        for (int i = 0; i < n2; i++) {
            AL2.add(randomString(r, pituus));
        }
        Collections.sort(AL1);
        Collections.sort(AL2);

        TraLinkedList<String> LL1 = new TraLinkedList<>();
        TraLinkedList<String> LL2 = new TraLinkedList<>();
        for (String s : AL1)
            LL1.insert(LL1.EOL, s);
        for (String s : AL2)
            LL2.insert(LL2.EOL, s);

        // tulostetaan listat jos alkioita ei ole paljoa
        if (n1 <= 20 && n2 <= 20) {
            System.out.println("LL1: " + TraLinkedListToString(LL1));
            System.out.println("LL2: " + TraLinkedListToString(LL2));
        }

        // kutsutaan tehtävää 11
        lomitaKasvavat(LL1, LL2);

        // tulostetaan listat jos alkioita ei ole paljoa
        if (n1 <= 20 && n2 <= 20) {
            System.out.println("LL1: " + TraLinkedListToString(LL1));
        }


    }

    /*
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
     * Kasvavien listojen lomitus. Lisää B:n alkiot listaan A siten, että A säilyy järjestyksessä.
     *
     * @param A   kasvava lista johon lisätään
     * @param B   kasvava lista jonka alkiot lisätään
     * @param <E> alkiotyyppi
     */
/*
        Kirjoita tehokas algoritmi joka saa parametrinaan kaksi kasvavassa järjestyksessä olevaa
        asemapohjaista linkitettyä listaa (TraLinkedList A, B) ja joka lisää listaan A kaikki listan
        B alkiot siten, että lisäysten jälkeen lista A on edelleen järjestyksessä. Listaa B ei muuteta.
        Voit olettaa ettei listoissa ole null alkioita. Koska nyt harjoittelemme listasolmuviittausten
        käyttöä, et saa käyttää valmista addAll() -operaatiota, lajittelua, joukko/kuvausrakenteita
        (Set/Map) tai alkiovirtaa (Stream) apuna. Mikä on algoritmisi aikavaativuus? Hyödynnä
        listojen kasvavaa järjestystä saadaksesi algoritmista tehokkaan.
*/
    static <E extends Comparable<? super E>> void lomitaKasvavat(TraLinkedList<E> A, TraLinkedList<E> B) {

        /* Algoritmin aikavaativuus on lineaarinen, mikäli Compare on O(1)*/

        // Haetaan listaan ekat lista solmut
        ListNode La = A.first();
        ListNode Lb = B.first();
        Boolean check = true;
        int i=0;
        //alkio testaamiseen elementit
        E elementti = null;
        E elementti2 = null;
        // ikilooppi
        while (check) {
            //Kun listat ovat loppu poistutaan loopista
            if (La == A.EOL && Lb == B.EOL) {
                check = false;
            }
            else {
                //Haetaan elementteihin alkiot
                if (La != A.EOL)
                    elementti = (E) La.getElement();
                if (Lb != B.EOL)
                    elementti2 = (E) Lb.getElement();
                // Testataan alkioita toisiinsa
                i = elementti.compareTo(elementti2);
                // Jos B on isompi kuin A, lisätään se A:han ja hypätään B:llä seuraavaan
                if ( i > 0){
                    if (La != A.EOL) {
                        A.insert(La, elementti2);
                        Lb = Lb.next();
                    }
                }
                // Jos A on pienempi kuin B liikutaan A listassa seuraavaan
                else if (i < 0 && La != A.EOL){//jod a<b
                    La = La.next();
                }
                // Jos Alkiot ovat samat Lisätään A:han, ja hypätään B:llä seuraavaan
                else{//jos A==b
                    A.insert(La,elementti2);
                    Lb = Lb.next();
                }
            }
        }
    }

    /**
     * Listan merkkijonoesitys.
     *
     * @param L   lista
     * @param <E> alkiotyyppi
     * @return lista merkkijonona
     */
    static <E> String TraLinkedListToString(TraLinkedList<E> L) {
        StringBuilder sb = new StringBuilder();
        sb.append("( ");
        ListNode<E> n = L.first();
        while (n != L.EOL) {
            sb.append(n.getElement().toString());
            sb.append(" ");
            n = n.next();
        }
        sb.append(")");
        return sb.toString();
    }


}