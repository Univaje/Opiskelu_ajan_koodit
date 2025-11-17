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
            ///////////Tehtävä 4


            int[] Lotto = new int[8];
            Random rng = new Random();
            int i, j, lisanumero, Crap;

            for (i = 0; i < Lotto.Length; i++)
            {
                Crap = rng.Next(1, 41);//Lotto tekee joka soluun luvun väliltä välillä 1-40
                for (j = 0; j < i - 1; j++)
                {
                    if (Lotto.Contains(Crap))
                    {
                        Crap = rng.Next(1, 41);
                    }

                }
                Lotto[i] = Crap;
            }
            lisanumero = Lotto[7];
            Lotto[7] = 41;
            Array.Sort(Lotto);
            Console.WriteLine("Lottonumerot ovat:");
            for (i = 0; i < Lotto.Length; i++)
            {
                Console.Write("{0} ", Lotto[i]);

            }
            Lotto[7] = lisanumero;
            Console.Write("+ " + lisanumero);
            Console.WriteLine();
        }
    }


}