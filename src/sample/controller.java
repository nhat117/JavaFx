package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class controller {
    @FXML private TextField name;
    @FXML
    private void handleButtonAction (ActionEvent event) {
        System.out.println(name.getText());
    }

}
