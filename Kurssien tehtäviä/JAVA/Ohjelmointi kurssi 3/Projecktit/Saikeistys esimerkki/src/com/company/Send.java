package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
Creator: Sam
Date: 22.02.2021
Version: 0.1
Description:

*/
public class Send extends  Thread{

    //Jäsenmuuttujat
    private Lahetus L;

    //Constructorit

    public Send(Lahetus l) {
        L = l;
    }


    //Getterit ja Setterit


    //Metodit


    @Override
    public void run() {


        while(true){
            try {
                File objekti = new File("lahetys.txt");
                while (objekti.exists())
                {
                    Thread.sleep(1000);
                }
                FileWriter myWriter = new FileWriter("Lahetys.txt");
                myWriter.write(L.toString());
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (Exception e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            break;
        }
        System.out.println("Tiedostoon kirjoitus onnistui!");
    }
}
