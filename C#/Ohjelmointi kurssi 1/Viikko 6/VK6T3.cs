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

        static void Tallenna(string[] args)
        {
            for (int i = 0; i < args.Length; i++)
            {
                string dir = @"c:\TempCrap\parametrit.txt";
                using (StreamWriter sw1 = new StreamWriter(dir, true))
                {
                    sw1.WriteLine(args[i]);
                }
            }
        }
        static void LueJaTulosta()
        {
            
            string dir = @"c:\TempCrap\parametrit.txt";
            
                using (StreamReader sr1 = new StreamReader(dir, true))
                {
                while (sr1.EndOfStream == false)
                {   
                    Console.WriteLine(sr1.ReadLine());
                }
            }

        }
        static void Main(string[] args)
        {
            //KT3

            //Jos Main-funktioon ei tullut yhtään parameteriä(0 kpl), niin silloin ohjelma päättyy ja tulostuu joku virheilmoitus.
            //Jos Main-funktioon tuli parametreja niin kirjoita tulleet parametrit ”parametrit.txt” tiedostoon allekkain. 
            //Sen jälkeen lue tiedostosta sinne kirjoitetut tiedot rivi kerrallaan ja tulosta näytölle. Käytä funktioita:
            //Tallenna
            //LueJaTulosta

            if (args.Length != 0)
            {
                
                Tallenna(args);
                LueJaTulosta();
            }
            else
                Console.WriteLine("Savolainen supersankari kylässä!");
        }
    }


}
