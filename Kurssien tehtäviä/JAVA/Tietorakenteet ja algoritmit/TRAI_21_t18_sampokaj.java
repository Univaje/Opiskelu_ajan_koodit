
// TraI_21_t18.java SJ

import fi.uef.cs.tra.TraSet;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TRAI_21_t18 {

        public static void main(String[] args) {

            int N = 10;
            if (args.length > 0)
                N = Integer.parseInt(args[0]);


            TraSet<Integer> S1 = new TraSet<>();
            TraSet<Integer> S2 = new TraSet<>();
            TraSet<Integer> S3 = new TraSet<>();

            Random r = new Random(42);
            Integer x, y;
            for (int i = 0; i < N; i++) {
                x = r.nextInt(N * 2);
                y = r.nextInt(N * 2);
                S1.add(x);
                S2.add(x - y);
                S3.add(x + y);
            }


            System.out.println("S1:      " + S1);
            System.out.println("S2:      " + S2);
            System.out.println("S3:      " + S3);


            System.out.println("KaksikolmestaTRA: " + kaksiKolmesta(S1, S2, S3));


        } // main()


        /**
         * 18. Kirjoita algoritmi joka hakee joukkojen â€kaksi kolmestaâ€ leikkauksen. Algoritmi saa siis parametrinaan kolme
         * tietorakennekirjastomme joukkoa (TraSet) ja muodostaa uuden joukon niistÃ¤ alkioista jotka kuuluvat tÃ¤smÃ¤lleen
         * kahteen syÃ¶tejoukoista. Mukana ei siis ole niitÃ¤ alkioita jotka kuuluvat vain yhteen syÃ¶tejoukoista, eikÃ¤ niitÃ¤
         * alkioita jotka kuuluvat kaikkiin syÃ¶tejoukkoihin. Ã„lÃ¤ muuta syÃ¶tejoukkoja Ã¤lÃ¤kÃ¤ kÃ¤ytÃ¤ apuna kuvausta (Map) tai
         * Javan va- kiokirjaston joukkoa (Set). VihjeitÃ¤: voit ottaa joukoista kopioita, kÃ¤ytÃ¤ joukko-operaatioita, ei
         * kannata lÃ¤hteÃ¤ iteroimaan joukkoja alkioittain. MikÃ¤ on algoritmisi aikavaativuus kun TraSet:n operaatioiden
         * aikavaativuus on kuten vastaavilla TreeSet -operaatioilla?
         *
         * @param A   syÃ¶tejoukko
         * @param B   syÃ¶tejoukko
         * @param C   syÃ¶tejoukko
         * @param <E> alkiotyyppi (ei kÃ¤ytetÃ¤)
         * @return uusi joukko jossa on ne alkiot jotka lÃ¶ytyvÃ¤t tasan kahdesta syÃ¶tejoukosta
         *
         * 18. Kirjoita algoritmi joka hakee joukkojen ”kaksi kolmesta” leikkauksen. Algoritmi saa siis
         * parametrinaan kolme tietorakennekirjastomme joukkoa (TraSet) ja muodostaa uuden joukon
         * niistä alkioista jotka kuuluvat täsmälleen kahteen syötejoukoista. Mukana ei siis ole niitä
         * alkioita jotka kuuluvat vain yhteen syötejoukoista, eikä niitä alkioita jotka kuuluvat kaikkiin
         * syötejoukkoihin. Älä muuta syötejoukkoja äläkä käytä apuna kuvausta (Map) tai Javan vakiokirjaston joukkoa
         * (Set). Vihjeitä: voit ottaa joukoista kopioita, käytä joukko-operaatioita,
         * ei kannata lähteä iteroimaan joukkoja alkioittain. Mikä on algoritmisi aikavaativuus kun
         * TraSet:n operaatioiden aikavaativuus on kuten vastaavilla TreeSet -operaatioilla?
         *      O(6nlogn+4) == O(nlogn)
         */
        public static <E> TraSet<E> kaksiKolmesta(TraSet<E> A, TraSet<E> B, TraSet<E> C) {
            TraSet<E> tulos = new TraSet<>();           //O(1)
            TraSet<E> yhdiste = new TraSet<>(A);        //O(1)
            yhdiste = yhdiste.intersection(B);          //O(nlogn)
            tulos.addAll(yhdiste);                      //O(nlogn)
            yhdiste = new TraSet<>(B);                  //O(1)
            yhdiste = yhdiste.intersection(C);          //O(nlogn)
            tulos.addAll(yhdiste);                      //O(nlogn)
            yhdiste = new TraSet<>(C);                  //O(1)
            yhdiste = yhdiste.intersection(A);          //O(nlobg)
            tulos.addAll(yhdiste);                      //O(nlogn)


            return tulos;

        } // kaksiKolmesta()


    } // class TraI_21_t18