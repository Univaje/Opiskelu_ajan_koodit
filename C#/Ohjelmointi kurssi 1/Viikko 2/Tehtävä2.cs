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

            //KOTITEHTÄVÄ 2

            Console.WriteLine("Moneske kuukausi nyt on?");
            switch (int.Parse(Console.ReadLine()))
            {


                case 2:
                case 3:
                case 4:
                    Console.WriteLine("On kevät");
                    break;
                case 5:
                case 6:
                case 7:
                    Console.WriteLine("On kesä");
                    break;
                case 8:
                case 9:
                case 10:
                    Console.WriteLine("On syksy");
                    break;
                case 1:
                case 11:
                case 12:
                    Console.WriteLine("On tavi");
                    break;
                default:
                    Console.WriteLine("Tuo ei ole kuukausi");
                    break;



            }
        }
    }
}
