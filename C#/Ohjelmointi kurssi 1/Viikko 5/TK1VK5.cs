using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace EkaOhjelma_020920
{
    class Program1
    {
        static void KysyJaTestaaLuku(out int iluku)
        {
            bool onnaa;
                Console.WriteLine("Anna luku:");
            onnaa=int.TryParse(Console.ReadLine(),out iluku);
            while (onnaa == false)
            {
                Console.Clear();
                Console.WriteLine("et antanut lukua!\nAnna luku:");
                onnaa = int.TryParse(Console.ReadLine(), out iluku);

            }
            if (iluku < 0)
                iluku = -1;
            else if (iluku == 0)
                iluku = 0;
            else
                iluku = 1;
        }
           
    

        static void Main(string[] args)
        {
            //KT1
            //Tee ohjelma, jossa kysytään KysyJaTestaaLuku() nimisessä funktiossa  käyttäjältä kokonaisluku. 
            //Funktio palauttaa kokonaislukuarvon seuraavasti:

            //1, jos syötetty luku on positiivinen.
            //0, jos syötetty luku on nolla.
            //-1, jos syötetty luku on negatiivinen.

            //Tulosta näiden paluuarvojen perusteella Mainissa ilmoitus ruudulle.

            //”Luku oli positiivinen”, jos paluuarvo oli 1.
            //”Luku oli nolla”, jos paluuarvo oli 0
            //”Luku oli negatiivinen”, jos paluuarvo oli - 1.

            //Käyttäkää Mainissa switch-case -rakennetta

            int iluku;
            KysyJaTestaaLuku(out iluku);
            switch (iluku)
            {
                case -1:
                    Console.WriteLine("Luku oli negatiivinen");
                    break;
                case 0:
                    Console.WriteLine("Luku oli nolla");
                    break;
                case 1:
                    Console.WriteLine("Luku oli positiivinen");
                    break;
            }
        }
    }


}
