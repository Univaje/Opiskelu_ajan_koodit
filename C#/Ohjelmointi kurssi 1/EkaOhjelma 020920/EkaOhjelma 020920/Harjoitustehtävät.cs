using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace EkaOhjelma_020920
{
    class Program
    {
        static void Main(string[] args)
        {
            // HARJOITUS TEHTÄVÄT MUUTTUJA TEHTÄVÄ 1 JA 2


            /* String komennossa saa olla mitä kirjaimia vain. Esimerkin vuoksi string arvo on kirjoitettu samalle riville
             * eikä erikseen niinkuin muissa esimerkeissä
             */
            String Nimi = "Sam";
            // int arvoa käytetty koska tarvitaan jo 5numeroa käyttöön. esimerkin vuoksi arvo on annettu eri rivillä.
            int postinumerosi;
            postinumerosi = 70000;
            // muistutukseksi laitettu byte arvolla joka käsittää arvot 0-255
            byte ikäsi;
            ikäsi = 10;
            //Char komennon esimerkki. vain yksi kirjain   
            Char lempikirjain;
            lempikirjain = 'G';
            // mahtaakohan väriä pystyä erikseen printtaamaan?
            String lempiväri;
            lempiväri = "liila";
            // käytettävä long komentoa koska numeroita on jo 13 kappaletta
            long puhelinnro = +35850123456;
            //dounle komennon esimerkki /tulostaako 3lukua desimaalin jälkeen?
            double hiuksenhalkaisija;
            hiuksenhalkaisija = 0.017;
            // float komento. saa nähdä osaanko käyttää
            float tilinsaldo = 13.46F;
            // Tämä on ehkä vielä mysteeri itselle
            Boolean yes = true, no = false ;

            Console.WriteLine("Tunnenko sinut? mahtaako sinun nimesi olla {0} ikäsi {1}. Puhelin numerosi pitäisi olla {2}?", Nimi, ikäsi, puhelinnro);
            Console.WriteLine("Kun kerta näin on niin tiedän Lempivärisi on {0}, Lempikirjain {1}.", lempiväri, lempikirjain);
            Console.WriteLine("Pelottavampaa tietoa on pankkitilisi saldo {0} ja hiuksen halkaisija {1:F2}\n" , tilinsaldo , hiuksenhalkaisija );
            
            
            
            //TEHTÄVÄ 3
            
            // Char komennolla saa Annettua vaaditun arvon A
            Char arvo = 'A';
            // Pidempi lause vaatii string komennon
            String lause = "Ohjelmointi on nastaa";
            // kun luvussa on desimaaleja niin tarvitaan joko dounle tai float
            Double desimaali = 12.786;
            // kokonaislukuun riittää int
            int luku = 144;
            Console.WriteLine("tulostettuna nämä arvot ovat " +arvo + " " +lause + " " +desimaali + " " +luku );


            //HARJOITUS TEHTÄVÄ TULOSTAMINEN
            //TEHTÄVÄ 1

            String kurssi;
            int Arvosana;
            kurssi = "Ohjelmoinnin perusteet";
            Arvosana = 5;

            Console.WriteLine("Olet kurssilla {0} ja saat arvosanan {1}", kurssi, Arvosana);
            Console.WriteLine("Olet kurssilla " + kurssi + " ja saat arvosanan " +Arvosana);

            // TEHTÄVÄ 2

            Double dSaldo = 12.45;
            float fPituus = 1.81F;

            Console.WriteLine("Tilisi saldo on {0} ja olet {1} metriä pitkä", dSaldo , fPituus );

            //TEHTÄVÄ 3

            String kokonimi = "Sami Lahti";
            int Syntymävuosi = 1971;
            Console.WriteLine("{0}, ja olet muuten {1} Vuotta",kokonimi, 2020 - Syntymävuosi );

            //TEHTÄVÄ 4

            String nimi;
            String asuinpaikka;
            String numero;
            nimi = "Sampo Kajaste";
            asuinpaikka = "Kuopio";
            numero = "+358501234567";

            Console.Write("{0}\n{1}\n{2}\n",nimi , asuinpaikka , numero );

            //TEHTÄVÄ 5

            String puh = "+358501234567";
            int kenkä = 43;

            Console.WriteLine("Sinun puhelinnumerosi on {0} ja kengän kokosi on muuten {1}", puh , kenkä);
            Console.WriteLine("Sinun puhelinnumerosi on " + puh + " ja kengän kokosi on muuten " +kenkä);

            //TEHTÄVÄ 6

            int Luku1 = 999;
            int luku2 = 341;
            int miinus = Luku1 - luku2;

            Console.WriteLine("lukujen " + Luku1 + " ja " + luku2 + " Erotus on " + miinus);
            Console.Write("lukujen {0} ja {1} Erotus on {2}\n",Luku1 ,luku2 , Luku1 - luku2 );

            //LUKEMINEN


            //Tehtävä 1

            float arvo1;
            String arvo2;
            Char arvo3;

            Console.WriteLine("Anna Desimaali luku");
            arvo1 = float.Parse(Console.ReadLine());
            Console.WriteLine("Anna Teksti ");
            arvo2 = Console.ReadLine();
            Console.WriteLine("Anna Kirjain luku");
            arvo3 = Char.Parse(Console.ReadLine());

            Console.Write("Annoit Luvun {0}\nTekstin: {1} \nja kirjaimen {2}\n", arvo1 , arvo2 , arvo3 );

            //TEHTÄVÄ 2

            String NIMESI;
            String OSOITTEESI;
            String POSTINUMEROSI;
            Console.WriteLine("Anna Nimesi");
            NIMESI = Console.ReadLine();
            Console.WriteLine("Anna Osoitteesi ");
            OSOITTEESI = Console.ReadLine();
            Console.WriteLine("Anna Postinumerosi");
            POSTINUMEROSI = Console.ReadLine();

            Console.Write("{0}\n{1}\n{2}\n", NIMESI , OSOITTEESI , POSTINUMEROSI );

            //TEHTÄVÄ 3
            String syote;
            int Yksi;
            int kaksi;

            Console.Write("Anna Ensimmäinen luku:");
            syote =Console.ReadLine();
            Yksi = int.Parse(syote);
            Console.Write("Anna Toinen luku :");
            syote = Console.ReadLine();
            kaksi = int.Parse(syote);
            Console.Write("\nAntamiesi lukujen summa on: {0}!\n", Yksi + kaksi );

        }
    }
}
