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
            ///////KOTITEHTÄVÄ4
            

            /////for lauseella
            int iPienirvo, iSuurirvo, iAskellin;
            for (iPienirvo = 1, iSuurirvo = 0, iAskellin = 0; iPienirvo > iSuurirvo || iAskellin == 0;)
            {
                Console.WriteLine("Syötä alkuluku josta tulostetaan:");
                iPienirvo = int.Parse(Console.ReadLine());
                Console.WriteLine("Syötä viimeinen luku joka tulostetaan:");
                iSuurirvo = int.Parse(Console.ReadLine());
                Console.WriteLine("Syötä askellus väli:");
                iAskellin = int.Parse(Console.ReadLine());
                Console.Clear();
            }
            for (; iPienirvo <= iSuurirvo; iPienirvo = iPienirvo + iAskellin)
            {
                Console.WriteLine(iPienirvo);

            }


            ///// While lauseella
            int iPienirvo = 0, iSuurirvo = 0, iAskellin = 0;
            while (iPienirvo > iSuurirvo || iAskellin == 0)
            {
                Console.WriteLine("Syötä alkuluku josta tulostetaan:");
                iPienirvo = int.Parse(Console.ReadLine());
                Console.WriteLine("Syötä viimeinen luku joka tulostetaan:");
                iSuurirvo = int.Parse(Console.ReadLine());
                Console.WriteLine("Syötä askellus väli:");
                iAskellin = int.Parse(Console.ReadLine());
                Console.Clear();
            }
            while (iPienirvo <= iSuurirvo)
            {
                Console.WriteLine(iPienirvo);
                iPienirvo = iPienirvo + iAskellin;
            }

            int iPienirvo = 0, iSuurirvo = 0, iAskellin = 0;



            /////do - while lauseella
            do
            {
                Console.WriteLine("Syötä alkuluku josta tulostetaan:");
                iPienirvo = int.Parse(Console.ReadLine());
                Console.WriteLine("Syötä viimeinen luku joka tulostetaan:");
                iSuurirvo = int.Parse(Console.ReadLine());
                Console.WriteLine("Syötä askellus väli:");
                iAskellin = int.Parse(Console.ReadLine());
                Console.Clear();
            } while (iPienirvo > iSuurirvo || iAskellin == 0);

            do

            {
                Console.WriteLine(iPienirvo);
                iPienirvo = iPienirvo + iAskellin;
            } while (iPienirvo <= iSuurirvo);
        }
    }


}
