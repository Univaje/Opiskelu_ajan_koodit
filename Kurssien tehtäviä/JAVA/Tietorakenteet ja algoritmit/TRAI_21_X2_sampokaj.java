import java.util.ArrayList;
import java.util.ListIterator;

public class TRAI_21_X2_sampokaj implements TRAI_21_X2 {

    /**
     * ITSEARVIONTI TÃ„HÃ„N:
     *tehtävä oli suhteellisen helppo kun ymmärsi miten numeroita tulee käydä läpi.
     * suurin ongelma itsellä tehtävän tiimoilta oli ymmärtää kuinka numerot saadaan listasta
     * haettua vertailua varten ilman että käyttää useampaa looppia. Aloitin ensin tekemään
     * iteraattorin avulla mutta sain ohjaus tunnilta apuja pelkän arraylistin avulla läpi käymiseen.
     * Aika vaativuus tehtävässä on lineaarinen. Tätä varmasti voidaan parantaa jollain.
     * Aika vaativuutta voidaan myös parantaa vähentämällä muuttujia ja käyttämällä näiden tilalla
     * get toimintoa. Koin itselleni tämän vain selkeimmäksi.
     */
    /**
     * Kasvavien listojen erotus.
     * Palauttaa sellaiset alkiot jotka löytyvät listasta A, mutta eivät listasta B.
     * Jos alkio on listassa A useasti, mutta ei lainkaan listassa B, alkio tulee tuloslistaan
     * yhtä monta kertaa kuin se listassa A on. Jos alkio on edes yhden kerran listassa B, se ei tule
     * tuloslistaan lainkaan.
     * Tuloslista tulee myös kasvavaan järjestykseen.
     * @param A ensimmäinen syötelista, alkiot kasvavassa järjestyksessä
     * @param B toinen syötelista, alkiot kasvavassa järjestyksessä
     * @return erotuslista
     */
    @Override
    public ArrayList<Integer> kasvavienErotus(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> tulos = new ArrayList<Integer>();
        if(A.isEmpty()){                                          //O=(1)
        return tulos;
        }                                                         //O=(1)
        Integer apua;                                             //O=(1)
        Integer apub =0;                                          //O=(1)
        Integer a=0,b=0;                                          //O=(1)
        boolean checked = false;                                  //O=(1)
        if(A.isEmpty())                                           //O=(1)
            checked = true;                                       //O=(1)
        while (!checked) {                                        //O=(n)
            apua = A.get(a);                                      //O=(1)
            if (!B.isEmpty())                                     //O=(1)
            apub = B.get(b);                                      //O=(1)

            if  (!apua.equals(apub)) {                            //O=(1)
                if (apua > apub && b < B.size()-1)                //O=(1)
                    b++;                                          //O=(1)
                else if (apua < apub ) {                          //O=(1)
                    tulos.add(apua++);                            //O=(1)
                    a++;                                          //O=(1)
                }
                else {
                    tulos.add(apua++);                            //O=(1)
                    a++;                                          //O=(1)
                }
            }
            else
                a++;                                              //O=(1)


            if (a >= A.size())                                    //O=(1)
                checked = true;                                   //O=(1)
            }

        return tulos;
    }

}