using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices;
using System.Runtime.Remoting.Messaging;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Xml.Schema;

namespace EkaOhjelma_020920
{
    class Program
    {
        static void ArvoJaTallennaTiedostoon()
        {
            string dir = @"c:\TempCrap\Crap.txt"; 
            Random rng = new Random();
            for (int i = 0; i < 40; i++)
            {

                float data1 = rng.Next(14, 59);
                float data = data1 / 10.00f;
                using (StreamWriter sw1 = new StreamWriter(dir, true))
                {
                    sw1.WriteLine(data);
                }
            }
        }
        static void LueTiedostosta(out double[] dtaulukko)
        {
            string dir = @"c:\TempCrap\Crap.txt";
            dtaulukko = new double[40];
            using (StreamReader sw2 = new StreamReader(dir))
            {
                for (int i = 0; i < dtaulukko.Length; i++)
                {
                    double dataslate = double.Parse(sw2.ReadLine());
                    dtaulukko[i] = dataslate;
                }
            }
        }
        static void TulostaTiedot(double[] dtaulukko)
        {
            
            Console.WriteLine(dtaulukko.Max());
            Console.WriteLine(dtaulukko.Min());
            Console.WriteLine(dtaulukko.Average());
            Console.WriteLine(dtaulukko.Sum());
        }
        static void Main(string[] args)
        {
            //KT2
            //Arvo 40 kpl liukulukuja väliltä 1.4 – 5.8 ja kirjoita ne datat.txt tiedostoon allekkain.
            //Älä käytä taulukkoa tässä vaiheessa.Sen jälkeen luo 40 alkioinen double-taulukko ja lue
            //arvot tiedostosta taulukkoon.Tämän jälkeen tulosta taulukon lukujen summa, keskiarvo, minimiarvo ja maksimiarvo. 
            //Käytä funktioita:
            //ArvoJaTallennaTiedostoon
            //LueTiedostosta
            //TulostaTiedot
            ArvoJaTallennaTiedostoon();
            double[] dtaulukko;
            LueTiedostosta(out dtaulukko);
            TulostaTiedot(dtaulukko);
            
        }
    }


}
