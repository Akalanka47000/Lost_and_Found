package sample;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Main extends Application {
    public static Stage Primarystage;
    public static Stage splashStage=new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Primarystage=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml")) ;
        primaryStage.setTitle("Lost and Found");
        primaryStage.setScene(new Scene(root, 475, 320));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
