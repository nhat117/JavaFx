package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;

public class line extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
//        Create a new pane
        Pane pane  = new Pane();

//        Create 2 Circle
        ArrayList <Circle> arr = createCircle();

//        Create a line

        Line line= new Line(arr.get(0).getCenterX(),arr.get(0).getCenterY(), arr.get(1).getCenterX(),arr.get(1).getCenterY());

//        Create text
        ArrayList <Text> txt = txt(arr);

        pane.getChildren().addAll(line,arr.get(0),arr.get(1),txt.get(0),txt.get(1));

        setScene(pane, stage);
    }

    public ArrayList<Circle> createCircle() {
        ArrayList <Circle> arr = new ArrayList<>();

        Circle c1 = new Circle(Math.random()*201, Math.random() * 201, 15);
        c1.setFill(Color.WHITE);
        c1.setStroke(Color.BLACK);

        Circle c2 = new Circle(Math.random()*201,Math.random()*201,15);
        c2.setFill(Color.BLUE);
        c2.setStroke(Color.BLACK);
        arr.add(c1);
        arr.add(c2);
        return arr;
    }

    public ArrayList<Text> txt(ArrayList<Circle> inp) {
        ArrayList <Text> txt = new ArrayList<>();
        Text txt1 = new Text(inp.get(0).getCenterX(),inp.get(0).getCenterY(),"1");
        Text txt2 = new Text(inp.get(1).getCenterX(),inp.get(1).getCenterY(),"2");
        txt.add(txt1);
        txt.add(txt2);
        return txt;
    }

    public void setScene(Pane pane, Stage stage) {
        Scene scene = new Scene(pane);
        stage.setTitle("Two Circle");
        stage.setScene(scene);
        stage.show();
    }

}

