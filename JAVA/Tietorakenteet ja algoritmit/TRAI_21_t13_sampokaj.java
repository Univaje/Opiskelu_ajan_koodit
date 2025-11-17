// TRAI_21_t13.java.java SJ

/**
 * 13. Kirjoita algoritmi, joka lisää sisäjärjestyksessä olevaan binääripuuhun uuden solmun siten, että puu säilyy
 * sisäjärjestyksessä. Jos sama alkio (.equals()) oli jo puussa, niin alkiota ei lisätä puuhun. Parametreina puu ja
 * alkio. Algoritmi luo uuden solmun jos lisäys tehdään.  Algoritmi palauttaa totuusarvon lisättiinkö alkio vai ei.
 * Algoritmin toiminta käydään läpi luennolla. Aikavaativuus?
 **/

// Tarvitset projektiin (tai komentoriville) TRA-kirjaston Moodlesta.

import fi.uef.cs.tra.BTree;
import fi.uef.cs.tra.BTreeNode;

import java.util.Random;

public class TRAI_21_t13 {

    public static void main(String[] args) {

        BTree<Integer> puu = new BTree<Integer>();

        int N = 12;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);

        System.out.println("Puuhun:");
        Random r = new Random(42);
        Integer x = 0;
        for (int i = 0; i < N; i++) {
            x = r.nextInt(N * 2);
            System.out.print(x + " ");
            inorderInsert(puu, x);
        }
        System.out.println();

        System.out.println("Sisäjärjestyksessä:");
        inorderPrint(puu);

        for (int i = 0; i < N * 2; i++) {
            System.out.println("Onko " + i + " : " +
                    inorderMember(puu, i));
        }

    } // main()


    /**
     * 13. Lisäys sisäjärjestettyyn binääripuuhun.
     * Lisää alkion x binääripuuhun jollei sitä siellä ennestään ole.
     * @param T binääripuu
     * @param x lisättävä alkio
     * @return tehtiinkö lisäys vai ei
     */
    /**
     * 13. Kirjoita algoritmi, joka lisää sisäjärjestyksessä olevaan binääripuuhun uuden solmun siten, että puu säilyy
     * sisäjärjestyksessä. Jos sama alkio (.equals()) oli jo puussa, niin alkiota ei lisätä puuhun. Parametreina puu ja
     * alkio. Algoritmi luo uuden solmun jos lisäys tehdään.  Algoritmi palauttaa totuusarvon lisättiinkö alkio vai ei.
     * Algoritmin toiminta käydään läpi luennolla. Aikavaativuus?
     **/

    /*Algoritmi on lineaarinen mikäli compare on O(1)*/
    public static <E extends Comparable<? super E>>
    boolean inorderInsert(BTree<E> T, E x) {
        Boolean check = true;
        int i=0;
        // Luodaan puun juuri sekä 2 nodea.
        BTreeNode<E> n = T.getRoot();
        BTreeNode<E> setchild = new BTreeNode<E>(x);
        BTreeNode<E> getchild;
        // Testataan onko puu tyhjä ja lisätään juuri jos on
        if (n == null){
            T.setRoot(setchild);
            return true;
        }
        else
        {
            // Ikilooppi josta poistutaan vasta kun alkio on lisätty tai todettu jo olevaksi puussa
            while (check) {
                // Testataan solmun alkiota
                i = x.compareTo(n.getElement());
                // Testauksen ollessa suurempi kuin testattava solmu siirrytään oikealle puu solmusta
                if (i > 0) {
                    // Testataan onko solmulla lapsi solmuja
                    getchild = n.getRightChild();
                    // Jos lapsisolmuja ei ole lisätään solmulle oikean puoleinen lapsi solmu.
                    if (getchild == null) {
                        n.setRightChild(setchild);
                        return true;
                    }
                    // jos lapsi solmu löytyi otetaan se uudeksi testattavaksi solmuksi seuraavalle loopille
                    else
                        n = getchild;
                }
                // Testauksen ollessa pienempi kuin testattava solmu siirrytään vasemmalle puu solmusta
                else if (i < 0) {
                    // Testataan onko solmulla lapsi solmuja
                    getchild = n.getLeftChild();
                    // Jos lapsisolmuja ei ole lisätään solmulle vasemman puoleinen lapsi solmu.
                    if (getchild == null) {
                        n.setLeftChild(setchild);
                        return true;
                    }
                    // jos lapsi solmu löytyi otetaan se uudeksi testattavaksi solmuksi seuraavalle loopille
                    else
                        n = getchild;
                }
                // Testattavien lukujen ollessa samat poistutaan loopista.
                else
                    return false;
            }
            return true;

    } // inorderInsert()
}

    // -------------------------------
    // esimerkkejä

    /**
     * Onko alkio sisäjärjestetyssä binääripuussa vai ei
     * @param T sisäjärjestetty binääripuu
     * @param x etsittävä alkio
     * @param <E> alkiotyyppi
     * @return true jos alkio x on puussa, muuten false
     */
    public static <E extends Comparable<? super E>>
    boolean inorderMember(BTree<E> T, E x) {
        BTreeNode<E> n = T.getRoot();

        while (n != null) {
            if (x.compareTo(n.getElement()) == 0)
                return true;
            else if (x.compareTo(n.getElement()) < 0)
                n = n.getLeftChild();
            else
                n = n.getRightChild();
        } // while
        return false;

    } // inorderMember()


    /**
     * Tulostus sisäjärjestyksessä rekursiivisesti.
     * @param T tulostettava puu
     */
    public static void inorderPrint(BTree T) {
        inorderPrintBranch(T.getRoot());
        System.out.println();
    } // inorderPrint()


    /**
     * Tulostus sisäjärjestyksessä rekursiivisesti.
     * @param n tulostettavan alipuun juuri
     */
    public static void inorderPrintBranch(BTreeNode n) {
        if (n == null)
            return;

        inorderPrintBranch(n.getLeftChild());
        System.out.print(n.getElement() + " ");
        inorderPrintBranch(n.getRightChild());

    } // inorderPrintBranch()


} // class TRAI_21_t13.java*/