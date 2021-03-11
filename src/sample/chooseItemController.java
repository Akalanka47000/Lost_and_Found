package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class chooseItemController {
    public static Stage foundOrLostMobile=new Stage();
    public static Stage foundOrLostWallet=new Stage();
    @FXML
    Button goBack;

    @FXML
    Button btnMobile;

    @FXML
    Button btnWallet;

    @FXML
    public void clickMobile() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("selectionMobile.fxml"));
        foundOrLostMobile.setTitle("Found or Lost?");
        foundOrLostMobile.setScene(new Scene(root, 340, 220));
        foundOrLostMobile.show();
        SignUp.chooseItem.close();
    }
    public void clickWallet() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("selectionWallet.fxml"));
        foundOrLostWallet.setTitle("Found or Lost?");
        foundOrLostWallet.setScene(new Scene(root, 340, 220));
        foundOrLostWallet.show();
        SignUp.chooseItem.close();
    }

    public void goBacktoMain() throws Exception{
        SignUp.chooseItem.close();
        Controller.loginStage.show();
    }

}
