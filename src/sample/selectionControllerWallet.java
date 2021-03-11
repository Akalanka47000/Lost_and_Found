package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class selectionControllerWallet {
    public static Stage foundWallet=new Stage();
    public static Stage lostWallet=new Stage();
    public void goBacktoChooseItem() throws Exception{
        chooseItemController.foundOrLostWallet.close();
        SignUp.chooseItem.show();
    }
    public void clickFoundWallet() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("wallets.fxml"));
        foundWallet.setTitle("Record details");
        foundWallet.setScene(new Scene(root, 540, 340));
        foundWallet.show();
        chooseItemController.foundOrLostWallet.close();
    }
    public void clickLostWallet() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("walletSearch.fxml"));
        lostWallet.setTitle("Search");
        lostWallet.setScene(new Scene(root, 490, 265));
        lostWallet.show();
        chooseItemController.foundOrLostWallet.close();
    }
}
