using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Testing_ground
{
    class Program
    {
        const int KR_PISTE = 90;
        //Ohjelma kysyy hypyn pituuden(liukuluku 0.5 metrin välein) 
        static void KysyHypynPituus(out double hPituus)
        {
            Console.WriteLine("Anna hypyn pituus 0,5 metrin tarkkuudella:");
            string Input = Console.ReadLine();
            bool testaa = double.TryParse(Input, out hPituus);
            hPituus = (Math.Round(hPituus * 2, MidpointRounding.AwayFromZero) / 2);
            while (testaa == false)
            {
                Console.Clear();
                Console.WriteLine("{0} ei ole sovelias pituus\nAnna arvosana:", Input);
                testaa = double.TryParse(Console.ReadLine(), out hPituus);
            }
        }
        //viiden arvostelutuomarin tyylipisteet
        //(0 - 20 välillä 0.5 välein eli esim. 16.5 tai 17.0 tai 18.5).
        static void KysyTuomareidenPisteet(ref double[] tPisteet)
        {
            double max = double.MinValue;
            double min = double.MaxValue;
            for (int i = 0; i < 5; i++)
            {

                double thisfuckingworks;
                Console.Clear();
                Console.WriteLine("Anna {0} tuomarin arvosana(0-20) 0,5 pisteen tarkkuudella:", i + 1);
                string Input = Console.ReadLine();
                bool testaa = double.TryParse(Input, out thisfuckingworks);
                thisfuckingworks = (Math.Round(thisfuckingworks * 2, MidpointRounding.AwayFromZero) / 2);
                while (testaa == false && thisfuckingworks < 0 || thisfuckingworks > 20 || Input == "")
                {
                    Console.Clear();
                    Console.WriteLine("!{0}! Ei ole sovelias arvosana\nAnna arvosana:", Input);
                    testaa = double.TryParse(Console.ReadLine(), out thisfuckingworks);
                }
                if (thisfuckingworks < min)
                    min = thisfuckingworks;
                else if (thisfuckingworks > max)
                    max = thisfuckingworks;

                tPisteet[i] = thisfuckingworks;

            }
            for (int j = 0; j < tPisteet.Length; j++)
            {
                if (tPisteet[j] == min)
                    tPisteet[j] = 0;
                else if (tPisteet[j] == max)
                    tPisteet[j] = 0;
            }
        }
        //pisteet = (hypyn pituus - kriittinen piste) *1.8 + kolmen keskimmäisen tuomarin tyylipisteet + 60.
        static void LaskeHypynPisteet(double hPituus, double[] tPisteet, out double hPisteet)
        {
            hPisteet = (hPituus - KR_PISTE) * 1.8;
            for (int i = 0; i < tPisteet.Length; i++)
            {
                hPisteet += tPisteet[i];
            }
            hPisteet += 60;
        }
        ////Tulosta lopuksi hypyn pituus ja hypyn pisteet.
        static void Tulosta(double hPituus, double hPisteet)
        {
            Console.WriteLine("Hypyn pituus oli {0} ja pisteet {1}", hPituus, hPisteet);
        }
        static void Main(string[] args)
        {

            //KT3
            //Tee ohjelma, joka laskee mäkihyppääjän yhden kierroksen suorituspisteet.
            //Ohjelma kysyy hypyn pituuden(liukuluku 0.5 metrin välein) sekä viiden arvostelutuomarin tyylipisteet
            //(0 - 20 välillä 0.5 välein eli esim. 16.5 tai 17.0 tai 18.5). Hyppääjän pisteet muodostuvat kaavasta.
            //pisteet = (hypyn pituus - kriittinen piste) *1.8 + kolmen keskimmäisen tuomarin tyylipisteet + 60.

            //Tyylipisteissä siis parhain ja huonoin pistemäärä tipahtaa pois.
            //Ohjelman hyppyrimäen kriittinen piste on 90 metrin kohdalla. Laita kriittinen piste vakioon KR_PISTE.
            //Tulosta lopuksi hypyn pituus ja hypyn pisteet.
            //Käytä ohjelmassa funktioita(funktiot eivät saa palauttaa mitään):


            //KysyHypynPituus
            //KysyTuomareidenPisteet
            //LaskeHypynPisteet
            //Tulosta
            double hPituus, hPisteet;
            double[] tPisteet5 = new double[5];

            KysyHypynPituus(out hPituus);
            KysyTuomareidenPisteet(ref tPisteet5);
            LaskeHypynPisteet(hPituus, tPisteet5, out hPisteet);
            Tulosta(hPituus, hPisteet);
        }
    }
}
