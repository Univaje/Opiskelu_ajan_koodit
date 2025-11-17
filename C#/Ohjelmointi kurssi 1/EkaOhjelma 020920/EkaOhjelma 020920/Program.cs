using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EkaOhjelma_020920
{
    class Program
    {
        static void Main(string[] args)
        {

            //koodattiin teksti terve maailma ihan vaan testatakseen toimiiko ympäristö
            //samasta syystä kirjoitan myös kommentteja muistutukseksi että näitäkin on hyvä kirjoittaa
            //kommentit vain koodareille yksi rivinen.. vihreä kertoo sen olevan kommentti
            /* tämä on usemmalle riville tarkoitettu kommentointi tapa
             * 
             */

            Console.WriteLine("Screw you World!");
            Console.WriteLine("Are you dead yet?");
            
            // käsitellään muuttujia ohjelman ajaksi tallennukseen se tallenetaan tiedostoon

            int Luku;

            //Luvulle annetaan arvo
            // 

            Luku = 2;

            //tulostetaan arvo

            Console.WriteLine("Luvun arvo on " + Luku);

            //Yhteenlaskua

            int summa;
            int toinenluku = 10;
            int ekaluku = 2;

            Console.WriteLine("ekaluku on " + ekaluku);
            Console.WriteLine("ekaluku on " + toinenluku);

            summa = toinenluku + ekaluku;

            Console.WriteLine("Summa = " + summa);

            // Byte on 8bittinen positiivinen luku 0-255

            byte lukuja;

            //desimaaliluvuille tarkoitettu on double

            Double desimaali;
            
            //char komento on yhtä kirjainta varten

            Char A;
                
            string ika;
            ika = Console.ReadLine();




        }
    }
}
