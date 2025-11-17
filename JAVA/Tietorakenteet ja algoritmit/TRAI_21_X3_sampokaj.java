import java.util.LinkedList;
import java.util.ListIterator;

/*
Creator: Sam
Date: 18.09.2021
Version: 0.1
Description:

*/
public class TRAI_21_X3_sampokaj implements TRAI_21_X3{
    /**
     * ITSEARVIOINTI TÃ„HÃ„N:
     * Tehtävä ei ollut vaikea. Iteraattori toimi kuten pitikin.
     * Aikavaativuus sovelluksessa pitäisi olla lineaarinen.
     */

    /**
     * Poistaa listasta A saman alkion peräkkäisistä esiintymistä muut paitsi ensimmäisen.
     * Listasta (4 3 3 2 2 2 2 1 2 2 3 3) tulee lista (4 3 2 1 2 3).
     * Lista voi sisältää myös null:eja jotka käsitellään samoin kuin muut alkiot.
     *
     * @param A syötelista
     * @return poistettujen määrä
     */
    @Override
    public <E> int poistaPerakkaisetDuplikaatit(LinkedList<E> A) {
        ListIterator<E> Ia = A.listIterator();

        E a= null,b=null;
        if (Ia.hasNext())
            a= Ia.next();
        int poistettu =0;
        while (Ia.hasNext()) {

            if (Ia.hasNext())
            b = Ia.next();
            if ((b == null && a == null)  || (b != null && b.equals(a))  ) {
                Ia.remove();
                poistettu++;
            }

            a =b;
         }

        return poistettu;
    }
}


