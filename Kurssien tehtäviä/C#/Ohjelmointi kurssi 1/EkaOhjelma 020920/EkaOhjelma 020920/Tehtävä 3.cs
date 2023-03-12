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
            // KOTITEHTÄVÄ 3

            const int ARVATTAVA_LUKU = 345;
            int syote = 0, laskuri = 0;

            while (syote != ARVATTAVA_LUKU)
            {
                laskuri++;
                Console.WriteLine("arvooppa luku:");
                syote = int.Parse(Console.ReadLine());
                if (syote < ARVATTAVA_LUKU)
                {
                    Console.Clear();
                    Console.WriteLine("Annoit liian pienen luvun");
                }
                else if (syote > ARVATTAVA_LUKU)
                {
                    Console.Clear();
                    Console.WriteLine("Annoit liian suuren luvun");
                }
                else
                {
                    Console.Clear();
                    Console.WriteLine("Oikein, arvasit luvun {0} kerralla", laskuri);
                }
            }
        }
    }


}
