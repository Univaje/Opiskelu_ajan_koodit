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
            ////////KOTITEHTÄVÄ 5

            char kirjain = 'a';
            int kirjainavro = 0;
            Console.WriteLine("Anna kirjain:");

            while (kirjain != '\r')
            {
                kirjain = Console.ReadKey(true).KeyChar;
                kirjainavro = (int)kirjain;

                if (kirjain == '\r')
                    Console.WriteLine("\r------End------");
                else if (kirjainavro > 64 && kirjainavro <= 90)
                {
                    kirjainavro = kirjainavro + 32;
                    kirjain = (char)kirjainavro;
                    Console.Write(kirjain);
                }
                else if (kirjainavro > 95 && kirjainavro < 122)
                {
                    kirjainavro = kirjainavro - 32;
                    kirjain = (char)kirjainavro;
                    Console.Write(kirjain);
                }
                else
                {
                    Console.Clear();
                    Console.WriteLine("eipä ollut kirjain");
                    Console.WriteLine("Anna kirjain:");
                }
            }
        }
    }


}
