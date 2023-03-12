package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MyController {
    public Label helloWorld;
    public Button btnShit;
    public Button btnPickle;

    public void sayHelloWorld(ActionEvent actionEvent) {
        helloWorld.setText("Shit pickle!");
        if (btnPickle.isVisible()== false){
            btnPickle.setVisible(true);
        }
    }

    public void sayHello(ActionEvent actionEvent) {
        btnShit.setText("Pickled Shit!");
        btnPickle.setVisible(false);
    }
}
