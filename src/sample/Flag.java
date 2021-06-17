package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Flag extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        GridPane pane = disp();
        Scene scene = new Scene(pane);
        stage.setTitle("Flags");
        stage.setScene(scene);
        stage.show();
    }
    public ArrayList<ImageView> img() {
        ArrayList <ImageView> img = new ArrayList<>();


        img.add(new ImageView(new Image("https://www.countryflags.com/wp-content/uploads/france-flag-png-large.png")));
        img.add(new ImageView(new Image("https://upload.wikimedia.org/wikipedia/en/thumb/a/a4/Flag_of_the_United_States.svg/220px-Flag_of_the_United_States.svg.png")));
        img.add(new ImageView(new Image("https://upload.wikimedia.org/wikipedia/en/thumb/9/9e/Flag_of_Japan.svg/1024px-Flag_of_Japan.svg.png")));
        img.add(new ImageView(new Image("https://cdn.britannica.com/62/4562-004-C04E54C5/Flag-Taiwan.jpg")));

        //Loop through array image view to set the property
        for (ImageView i : img) {
            i.setPreserveRatio(true);
            i.setFitHeight(500);
            i.setFitWidth(500);
        }
        return img;
    }

    public GridPane disp() {
        ArrayList <ImageView> img = img();

        GridPane pane = new GridPane();
        pane.add(img.get(0),1,0);
        pane.add(img.get(1),0,1);
        pane.add(img.get(2),1,1);
        pane.add(img.get(3),0,0);

        return pane;
    }
}
