package sample;

/*
Creator: Sam
Date: 23.02.2021
Version: 0.1
Description:
    Tee luokka Tuote ja käytä sitä ohjelmassa.
    Luokalla on yksityiset attribuutit:
        - Nimi (String)
        - Tuotetyyppi (String)
        - Kayttoonottopaiva (String)
        - Myyntihinta (double)
*/
public class Tuote {

    //Jäsenmuuttujat
    private String Tuotenimi;
    private String Nimi;
    private String TuoteTyyppi;
    private String Kauttoonottopaiva;
    private double Myyntihinta;

    //Constructorit

    public Tuote() {
    }

    public Tuote(String tuotenimi, String nimi, String tuoteTyyppi, String kauttoonottopaiva, double myyntihinta) {
        Tuotenimi = tuotenimi;
        Nimi = nimi;
        TuoteTyyppi = tuoteTyyppi;
        Kauttoonottopaiva = kauttoonottopaiva;
        Myyntihinta = myyntihinta;
    }

//Getterit ja Setterit

    public String getNimi() {
        return Nimi;
    }

    public void setNimi(String nimi) {
        Nimi = nimi;
    }

    public String getTuoteTyyppi() {
        return TuoteTyyppi;
    }

    public void setTuoteTyyppi(String tuoteTyyppi) {
        TuoteTyyppi = tuoteTyyppi;
    }

    public String getKauttoonottopaiva() {
        return Kauttoonottopaiva;
    }

    public void setKauttoonottopaiva(String kauttoonottopaiva) {
        Kauttoonottopaiva = kauttoonottopaiva;
    }

    public double getMyyntihinta() {
        return Myyntihinta;
    }

    public void setMyyntihinta(double myyntihinta) {
        Myyntihinta = myyntihinta;
    }

    public String getTuotenimi() {
        return Tuotenimi;
    }

    public void setTuotenimi(String tuotenimi) {
        Tuotenimi = tuotenimi;
    }
//Metodit


    @Override
    public String toString() {
        return "Tuote: TuoteNimi: " + Tuotenimi +", TuoteTyyppi: " + TuoteTyyppi +", Kauttoonottopaiva: " + Kauttoonottopaiva + ", Myyntihinta:"
                + Myyntihinta +" Ostaja: "+Nimi;

    }
   /* public Boolean Tarkista(){
        return true;

        // Käydään läpi osoite luokaan syötetyt tiedot. Palautetaan null opiskelija ja annetaan virhe tietojen uupuessa.
        if (getNimi().isEmpty() || getKauttoonottopaiva().isEmpty() ||getTuoteTyyppi().isEmpty()) {
            return true;
            System.out.println("Virheellinen osoite! ");
        }
        // Käydään läpi etu ja sukunimet. Palautetaan null opiskelija ja annetaan virhe tietojen uupuessa.
        else if (getMyyntihinta().isEmpty() || get.isEmpty()) {
            System.out.println("Virheellinen etu- tai sukunimi!");
            op = null;
            return true;
        }
        // Käydään läpi opiskelija numeron muoto. Palautetaan null opiskelija ja annetaan virhe tietojen uupuessa.
        else if (!op.getOpiskelijanumero().matches("[0-9]+")) {
            System.out.println("Virheellinen opiskelijanumero!");
            op = null;
        }
        else {
            // Kaikkien tietojen ollessa kohdallaan muutetaan etu ja sukunimet oikeaan muotoon.
            op.setEtunimi(op.getEtunimi().substring(0, 1).toUpperCase() + op.getEtunimi().substring(1).toLowerCase());
            op.setSukunimi(op.getSukunimi().substring(0, 1).toUpperCase() + op.getSukunimi().substring(1).toLowerCase());
        }
        return false;
    }*/
}
