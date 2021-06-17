package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.RandomAccess;

public class card extends Application {
    public static void main(String[] args) {
        launch(args);
    }
//    Generate a random number
    private  static int [] arr = new int[3];

    public static void deal() {
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = rand();
        }
    }

    public static int rand() {
        int max = 52;
        int min = 1;
        Random random = new Random();
        //Algo for generate random number
        return random.nextInt((max-min) +1 ) + min;
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Setuo image view
        ImageView if1 = new ImageView();
        ImageView if2 = new ImageView();
        ImageView if3 = new ImageView();
        ArrayList <ImageView> inp = new ArrayList<>();
        inp.add(if1);
        inp.add(if2);
        inp.add(if3);
        javafx.scene.control.Button buttdeal = new javafx.scene.control.Button("Deal");
        javafx.scene.control.Button buttexit = new Button("Exit");

        // Disp score
        Text txt = new Text( "You have " + scorecalc() + " points");
        // Set evennt of the button

        buttdeal.setOnAction(e -> {
            deal();
            txt.setText("You have " + scorecalc() + " points");
            for (int i = 0; i < arr.length; i++) {
                dispimg(inp.get(i),arr[i]);
            }
        });
        // Exit the program
        buttexit.setOnAction(e -> System.exit(1));

        //Normal ui
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(5,5,5,5));
        pane.add(inp.get(0),1,1);
        pane.add(inp.get(1),2,1);
        pane.add(inp.get(2),3,1);
        pane.add(buttdeal,1,2);
        GridPane.setMargin(buttdeal, new Insets(30,0,40,150));
        pane.add(buttexit,3,2);
        GridPane.setMargin(buttexit, new Insets(30,150,40,0));
        pane.add(txt,2,2);
        GridPane.setMargin(buttdeal, new Insets(15,0,80,80));

        // Normal stuff
        Scene scene = new Scene(pane,610,400);
        stage.setScene(scene);
        stage.setTitle("Cards");
        stage.show();

    }

    public int scorecalc() {
        int score = 0;
        for (int i = 0; i <arr.length; i ++ ) {
            score +=score (arr[i]);
        }
        return score;
    }

//Check if the card is over 10 ?
    public int score(int a) {
        int res = a % 13;
        if(res > 10 || res == 0) {
            return  10;
        }
        return  res;
    }

    public void dispimg(ImageView inp, int a) {
        //Destination of card file
        inp.setImage(new Image("sample/cards/" + a + ".png"));
        //Set height of the card
        inp.setFitHeight(300);
        inp.setFitWidth(200);
    }
}
