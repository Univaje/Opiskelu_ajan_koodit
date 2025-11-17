package com.company;

public class Main {

    public static void main(String[] args) {
        Lahetus lahetys1 = new Lahetus(12,"Iisalmi","Mä");
        Lahetus lahetys2 = new Lahetus(14,"Kuopio","Sä");
        Lahetus lahetys3 = new Lahetus(12,"Iisalmi","Mä");

/*        if(lahetys1 != lahetys2){
            System.out.println("Eri lähetys oliot");
        }
        else
            System.out.println("Samat lähetys oliot");

        if(lahetys1 != lahetys3){
        System.out.println("Eri lähetys oliot");
        }
        else
                System.out.println("Samat lähetys oliot");

        if(lahetys1.equals(lahetys3)){
            System.out.println("Sama paska");
        }*/


        Send s1 = new Send(lahetys1);
        s1.start();

        try {
            Thread.sleep(1000);

        }catch (Exception e){

        }
        Send s2 = new Send(lahetys2);
        s2.start();
        }
    }
