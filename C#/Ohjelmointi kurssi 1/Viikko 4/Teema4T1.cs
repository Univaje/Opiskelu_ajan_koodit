using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.ExceptionServices;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace EkaOhjelma_020920
{
    class Program
    {

        static void Main(string[] args)
        {
            ///////////Tehtävä 1

            double[] dTaulu = new double[3];
            Console.WriteLine("Syötä taulukkoon luku:");
            double summa = 0;
            for (int i = 0; i < dTaulu.Length; i++)
            {
                dTaulu[i] = double.Parse(Console.ReadLine());
                summa += dTaulu[i];
            }

            Console.WriteLine("Syötettyjen lukujen lukujen summa on: {0:f2}", summa);
            Console.WriteLine("keskiarvo on {0:f2}", dTaulu.Average());
        }
    }


}
