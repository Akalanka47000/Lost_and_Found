package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;

public class selectionControllerMobile {

    @FXML
    Button btnLostMobile;

    @FXML
    Button btnFounfMobile;

    public static Stage foundMobile=new Stage();
    public static Stage lostMobile=new Stage();

    public void goBacktoChooseItem() throws Exception{
        chooseItemController.foundOrLostMobile.close();
        SignUp.chooseItem.show();
    }
    public void clickFoundMobile() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mobiles.fxml"));
        foundMobile.setTitle("Record details");
        foundMobile.setScene(new Scene(root, 440, 335));
        foundMobile.show();
        chooseItemController.foundOrLostMobile.close();
    }
    public void clickLostMobile() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mobileSearch.fxml"));
        lostMobile.setTitle("Search");
        lostMobile.setScene(new Scene(root, 440, 280));
        lostMobile.show();
        chooseItemController.foundOrLostMobile.close();
    }

}
