package pong;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    //Variable
    private static final int w = 800;
    private static final int h = 600;
    private static final double pHeight = 100;
    private static final double pWidth = 15;
    private static final int rBall = 15;
    //Ball Component
    private int vXBall = 1;
    private int vYBall = 1;

    private int ballXPos = w/2;
    private int ballYPos = h/2;

    //Variable Component
    private int p1Score = 0;
    private int p2Score = 0;

    private double p1YPos = h/2;
    private double p2YPos = h/2;

    private double p1XPos = 0;
    private double p2XPos = w - pWidth;

    private boolean gameStart;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Ping Pong");
        //Inititate canvas
        Canvas canvas = new Canvas(w,h);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Timeline t1 = new Timeline(new KeyFrame(Duration.millis(10), e ->run(gc) ));
        t1.setCycleCount(Timeline.INDEFINITE);

        //Set up mouse controll
        canvas.setOnMouseMoved(e -> p1YPos = e.getY());
        canvas.setOnMouseClicked(e -> gameStart = true);
        stage.setScene(new Scene(new StackPane(canvas)));
        stage.show();
        t1.play();
    }

    private void run(GraphicsContext gc) {
        //Set Back ground color
        gc.setFill(Color.BROWN);
        gc.fillRect(0,0, w, h);

        //Set Text
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font(25));

        //Game logic
        if (gameStart) {
            ballXPos += vXBall;
            ballYPos += vYBall;

          //Bot
            if(ballXPos < (w - w/4)) {
                p2YPos = ballYPos - pHeight /2;
            } else  {
                p2YPos = ballYPos > p2YPos + pHeight/2 ? p2YPos += 1 : p2YPos -- ;
            }

            //Draw ball
            gc.fillOval(ballXPos,ballYPos,rBall,rBall);
        } else {
            //Set start Text
            gc.setStroke(Color.WHITE);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.strokeText("Welcome to Ping Pong Game. Let's Play", w/2,h/2 );

            //Reset the ball start position
            ballXPos = w/2;
            ballYPos = h/2;

            //Reset the speed & direction
            vXBall = new Random().nextInt(2) == 0 ? 1 : -1;
            vYBall = new Random().nextInt(2) == 0 ? 1 : -1;
        }

        //Make sure the ball stay on the canvas
        if(ballYPos > h || ballYPos < 0) {
            vYBall *= -1;
        }

        //Point mechanism
        //Computer get point
        if(ballXPos < p1XPos - pWidth) {
            p2Score ++;
            gameStart = false;
        }
        //Player get point
        if(ballXPos > p2XPos + pWidth) {
            p1Score ++;
            gameStart = false;
        }

        //Increase the ball speed
        if((ballXPos + rBall > p2XPos && ballYPos >= p2YPos && ballYPos <=p2YPos + pHeight) ||
                (ballXPos < p1XPos + pWidth && ballYPos >= p1YPos && ballYPos <=p1YPos + pHeight)) {
            vYBall += 1* Math.signum(vYBall);
            vXBall += 1 * Math.signum(vXBall);
            vYBall *= -1;
            vXBall *= -1;
        }

        //Draw Score
        gc.fillText(p1Score + "\t\t\t\t\t\t\t\t\t\t\t" + p2Score, w/2,100 );

        //Draw 2 player
        gc.fillRect(p1XPos, p1YPos, pWidth, pHeight);
        gc.fillRect(p2XPos, p2YPos, pWidth, pHeight);
    }
}