using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices;
using System.Runtime.Remoting.Messaging;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Xml.Schema;

namespace EkaOhjelma_020920
{
    class Programs
    {
        static void KysyNimi(out string nimi)
        {
            Console.WriteLine("Anna nimesi(max. 18 merkkiä):");
            nimi = Console.ReadLine();
            while (nimi.Length > 18)
            {
                Console.WriteLine("Liian pitkä");
                Console.WriteLine("Anna nimesi(max. 18 merkkiä):");
                nimi = Console.ReadLine();
            }
            

        }
        static void Tulosta(string nimi)
        {
            Console.Clear();
            for (int i = nimi.Length - 1; i >= 0; i--)
            {
                for (int k = 0; k < i; k++)
                {


                    Console.Write("  ");
                }

                Console.WriteLine(nimi[i]);


            }
            Console.WriteLine("\n" + nimi);
        }

        static void Tallenna(string nimi)
        {
            using (StreamWriter sw1 = new StreamWriter(@"c:/TempCrap/tallenne.txt"))
            {
                for (int i = nimi.Length - 1; i >= 0; i--)
                {
                    for (int k = 0; k < i; k++)
                    {
                        sw1.Write("  ");
                    }
                    sw1.Write(nimi[i]);
                    sw1.WriteLine();
                }
                sw1.WriteLine("\n"+nimi);
            }
        }

        static void Maineer(string[] args)
        {


            //KT4

            //Kirjoita C#-kielinen ohjelma, joka kysyy käyttäjän nimeä, kuitenkin enintään 18 merkkiä ja sitten tulostaa sen alla 
            //kuvatusti nousevana ja pituudesta riippumatta sivusuunnassa keskelle kuvaruutua. Jotta teksti hahmottuisi riviksi, 
            //lisää kaksi välilyöntiä perättäisten merkkien väliin. Kirjoita tämä myös nimi.txt-tiedostoon



            //Anna nimesi(max. 18 merkkiä):  
            //                                          N
            //                                       E
            //                                    N
            //                                 I
            //                              A
            //                           L
            //                        U
            //                     K
            //                  E
            //               T
            //            U
            //         M
            //      E
            //   E
            //T

            //nimi
            string nimi;
            KysyNimi(out nimi);
            Tulosta(nimi);
            Tallenna(nimi);

        }
    }
}



