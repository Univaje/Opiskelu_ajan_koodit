import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TRAI_21_X7_sampokaj<E> implements TRAI_21_X7<E>//,Iterable<E>
{

    /**
     * ITSEARVIOINTI TÄHÄN:
     * Aikavaativuudeltaan algoritmi on tehokas. Lisäys ja poisto ovat O(n) aikaisia.
     * Ainut missä aika ajoin on O(n) aikainen on taulukon tuplaus. Pyörittelin pitkään
     * kuinka tuon algoritmin saisi tehtyä vain kahdella kolmesta muuttujasta. Kuinka erotella
     * täysi ja tyhjä taulukko, mutta koska alku ja loppu indeksit vaihtavat paikkaa ja alkioiden tarkastamisesta
     * ei ole hyötyä kun niitä ei varsinaisesti poisteta ainoastaan jätetään indeksin ulkopuolelle.
     * Totesin lopulta ettei O(1) aikainen kolmas muuttuja lisää aikavaativuutta merkittävästi joten sen käyttö
     * helpottaa algoritmin rakennusta itselle. Toisin sanoen algoritmissa on vielä parannettavaa tehokkuudessa
     * mutta ei millään merkittävällä tavalla.
     *
     */
    private E[] train;
    private Integer last;
    private Integer first;
    private Integer passenger =0;
    @SuppressWarnings({"unchecked"})
    public TRAI_21_X7_sampokaj() {
        train = (E[]) new Object[20];
        last = train.length-1;
        first = 0;
    }


    /**
     * Lisää jonoon yhden alkion.
     *
     * @param x lisättävä alkio.
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public void lisaa(E x) {
        if (first == (last+1) % train.length && passenger ==20)
            ExrtaCart();
        last = (last + 1) % train.length;
        train[last] = x;
        passenger++;

    }
    @SuppressWarnings({"unchecked"})
    private void ExrtaCart (){
        E[] cart = (E[]) new Object[train.length*2];
            for (int i = 0; i < train.length; i++) {
                cart[i] = train[(first+i) % train.length];
            }
            train = cart;
            first = 0;
            last = passenger-1;
        }


    /**
     * Poistaa ja palauttaa jonosta siellä pisimpään olleen alkion.
     *
     * @return poistettu jonossa pisimpään ollut alkio.
     * @throws NoSuchElementException jollei jonossa ole yhtään alkiota.
     */
    @Override
    public E poista() {
        if (onkoTyhja())
            throw new NoSuchElementException("No luck here. Queue is empty!");
        E removed = train[first];
        first = (first+1) % train.length;
        passenger--;



        return removed;
    }

    /**
     * Onko jono tyhjä vai ei?
     *
     * @return true jos jonossa ei ole yhtään alkiota, muuten false
     */
    @Override
    public boolean onkoTyhja() {
        if (first == (last+1) % train.length && passenger == 0)
            return true;
        else
            return false;
    }

}