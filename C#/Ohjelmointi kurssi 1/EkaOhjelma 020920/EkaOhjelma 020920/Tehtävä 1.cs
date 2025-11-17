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
            // KOTITEHTÄVÄ 1

            int iArvo = 0, iLaskuri = 0;
            double iYhteisluku = 0;
            while (iArvo != -1)
            {
                Console.WriteLine("Voit lopettaa antamalla luvun -1");
                Console.WriteLine("Anna Luku:");
                iArvo = int.Parse(Console.ReadLine());
                iYhteisluku = iYhteisluku + iArvo;
                iLaskuri++;
                Console.Clear();
            }
            iYhteisluku++;
            iLaskuri--;
            Console.WriteLine("yhteisarvo antamillesi arvoille {0} annettuja arvoja oli yhteensä {1}", iYhteisluku, iLaskuri);
            Console.WriteLine("Antamiesi lukujen keskiarvo oli {0}", iYhteisluku / iLaskuri);

        }
    }


}
