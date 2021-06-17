package sample;

import com.sun.prism.shader.Solid_TextureRGB_AlphaTest_Loader;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.w3c.dom.Node;

import javax.swing.text.Element;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.util.ArrayList;

public class Main extends Application{
    javafx.scene.control.Button butt = new Button("Yo");
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello");
        //Need to make a layout
        StackPane layout = new StackPane();
        layout.getChildren().add(butt);
        //Anonymous inner class
        //Lambda Expression
        butt.setOnAction(e -> System.out.println("Fuck you !!"));
        Scene scene = new Scene(layout,1366,768);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
