// TRAI_21_t12.java SJ

/**
 * 12. Palindromi on merkkijono joka myös takaperin luettuna on sama. Kun sana talletetaan pakkaan merkki kerrallaan, on
 * helppoa tarkastaa onko sana palindromi vai ei. Kirjoita algoritmi joka tallettaa merkkijonon merkit pakkaan ja joka
 * tarkastaa onko pakan sisältö palindromi vai ei. Ota kurssin Moodlesta pääohjelma jossa on vinkkejä miten merkkijono
 * muutetaan pakaksi. Aikavaativuus?
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class TRAI_21_t12 {


    // Pääohjelman käyttö:
    // java TRAI_21_t12 [merkkijono]
    public static void main(String[] args) {

        String mjono = null;

        if (args.length > 0)
            mjono = args[0];

        if (mjono == null) {
            System.out.print("Anna merkkijono : ");
            Scanner sc = new Scanner(System.in);
            mjono = sc.nextLine();
        }

        System.out.print("Merkkijono '" + mjono + "' ");
        if (onkoPalindromi(mjono))
            System.out.println("on palindromi");
        else
            System.out.println("ei ole palindromi");

    } // main()


    /**
     * Merkkijonosta merkkipakka.
     *
     * @param S syötemerkkijono
     * @return merkit pakkana
     */
    public static Deque<Character> merkkijonostaPakka(String S) {
        Deque<Character> D = new ArrayDeque<>();

        for (int i = 0; i < S.length(); i++)
            D.addLast(S.charAt(i));

        return D;

    } // merkkijonostaPakka()


    /**
     * Onko merkkijono palindromi vai ei?
     *
     * @param S syötemerkkijono
     * @return totuusarvo
     */
    public static boolean onkoPalindromi(String S) {

        /* Algoritmi ei ota kantaa siihen ovatko sanat oikeasti palindromeja koneen tulisi
        * ymmärtää oikeasti sanan tarkoitus jos haluttaisiin että tämä toimisi oikein. */
        int i=0;
        Boolean palindromi = false;
        Deque<Character> D = merkkijonostaPakka(S);
        // Talletetaan pakan koko palindromi testiä varten
        int size = D.size();
        // Loopataan kunnes pakassa ei ole jäljellä kirjaimia
        while (!D.isEmpty() ){
            /* Pakan ollessa parittoman lukuinen on lisättävä
            pakkaan ylimääräinen kirjain jotta ne voidaan ottaa
            pakan molemmista päistä testiä varten. Parittoman lukuisessa
            sanassa keskimmäinen kirjain on kuitenkin lopusta alkuun ja
            alusta loppuun sama*/
            if (D.size() == 1){
                D.addFirst(D.getFirst());
                // Kasvatetaan pakkaa yhdellä koska lisäämme sinne kirjaimen
                size++;
            }
            // Otetaan pakan ensimmäinen kirjain
            Character alku = D.getFirst();
            // Otetaan pakan viimeinen kirjain
            Character loppu = D.getLast();
            // Testataan pakan ensimmäistä ja viimeistä kirjainta
            if (alku.equals(loppu)){
                // Näiden ollessa samat kasvatetaan palindromi lukua
                i++;
            }
            // Poistetaan testatut kirjaimet pakasta
            D.removeFirst();
            D.removeLast();
        }
        // Testataan oliko sana paldinrom. jos palindromi luku vastaa puolta
        // pakan alkuperäisestä koosta on sana ollut palindromi.
        if (i == size/2){
            palindromi = true;
        }

        return palindromi;
    } // onkoPalindromi()

} // class
