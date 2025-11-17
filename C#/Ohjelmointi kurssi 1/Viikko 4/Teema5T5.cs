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
            double[,] dSade = new double[5, 4];
            double sademaara = 0;

            for (int i = 0; i < dSade.GetLength(0); i++)
            {
                if (i == 0)
                    Console.Write("Maanantain ");
                else if (i == 1)
                    Console.Write("Tiistain ");
                else if (i == 2)
                    Console.Write("Keskiviikon ");
                else if (i == 3)
                    Console.Write("Torstain ");
                else
                    Console.Write("Perjantain ");
                for (int j = 0; j < dSade.GetLength(1); j++)
                {
                    Console.Write("Mittaus numero {0}\n", j + 1);
                    Console.WriteLine("Syötä sademäärä milleinä:");
                    sademaara = double.Parse(Console.ReadLine());
                    dSade[i, j] = sademaara;
                }
                Console.Clear();
                Console.WriteLine("Sademäärä tallennettu.");
            }
            for (int i = 0; i < dSade.GetLength(0); i++)
            {
                sademaara = 0;
                if (i == 0)
                    Console.Write("Naamantai: ");
                else if (i == 1)
                    Console.Write("Tiistai: ");
                else if (i == 2)
                    Console.Write("Keskiviikko: ");
                else if (i == 3)
                    Console.Write("Torstai: ");
                else
                    Console.Write("Perjantai: "); ;
                for (int j = 0; j < dSade.GetLength(1); j++)
                {
                    sademaara = sademaara + dSade[i, j];
                }
                Console.WriteLine("\t{0} mm", sademaara);

            }
        }
    }


}