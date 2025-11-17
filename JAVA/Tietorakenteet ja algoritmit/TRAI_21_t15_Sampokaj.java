// TRAI_21_t14_15.java SJ


import fi.uef.cs.tra.BTree;
import fi.uef.cs.tra.BTreeNode;
import fi.uef.cs.tra.LinkedQueue;
import fi.uef.cs.tra.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.TreeMap;

public class TRAI_21_t15_Sampokaj {

    public static void main(String[] args) {

        BTree<Integer> puu = null;

        int N = 15;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);


        // testataan ensin vakiopuulla

        puu = exampleBTree();
        System.out.println("Sisäjärjestyksessä:");
        inorderPrint(puu);

        System.out.println("Matalin lehtisolmu = " + matalin(puu).getElement());

        // tehdään uusi puu

        puu = new BTree<Integer>();


        System.out.println("\nPuuhun:");
        Random r = new Random(42);
        Integer x = null;
        for (int i = 0; i < N; i++) {
            x = r.nextInt(N*2);
            System.out.print(x + " ");
            inorderInsert(puu, x);
        }
        System.out.println();

        System.out.println("Sisäjärjestyksessä:");
        inorderPrint(puu);

        System.out.println("Matalin lehtisolmu = " + matalin(puu).getElement());

        // rakenteiden vertailu

        puu = exampleBTree();

        BTree<Integer> puu2 = exampleBTree();

        System.out.println("Samat rakenteet : " + vertaaRakenne(puu, puu2));

        System.out.println("Lisätään: 7");
        inorderInsert(puu, 7);
        System.out.println("Samat rakenteet : " + vertaaRakenne(puu, puu2));

        System.out.println();


    } // main()



    /**
     * 14. Kirjoita algoritmi joka etsii binääripuun matalimman (vähiten syvän)
     * lehtisolmun. Vihje: tasoittainen läpikäynti. Aikavaativuus?
     * @param T binääripuu
     * @return matalin lehtisolmu tai null jos puu on tyhjä
     **/

    public static BTreeNode matalin(BTree T) {
        LinkedQueue<BTreeNode> Q = new LinkedQueue<BTreeNode>();
        if (T.getRoot() != null)
            Q.offer(T.getRoot());
        while (!Q.isEmpty()){
            BTreeNode n = Q.poll();
            if (n.getRightChild() == null && n.getLeftChild() == null)
                return n;
            else{
                if ( n.getLeftChild() != null)
                    Q.offer(n.getLeftChild());
                if ( n.getRightChild() != null)
                    Q.offer(n.getRightChild());
            }
        }
        return null;

    } // matalin()


    /**
     * 15. Kirjoita algoritmi, joka vertaa kahta binääripuuta ja palauttaa toden jos puut ovat raken-
     teeltaan samat, muuten epätoden. Puut ovat samat, jos juuren molemmat alipuut ovat
     keskenään rakenteeltaan samanlaiset. Puun sisältämiä elementtejä ei siis vertailla, vain puun
     rakennetta (â€oksaston muotoaâ€). Aikavaativuus? Tilavaativuus? Vihje: rekursio rinta rinnan.
     * @param T1 syötepuu1
     * @param T2 syötepuu2
     * @param <E> alkiotyyppi (ei käytetä)
     * @return ovatko rakenteeltaan samat vai ei
     *
     * aikavaativuus tehtävässä on O(logn)
     * Tilavaativuudella oletettavasti riippuu puoden koosta. puiden yhteis koko T1+T2.
     */
    public static <E> boolean vertaaRakenne(BTree<E> T1, BTree<E> T2) {
        Boolean check;
        check = vertaaNode(T1.getRoot(),T2.getRoot());
        return check;
    } // vertaaRakenne()
    public static <E> boolean vertaaNode(BTreeNode T1, BTreeNode T2){
        BTreeNode childa = T1;
        BTreeNode childb = T2;
        if (childa == null && childb != null || childa != null && childb == null )
            return false;
        else{
            if (childa != null || childb != null){
                return vertaaNode(T1.getLeftChild(),T2.getLeftChild()) && vertaaNode(T1.getRightChild(),T2.getRightChild());
            }
            else
                return true;
        }
    }
    // vertaaRakenne()


    // esimerkkejä ja pohjia


    public static BTree<Integer> exampleBTree() {

        BTree<Integer> T = new BTree<Integer>();

        // juuri
        T.setRoot(new BTreeNode<Integer>(9));

        BTreeNode<Integer> n = T.getRoot();

        // juuren lapset
        n.setLeftChild(new BTreeNode<Integer>(5));
        n.setRightChild(new BTreeNode<Integer>(15));

        // vasen haara
        BTreeNode<Integer> l = n.getLeftChild();

        l.setLeftChild(new BTreeNode<Integer>(3));
        l.setRightChild(new BTreeNode<Integer>(8));

        l.getLeftChild().setRightChild(new BTreeNode<Integer>(4));

        // oikea haara
        l = n.getRightChild();

        l.setLeftChild(new BTreeNode<Integer>(12));
        l.setRightChild(new BTreeNode<Integer>(18));

        l.getLeftChild().setLeftChild(new BTreeNode<Integer>(11));
        l.getLeftChild().setRightChild(new BTreeNode<Integer>(13));


        System.out.println("                 ");
        System.out.println("       9        ");
        System.out.println("    __/  \\__     ");
        System.out.println("   5        15   ");
        System.out.println("  / \\      /  \\  ");
        System.out.println(" 3   8   12    18");
        System.out.println("  \\      /\\      ");
        System.out.println("   4    11 13    ");
        System.out.println("                 ");

        return T;

    } // exampleBTree()



    /**
     * 13. Lisäys sisäjärjestettyyn binääripuuhun.
     * @param T binääripuu
     * @param x lisättävä alkio
     * @return tehtiinkö lisäys vai ei
     */

    /**
     * Kirjoita algoritmi joka etsii binääripuun vähiten syvän (lähimpänä juurta olevan) lehtisolmun.
     Vihje: tasoittainen läpikäynti. Aikavaativuus?
     * */
    public static <E extends Comparable<? super E>>
    boolean inorderInsert(BTree<E> T, E x) {
        BTreeNode<E> n = T.getRoot();
        if (n == null) {
            T.setRoot(new BTreeNode<E>(x));
            return true;
        }

        while (true) {

            if (x.compareTo(n.getElement()) == 0)
                // prev jo puussa, eli lisätä
                return false;

            else if (x.compareTo(n.getElement()) < 0) {
                // prev edeltää n:n alkiota
                if (n.getLeftChild() == null) {
                    // lisäyskohta läydetty
                    n.setLeftChild(new BTreeNode<>(x));
                    return true;
                } else
                    n = n.getLeftChild();
            } else {
                // prev suurempi kuin n
                if (n.getRightChild() == null) {
                    // lisäyskohta läydetty
                    n.setRightChild(new BTreeNode<>(x));
                    return true;
                } else
                    n = n.getRightChild();
            }
        } // while


    } // inorderInsert()







    // Tulostus sisäjärjestyksessä rekursiivisesti
    public static void inorderPrint(BTree T) {
        inorderPrintBranch(T.getRoot());
        System.out.println();
    } // inorderPrint()


    public static void inorderPrintBranch(BTreeNode n) {
        if (n == null)
            return;

        inorderPrintBranch(n.getLeftChild());
        System.out.print(n.getElement() + " ");
        inorderPrintBranch(n.getRightChild());

    } // inorderPrintBranch()


} // class TRAI_21_t14.java