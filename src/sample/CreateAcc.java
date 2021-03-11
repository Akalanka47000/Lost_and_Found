package sample;

import com.sun.org.apache.xpath.internal.operations.And;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import  java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CreateAcc {

    @FXML
    Button btnBack;

    @FXML
    Button btnCreate;

    @FXML
    TextField txtUsername;

    @FXML
    TextField txtEmail;

    @FXML
    PasswordField txtPassword;

    @FXML
    PasswordField txtConfirmPassword;

    public String username;
    public String password;
    public String email;
    public String confirmPassword;

    public static Integer count;
    public static String data;
    public static Stage chooseItem=new Stage();
    public boolean found=false;
    public boolean spaceFound;


    @FXML
    public void proceedWithCreation() throws Exception {
        username = txtUsername.getText();
        email = txtEmail.getText();
        password = txtPassword.getText();
        confirmPassword = txtConfirmPassword.getText();
        spaceFound = false;
        for (int i = 0; i < username.length(); i++) {
            String character = (username.substring(i, (i + 1)));
            if (character.equals(" ")) {
                spaceFound = true;
            }
        }
        if (spaceFound == true) {
            Alert spaceInUsername = new Alert(Alert.AlertType.NONE);
            spaceInUsername.setAlertType(Alert.AlertType.WARNING);
            spaceInUsername.setContentText("Username cannot contain any spaces. Please enter another username");
            spaceInUsername.showAndWait();
        } else {

            if (!password.equals(confirmPassword)) {
                Alert wrongPassword = new Alert(Alert.AlertType.NONE);
                wrongPassword.setAlertType(Alert.AlertType.WARNING);
                wrongPassword.setContentText("Passwords do not match. Please Re-enter");
                wrongPassword.showAndWait();
            } else {
                if (!username.equals("") && !password.equals("") && !email.equals("")) {
                    try {
                        File file = new File("C:\\Users\\Akalanka Perera\\Downloads\\JavaFX project\\Lost items\\loginDetails.txt");
                        FileWriter fr = new FileWriter(file, true);
                        File myObj = new File("C:\\Users\\Akalanka Perera\\Downloads\\JavaFX project\\Lost items\\loginDetails.txt");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNext() && found == false) {
                            data = myReader.nextLine();
                            count = 0;
                            String Username = "";
                            while (!data.substring(count, count + 1).equals(" ")) {
                                Username = Username + (data.substring(count, (count + 1)));
                                count += 1;
                            }
                            if (((username).equals(Username))) {
                                found = true;
                            } else {
                                found = false;
                            }
                        }
                        myReader.close();
                        if (found == true) {
                            Alert usernameExists = new Alert(Alert.AlertType.NONE);
                            usernameExists.setAlertType(Alert.AlertType.WARNING);
                            usernameExists.setContentText("Username already exists. Please enter another username");
                            usernameExists.showAndWait();
                        } else {
                            fr.write(System.lineSeparator() + username + " " + password);
                            fr.close();
                            Alert a = new Alert(Alert.AlertType.NONE);
                            a.setAlertType(Alert.AlertType.INFORMATION);
                            a.setContentText("Account created successfully. You may now login");
                            a.showAndWait().ifPresent(response -> {
                                if (response == ButtonType.OK) {
                                    Controller.createAccStage.close();
                                    Main.Primarystage.show();
                                }
                            });

                        }
                        found = false;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Alert emptyDetails = new Alert(Alert.AlertType.NONE);
                    emptyDetails.setAlertType(Alert.AlertType.WARNING);
                    emptyDetails.setContentText("All details have not been entered. Please fill them");
                    emptyDetails.showAndWait();
                }
            }
        }
    }
    @FXML
    public void goBacktoMain() throws Exception{
        Controller.createAccStage.close();
        Main.Primarystage.show();
    }
}
