package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;

public class Controller {
    @FXML
    Button btnNewAcc;

    @FXML
    Button btnLogin;

    public static Stage createAccStage=new Stage();
    public static Stage loginStage=new Stage();
    public static Stage AboutStage=new Stage();
    @FXML
    public void accCreate() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("createAcc.fxml"));
        createAccStage.setTitle("Create Account");
        createAccStage.setScene(new Scene(root, 340, 375));
        createAccStage.show();
        Main.Primarystage.close();
    }

    @FXML
    public void signUp() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("signUp.fxml"));
        loginStage.setTitle("Log into your account");
        loginStage.setScene(new Scene(root, 340, 245));
        loginStage.show();
        Main.Primarystage.close();
    }

    public void about() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("About.fxml"));
        AboutStage.setTitle("App info");
        AboutStage.setScene(new Scene(root, 540, 300));
        AboutStage.show();
    }

}
