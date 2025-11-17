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
            ///////////Tehtävä 2

            int[] paritaulu = new int[10];
            Random rng = new Random();
            for (int i = 0; i < paritaulu.Length; i++)
            {
                paritaulu[i] = rng.Next(11);
                for (int j = 0; j < paritaulu.Length; j++)
                {
                    if (paritaulu[i] % 2 != 0)
                        paritaulu[i] = rng.Next(11);
                }
            }
            for (int i = 0; i < paritaulu.Length; i++)
            {
                Console.Write("{0}\t", paritaulu[i]);
            }
        }
    }


}