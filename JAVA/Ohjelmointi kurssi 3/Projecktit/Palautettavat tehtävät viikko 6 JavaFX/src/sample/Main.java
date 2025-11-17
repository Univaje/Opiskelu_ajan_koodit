package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/*  Tehtävä 3

    Savoniassa on päätetty tehdä pilottikokeilu, jossa poistoon meneviä tietokoneita sekä tarvikkeita myydään
    oppilaille verkkokaupan kautta. Pääset osallistumaan projektiin ja käyttämään luovaa ajattelua käyttöliittymän
    suunnittelussa.

    Tee JavaFX-kirjastoa käyttäen käyttöliittymä, jossa verkkokauppaan syötetään tuote ja sen tiedot.

    Tuotteesta tarvittavat tiedot:
    - Nimi
    - Tuotetyyppi (esim. tietokone, hiiri, monitori). Tämä voisi olla alasvetovalikko.
    - Käyttöönottopäivä. Tämä valitaan kalenterista (Date Picker).
    - Myyntihinta
    - Ostajan nimi

    Tärkeää on myös, että ruudun ylälaidassa on Savonian logo. Ruudulla lisäksi on alalaidassa ”Tallenna”- ja
    ”Sulje”-napit, jotka eivät vielä tee mitään.”

    Tehtävä 4

    Käytä edellisessä tehtävässä luotua käyttöliittymää, jolle tässä tehtävässä tehdään toteutus.
    Kun toteutusta tehdään, niin käytä kuuntelijoiden esittelyssä Lambda-syntaksia, esim.:

    b.addActionListener(e -> System.out.println("Hello World!"));

    Sama ilman Lambdaa:


    b.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
    System.out.println("Hello World!");
    }
    });

    Tee käyttöliittymän kentille kuuntelijat:
    - Kun käyttöliittymällä olevia kenttiä muutetaan, niihin syötetty tieto asetetaan kuuntelijassa
      Tuote-luokan olion attribuuttiin.

    - Tallenna-napin painalluksen kuuntelijassa tarkastetaan, että kaikki tuotteen tiedot on täytetty.
      Jos joku arvo on tyhjä, ilmoitetaan siitä käyttäjälle ja pyydetään täyttämään tiedot. Jos kaikki kentät ovat
      täytettynä, lopetetaan ohjelman ajo.

    - Sulje-napin painallus lopettaa ohjelman ajon.
	 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Tuote UusiTuote = new Tuote();

        TextField Nimikentta =new TextField();
        Nimikentta.textProperty().addListener(e -> UusiTuote.setNimi(Nimikentta.getText()));

        DatePicker dpPvm = new DatePicker();
        dpPvm.setValue(LocalDate.of(2020,12,24));
        dpPvm.setOnAction(e -> UusiTuote.setKauttoonottopaiva(dpPvm.getValue().toString()));

        ComboBox cbMyyntilista = new ComboBox();
        cbMyyntilista.getItems().addAll("Hiiri","Näppäimistö","Monitori","Tietokone");
        cbMyyntilista.getSelectionModel().selectFirst();
        cbMyyntilista.setOnAction(e -> UusiTuote.setTuoteTyyppi(cbMyyntilista.getValue().toString()));

        TextField hintakentta = new TextField();
        hintakentta.textProperty().addListener(e -> {
            if (!hintakentta.getText().matches("\\d*")) {
                hintakentta.setText(hintakentta.getText().replaceAll("[^\\d]", ""));
        }
            if(!hintakentta.getText().matches(""))
                    UusiTuote.setMyyntihinta(Double.valueOf(hintakentta.getText()));
        });

        TextField OstajanNimikentta = new TextField();
        OstajanNimikentta.textProperty().addListener(e -> UusiTuote.setTuoteTyyppi(OstajanNimikentta.getText()));

        Button btPoista = new Button("Poista");
        btPoista.setOnAction(e -> primaryStage.close());

        Button btLisaa = new Button("Tallenna");
        Label Virhe = new Label();
        btLisaa.setOnAction(e -> {
            Virhe.setText("");
            if(Nimikentta.getText().isEmpty()|| OstajanNimikentta.getText().isEmpty()|| hintakentta.getText().isEmpty())
                Virhe.setText("Tietoja uupuu!");
            if (dpPvm.getValue().equals(LocalDate.of(2020,12,24)))
                Virhe.setText("Virheellinen Päivämäärä!");


            if (Virhe.getText().equals(""))
                primaryStage.close();

        });

        GridPane Kuvapaneeli = new GridPane();
        Kuvapaneeli.isResizable();
        Kuvapaneeli.setHgap(150);
        Kuvapaneeli.setVgap(50);
        Kuvapaneeli.add(Virhe, 1, 3);
        GridPane paneeli = new GridPane();
        Kuvapaneeli.add(paneeli,1,2);

        Image kuva = new Image("SavoniaLogo.png",300,100,false,false);
        Kuvapaneeli.add(new ImageView(kuva),1,1);
        ImageView kuvaNaytto2 = new ImageView(kuva);
        kuvaNaytto2.setFitHeight(5);
        kuvaNaytto2.setFitWidth(10);
        paneeli.getChildren().add(kuvaNaytto2);


        paneeli.setAlignment(Pos.BOTTOM_CENTER);
        paneeli.setPadding(new Insets(5, 5, 5, 5));
        paneeli.setHgap(5);
        paneeli.setVgap(5);
        paneeli.add(new Label("Nimi: "), 0, 0);
        paneeli.add(Nimikentta, 1, 0);
        paneeli.add(new Label("Tuote Tyyppi: "), 0, 1);
        paneeli.add(cbMyyntilista, 1, 1);
        paneeli.add(new Label("Käyttöönotto päivä:"), 0, 2);
        paneeli.add(dpPvm, 1, 2);
        paneeli.add(new Label("Myyntihinta:"), 0, 3);
        paneeli.add(hintakentta, 1, 3);
        paneeli.add(new Label("Ostajan nimi:"), 0, 4);
        paneeli.add(OstajanNimikentta, 1, 4);
        paneeli.add(btLisaa, 0, 5);
        GridPane.setHalignment(btLisaa, HPos.LEFT);
        paneeli.add(btPoista, 1, 5);
        GridPane.setHalignment(btPoista, HPos.RIGHT);

        primaryStage.setTitle("Myyntituotteet:");
        primaryStage.setScene(new Scene(Kuvapaneeli, 600, 550));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
