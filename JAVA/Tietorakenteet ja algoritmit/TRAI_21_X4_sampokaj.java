import fi.uef.cs.tra.BTree;
import fi.uef.cs.tra.BTreeNode;

import javax.swing.*;

public class TRAI_21_X4_sampokaj implements TRAI_21_X4 {

    /**
     * ITSEARVIOINTI TÄHÄN:
     * Algoritmin toteutus vaati huolellista keskittymistä missä vaiheessa
     * haetaan mitäkin alkiota. Luentojen avulla tuli selkeä käsitys mitä pitää
     * hakea missäkin vaiheessa. Algorimin työstäminen oli hankalaa vaikka selkeä
     * kuva oli mitä tältä haettiin. Aikavaativuudesta en mene ihan takuuseen
     */

    /**
     * Palauttaa binääripuun sisäjärjestyksessä viimeisen solmun.
     *
     * @param T Tarkasteltava puu.
     * @return Viimeinen solmu tai null jos puu T on tyhjä.
     */
    /** Kirjoita operaatiot sisaViimeinen(BTree T) joka palauttaa binääripuun T sisäjärjestyksessä
     *  viimeisen solmun ja sisaEdellinen(BTreeNode n) joka saa parametrinaan binääripuun
        solmun n ja joka palauttaa ko. solmun edeltäjäsolmun sisäjärjestyksessä. Algoritmi ei tutki
        solmujen sisältöä, vain puun rakennetta. Solmun edeltäjä on vasemman lapsen oikeanpuoleisin
        jälkeläinen, tai, jollei vasenta lasta ole, niin se esivanhempi jonka oikeassa alipuussa
        alkuperäinen solmu oli. Jollei edeltäjää ole, sisaEdellinen() palauttaa null. Vastaavasti jos
        puu on tyhjä, sisaViimeinen() palauttaa null. Algoritmin toimintaperiaate käytiin läpi
        luennolla tiistaina 21.9. Mikä on algoritmisi aikavaativuus? Metodilla sisaViimeinen() ja metodia
        sisaEdellinen() toistuvasti kutsuen voidaan käydä binääripuun alkiot läpi sisäjärjestyksessä
        takaperin. Mikä on koko läpikäynnin aikavaativuus?
        Aikavaativuus on O(n) algoritmi käy läpi kaikki alkiot lineaarisessa ajassa.
    */
    @Override
    public BTreeNode sisaViimeinen(BTree T) {
        BTreeNode n = T.getRoot();
        if (n == null)
            return null;
        if (n.getRightChild() != null) {
            while (n.getRightChild() != null)
                n = n.getRightChild();
            return n;
        }
        else {
            if (n.getParent() != null)
                return n.getParent();
        }
        return n;
    }

    /**
     * Palauttaa binääripuun solmun n edeltäjän sisäjärjestyksessä.
     *
     * @param n Binääripuun solmu.
     * @return edeltäjäsolmu tai null jollei edeltäjää ole.
     */
    /** Kirjoita operaatiot sisaViimeinen(BTree T) joka palauttaa binääripuun T sisäjärjestyksessä
     *  viimeisen solmun ja sisaEdellinen(BTreeNode n) joka saa parametrinaan binääripuun
     solmun n ja joka palauttaa ko. solmun edeltäjäsolmun sisäjärjestyksessä. Algoritmi ei tutki
     solmujen sisältöä, vain puun rakennetta. Solmun edeltäjä on vasemman lapsen oikeanpuoleisin
     jälkeläinen, tai, jollei vasenta lasta ole, niin se esivanhempi jonka oikeassa alipuussa
     alkuperäinen solmu oli. Jollei edeltäjää ole, sisaEdellinen() palauttaa null. Vastaavasti jos
     puu on tyhjä, sisaViimeinen() palauttaa null. Algoritmin toimintaperiaate käytiin läpi
     luennolla tiistaina 21.9. Mikä on algoritmisi aikavaativuus? Metodilla sisaViimeinen() ja metodia
     sisaEdellinen() toistuvasti kutsuen voidaan käydä binääripuun alkiot läpi sisäjärjestyksessä
     takaperin. Mikä on koko läpikäynnin aikavaativuus?
     Aikavaativuus on O(nlogn) algoritmi käy läpi kaikki alkiot lineaarisessa ajassa ja etsintä operaatio
     vie logn ajan.
     */
    @Override
    public BTreeNode sisaEdellinen(BTreeNode n) {
        //Solmun edeltäjä on vasemman lapsen oikeanpuoleisin jälkeläinen,

        if (n.getLeftChild() != null) {
            n = n.getLeftChild();
            while (n.getRightChild() != null)
                n = n.getRightChild();
            return n;}
        // tai, jollei vasenta lasta ole, niin se esivanhempi jonka oikeassa alipuussaalkuperäinen solmu oli.
        else {
            BTreeNode parent = n.getParent();
            while (n.getParent() != null) {
                if (n.getParent().getRightChild() == n)
                    return parent;
                else {
                    n = parent;
                    parent = parent.getParent();
                }
            }
            // Jollei edeltäjää ole, sisaEdellinen() palauttaa null.
        }return null;
    }
}