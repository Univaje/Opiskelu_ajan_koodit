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
            int iluku;
            int iluku2;
            Console.WriteLine("Anna luku:");
            iluku = int.Parse(Console.ReadLine());
            if (iluku <= 20) 
            Console.WriteLine("Luku on aika pieni");
            Console.WriteLine("Luku on aika iso");

            Console.WriteLine("Anna toinen luku");
            iluku2 = int.Parse(Console.ReadLine());
            if (iluku2 % 2 == 0)
            { 
                Console.WriteLine("Luku on parillinen");
            }
            else
            {
                Console.WriteLine("Luku on pariton");
            }
            int arvosana;
            Console.WriteLine("anna arvosana 4-10 väliltä:");
            arvosana = int.Parse(Console.ReadLine());
            if (arvosana >= 4 && arvosana <= 10) 
            { 
                Console.WriteLine("annoit arvosanan "+ arvosana );
            }
            else
            {
                Console.WriteLine("Arvosanan tulisi olla 4-10 väliltä");
            }
            int ika;

            Console.WriteLine("anna ikäsi");
            ika = int.Parse(Console.ReadLine());
            if (ika < 6)
            {
                Console.WriteLine("OLETPAS SINÄ NUORI JA TERÄVÄ");
            }
            else if (ika > 6 && ika < 80)
            {
                Console.WriteLine("SUJUUHAN SE OHJELMOINTI SINULTAKIN");
            }
            else
            {
                Console.WriteLine("OLET IKÄÄSI NÄHDEN TAITAVA OHJELMOIJA");
            }

        }
    }
}
