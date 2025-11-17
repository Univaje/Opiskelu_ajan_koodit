import java.util.HashSet;
import java.util.Set;

public class TRAI_21_X5_sampokaj implements TRAI_21_X5 {

    /**
     * ITSEARVIOINTI TÄHÄN:
     * Tehtävän haastavin osuus oli ymmärtää miten settejä tulisi yhdistellä ja erotella.
     * Ensimmäisenä tein tehtävän toisin päin. Lisäsin tulokseen kaikki alkiot. Selvitin
     * mitkä tuloksesta pitäisi poistaa ja poistin ne. Tämän jälkeen ymmärsin että algoritmia
     * voi yksinkertaistaa tekemällä asia toisin päin. selvittää mitkä pitää mistäkin listasta
     * lisätä tulokseen ja lisätä ne. Aikavaativuuksien ymmärtämisessä koen vaikeuksia. Tämän 
     * opiskelu vaati enemmän aikaa kun algoritmin tuottaminen. Enkä ole vieläkään varma sainko
     * sitä oikein.
     */

    /**
     * Joukkojen kaksi kolmesta -leikkaus. Luo uuden joukon johon algoritmi laittaa ne syötejoukkojen alkiot jotka
     * kuuluvat tasan kahteen kolmesta syötejoukosta. Jos jokin alkio kuuluu vain yhteen tai kaikkiin kolmeen
     * syötejoukkoon, alkiota ei laiteta tulosjoukkoon. Ei muuta syötejoukkojensa sisältöä (vaan luo uuden tulosjoukon)
     * Jos mikään alkio ei täytä ehtoa, palautetaan tyhjä joukko.
     *
     * @param S1 syötejoukko
     * @param S2 syötejoukko
     * @param S3 syötejoukko
     * @return tulosjoukko
     *
     * X5. Kirjoita algoritmi joka hakee joukkojen ”kaksi kolmesta” leikkauksen. Algoritmi saa siis parametrinaan
     * kolme joukkoa (java.util.Set) ja muodostaa uuden joukon niistä alkioista jotka
     * kuuluvat täsmälleen kahteen syötejoukoista. Mukana ei siis ole niitä alkioita jotka kuuluvat
     * vain yhteen syötejoukoista, eikä niitä alkioita jotka kuuluvat kaikkiin syötejoukkoihin. Älä
     * muuta syötejoukkoja äläkä käytä apuna kuvausta (Map) tai tietorakennekirjastomme joukkoa (TraSet).
     * Vihjeitä: voit ottaa joukoista kopioita, käytä joukko-operaatioita, ei kannata
     * lähteä iteroimaan joukkoja alkioittain. Mikä on algoritmisi aikavaativuus jos syötejoukot
     * ovat HashSet-tyyppiä? Aikavaativuus vaikuttaa arvosteluun.
     *          O(9n+5) = O(n)
     */
    @Override
    public <E> Set<E> kaksiKolmesta(Set<E> S1, Set<E> S2, Set<E> S3) {
           Set<E> tulos = new HashSet<>();     //O(1)
           Set<E> yhdiste = new HashSet<>(S1); //O(1)
           yhdiste.retainAll(S2);              //O(n)
           yhdiste.removeAll(S3);              //O(n)
           tulos.addAll(yhdiste);              //O(n)
           yhdiste = new HashSet<>(S2);        //O(1)
           yhdiste.retainAll(S3);              //O(n)
           yhdiste.removeAll(S1);              //O(n)
           tulos.addAll(yhdiste);              //O(n)
           yhdiste = new HashSet<>(S3);        //O(1)
           yhdiste.retainAll(S1);              //O(n)
           yhdiste.removeAll(S2);              //O(n)
           tulos.addAll(yhdiste);              //O(n)
        return tulos;                          //O(1)

    }
}
