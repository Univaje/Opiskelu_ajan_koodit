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

            Console.Title = "Kotitehtävät 07.09.2020";
            //KOTITEHTÄVÄ 1

            const int RAJA = 8;
            int arvosana;
            Console.WriteLine("Anna kokeesi numero:");
            arvosana = int.Parse(Console.ReadLine());
            if (arvosana == 9 || arvosana == 10)
                Console.WriteLine("Hyvä");
            else if (arvosana == RAJA || arvosana == RAJA - 1)
                Console.WriteLine("Kelpo");
            else if (arvosana == RAJA - 2 || arvosana == RAJA - 3)
                Console.WriteLine("Tyydyttävä");
            else if (arvosana == RAJA - 4)
                Console.WriteLine("Heikko");
            else
                Console.WriteLine("Et antanut arvosanaa annetulla väliltä");





        }
    }
}
