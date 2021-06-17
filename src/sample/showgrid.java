package sample;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class showgrid extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5,12.5,13.5,14.5));
        //Set Gap btw Node
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        //Place node in the pane
        pane.add(new Label("First Name:"), 0, 0);
        pane.add(new TextField(),1,0);
        pane.add(new Label("MI: "), 0, 1);
        pane.add(new TextField(),1,1);
        pane.add(new Label("Last Name: "),0,2);
        pane.add(new TextField(),1,2);
        Button buttadd = new Button("Add Name");
        pane.add(buttadd,0,3);
        GridPane.setHalignment(buttadd, HPos.RIGHT);

        // Create a new scene
        Scene scene = new Scene(pane);
        stage.setTitle("Show Grid Pane");
        stage.setScene(scene);
        stage.show();
    }
}
