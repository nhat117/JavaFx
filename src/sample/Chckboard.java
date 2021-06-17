package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Chckboard extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Initialize Gridpane
        GridPane pane  = new GridPane();
        for(int i = 0,count = 0; i < 8; i ++,count ++) {
            for(int j = 0 ; j < 8; j ++) {
//                Lenght of the side
                Rectangle rec = new Rectangle(100,100,100,100);
                if (count % 2 == 0) {
                    //Set fill of the rectangle
                    rec.setFill(Color.WHITE);
                } else {
                    rec.setFill(Color.BLACK);
                }
                // Add rec to pame
                pane.add(rec, j ,i);
                count ++;
            }
        }
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Checker Board");
        stage.show();
    }
}
