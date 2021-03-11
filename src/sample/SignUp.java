package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.jws.soap.SOAPBinding;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SignUp {
    public static Integer count;
    public static String data;
    public static Stage chooseItem=new Stage();
    public boolean found=false;
    @FXML
    Button btnBack;

    @FXML
    Button btnLogin;

    @FXML
    TextField txtUsername;

    @FXML
    PasswordField txtPassword;


    @FXML
    public void login() throws Exception{

        try {
            File myObj = new File("C:\\Users\\Akalanka Perera\\Downloads\\JavaFX project\\Lost items\\loginDetails.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNext() && found==false) {
                data = myReader.nextLine();
                count = 0;
                String Username = "";
                String Password;
                while (!data.substring(count, count + 1).equals(" ")) {
                    Username = Username + (data.substring(count,(count+1)));
                    count +=1;
                }
                count +=1;
                Password = data.substring(count,data.length());
                if (((txtUsername.getText()).equals(Username)) && ((txtPassword.getText()).equals(Password))){
                    Parent root = FXMLLoader.load(getClass().getResource("chooseItem.fxml"));
                    chooseItem.setTitle("Choose Item Type");
                    chooseItem.setScene(new Scene(root, 340, 175));
                    chooseItem.show();
                    Controller.loginStage.close();
                    found=true;
                }else{
                    found=false;
                }
                System.out.println(Username+" "+Password);
            }
            if (found==false) {
                Alert wrongLoginDetails = new Alert(Alert.AlertType.NONE);
                wrongLoginDetails.setAlertType(Alert.AlertType.WARNING);
                wrongLoginDetails.setContentText("Wrong Username or Password. Please re-enter");
                wrongLoginDetails.showAndWait();
            }
            myReader.close();
            found=false;
            Scanner myReader2 = new Scanner(myObj);


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @FXML
    public void goBacktoMain() throws Exception{
        Controller.loginStage.close();
        Main.Primarystage.show();
    }
}
