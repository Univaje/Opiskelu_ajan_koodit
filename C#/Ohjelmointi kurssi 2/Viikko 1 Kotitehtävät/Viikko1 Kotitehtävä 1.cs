using System;
using System.Reflection.Metadata.Ecma335;

namespace Ohjelmointi_II
{
    class ProgramKT1
    {
        public struct Laske
        {
            public int Matka;
            public int polttoaine;

        }
        static void Maink1(string[] args)
        {
            /* 1. Tehtävä
             * Esittele tietue (struct), jolla on kaksi kokonaislukuarvoa. Toinen niistä on kuljettu matka (km)
             * ja toinen on kulutettu polttoainemäärä (l). Esittele tietueesta muuttuja ja kysy käyttäjältä arvot 
             * tietueen muuttujiin. Tulosta polttoaineen kulutus (litraa/100km) siten, että käytät tietueeseen tallennettuja 
             * arvoja  */


            Laske H;
            Console.WriteLine("Anna kuljettu matka:");
            int.TryParse(Console.ReadLine(), out H.Matka);
            Console.WriteLine("Anna kulutettu polttoaine:");
            int.TryParse(Console.ReadLine(), out H.polttoaine);
            double summa = H.polttoaine / H.Matka * 100;
            Console.WriteLine("Kulutus kuljetulle matkalle {0} ja bensamäärälle {1} on {2}", H.Matka, H.polttoaine, summa);




        }

    }
}
