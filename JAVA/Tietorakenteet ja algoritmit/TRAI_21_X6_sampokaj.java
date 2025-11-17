import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TRAI_21_X6_sampokaj implements TRAI_21_X6 {

    /**
     * ITSEARVIOINTI TÄHÄN:
     * Tehtävä tuotti alkuun ongelmaa ymmärtää miten settien settiä käsitellään. Pienellä
     * tutkimisella sekin kuitenkina aikesi. Aikavaativuudessa on vielä epäselvyyksiä ja opiskeltavaa.
     * Oletan että aikavaativuus on lineaarinen näissä koska tässä käydään settien setit ja setti läpi
     * eri loopeissa mutta se mikä jäi tässä mietityttämään on se kun getin ja putin aikavaativuudet ovat O(1)
     * mutta ne kun palauttavat setin joka lisätään toiseen settiin muuttaako se tämän aikavaativuuden O(n).
     * Oletusarvoisesti kun materiaaleissa lukee näiden olevan O(1) niin tämän tulisi olla lineaarinen algoritmi.
     *
     * HUOM!
     * Toteutuksen olisi myös voinut toteuttaa get operaatiolla kun haetaan settien setin edeltävää settiä
     * johon lisätään uusi löydetty setti.
     *
     */

    /**
     * Alkioiden hakemisto.
     * Palauttaa kuvauksen jossa kutakin syötejoukoissa olevaa alkiota kohti
     * on joukko niitĆ¤ joukkoja jossa ko. syötealkio esiintyi.
     * @param SS syötejoukkojen joukko
     * @param <E> alkioiden tyyppi
     * @return kuvaus alkioilta syötejoukoille
     *
     * X6. Kirjoita algoritmi joka muodostaa joukkojen joukosta hakemiston. Syötteenä on joukkojen joukko
     * (Set<Set<E>>) ja tuloksena on kuvaus (Map<E, Set<Set<E>>) jossa on
     * avaimena kukin erilainen syötejoukoissa esiintyvä alkio ja avaimen kuvana on joukko niistä
     * syötejoukoista joissa ko. alkio esiintyy. Joukkoja ja alkioita käsitellään viittauksina.
     * Kuvauksen arvoiksi luodaan uusi joukkojen joukko kutakin erilaista alkiota kohti ja siihen
     * lisätään ne syötejoukot joissa ko. alkio esiintyi. Älä muuta syötejoukkoja.
     * Mikä on algoritmisi aikavaativuus jos syötejoukot ovat HashSet-tyyppiä ja tuloskuvaus HashMap-tyyppiä?
     * Aikavaativuus vaikuttaa arvosteluun
     */
    @Override
    public <E> Map<E, Set<Set<E>>> hakemisto(Set<Set<E>> SS) {
        Map<E, Set<Set<E>>> tulosHakemisto = new HashMap<>();           //O(1)
        Set<Set<E>> lisattavat = new HashSet<>();                       //O(1)
        for (Set<E> setti : SS) {                                       //O(n)

            for (E alkio : setti) {                                     //O(m)

                lisattavat = new HashSet<>();                           //O(1)
                if(tulosHakemisto.containsKey(alkio)){                  //O(1)
                    lisattavat = tulosHakemisto.put(alkio,lisattavat);  //O(1) Tämän olisi voinut toteuttaa myös getillä.
                    lisattavat.add(setti);                              //O(1)
                    tulosHakemisto.put(alkio,lisattavat);               //O(1)
                }
                else{

                    lisattavat.add(setti);                              //O(1)
                    tulosHakemisto.put(alkio,lisattavat);               //O(1)
                }
            }
        }
        return tulosHakemisto;                                          //O(1)
    }
}
