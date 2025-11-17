using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.ExceptionServices;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace EkaOhjelma_020920
{
    class Program
    {

        static void Main(string[] args)
        {
            ///////////Tehtävä 3


            string sTeksti, steksti2, valiton;
            string reverse = "";
            char crap;
            Console.WriteLine("Anna teksti:");
            sTeksti = Console.ReadLine();
            steksti2 = sTeksti.ToUpper();
            Console.WriteLine("Caps mode:\n" + steksti2);
            Console.WriteLine("A = !");
            foreach (char item in sTeksti)
            {
                crap = item;
                if (item == 'A')
                    crap = '!';
                Console.Write(crap);
            }
            Console.WriteLine();
            valiton = sTeksti.Replace(" ", "");
            Console.WriteLine("ilman välejä \n" + valiton);
            for (int i = sTeksti.Length - 1; i >= 0; i--)
            {
                reverse = reverse + " " + sTeksti[i];
            }

            Console.WriteLine("Tekstisi käännettynä\n" + reverse);

        }
    }


}