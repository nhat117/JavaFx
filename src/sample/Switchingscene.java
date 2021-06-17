package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class Switchingscene extends Application {
    Scene s1, s2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {

        Label l1 = new Label("Welcome to the first scene");
        Button butt = new Button("Yo");
        butt.setOnAction(e ->window.setScene(s2));
        //Set distance btw lable and text
        VBox layout = new VBox(20);
        layout.getChildren().addAll(l1,butt);
        s1 = new Scene(layout ,200,200);

        //Button 2
        Button butt2 = new Button("Fy");
        butt2.setOnAction(e ->window.setScene(s1));

        //Layout 3
        Label l2 = new Label("This is the second scene");
        StackPane layout2 = new StackPane();
        VBox l3= new VBox(20);
        l3.getChildren().addAll(l2,butt2);
        s2 = new Scene(l3,200,200);

        window.setScene(s1);
        window.setTitle("SAHGAHNS");
        window.show();

    }
}
