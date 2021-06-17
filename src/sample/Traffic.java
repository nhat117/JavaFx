package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Traffic extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    //Add pane
    private final double  paneW = 400;
    private final double  paneH = 400;

    @Override
    public void start(Stage stage) throws Exception {
//    Create pane
        HBox paneTxt = new HBox();
        StackPane paneLight = new StackPane();
        GridPane paneC = new GridPane();
        HBox paneButt = new HBox(5);
        //Create a bane for all element
        BorderPane paneAll = new BorderPane();

        //Set Properties
        Rectangle rec = createRec();
        ArrayList <Circle> cir = creatCir();
        ArrayList <Button> butt = createButt();
        Text txt = createTxt();

        setPaneC(paneC,cir);
        setPaneTraff(paneLight, rec, paneC);
        setPaneButt(paneButt, butt);
        setPaneTxt(paneTxt,txt);

        setActButt(butt,cir);
        setPaneAll(paneAll, paneLight, paneButt, paneTxt);

//        Create scene
        createScene(stage, paneAll);

    }

    public void setPaneTxt(HBox paneTxt, Text txt) {
        paneTxt.getChildren().add(txt);
        //Set center position
        paneTxt.setAlignment(Pos.CENTER);
    }

    public void setPaneC (GridPane paneC, ArrayList<Circle> cir) {
        paneC.setAlignment(Pos.CENTER);
        paneC.setPadding(new Insets(5,5,5,5));
        paneC.setHgap(5);
        paneC.setVgap(5);
        // Add all cir into pane
        paneC.add(cir.get(0),1,1);
        paneC.add(cir.get(1),1,2);
        paneC.add(cir.get(2),1,3);
    }

    public void setPaneButt(HBox paneButt, ArrayList<javafx.scene.control.Button> butt) {
        paneButt.getChildren().addAll(butt.get(0),butt.get(1));
        paneButt.setAlignment(Pos.CENTER);
    }

    public void setPaneTraff(StackPane pane, Rectangle rec, GridPane cir) {
        pane.getChildren().add(rec);
        pane.getChildren().add(cir);
    }

    public Text createTxt () {
        Text txt = new Text("Traffic Light");
        txt.setFont(new Font("Arial", 40));
        return txt;
    }

    public void setPaneAll(BorderPane paneAll, StackPane pane, HBox buttPane, HBox txtpane) {
        paneAll.setCenter(pane);
        paneAll.setBottom(buttPane);
        paneAll.setTop(txtpane);
    }

    public void setActButt(ArrayList<javafx.scene.control.Button> butt, ArrayList<Circle> cir) {
        //Chain set action
        butt.get(0).setOnAction(e -> {
            cir.get(0).setFill(Color.RED);
            cir.get(1).setFill(Color.BLACK);
            cir.get(2).setFill(Color.BLACK);

            butt.get(0).setOnAction(e1-> {
                cir.get(0).setFill(Color.BLACK);
                cir.get(1).setFill(Color.BLACK);
                cir.get(2).setFill(Color.GREEN);

                butt.get(0).setOnAction(e2-> {
                    cir.get(0).setFill(Color.BLACK);
                    cir.get(1).setFill(Color.YELLOW);
                    cir.get(2).setFill(Color.BLACK);

                    setActButt(butt,cir);
                });
            });
        });
            //EXIT THE PROGRAM
            butt.get(1).setOnAction(e-> System.exit(1));
    }

    public ArrayList<javafx.scene.control.Button> createButt() {
        ArrayList<javafx.scene.control.Button> butt = new ArrayList<>();
        javafx.scene.control.Button next = new javafx.scene.control.Button("Next");
        javafx.scene.control.Button ext = new javafx.scene.control.Button("Exit");

        butt.add(next);
        butt.add(ext);
        return  butt;
    }

    public ArrayList<Circle> creatCir() {
        ArrayList <Circle> cir = new ArrayList<>();

        Circle red = new Circle(paneW/2,60,40);
        red.setStroke(Color.BLACK);
        red.setFill(Color.BLACK);

        Circle yellow = new Circle(paneW/2,60,40);
        yellow.setStroke(Color.BLACK);
        yellow.setFill(Color.BLACK);

        Circle green = new Circle(paneW/2,60,40);
        green.setStroke(Color.BLACK);
        green.setFill(Color.BLACK);

        cir.add(red);
        cir.add(yellow);
        cir.add(green);
        return cir;
    }

    public Rectangle createRec() {
        Rectangle rec = new Rectangle(125,150,125,300);
        rec.setFill(Color.BLUE);
        rec.setStroke(Color.BLACK);
        return  rec;
    }

    public void createScene(Stage stage, Pane paneAll) {
        //Set stage
        Scene scene = new Scene(paneAll,paneW, paneH + 100);
        stage.setScene(scene);
        stage.setTitle("Traffic Light");
        stage.show();
    }
}









