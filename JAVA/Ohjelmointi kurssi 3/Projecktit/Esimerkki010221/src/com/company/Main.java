package com.company;

import com.company.Harjoitustehtava2.Hiihto;
import com.company.Harjoitustehtava2.Juoksu;
import com.company.Harjoitustehtava2.Matkaharjoitus;
import com.company.Harjoitustehtava2.Urheilusuoritus;
import com.company.Model.Henkilo;
import com.company.Model.Opiskelija;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Urheilusuoritus u1 = new Urheilusuoritus("heti","joskus",200,"Jaksaisko");
        Matkaharjoitus m1 = new Matkaharjoitus("huomenna","never",210,"en haluu",200);
        Juoksu j1 = new Juoksu("tänään","tänään",1,"kuolen",100,2);
        Hiihto hiih1 = new Hiihto("apuva","apuva",1,"EE KIINNOSTA",100,"vapaa");


        System.out.println(u1);
        System.out.println(m1);
        System.out.println(j1);
        System.out.println(hiih1);





	Henkilo h1 = new Henkilo("Aku","Ankka","1234455-2314");
        //System.out.println(h1);
	Opiskelija o1 = new Opiskelija("Iines" ,"Ankka","12443355-4567","Kotihoito",1231);
        //System.out.println(o1);
        //System.out.println(o1.getEtunimi());


        Henkilo h2 = h1;
        h2 = o1; // ok

        Opiskelija o2;
        //o2 = (Opiskelija)h1; // ei ok

        Object x;
        x = o1;
        ArrayList<Object> nimet = new ArrayList<>();
        nimet.add(o1);
        nimet.add(h2);
        nimet.add(h1);
        for (Object o : nimet) {
            if (o instanceof Henkilo) {
                Henkilo h = (Henkilo) o;
                System.out.println(h);
            }
        }
        o1.tulosta();

        Henkilo h3 = o1;
       // System.out.println(h3.tulosta());
        h3 = h1;
        h3.tulosta();


    }
}
