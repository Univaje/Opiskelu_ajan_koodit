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
    class ProgramOS1
    {


        //static void TulostaNimi()
        //{
        //    Console.WriteLine("Sampo kajaste");

        //}
        //static void TulostaAsuinpaikka()
        //{
        //    Console.WriteLine("Iisalmi");

        //}
        //static void TulostaPuhelin()
        //{
        //    Console.WriteLine("045-1234567");

        //}

        //static void TulostaTiedot(string crap, int ika, string Hetu)
        //{
        //    Console.WriteLine(crap);
        //    Console.WriteLine(ika);
        //    Console.WriteLine(Hetu);
        //}

        //static String KysyNimi()
        //{
        //    string Snimi;
        //    Console.WriteLine("Anna nimesi:");
        //    Snimi = Console.ReadLine();
        //    return (Snimi);
        //}

        //static int KysySyntymävuosi()
        //{
        //    int iVuosi;
        //    Console.WriteLine("Anna syntymävuotesi:");
        //    iVuosi = int.Parse(Console.ReadLine());
        //    return (iVuosi);
        //}

        //static int Laskeika(int ivuosi)
        //{
        //    //int Laskettu;
        //    //Laskettu = 2020 - ivuosi;
        //    //return (2020-ivuosi);
        //    return DateTime.Now.Year - ivuosi;
        //}
        //static void Tulostin(string Snimi, int ivuosi, int laskettu)
        //{
        //    Console.WriteLine(Snimi);
        //    Console.WriteLine(ivuosi);
        //    Console.WriteLine(laskettu);

        //}
        //static int Kysynummer()
        //{
        //    Console.WriteLine("Anna Laskettava numero");
        //    return (int.Parse(Console.ReadLine()));
        //}
        //static int Laskukaava(int luku1, int luku2)
        //{
        //    return (luku1 + luku2);
        //}
        //static void Tulostus(int luku1, int luku2, int luku3)
        //{
        //    Console.WriteLine("Laskettiin lukujen {0} ja {1} summa", luku1, luku2);
        //    Console.WriteLine("Tulokseksi saatiin {0}", luku3);
        //    return;
        //}
        //static void LueArvot(out string arvo1, ref int arvo2, out double desiluku)
        //{
        //    Console.WriteLine("Anna emrkkijono");
        //    arvo1 = Console.ReadLine();
        //    Console.WriteLine("Anna luku:");
        //    arvo2 = int.Parse(Console.ReadLine());
        //    Console.WriteLine("Anna desiluku:");
        //    desiluku = double.Parse(Console.ReadLine());

        //}
        //static void Tulostettava(string arvo1, int arvo2, double desiluku)
        //{
        //    Console.WriteLine("{0} + {1} = {2}", arvo1, arvo2, desiluku);
        //}

        //static void Minimilasku(ref int luku1, out int luku2)
        //{
        //    Console.WriteLine("Anna 1 luku:");
        //    luku1 = int.Parse(Console.ReadLine());
        //    Console.WriteLine("Anna 2 luku:");
        //    luku2 = int.Parse(Console.ReadLine());
        //}
        //static int minimi(int luku1, int luku2)
        //{
        //    int mini;
        //    if (luku1 < luku2)
        //        mini = luku1;
        //    else
        //        mini = luku2;
        //    return (mini);
        //}
        //static void KysyAvot(out double luku1, out double luku2)
        //{
        //    Console.WriteLine("Anna 1 luku:");
        //    luku1 = double.Parse(Console.ReadLine());
        //    Console.WriteLine("Anna 2 luku:");
        //    luku2 = double.Parse(Console.ReadLine());
        //}
        //static double Jakolasku(double luku1, double luku2)
        //{
        //    return (luku1 / luku2);
        //}
        //static void Tulostaa(double luku1, double luku2, double osamaara)
        //{
        //    Console.WriteLine("{0:f2} / {1:f2} = {2:f2}", luku1, luku2, osamaara);
        //}

        //static void KysyKoko(ref int koko)
        //{

        //Console.WriteLine("Kuinka suuri taulu luodaan?");
        //koko = int.Parse(Console.ReadLine());

        //}
        static Random rnd = new Random();

        static void Main(string[] args)

        {
            





















            /*
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


            short sluku;
            short sluku2;
            Console.WriteLine("Anna luku 1-255");
            sluku = short.Parse(Console.ReadLine());
            Console.WriteLine("Anna vielä toinen luku");
            sluku2 = short.Parse(Console.ReadLine());
            if( sluku < sluku2)
            {
                Console.WriteLine("Luku {0} on isompi kuin {1}", sluku2, sluku);
            }
            else if(sluku>sluku2)
            {
                Console.WriteLine("Luku {0} on isompi kuin {1}", sluku, sluku2);
            }
            else
            {
                Console.WriteLine("Luvut ovat yhtä suuria");
            }

            int sluku3;
            int sluku4;
            int summa;
            Console.WriteLine("Anna luku");
            sluku3 = int.Parse(Console.ReadLine());
            Console.WriteLine("Anna vielä toinen luku");
            sluku4 = int.Parse(Console.ReadLine());
            summa = sluku3 + sluku4;
            if (summa >= 100)
                Console.WriteLine("aika isot luvut");


            char merkki;
            Console.WriteLine("anna yksi merkki:");
            merkki = char.Parse(Console.ReadLine());
            if (merkki == 'S')
                Console.WriteLine("ISO ÄSSÄ");


            double desimal;
            Console.WriteLine("anna desimaali luku");
            desimal = double.Parse(Console.ReadLine());
            if (desimal > 1.25 && desimal < 5.76)
            {
                Console.WriteLine("Osuit väliin");
            }
            else if (desimal > 12.1 && desimal < 17.96)
            {
                Console.WriteLine("Osuit toiseen väliin");
            }
            else
                Console.WriteLine("ei sattunut väleihin");

            int iluku;
            Console.WriteLine("anna luku:");
            iluku = int.Parse(Console.ReadLine());

            if (iluku >= 3 && iluku <= 7 || iluku >= 9 && iluku <= 11)
                Console.WriteLine("Välissä oli");
            else
                Console.WriteLine("ei napsunut väliin");



            byte bluku;
            Console.WriteLine("anna arvo");
            bluku = byte.Parse(Console.ReadLine());
            if (bluku <= 10 || bluku >= 20)
            {
                Console.WriteLine("{0} ei ollut 10 ja 20 välissä", +bluku);
            }

            const int cRaja = 8;
            int arvo1;
            string juu = "Hieno juttu!";
            String ei = "Paremminkin voisi mennä.";
            string niin;
            Console.WriteLine("anna arviointisi:");
            arvo1 = int.Parse(Console.ReadLine());
            niin = (arvo1 >= cRaja) ? juu : ei;
            Console.WriteLine(niin);


           //Lue käyttäjältä kaksi kokonaislukua ja lisäksi lue operaatio(+tai -) joka 
           //luvuille tehdään.Jos operaatio oli annettu väärin, niin laskutoimitusta
           //ei saa tehdä, vaan annetaan virheilmoitus!Esittele myös vastaus muuttuja,
           //joka saa arvon ehdollisessa operaattorissa käyttäjän syöttämän operaation
           //perusteella. Tulosta koko laskutoimitus lopuksi


           // Tämä toimii mutta en ole varma saako tätä siivotummin tehtyä.
           //vaikuttaa minusta sotkuiselta (Opettaja ratkaisi lasku2 = (merkki == '+') ? iluku1 + iluku2 : iluku1 - iluku2;

           int iluku1, iluku2, iplus, imiinuslasku2;
           string sVastaus, sVastaus2;
           char merkki;
           Console.WriteLine("anna luku");
           iluku1 = int.Parse(Console.ReadLine());
           Console.WriteLine("anna toinen luku");
           iluku2 = int.Parse(Console.ReadLine());
           iplus = iluku1 + iluku2;
           imiinus =iluku1 - iluku2;
           Console.WriteLine("plus vai miinus?");
           merkki = char.Parse(Console.ReadLine());
           lasku2 = (merkki == '+') ? iplus : imiinus; //(Opettaja ratkaisi lasku2 = (merkki == '+') ? iluku1 + iluku2 : iluku1 - iluku2;)
           sVastaus2 = "Laskun " + iluku1 + " " + merkki + " " + iluku2 + " vastaus on " + lasku2;
           sVastaus = (merkki == '+' || merkki == '-') ? sVastaus2 : "Annoit väärän merkin.";
           Console.WriteLine(sVastaus);

            const int raja = 100;
            int iLuku5;
            String sVastaus;
            Console.WriteLine("anna lukusi");
            iLuku5 = int.Parse(Console.ReadLine());
            sVastaus = (iLuku5 >= raja) ? "iso luku" : "pieni luku";
            Console.WriteLine(sVastaus);

            const int cRajaluku = 3;
            int iArvosana;
            string sTulostus;
            Console.WriteLine("Anna itsellesi arvosana ohjelmoinnista:");
            iArvosana = int.Parse(Console.ReadLine());
            sTulostus = (iArvosana >= cRajaluku) ? "hyvä homma" : "lisää reeniä";
            Console.WriteLine(sTulostus);


            Console.WriteLine("{0} ja {1} luvut {2} ja {3}", pvm.MA, pvm.TO,(int)pvm.MA,(int)pvm.TO);

            Console.WriteLine("Anna luku 1-7");
            switch (int.Parse(Console.ReadLine()))
            {
                case 1:
                    Console.WriteLine("Numero 1 on "+pvm.MA);
                    break;
                case 2:
                    Console.WriteLine("Numero 2 on " + pvm.TI);
                    break;
                case 3:
                    Console.WriteLine("Numero 3 on " + pvm.KE);
                    break;
                case 4:
                    Console.WriteLine("Numero 4 on " + pvm.TO);
                    break;
                case 5:
                    Console.WriteLine("Numero 5 on " + pvm.PE);
                    break;
                case 6:
                    Console.WriteLine("Numero 6 on " + pvm.LA);
                    break;
                case 7:
                    Console.WriteLine("Numero 7 on " + pvm.SU);
                    break;
                default:
                    Console.WriteLine("Nyt en ymmärrä");
                    break;
          }

            Console.WriteLine("Anna luku 1-7");
            switch (int.Parse(Console.ReadLine()))
            {
                case 1:                 
                case 2:
                case 3:
                case 4:
                case 5:
                    Console.WriteLine("On arkipäivä");
                    break;
                case 6:
                case 7:
                    Console.WriteLine("On viikonloppu");
                    break;
                default:
                    Console.WriteLine("Nyt en ymmärrä");
                    break;

            Console.WriteLine("väsyttääkö? (k/e)");
            switch (char.Parse(Console.ReadLine()))
                {
                case 'k':
                    Console.WriteLine("Kohta loppuu");
                break;
                case 'e':
                    Console.WriteLine("Hyvä");
                break;
                default:
                    Console.WriteLine("Nyt en ymmärrä");
                    break;

            Console.WriteLine("Jatkuuko tunnit vielä tämän jälkeen? (k/e)");
            switch (char.Parse(Console.ReadLine()))
            {
                case 'k':
                case 'K':
                    Console.WriteLine("Pitkä päivä");
                    break;
                case 'e':
                case 'E':
                    Console.WriteLine("Lyhyt päivä");
                    break;
                default:
                    Console.WriteLine("taidat olla aika zippi jo nyt");
                    break;
            }

            int ilukuarv = 2;
            while (ilukuarv < 18)
            {
                Console.WriteLine("Luku {0} on alle 18", ilukuarv);
                ilukuarv = ilukuarv + 1;
            }

           ////////////// H1

            int ilukuarv9 = 29;
            while (ilukuarv9 >= 5)
            {
                Console.WriteLine("Luku {0}", ilukuarv9);
                ilukuarv9 = ilukuarv9 - 1;
            }

            //////////////////2
            int ilukuarv8 = -3;
            while (ilukuarv8 <9)
            {
                Console.Write(" {0},",ilukuarv8);
                ilukuarv8 = ilukuarv8 + 3;
            }
            Console.Write(" " +ilukuarv8 + "\n");
            //////////////////3
            double  lukuarv7 = 1;
            while (lukuarv7 < 100) 
            {
                lukuarv7++;
                if ((lukuarv7 % 3) == 0)
                {
                    Console.WriteLine(lukuarv7);
                }
            } 


            //////////4

            int laskuri =1, annaluku=0, iSuurin = 0, iPienin = 0;
            while (laskuri  <= 7)
            {
                Console.WriteLine("Anna uusi luku");
                annaluku = int.Parse(Console.ReadLine());
                if (iSuurin < annaluku)
                    iSuurin = annaluku;
                else if (annaluku > iPienin)
                    iPienin = annaluku;

                laskuri++;

            }

            Console.WriteLine("suurin antamasi luku on {0} ja pienin {1}", iSuurin,iPienin);

            //////////////5
            ///
            int iKasvava=2,edellinen=0;
            while (iKasvava <24)
            {
                Console.WriteLine(iKasvava);
                edellinen++;
                iKasvava = iKasvava + edellinen;


            }


            //////////HARJOITUS 1

            int iDoit =1;
            do
            {
                Console.Write(" " + iDoit +",");
                iDoit++;

            } while (iDoit < 5);
            Console.Write(" {0}\n",iDoit);

            ////////////HARJOITUS 2



            int arvosana;
            do
            {
                Console.WriteLine("anna arvosana");
                arvosana = int.Parse(Console.ReadLine());
                Console.Clear();
            }

             while (arvosana >= 5 || arvosana <= 1);



            ///////:HARJOITUS TEHTÄVÄ 3

            int iAnar,iLaskuri=0;

            do
            {
                Console.WriteLine("Anna lukuarvo:");
                iAnar = int.Parse(Console.ReadLine());
                if (iAnar % 2 == 0)
                {
                    iLaskuri++;
                }
            } while (iAnar != 999);
            Console.WriteLine("Antamistasi luvuista parillisia oli "+iLaskuri);


            char cMerkki;
            int iAsciiarvo;


            do
            {
                Console.WriteLine("Anna merkki");
                cMerkki = char.Parse(Console.ReadLine());
                iAsciiarvo = (int)cMerkki;
            } while (iAsciiarvo < 64 || iAsciiarvo > 76);




            //////H2
            char ceemerkki;
            Console.WriteLine("anna merkki");
            do
            {
                ceemerkki = Console.ReadKey(true).KeyChar;
                Console.WriteLine("{0} {1}", ceemerkki, (int)ceemerkki);
            }
            while (ceemerkki != 90) ;

            ///////////H3

            char ceMerkki = '9';
            Console.WriteLine("anna merkki");
            while (ceMerkki != '0')
            {
                ceMerkki = Console.ReadKey(true).KeyChar;
                if ( (int)ceMerkki < 90 && (int)ceMerkki > 64)
                    Console.Write(ceMerkki);
            }

            Console.WriteLine("anna salasana:");

            Char lopetus = '1';

            while (lopetus !='\r')
            {
                lopetus = Console.ReadKey(true).KeyChar;
                if((int)lopetus == 8)
                    Console.Write("\b \b");

                else if ((int)lopetus == 13)
                {
                    Console.WriteLine("");
                    lopetus = '\r';
                }

                else if ((int)lopetus > 1 && (int)lopetus < 10000)
                    Console.Write("*");

            }
            Console.WriteLine("System failure");

            int palkka=1, laskuri;
            for (laskuri = 1; laskuri <= 30; laskuri++)
            {
                Console.WriteLine(palkka);
                palkka = palkka + palkka;
            }






            ///FÒR HARJOITUS 1
            int ij;
            for (ij =1; ij <= 10; ij++)
            {
                if (ij == 1)
                    Console.Write(ij);
                else
                    Console.Write(",{0}",ij);
            }    


            ///FÒR HARJOITUS 2

            int ijj;
            for (ijj=1; ijj<=10; ijj++)
                Console.WriteLine(ijj);

            ///FÒR HARJOITUS 3

            int ilkuku, kerto = 1;
            Console.WriteLine("anna luku");
            ilkuku = int.Parse(Console.ReadLine());

            Console.WriteLine("annetun luvun kertotaulutulokset 10 asti ovat:");
            for (kerto = 1; kerto <= 10; kerto++)
                Console.WriteLine("{0}", ilkuku * kerto);


            ///FÒR HARJOITUS 4

            int i, j;
            for (i = 2, j = 9; i < 9 && j > 2; i++, j--)
                Console.WriteLine("{0} * {1} = {2}", i, j, i * j);

            ///FOR HARJOITUS 5

            int laskuri=0,isluku=1, piluku=20, anluku;
            for(laskuri=1; laskuri<=20;laskuri++)
            {
                    Console.WriteLine("Anna luku 1-20");
                    anluku = int.Parse(Console.ReadLine());
                if (anluku > 20 || anluku < 1)
                {
                    Console.Clear();
                    Console.WriteLine("luku ei ollut väliltä 1-20");
                    laskuri--;
                }
                else
                    if (anluku > isluku)
                {
                    isluku = anluku;
                    Console.Clear();
                }
                else if (anluku < piluku)
                {
                    piluku = anluku;
                    Console.Clear();
                }
                else
                    Console.Clear();
            }
            Console.WriteLine("Pienin antamasi luku oli {0} ja suurin {1} ",piluku , isluku );

            ///FOR HARJOITUS 6

            int il, j;

            for (il = 1; il <= 10; il++)
            {
                for (j = 1; j < il; j++)
                {
                    Console.Write(" ");
                }
                Console.WriteLine(il);
            }

            ///FÒR HARJOITUS 7



            ///FÒR HARJOITUS 8



            ///FÒR HARJOITUS 9





            int palkka = 1, laskuri;
            for (laskuri = 1; laskuri <= 32; laskuri++)
            {
                Console.WriteLine(palkka);
                palkka = palkka + palkka;
            }



            //////Taulukko HARJOITUSET
            ////Harjoitus 1

            ///Esittele 3 alkioinen taulukko(int) ja lue siihen käyttäjältä arvot.Tulosta lopuksi lukujen summa näytölle.ÄLÄ KÄYTÄ SILMUKKAA

            int[] iTaulukko = new int[3];
            Console.WriteLine("Anna Ensimmäinen arvo");
            iTaulukko[0] = int.Parse(Console.ReadLine());
            Console.WriteLine("Anna Toinen arvo");
            iTaulukko[1] = int.Parse(Console.ReadLine());
            Console.WriteLine("Anna Kolmas arvo");
            iTaulukko[2] = int.Parse(Console.ReadLine());
            Console.WriteLine("Lukujen summa on : {0}", iTaulukko.Sum());


            //////HARJOITUS TEHTÄVÄ 2

            int i;
            int[] iTaulukko7 = new int[7];
            for (i = 0; i < iTaulukko7.Length; i++)
            {
                Console.WriteLine("Anna arvo");
                iTaulukko7[i] = int.Parse(Console.ReadLine());
                Console.Clear();
            }
            foreach(int luku in iTaulukko7)
            {
                Console.WriteLine(luku);
            }

            ////HARJOITUSTEHTÄVÄ 3

            int i;
            int iNga =0, iPosi =0;
            int[] iTaulukko10 = new int[10];
            for (i = 0; i < iTaulukko10.Length; i++)
            {
                Console.WriteLine("Anna arvo");
                iTaulukko10[i] = int.Parse(Console.ReadLine());
                if (iTaulukko10[i] == 0)
                {
                    Console.Clear();
                    Console.WriteLine("luku 0 ei kelpaa!");
                    i--;
                }

            }
            foreach (int luku in iTaulukko10)
            {
                if (luku < 0)
                    iNga++;
                else
                    iPosi++;

            }
            Console.WriteLine("luvuistasi {0} oli positiivisia ja {1} negatiivisia", iPosi, iNga);

            for (d = 0; d < dTaulukko6.GetLength(0); d++)
            {

                for (e = 0; e < dTaulukko6.GetLength(1); e++)
                {
                    Console.WriteLine("{0:f2}", dTaulukko6[e,d]);
                }
            }


            ////HARJOITUSTEHTÄVÄ 4

            double[,] dTaulukko6 = new double[2,3];
            int d,e;
            for (d = 0; d < dTaulukko6.GetLength(0); d++)
            {

                for (e = 0; e < dTaulukko6.GetLength(1); e++)
                {
                    Console.WriteLine("Anna desimaaliluku");
                    dTaulukko6[d,e] = double.Parse(Console.ReadLine());  
                }
            }
            foreach (double item in dTaulukko6)
            {
                Console.WriteLine("{0:f2}",item);
            }


            ////HARJOITUSTEHTÄVÄ 5
            string sTieto;
            Console.WriteLine("antoo mulle sanan");
            sTieto = Console.ReadLine();
            foreach (char item in sTieto)
            {
                Console.WriteLine(item);
            }


            ////HARJOITUSTEHTÄVÄ 6

            string sTeksti;
            Console.WriteLine("Anna kirjamimia ja lukuja");
            sTeksti = Console.ReadLine();
            foreach (char item in sTeksti)
            {
                if ((int)item >=48 && (int)item <=57)
                    Console.WriteLine(item);
            }

            ////HARJOITUSTEHTÄVÄ 7
            string sTeksti7;
            Console.WriteLine("Anna kirjamimia ja lukuja");
            sTeksti7 = Console.ReadLine();
            for (int i = sTeksti7.Length -1 ; i >= 0 ; i--)
            {
                Console.Write("{0}",sTeksti7[i]);
            }

            ////HARJOITUSTEHTÄVÄ 8
            Console.WriteLine("montako arvosanaa syötetään?");
            int Maara = int.Parse(Console.ReadLine());
            int arvosana;
            int[] itaulukko = new int [Maara];
            for (int i = 0; i < itaulukko.Length ; i++)
            {
                Console.WriteLine("Anna Arvosana:");
                arvosana = int.Parse(Console.ReadLine());
                if (arvosana < 0 || arvosana > 5)
                {
                    Console.WriteLine("Ei kelvollinen luku");
                    i--;
                }
                else
                    itaulukko[i] = arvosana;
                {

                }

            }
            Console.WriteLine("Pienin arvosana: {0}", itaulukko.Min());
            Console.WriteLine("suurin arvosana: {0}", itaulukko.Max());

            ////HARJOITUSTEHTÄVÄ 9
            ///Esittele 7 alkioinen double-taulukko. Lue siihen arvot for-silmukassa.
            ///Käytä ehdossa taulukolta löytyvää ominaisuutta, joka kertoo taulukon pituuden. 
            ///Tulosta taulukon alkiot 3-desimaalin tarkkuudella peräkkäin tabuloinnilla eroteltuna,
            ///käyttäen foreach-silmukkaa

            int seiska=2;
            double[] dTaulukko = new double [seiska];
            for (int i =0; i< dTaulukko.Length; i++)
            {
                Console.WriteLine("Anna Desimaali luku :");
                dTaulukko[i] = double.Parse(Console.ReadLine());
            }
            foreach (double item in dTaulukko)
            {
                Console.Write("{0:f3}\t", item);
            }

            ////HARJOITUSTEHTÄVÄ 10


            int[,] dTaulukko10 = { { 10, 23, 67 }, { 3, 8, 2 } };
            int i, j;
            for (i = 0; i < dTaulukko10.GetLength(0); i++) 
            {

                for (j = 0; j <dTaulukko10.GetLength(1); j++)
                {
                    Console.Write("{0} ", dTaulukko10[i, j]);
                }
                Console.WriteLine();
            }



            for (j = 0; j < dTaulukko10.GetLength(1); j++)
            {
                for ( i = 0; i < dTaulukko10.GetLength(0); i++)
                {
                    Console.Write("{0} ", dTaulukko10[i, j]);
                }
                Console.WriteLine();
            }


            ////HARJOITUSTEHTÄVÄ 11

            double[,] datataulukko = new double[2, 6];
            int k, l;
            for (k = 0; k < datataulukko.GetLength(0); k++)
            {
                for (l  = 0;  l< datataulukko.GetLength(1); l++)
                {
                    Console.WriteLine("Anna desimaaliluku:");
                    datataulukko[k, l] = double.Parse(Console.ReadLine());
                }
            }
            for (k = 0; k < datataulukko.GetLength(0); k++)
            {
                for (l = 0; l < datataulukko.GetLength(1); l++)
                {
                    Console.Write("{0:f2}\t", datataulukko[k,l]);

                }
                Console.WriteLine();
            }


            ////HARJOITUSTEHTÄVÄ 12

            string[,] pelitaulu = new string[3, 3];
            int a, s; 
            for (s = 0; s < pelitaulu.GetLength(0); s++)
            {
                for (a = 0; a < pelitaulu.GetLength(1); a++)
                {

                    if (a == 0)
                        Console.WriteLine("Anna Pelaajan nimi:");    
                    else if (a ==1)
                        Console.WriteLine("Anna Pelaajan seura:");
                    else
                        Console.WriteLine("Anna pelaajan pelipaikka:");
                    pelitaulu[a, s] = Console.ReadLine();
                    Console.Clear();
                }
            }
            Console.Clear();
                for (a = 0; a < pelitaulu.GetLength(0); a++)
                {

                    for (s = 0; s < pelitaulu.GetLength(1); s++)
                    {
                        Console.Write("{0}\t",pelitaulu[a, s]);
                    }
                    Console.WriteLine();
                }
                Console.WriteLine();




            ///// SATUNNAISLUVUT
            ////HARJOITUSTEHTÄVÄ 1

            int i, j;
            Random rnd = new Random();
            for (i = 1; i <=300; i++)
            {
                j = rnd.Next();
                Console.WriteLine("{0} kierros randomluku: {1}", i,j);
            }


            ////HARJOITUSTEHTÄVÄ 2

            int[] taulu = new int[17];
            int arpa;
            double ka =0.00;
            Random rnd = new Random();
            for (int j = 0; j < taulu.Length; j++)
            {
                arpa = rnd.Next(4, 10);
                taulu[j] = arpa;
            }
            foreach (int item in taulu)
            {
                Console.WriteLine("{0}\t",item);

            }
            ka = taulu.Sum() / (double)taulu.Length;
            Console.WriteLine("lukujen summa oli {0} ja lukuja oli {1} ja niiden keskiarvo oli {2:f1}", taulu.Sum(), taulu.Length, ka);


            ////HARJOITUSTEHTÄVÄ 3


            int[] satataulu = new int[100];
            Random rnd = new Random();
            for (int i = 0; i < satataulu.Length; i++)
            {
                satataulu[i] = rnd.Next();
            }
            for (int j= satataulu.Length-1; j>=0 ; j--)
            {
                Console.WriteLine("alkio numero {0} satunnaisluku{1}", j, satataulu[j]);
            }




            ////HARJOITUSTEHTÄVÄ 4

            int[] viisisatataulu = new int[500];
            int posi=0, nega=0;

            Random rnd = new Random();
            for (int i = 0; i < viisisatataulu.Length; i++)
            {
                viisisatataulu[i] = rnd.Next(-50,50);
                if (viisisatataulu[i] < 0)
                    nega++;
                else
                    posi++;
            }
            Console.WriteLine("{0} arvotusta luvusta oli {1} positiivisia ja {2} negatiivisia",viisisatataulu.Length,posi,nega);



            ////HARJOITUSTEHTÄVÄ 5

            double[] kymmenetaulu = new double[10];
            double arpa, kaskyluku=14.1,lukuvali = 27.8 - 14.1 ;
            Random rnd = new Random();
            for (int i = 0; i < kymmenetaulu.Length; i++)
            {
                arpa = rnd.NextDouble() * lukuvali + kaskyluku;
                kymmenetaulu[i] = arpa;

            }
            foreach (double item in kymmenetaulu)
            {
                Console.WriteLine("{0:f1}",item);
            }


            ////HARJOITUSTEHTÄVÄ 6

            int jako,vali, satun;
            Random rnd = new Random();
            int[] nelitoistaulu = new int[14];
            vali = 37 + 23;
            for (int i = 0; i < nelitoistaulu.Length; i++)
            {
                satun = rnd.Next();
                jako = (satun % vali) -23;
                nelitoistaulu[i] = jako;
            }
            foreach (int item in nelitoistaulu)
            {
                Console.WriteLine(item);
            }



            ////HARJOITUSTEHTÄVÄ 7


            int kysytty, pari = 0, pariit = 0;
            Console.WriteLine("montako lukua luodaan?");
            kysytty = int.Parse(Console.ReadLine());
            int[] satataulu = new int[kysytty];
            Random rnd = new Random();
            for (int i = 0; i < satataulu.Length; i++)
            {
                satataulu[i] = rnd.Next(1, 10);
                if (satataulu[i] % 2 == 1)
                    pariit++;
                else
                    pari++;
            }
            Console.WriteLine("luvuista {0} oli parillisia {1} ja parittomia {2}", kysytty,pari,pariit);



            ////HARJOITUSTEHTÄVÄ 8
            ///
            Random rnd = new Random();
            int kysytty, j, i;
            Console.WriteLine("montako lukua luodaan?");
            kysytty = int.Parse(Console.ReadLine());
            Console.Clear();
            int[] satataulu = new int[kysytty];
            for ( i = 0; i < satataulu.Length; i++)
            {
                satataulu[i] = rnd.Next(6);

            }
            for ( i = 0; i < 5; i++)
            {
                Console.Write("{0} :", i);
                for ( j = 0; j < satataulu.Length; j++)
                {
                    if(satataulu[j] == i)
                        Console.Write("*");
                }
                Console.WriteLine();
            }


            ////HARJOITUSTEHTÄVÄ 9





            ////HARJOITUSTEHTÄVÄ 10
            ///int[] munrivi = { 6,8,14,23,25,28,29,44,70,65};
            int[] munrivi = new int[10];
            int[] keno = new int[20];
            int[] voittorivit = new int[10];
            Random rng = new Random();
            int maksanut=0, kierros=0, voitot=0, i, j,k, oikein,kulunut, rivi ;
            double paivat = 0.0;
            do
            {
                for (i = 0; i < munrivi.Length; i++)
                {
                    munrivi[i] = rng.Next(71);
                    if (munrivi[0] == 0)
                        munrivi[i] = rng.Next(71);
                }
                kierros++;
                oikein = 0;
                paivat = paivat + 0.5;
                maksanut++;
                for (i = 0; i < keno.Length; i++)
                {
                    keno[i] = rng.Next(71);//keno tekee joka soluun numeron 71 jotta luku olisi välillä 1-70
                    if (munrivi[0] == 0)
                        munrivi[i] = rng.Next(71);
                    for (j = 0; j < keno.Length; j++) //kiertää uudelleen keno solut tarkoituksena tarkistaa ettei ole samoja
                    {
                        if (keno[i] == keno[j]) // testaa onko sama
                        {
                            keno[i] = rng.Next(71);// arpoo silloin uuden random luvun
                        }
                    }
                }
                for ( i = 0; i < 10; i++) //tarvitaan 10 oikeinriviä varten laskuri
                {
                    j = munrivi[i]; // otetaan omasta rivistä numero j:n
                    for (k = 0; k < keno.Length; k++) // kenon laskuri kierrätetään 20kertaa
                    {
                        if (keno[k] == j)  // verrataan kenon numeroon omaa
                        {
                            oikein++;  // kerrytetään oikeinrivin laskuria
                        }
                    }

                }




                switch (oikein)
                {
                    case 1:
                        voittorivit[1]++;
                        break;
                    case 2:
                        voittorivit[2]++;
                        break;
                    case 3:
                        voittorivit[3]++;
                        break;
                    case 4:
                        voittorivit[4]++;
                        break;
                    case 5:
                        voitot = voitot + 1;
                        voittorivit[5]++;
                        break;
                    case 6:
                        voitot = voitot + 4;
                        voittorivit[6]++;
                        break;
                    case 7:
                        voitot = voitot + 20;
                        voittorivit[7]++;
                        break;
                    case 8:
                        voitot = voitot + 200;
                        voittorivit[8]++;
                        break;
                    case 9:
                        voitot = voitot + 5000;
                        voittorivit[9]++;
                        break;
                    case 10:
                        voitot = voitot + 200000;
                        break;
                    default:
                        voitot = voitot + 1;
                        voittorivit[0]++;
                        break;
                }
                kulunut = voitot - maksanut;
                Console.WriteLine("Voittorivejä sinulla on ollut");
                for (i = 0; i < 10; i++)
                {
                    Console.Write("{0}: ", i);
                    Console.Write("{0} ", voittorivit[i]);

                }
                Console.WriteLine();
                Console.WriteLine("pelataan kierrosta {0} aloituksestasi on aikaa {1:f0} vuotta ja {2:f1} päivää\nRahaa olet voittanut {3}euroa ja käyttänyt {4}euroa\nPalautusprosentti on {5}%",kierros,paivat/365,(paivat % 365),voitot,maksanut,voitot/maksanut);
                Console.WriteLine("Raha tilanteesi: {0}", kulunut);
            } while (oikein != 10); // homma toimii niin kauan kunnes oikein määrä on 10




            // H1
            // Tee funktiot TulostaNimi, TulostaAsuinpaikka ja TulostaPuhelinNro. '
            // Näitten funktioiden avulla sinun pitäisi saada tulostumaan omat tietosi
            // Sami Lahti
            // Siilinjärvi
            // 044 - 7856337

            TulostaNimi();
            TulostaAsuinpaikka();
            TulostaPuhelin();


            string Crap;
            int ika;
            String Hetu;
            Console.WriteLine("nimesi:");
            Crap = Console.ReadLine();
            Console.WriteLine("ikäsi:");
            ika = int.Parse(Console.ReadLine());
            Console.WriteLine("Hetusi:");
            Hetu = Console.ReadLine();


            TulostaTiedot(Crap, ika, Hetu);

            */
            //H3
            //Tee funktio KysyNimi, joka kysyy käyttäjältä nimen ja   
            //palauttaa sen.Tee funktio KysySyntymavuosi, joka kysyy 
            //käyttäjältä syntymävuoden ja palauttaa sen.Tee funktio 
            //LaskeIka, joka ottaa parametrikseen syntymävuoden, laskee 
            //henkilön iän ja palauttaa sen. Tee funktio Tulosta, joka 
            //ottaa parametrikseen nimen ja iän ja tulostaa tiedot näytölle.



            //string inimi = KysyNimi();
            //int ivuosi = KysySyntymävuosi();
            //int Laskettu = Laskeika(ivuosi);
            //Tulostin(inimi, ivuosi, Laskettu);

            //Console.WriteLine()



            //int luku1 = Kysynummer();
            //int luku2 = Kysynummer();
            //int luku3 = Laskukaava(luku1, luku2);
            //Tulostus(luku1, luku2, luku3);

            //Esittele Mainissa string, int ja double muuttujat ja lue niihin arvot
            //    Lue - funktiossa. int tyyppinen muuttuja on saanut Mainissa alkuarvon.
            //    Tulosta lopuksi muuttujien arvot Tulosta - funktiossa

            //string arvo1;
            //int arvo2 = 10;
            //double desiluku;
            //LueArvot(out arvo1, ref arvo2, out desiluku);
            //Tulostettava(arvo1, arvo2, desiluku);

            /*

            //H2
            //Esittele Mainissa int tyyppiset muuttujat luku1 ja luku2. 
            //Alusta luku1 jollakin alkuarvolla, mutta älä anna luku2 mitään alkuarvoa.
            //Lue muuttujiin käyttäjältä arvot funktiossa Lue. Mieti miten viet muuttujat sinne.
            //Tee Minimi-funktio, joka palauttaa pienemmän kyseisistä arvoista.Tulosta Mainissa pienempi arvo.

            int luku1 = 0;
            int luku2;
            MinimiLasku(ref luku1, out luku2);
            int mini = minimi(luku1, luku2);
            Console.WriteLine("{0} oli luvuista pienempi", mini);



            //H3
            //Esittele Mainissa double tyyppiset luku1, luku2 ja osamaara - muuttujat.
            //Lue luku1 ja luku2 muuttujiin arvot Lue-funktiossa.Laske lukujen osamäärä 
            //Laske - funktiossa ja tulosta koko laskutoimituksen tulosta Tulosta-funktiossa.
            //Mikään funktio ei saa palauttaa mitään

            double luku1;
            double luku2;
            double osamaara;
            KysyAvot(out luku1, out luku2);
            osamaara = Jakolasku(luku1, luku2);
            Tulostaa(luku1, luku2, osamaara);
            */

            //H4
            //Lue käyttäjältä tieto, kuinka iso taulukko luodaan.Luo int taulukko ja arvo siihen lukuja väliltä 1 - 10.
            //Lue lisäksi käyttäjältä kerroin ja tulosta taulukon alkiot 
            //Tulosta-funktiossa kerrottuna kyseisellä kertoimella.

            //Käytä funktioita
            //KysyKoko - palauttaa kysytyn tiedon
            //Arvo
            //KysyKerroin - tämä funktio ei palauta mitään
            //Tulosta

            //int koko = 1;
            //KysyKoko(ref koko);
            //int[] kertotaulu = new int[koko];
            //Arvo(int[] kertotaulu);


























            ////HARJOITUSTEHTÄVÄ 1

            ////HARJOITUSTEHTÄVÄ 2



        }

    }


}
