import java.util.Iterator;
import java.util.NoSuchElementException;

public class TRAI_21_t29_sampokaj<E> implements TRAI_21_X7<E>,Iterable<E>
{

    private E[] train;
    private Integer last;
    private Integer first;
    private Integer passenger =0;
    @SuppressWarnings({"unchecked"})
    public TRAI_21_t29_sampokaj() {
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

    @Override
    public String toString() {
        StringBuilder Tulostus = new StringBuilder();
        Tulostus.append("<");
        for (int i = first; i <= last; i++) {
            Tulostus.append(train[i].toString());
            Tulostus.append(", ");
        }
        Tulostus.append("\b\b>");
        return Tulostus.toString();
    }
    @Override
    public Iterator<E> iterator() {
        return new TRAI_21_t29_sampokaj.QueIterator();
    }


    private class QueIterator implements Iterator<E>{

        Integer conductor;
        public QueIterator() {
            conductor = first;

        }

        @Override
        public boolean hasNext() {
            if (conductor <= last)
                return true;
            else
                return false;
        }

        @Override
        public E next() {
            if (conductor > last)
                throw new NoSuchElementException("Having problems? Check next first!");
            else
                return train[conductor++];
        }
    }
}