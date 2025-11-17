using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Kotitehtävä_viikko2
{
    class Program
    {
        static void Main(string[] args)
        {
            int iLaskuri1, iLaskuri2 = 10;
            for (iLaskuri1 = 11; iLaskuri1 <= 20; iLaskuri1++)
            {
                
                Console.WriteLine("{0} {1}", iLaskuri1, iLaskuri2);
                iLaskuri2--;
            }




        }
    }
}
