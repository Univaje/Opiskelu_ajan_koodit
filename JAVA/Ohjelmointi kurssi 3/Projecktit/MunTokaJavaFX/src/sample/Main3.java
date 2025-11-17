package sample;

/*
Creator: Sam
Date: 16.02.2021
Version: 0.1
Description:

*/import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
public class Main3 extends Application
{
    @Override // korvaa metodin start luokassa Application
    public void start(Stage alkuIkkuna)
    {
        // luodaan paneeli ja sijoitetaan siihen button olio
        StackPane paneeli = new StackPane();
        paneeli.getChildren().add(new Button("OK"));
        // sijoitetaan paneeli kehykseen
        Scene kehys = new Scene(paneeli, 200, 50);
        alkuIkkuna. setTitle("Painike paneelissa"); // otsikko ikkunalle
        alkuIkkuna.setScene(kehys); // sijoitetaan kehys ikkunaan
        alkuIkkuna.show(); // näytetään ikkuna


    }

    public static void main(String [] args)
    {
        Application.launch(args);
    }
}
