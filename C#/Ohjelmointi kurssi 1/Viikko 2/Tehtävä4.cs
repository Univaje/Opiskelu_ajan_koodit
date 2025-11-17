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

            //KOTITEHTÄVÄ 4

            string muuttuja;
            int lukuarvo, lukuarvo1;
            Console.WriteLine("Anna ensimmäinen luku:");
            lukuarvo = int.Parse(Console.ReadLine());
            Console.WriteLine("Anna toinen luku:");
            lukuarvo1 = int.Parse(Console.ReadLine());
            Console.WriteLine("+, -, * vai /:");
            muuttuja = Console.ReadLine();

            switch (char.Parse(muuttuja))
            {
                case '+':
                    Console.WriteLine("Lukujen {0} ja {1} summa on {2}", lukuarvo, lukuarvo1, lukuarvo + lukuarvo1);
                    break;
                case '-':
                    Console.WriteLine("Lukujen {0} ja {1} erotus on {2}", lukuarvo, lukuarvo1, lukuarvo - lukuarvo1);
                    break;
                case '*':
                    Console.WriteLine("Lukujen {0} ja {1} tulo on {2}", lukuarvo, lukuarvo1, lukuarvo * lukuarvo1);
                    break;
                case '/':
                    if (lukuarvo == 0 || lukuarvo1 == 0)
                        Console.WriteLine("Nolla jakoa ei saa olla!");
                    else
                        Console.WriteLine("Lukujen {0} ja {1} jakojäännös on {2}", lukuarvo, lukuarvo1, lukuarvo / lukuarvo1);
                    break;
                default:
                    Console.WriteLine("Virheellinen lasku tyypin valinta!");
                    break;




            }





        }
    }
}
