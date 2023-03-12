using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace EkaOhjelma_020920
{

    class Program5
    {
        static void LuoTaulukko(out float[] fTaulu)
        {
         fTaulu = new float[7];
        }
        static void KysyArvotTaulukkoon(ref float[] fTaulu)
        {
            for (int i = 0; i < fTaulu.Length; i++)
            {
                Console.Clear();
                float tulos;
                Console.WriteLine("Anna float luku:");
                String input = Console.ReadLine();
                bool Tosi = float.TryParse(input, out tulos);
                while (Tosi == false  || input == "")
                {
                    Console.Clear();
                    Console.WriteLine("Syöttämäsi: {0} ei ollut oikeanlainen luku! \nAnna uusi luku:",input);
                    input = Console.ReadLine();
                    Tosi = float.TryParse(input, out tulos);
                }
                fTaulu[i] = tulos;
            }
        }
        static void LajitteleTaulukko(ref float[] fTaulu)
        {
            Array.Sort(fTaulu);
            
        }
        static void TulostaTiedot(float[] fTaulu)
        {
            Console.Clear();
            Console.WriteLine("Taulun maksimi:{0}\nTaulun minimi: {1}",fTaulu[0],fTaulu[6]);
        }
        static int KysyLuku()
        {
            Console.Write("Anna luku : ");
            return int.Parse(Console.ReadLine());
        }
        static void Main(string[] args)
        {
            iluku = KysyLuku();
            Console.WriteLine(iluku);
            //Luo 7 alkioinen float-taulukko ja lue siihen käyttäjältä arvoja.Kun käyttäjä syöttää arvoa taulukkoon, 
            //niin ohjelma ei saa kaatua vaan väärä arvo on kysyttävä uudestaan.Lajittele taulukko ja tulosta taulukon 
            //minimi-ja maksimiarvot.Käytä funktioita:

            //LuoTaulukko
            //KysyArvotTaulukkoon
            //LajitteleTaulukko
            //TulostaTiedot

            float[] fTaulu;
            LuoTaulukko(out fTaulu);
            KysyArvotTaulukkoon(ref fTaulu);
            LajitteleTaulukko(ref fTaulu);
            TulostaTiedot(fTaulu);
        }
    }


}
