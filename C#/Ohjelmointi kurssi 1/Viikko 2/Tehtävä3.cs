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

            Console.Title = "Kotitehtävät 14.09.2020";
            // KOTITEHTÄVÄ 1
            int iArvo, yhteisluku, laskuri;
            Console.WriteLine("Voit lopettaa antamalla luvun -1");
            Console.WriteLine("Anna Luku:");
            iArvo = int.Parse(Console.ReadLine());
            while (iArvo != -1)
            {
                yhteisluku = yhteisluku + iArvo;
                laskuri++
            }

            Console.WriteLine("Antamiesi lukujen keskiarvo oli {0}", yhteisluku / laskuri);
        }
    }
}
