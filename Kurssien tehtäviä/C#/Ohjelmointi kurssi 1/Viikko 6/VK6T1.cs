using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices;
using System.Runtime.Remoting.Messaging;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace EkaOhjelma_020920
{
    class Program
    {
        static void Main(string[] args)
        {


            string dir = @"c:\TempCrap\";
           
            for (int i = 0; i < 10; i++)
            {
                DirectoryInfo tinfo = new DirectoryInfo(dir+"hakemisto"+i);
                if (!tinfo.Exists)
                    tinfo.Create();
            }
            string[] lista = Directory.GetDirectories(dir);
            for (int i = 0; i < lista.Length; i++)
            {
                Directory.Delete(lista[i],true);
            }


        }
    }


}
