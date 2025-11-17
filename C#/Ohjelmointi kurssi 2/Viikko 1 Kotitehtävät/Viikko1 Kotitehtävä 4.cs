using System;
using System.Reflection.Metadata.Ecma335;
using System.Security.Cryptography;

namespace Ohjelmointi_II
{
    class Programk4
    {
        class Omistaja
        {
            public string etunimi;
            public string sukunimi;
            public string hetu;
            public string Osoite;
            public string Postinro;
            public string ptm;

            public void KysyOmistajaTiedot()
            {
                Console.WriteLine("Anna etunimesi:");
                etunimi = Console.ReadLine();
                Console.WriteLine("Anna sukunimesi:");
                sukunimi = Console.ReadLine();
                Console.WriteLine("Anna hetu:");
                hetu = Console.ReadLine();
            }
            public void Tulosta()
            {
                Console.WriteLine(etunimi);
                Console.WriteLine(sukunimi);
                Console.WriteLine(hetu);
            }
        }
        class Auto
        {
            public string merkki;
            public string malli;
            public string tyyppi;
            public int vuosimalli;
            public string rekisterinro;
            public Omistaja omistaja;

            public void KysyTiedot()
            {
                bool testaa;
                Console.WriteLine("Anna Autosi merkki:");
                merkki = Console.ReadLine();
                Console.WriteLine("Anna Autosi malli:");
                malli = Console.ReadLine();
                Console.WriteLine("Anna Autosi tyyppi:");
                tyyppi = Console.ReadLine();
                Console.WriteLine("Anna Autosi vuosimalli:");
                testaa = int.TryParse(Console.ReadLine(), out vuosimalli);
                while (testaa == false)
                {
                    Console.WriteLine("Et antanut vuosimallia oikein\nAnna Autosi vuosimalli:");
                    testaa = int.TryParse(Console.ReadLine(), out vuosimalli);
                }
                Console.WriteLine("Anna Autosi rekisterinumero:");
                rekisterinro = Console.ReadLine();
                omistaja = new Omistaja();
                omistaja.KysyOmistajaTiedot();

            }
            public void Tulosta()
            {
                Console.WriteLine(merkki);
                Console.WriteLine(malli);
                Console.WriteLine(tyyppi);
                Console.WriteLine(vuosimalli);
                Console.WriteLine(rekisterinro);
                Console.WriteLine(merkki);
                omistaja.Tulosta();
            }
        }




        static void Maink4(string[] args)
        {
            /*4. Tehtävä
            Esittele seuraavat luokat
            Yksittäisestä autosta on tietoina 
            - merkki
            - malli
            - tyyppi
            - vuosimalli
            - rekisterinro
            - omistaja
            Yksittäisestä omistajasta on tietoina
            - etunimi
            - sukunimi
            - hetu
            Käytä siis luokkia sekä autolle että omistajalle! Tee funktiot kysytiedot() molemmille luokille. 
            Ko funktio siis kysyy luokan jäsenmuuttujiin arvot. Huomaa, että auton omistajatietojen kohdalla 
            pitää kutsua omistaja-luokan kysytiedot() -funktioita.  */
            Auto Autosi = new Auto();
            Omistaja omistaja = new Omistaja();
            Autosi.KysyTiedot();
            Autosi.Tulosta();

        }
    }
}