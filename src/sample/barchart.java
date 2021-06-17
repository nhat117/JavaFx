package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

public class barchart extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Create hbox
        HBox hbox = new HBox(15);
        hbox.setAlignment(Pos.BOTTOM_CENTER);

        // Create content
        String[] label = {"Project", "Quiz", "Midterm", "Final"};
        double [] grade = {20,10,30,40};
        //Hight and width off rectabgke
        double max = getMax(grade);
        double height = 200;
        double width = 150;

        //Create 4 rec
        //Calculaate height according to the ratio
        Rectangle proj = new Rectangle(0,0,width,height*grade[0]/max);
        proj.setFill(Color.RED);
        Rectangle quiz = new Rectangle(0,0,width,height*grade[1]/max);
        quiz.setFill(Color.BLUE);
        Rectangle mid = new Rectangle(0,0,width,height*grade[2]/max);
        mid.setFill(Color.GREEN);
        Rectangle fin = new Rectangle(0,0,width,height*grade[3]/max);
        fin.setFill(Color.ORANGE);

        //Create 4 text obj
        Text tproj = new Text(0,0, label[0] + "--" + grade[0] + "%");
        Text tquiz = new Text(0,0, label[1] + "--" + grade[1] + "%");
        Text tmid = new Text(0,0, label[2] + "--" + grade[2] + "%");
        Text tfinal = new Text(0,0, label[3] + "--" + grade[3] + "%");

        // Create stack pane
        StackPane pane = new StackPane();
        // Create insert arround
        pane.setPadding(new Insets(20,15,5,15));
        hbox.getChildren().addAll(getV(tproj,proj), getV(tquiz,quiz),getV(tmid,mid),getV(tfinal,fin));
        pane.getChildren().add(hbox);
        //Always have all of this shit
        Scene scene = new Scene(pane);
        stage.setTitle("Bar Chart");
        stage.setScene(scene);
        stage.show();

    }

    public VBox getV(Text text, Rectangle rec) {
        VBox vBox = new VBox(6);
        vBox.setAlignment(Pos.BOTTOM_LEFT);
        vBox.getChildren().addAll(text,rec);
        return vBox;
    }

    public double getMax (double [] input) {
//        Set max to become the first index of the array
        double max = input[0];
        for(double i : input) {
            if(i > max) {
                i = max;
            }
        }
        return max;
    }
}
