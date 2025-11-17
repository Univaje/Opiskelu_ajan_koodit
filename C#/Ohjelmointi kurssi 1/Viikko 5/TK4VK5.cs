using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace EkaOhjelma_020920
{
    class Program4
    {

        static void Main(string[] args)
        {
            //KT4

            //tee ohjelma, joka tulostaa ensin tiedon siitä, kuinka monta parametria Main-funktioon tuli.
            //Lisäksi jos ensimmäisen parametri oli "opettaja" niin tulosta "Koita saada oppilaat oppimaan",
            //jos se taas oli "opiskelija", niin tulosta "koita opiskella ahkerasti".Jos se oli jotain muuta, 
            //niin tulosta "en ymmärrä"
            Console.WriteLine("Parametrejä ohjelmalla on {0}", args.Length);
            if (args.Length > 0)
            {
                if (args[0] == "oppilas")
                {
                    Console.WriteLine("Koita saada oppilaat oppimaan");
                }
                else if (args[0] == "opettaja" )
                {
                    Console.WriteLine("koita opiskella ahkerasti");
                }
            else
                    Console.WriteLine("En ymmärrä");
            }
            else
                Console.WriteLine("En ymmärrä");

        }
    }


}
