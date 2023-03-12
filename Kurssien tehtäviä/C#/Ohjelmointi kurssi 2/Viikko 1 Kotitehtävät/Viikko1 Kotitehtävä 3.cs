using System;
using System.Reflection.Metadata.Ecma335;
using System.Security.Cryptography;

namespace Ohjelmointi_II
{
    class Programk3
    {
        public struct Pythagora
        {

            public double a;
            public double b;
            public double c;
            public bool RatkaisePuuttuva()
            {
                if (a == 0 && b == 0 || b == 0 && c == 0 || a == 0 && c == 0)
                    return false;
                if (a == 0)
                    a = Math.Sqrt((Math.Pow(c, 2) - (Math.Pow(b, 2))));
                else if (b == 0)
                    b = Math.Sqrt((Math.Pow(c, 2) - (Math.Pow(a, 2))));
                else
                    c = Math.Sqrt((Math.Pow(a, 2) + (Math.Pow(b, 2))));
                return true;
            }
        }

        // tietueessa pythagora pitää olla tiedo a,b,c
        // funkito ratkaise puuttuva:
        //  -jos kaksi arvoa on 0 => palauta false
        //  -jos vain 1 arvo on 0 => ratkaistaan arvo ja palautetaan true

        static void Maink3(string[] args)
        {
            /*3. Tehtävä
            Tee tietue Pythagora, jolla on tietoinaan ko lausekkeen kertoimet a, b ja c. 
            Tee tietueelle funktio RatkaisePuuttuva, joka laskee puuttuvan arvon (jos puuttuu eli arvo on 0). 
            Jos kaksi arvoa puuttuu, niin haluttua arvoa ei tietenkään voida ratkaista. 
            Tällöin funktio palauttaa arvon false, muutoin arvon true.
            a2 = c2 - b2
            b2 = c2 - a2
            c2 = a2 + b2  */

            Pythagora Lasku;
            Console.WriteLine("Anna a:n arvo:");
            double.TryParse(Console.ReadLine(), out Lasku.a);
            Console.WriteLine("Anna b:n arvo:");
            double.TryParse(Console.ReadLine(), out Lasku.b);
            Console.WriteLine("Anna c:n arvo:");
            double.TryParse(Console.ReadLine(), out Lasku.c);
            bool onkoNolla = false;
            onkoNolla = Lasku.RatkaisePuuttuva();
            if (onkoNolla == true)
                Console.WriteLine("Arvot ovat:a:{0} b:{1} c:{2}", Lasku.a, Lasku.b, Lasku.c);
            else
                Console.WriteLine("Kaksi luvuista oli 0 ei voida laskea");
        }
    }


}