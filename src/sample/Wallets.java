package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;

public class Wallets {
    @FXML
    TextField txtColor;

    @FXML
    TextField txtIDNum;

    @FXML
    TextField txtBuildingFound;

    @FXML
    TextField txtFloorFound;

    @FXML
    TextField txtName;

    @FXML
    TextField txtContact;

    public static String Color;
    public static String ID;
    public static String Building;
    public static String Floor;
    public static String Name;
    public static String Contact;
    public static Integer IntContact;
    public static Boolean contactFlag;
    public static Boolean validId;

    @FXML
    public void saveDetails() throws Exception {
        Color = txtColor.getText();
        ID = txtIDNum.getText();
        Building = txtBuildingFound.getText();
        Floor = txtFloorFound.getText();
        Name = txtName.getText();
        Contact = txtContact.getText();
        validId = false;
        try {
            IntContact = Integer.parseInt(Contact);
            contactFlag = true;
        } catch (NumberFormatException e) {
            contactFlag = false;
        }
        if (ID.length() == 10 | ID.length() == 12) {
            validId = true;
        } else if (ID.equals("-")) {
            validId = true;
        }else {
            validId=false;
        }
            if (!Color.equals("") && !ID.equals("") && !Building.equals("") && !Floor.equals("") && !Name.equals("") && !Contact.equals("")) {
                if (validId ==false) {
                    Alert wrongID = new Alert(Alert.AlertType.NONE);
                    wrongID.setAlertType(Alert.AlertType.WARNING);
                    wrongID.setContentText("Either enter a valid ID name or a dash if there was no ID in the wallet");
                    wrongID.showAndWait();
                } else {
                    if (Contact.length() != 10 | contactFlag == false) {
                        Alert invalidContact = new Alert(Alert.AlertType.NONE);
                        invalidContact.setAlertType(Alert.AlertType.WARNING);
                        invalidContact.setContentText("Invalid Phone number. Please re-enter");
                        invalidContact.showAndWait();
                    } else {
                        if (Building.toUpperCase().equals("ONE")) {
                            if ((Floor.toUpperCase()).equals("GROUND") | (Floor.toUpperCase()).equals("FIRST") | (Floor.toUpperCase()).equals("SECOND") | (Floor.toUpperCase()).equals("THIRD") | (Floor.toUpperCase()).equals("FOURTH") | (Floor.toUpperCase()).equals("FIFTH")) {
                                File file = new File("C:\\Users\\Akalanka Perera\\Downloads\\JavaFX project\\Lost items\\Record Files\\Wallets\\Building 1\\WB1Details.txt");
                                FileWriter fr = new FileWriter(file, true);
                                fr.write(System.lineSeparator() + Color + " " + ID + " " + Floor + " " + Name + " " + Contact);
                                fr.close();
                                Alert a = new Alert(Alert.AlertType.NONE);
                                a.setAlertType(Alert.AlertType.INFORMATION);
                                a.setContentText("Details entered successfully");
                                a.showAndWait().ifPresent(response -> {
                                    if (response == ButtonType.OK) {
                                        selectionControllerWallet.foundWallet.close();
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
                                File file = new File("C:\\Users\\Akalanka Perera\\Downloads\\JavaFX project\\Lost items\\Record Files\\Wallets\\Building 2\\WB2Details.txt");
                                FileWriter fr = new FileWriter(file, true);
                                fr.write(System.lineSeparator() + Color + " " + ID + " " + Floor + " " + Name + " " + Contact);
                                fr.close();
                                Alert a = new Alert(Alert.AlertType.NONE);
                                a.setAlertType(Alert.AlertType.INFORMATION);
                                a.setContentText("Details entered successfully");
                                a.showAndWait().ifPresent(response -> {
                                    if (response == ButtonType.OK) {
                                        selectionControllerWallet.foundWallet.close();
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
                                File file = new File("C:\\Users\\Akalanka Perera\\Downloads\\JavaFX project\\Lost items\\Record Files\\Wallets\\Building 3\\WB3Details.txt");
                                FileWriter fr = new FileWriter(file, true);
                                fr.write(System.lineSeparator() + Color + " " + ID + " " + Floor + " " + Name + " " + Contact);
                                fr.close();
                                Alert a = new Alert(Alert.AlertType.NONE);
                                a.setAlertType(Alert.AlertType.INFORMATION);
                                a.setContentText("Details entered successfully");
                                a.showAndWait().ifPresent(response -> {
                                    if (response == ButtonType.OK) {
                                        selectionControllerWallet.foundWallet.close();
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
                }

            } else {
                Alert emptyDetails = new Alert(Alert.AlertType.NONE);
                emptyDetails.setAlertType(Alert.AlertType.WARNING);
                emptyDetails.setContentText("All details have not been entered. Please fill them");
                emptyDetails.showAndWait();
            }

        }




    public void goBacktoFoundOrLost() throws Exception{
        selectionControllerWallet.foundWallet.close();
        chooseItemController.foundOrLostWallet.show();
    }
}
