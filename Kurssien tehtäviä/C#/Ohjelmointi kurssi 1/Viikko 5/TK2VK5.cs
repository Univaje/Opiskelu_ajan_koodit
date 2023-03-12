using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace EkaOhjelma_020920
{
    class Program2
    {
        static Random Rng = new Random();
        static void KysyKoko(out int tKoko)
        {
            Console.WriteLine("Anna taulukon koko:");
            string Input = Console.ReadLine();
            bool testaa = int.TryParse(Input, out tKoko);
            while (testaa == false)
            {
                Console.WriteLine("{0} ei ole sovelias koko",Input);
                testaa = int.TryParse(Console.ReadLine(), out tKoko);
            }
        }
        static void LuoTaulukko(out int[] ArvoTaulu,int tkoko) 
        {
            ArvoTaulu = new int[tkoko];
        }
        static void ArvoArvosanat(ref int[] ArvoTaulu) 
        {
            for (int i = 0; i < ArvoTaulu.Length; i++)
            {
                ArvoTaulu[i] = Rng.Next(6);
            }
        }
        static void TutkiHylatyt(int[] ArvoTaulu,out int hylatut) 
        {
            hylatut = 0;
            for (int i = 0; i < ArvoTaulu.Length; i++)
            {
                if (ArvoTaulu[i] == 0)
                    hylatut += 1;
            }
        }
        static void Tulosta(int tkoko, int hylatut) 
        {
            Console.WriteLine("Taulukon koko oli: "+tkoko);
            Console.WriteLine("Hylättyjä oli: " + hylatut);
        }
        static void Main(string[] args)
        {
            //KT2
            //Kysy käyttäjältä kuinka iso taulukko luodaan.Luo taulukko ja arvo siihen arvosanoja väliltä 0 - 5.
            //Tutki kuinka moni sai hylätyn arvosanan eli arvosanan 0.Tulosta määrä näytölle. 
            //Käytä ohjelmassa seuraavia funktioita:


            //KysyKoko
            //LuoTaulukko
            //ArvoArvosanat
            //TutkiHylatyt
            //Tulosta

            int tkoko, hylatut;
            int[] ArvoTaulu;

            KysyKoko(out tkoko);
            LuoTaulukko(out ArvoTaulu,tkoko);
            ArvoArvosanat(ref ArvoTaulu);
            TutkiHylatyt(ArvoTaulu, out hylatut);
            Tulosta(tkoko, hylatut);
        }
    }


}
