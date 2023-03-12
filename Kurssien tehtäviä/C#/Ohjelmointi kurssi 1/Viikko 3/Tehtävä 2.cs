using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace EkaOhjelma_020920
{
    class Program
    {

        static void Main(string[] args)
        {
            Console.Title = "Kotitehtävät 14.09.2020";
            // KOTITEHTÄVÄ 2
            int iLaskuri1, iLaskuri2 = 10;
            for (iLaskuri1 = 11; iLaskuri1 <= 20; iLaskuri1++)
            {
                Console.WriteLine("{0} {1}", iLaskuri1, iLaskuri2);
                iLaskuri2--;
            }
        }
    }

}
