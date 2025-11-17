using System;
using System.Reflection.Metadata.Ecma335;
using System.Security.Cryptography;

namespace Ohjelmointi_II
{
    class ProgramKT2
    {
        public struct Henkilo
        {
            public string etunimi;
            public string sukunimi;
            public double pituus;
            public double paino;
            

        }
        static void LaskePainoindeksi(Henkilo[] taulukko)
            {
                double Keskiarvo = 0.00;
                foreach (Henkilo henkilotiedot  in taulukko)
                {
                    Keskiarvo += (henkilotiedot.paino / (henkilotiedot.pituus * henkilotiedot.pituus));
                }
                Console.WriteLine("Keskimääräinen painoindeksi saaduille tiedoille on {0:f2}",Keskiarvo/taulukko.Length);
            }
        static void Maink2(string[] args)
        {
            /* 2. Tehtävä
            Esittele 10 alkioinen taulukko, jossa henkilötietoja. Yksittäisestä henkilöstä on tietoina 
            - etunimi
            - sukunimi
            - pituus 
            - paino
            Käytä tietuetyyppiä! Tee funktio LaskePainoindeksi, joka saa parametrinaan ko. taulukon 
            ja tulostaa henkilöiden keskimääräisen painoindeksin. Joudut luonnollisesti tekemään pääohjelman, 
            jossa joko kysyt 10 henkilön tiedot tai alustat arvot ohjelman sisällä. Ja painoideksihän lasketaa kaavalla
            bmi = paino (kg) / pituus (m) 2  */

            Henkilo[] Henkilotiedot = new Henkilo[2];
            Henkilo h1;
            for (int i = 0; i < Henkilotiedot.Length; i++)
            {
                
                bool testaa;
                Console.WriteLine("Anna etunimesi:");
                h1.etunimi = Console.ReadLine();
                Console.WriteLine("Anna sukunimesi:");
                h1.sukunimi = Console.ReadLine();
                Console.WriteLine("Anna painosi:");
                testaa = double.TryParse(Console.ReadLine(), out h1.paino);
                while (testaa == false)
                {
                    Console.WriteLine("Annoit painosi väärin\nAnna Painosi:");
                    testaa = double.TryParse(Console.ReadLine(), out h1.paino);
                }
                Console.WriteLine("Anna pituutesi metreinä:");
                testaa = double.TryParse(Console.ReadLine(), out h1.pituus);
                while (testaa == false || h1.pituus == 0 )
                {
                    if (h1.pituus == 0)
                    {
                        Console.WriteLine("Pituus ei voi olla 0\nAnna Pituutesi:");
                        testaa = double.TryParse(Console.ReadLine(), out h1.pituus);
                    }

                    else
                    {
                        Console.WriteLine("Annoit Pituutesi väärin\nAnna Pituutesi:");
                        testaa = double.TryParse(Console.ReadLine(), out h1.pituus);
                    }
                }
                Henkilotiedot[i] = h1;
            
            
            }
            LaskePainoindeksi(Henkilotiedot);
            


        }

    }
}
