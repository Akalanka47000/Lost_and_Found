package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;

public class Mobiles {
    @FXML
    TextField txtBrand;

    @FXML
    TextField txtModel;

    @FXML
    TextField txtBuildingFound;

    @FXML
    TextField txtFloorFound;

    @FXML
    TextField txtName;

    @FXML
    TextField txtContact;

    public static String Brand;
    public static String Model;
    public static String Building;
    public static String Floor;
    public static String Name;
    public static String Contact;
    public static Integer IntContact;
    public static Boolean contactFlag;

    @FXML
    public void saveDetails() throws Exception{
        Brand=txtBrand.getText();
        Model=txtModel.getText();
        Building=txtBuildingFound.getText();
        Floor=txtFloorFound.getText();
        Name=txtName.getText();
        Contact=txtContact.getText();
        try {
           IntContact=Integer.parseInt(Contact);
           contactFlag=true;
        }catch (NumberFormatException e) {
            contactFlag=false;
        }

        if (!Brand.equals("") && !Model.equals("") && !Building.equals("") && !Floor.equals("") && !Name.equals("") && !Contact.equals("")) {
            if (Contact.length()!=10 | contactFlag==false)  {
                Alert invalidContact = new Alert(Alert.AlertType.NONE);
                invalidContact.setAlertType(Alert.AlertType.WARNING);
                invalidContact.setContentText("Invalid Phone number. Please re-enter");
                invalidContact.showAndWait();
            }else {
                if (Building.toUpperCase().equals("ONE")) {
                    if ((Floor.toUpperCase()).equals("GROUND") | (Floor.toUpperCase()).equals("FIRST") | (Floor.toUpperCase()).equals("SECOND") | (Floor.toUpperCase()).equals("THIRD") | (Floor.toUpperCase()).equals("FOURTH") | (Floor.toUpperCase()).equals("FIFTH")) {
                        File file = new File("C:\\Users\\Akalanka Perera\\Downloads\\JavaFX project\\Lost items\\Record Files\\Mobiles\\Building 1\\MB1Details.txt");
                        FileWriter fr = new FileWriter(file, true);
                        fr.write(System.lineSeparator() + Brand + " " + Model + " " + Floor +" "+Name+" "+Contact);
                        fr.close();
                        Alert a = new Alert(Alert.AlertType.NONE);
                        a.setAlertType(Alert.AlertType.INFORMATION);
                        a.setContentText("Details entered successfully");
                        a.showAndWait().ifPresent(response -> {
                            if (response == ButtonType.OK) {
                                selectionControllerMobile.foundMobile.close();
                                SignUp.chooseItem.show();
                            }
                        });
                    } else {
                        Alert invalidFloor = new Alert(Alert.AlertType.NONE);
                        invalidFloor.setAlertType(Alert.AlertType.WARNING);
                        invalidFloor.setContentText("Floor " + Floor + " does not exist. Please re-enter");
                        invalidFloor.showAndWait();
                    }
                } else if (Building.toUpperCase().equals("TWO")) {
                    if ((Floor.toUpperCase()).equals("GROUND") | (Floor.toUpperCase()).equals("SECOND") | (Floor.toUpperCase()).equals("THIRD")) {
                        File file = new File("C:\\Users\\Akalanka Perera\\Downloads\\JavaFX project\\Lost items\\Record Files\\Mobiles\\Building 2\\MB2Details.txt");
                        FileWriter fr = new FileWriter(file, true);
                        fr.write(System.lineSeparator() + Brand + " " + Model + " " + Floor+" "+Name+" "+Contact);
                        fr.close();
                        Alert a = new Alert(Alert.AlertType.NONE);
                        a.setAlertType(Alert.AlertType.INFORMATION);
                        a.setContentText("Details entered successfully");
                        a.showAndWait().ifPresent(response -> {
                            if (response == ButtonType.OK) {
                                selectionControllerMobile.foundMobile.close();
                                SignUp.chooseItem.show();
                            }
                        });
                    } else {
                        Alert invalidFloor = new Alert(Alert.AlertType.NONE);
                        invalidFloor.setAlertType(Alert.AlertType.WARNING);
                        invalidFloor.setContentText("Floor " + Floor + " does not exist. Please re-enter");
                        invalidFloor.showAndWait();
                    }
                } else if (Building.toUpperCase().equals("THREE")) {
                    if ((Floor.toUpperCase()).equals("GROUND") | (Floor.toUpperCase()).equals("FIRST") | (Floor.toUpperCase()).equals("SECOND") | (Floor.toUpperCase()).equals("THIRD")) {
                        File file = new File("C:\\Users\\Akalanka Perera\\Downloads\\JavaFX project\\Lost items\\Record Files\\Mobiles\\Building 3\\MB3Details.txt");
                        FileWriter fr = new FileWriter(file, true);
                        fr.write(System.lineSeparator() + Brand + " " + Model + " " + Floor+" "+Name+" "+Contact);
                        fr.close();
                        Alert a = new Alert(Alert.AlertType.NONE);
                        a.setAlertType(Alert.AlertType.INFORMATION);
                        a.setContentText("Details entered successfully");
                        a.showAndWait().ifPresent(response -> {
                            if (response == ButtonType.OK) {
                                selectionControllerMobile.foundMobile.close();
                                SignUp.chooseItem.show();
                            }
                        });
                    } else {
                        Alert invalidFloor = new Alert(Alert.AlertType.NONE);
                        invalidFloor.setAlertType(Alert.AlertType.WARNING);
                        invalidFloor.setContentText("Floor " + Floor + " does not exist. Please re-enter");
                        invalidFloor.showAndWait();
                    }
                } else {
                    Alert invalidBuilding = new Alert(Alert.AlertType.NONE);
                    invalidBuilding.setAlertType(Alert.AlertType.WARNING);
                    invalidBuilding.setContentText("Building " + Building + " does not exist. Please re-enter");
                    invalidBuilding.showAndWait();
                }
            }

        }else{
            Alert emptyDetails = new Alert(Alert.AlertType.NONE);
            emptyDetails.setAlertType(Alert.AlertType.WARNING);
            emptyDetails.setContentText("All details have not been entered. Please fill them");
            emptyDetails.showAndWait();
        }

    }



    public void goBacktoFoundOrLost() throws Exception{
        selectionControllerMobile.foundMobile.close();
        chooseItemController.foundOrLostMobile.show();
    }
}
