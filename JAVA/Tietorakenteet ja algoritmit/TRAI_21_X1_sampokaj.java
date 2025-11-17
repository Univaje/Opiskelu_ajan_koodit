/*
Creator: Sam
Date: 05.09.2021
Version: 0.1
Description:

*/
public class TRAI_21_X1_sampokaj implements TRAI_21_X1 {


    /**
     * ITSEARVIOINTI TÄHÄN:
     * Mielestäni kirjoittamani algorimti on simppeli ja helposti ymmärrettävä. Haasteita alkuun tuotti millä saan
     * merkattua pienintä lukua ennen kuin aloitan tarkastamisen. Lopulta älysin että asettamalla taulukon ensimmäisen
     * alkion pienimmäksi tulee pienin luku varmasti oikein. Tämä onnistuisi paljon helpommin jos käytössä ei olisi
     * taulukoita, koska ne ovat kankeita ja vaikeita käyttää.
     */

    /**
     * Suurimman ja pienimmÃ¤n summa.
     * Palauttaa taulukon suurimman ja pienimmÃ¤n luvun summan tai null jos
     * taulukko on tyhjä.
     *
     * @param A SyÃ¶tetaulukko.
     * @return suurimman ja pienimmÃ¤n summan tai null jos taulukko on tyhjÃ¤.
     */
    @Override
    public Integer suurinJaPieninSumma(Integer[] A) {
        if (A.length < 1)
            return null;

        Integer P = A[0];
        Integer S = A[0];
        for (Integer I : A) {
            if(I > S)
                S = I;
            if (I < P)
                P = I;
        }
        return (P+S);
    }
}

