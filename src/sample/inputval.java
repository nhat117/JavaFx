package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class inputval extends Application {
    Scene scene;
    Button butt = new Button("Apply");

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Input Validation");

        //Form
        TextField name = new TextField();
        butt.setOnAction(e -> isINT(name) );
        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(name,butt);
        scene = new Scene(layout, 300, 250);
        stage.setScene(scene);
        stage.show();
    }

    private boolean isINT(TextField inp) {
        try {
            int age = Integer.parseInt(inp.getText());
            System.out.println("User is" + age);
            return  true;
        } catch (NumberFormatException e) {
            System.out.println("Error msg is not an INT");
            return false;
        }
    }
}
