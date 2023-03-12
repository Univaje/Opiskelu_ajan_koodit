package com.company.Tehtava5;

/*
Creator: Sam
Date: 23.02.2021
Version: 0.1
Description:

        public class Jasen{

            private String etunimi;
            private String sukunimi;
            private String email;

        }
*/
public class Jasen extends JasenBase{

    //Jäsenmuuttujat
    private String etunimi;
    private String sukunimi;
    private String email;

    //Constructorit

    public Jasen(String jasenseura, int vakuutusnro, String etunimi, String sukunimi, String email) {
        super(jasenseura, vakuutusnro);
        setEtunimi(etunimi);
        setSukunimi(sukunimi);
        setEmail(email);
    }


    //Getterit ja Setterit

    public String getEtunimi() {
        return etunimi;
    }

    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //Metodit


    @Override
    public void tulostaJasenTiedot() {
        // Olisi voinut käyttää this.haettava_arvo tilalla arvo ( this.getEtunimi tilalle etunimi )
        // Tuleepahan käytettyä gettereitä.
        System.out.println("Jasen: "+this.getEtunimi() +", sukunimi: " + this.getSukunimi() + "," +
                " Email: " +this.getEmail() + " Vakuutusnumero: " + super.getVakuutusnro());
    }


}
