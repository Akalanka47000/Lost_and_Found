package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WalletSearch {
    public static Integer count;
    public static String data;
    public boolean found = false;
    public static boolean validId;

    @FXML
    Button btnSearch;

    @FXML
    TextField txtColor;

    @FXML
    TextField txtID;

    @FXML
    TextField txtBuildingLostIn;

    @FXML
    TextField txtFloorLastSeen;

    @FXML
    public void Search() throws Exception {
        if (txtID.getText().length() == 10 | txtID.getText().length() == 12) {
            validId = true;
        } else if (txtID.getText().equals("-")) {
            validId = true;
        } else {
            validId = false;
        }
            if (!txtColor.getText().equals("") && !txtID.getText().equals("") && !txtBuildingLostIn.getText().equals("") && !txtFloorLastSeen.getText().equals("")) {
                if (validId == false) {
                    Alert wrongID = new Alert(Alert.AlertType.NONE);
                    wrongID.setAlertType(Alert.AlertType.WARNING);
                    wrongID.setContentText("Either enter a valid ID name or a dash if there was no ID in the wallet");
                    wrongID.showAndWait();
                } else {
                    if (txtBuildingLostIn.getText().toUpperCase().equals("ONE")) {
                        if ((txtFloorLastSeen.getText().toUpperCase()).equals("GROUND") | (txtFloorLastSeen.getText().toUpperCase()).equals("FIRST") | (txtFloorLastSeen.getText().toUpperCase()).equals("SECOND") | (txtFloorLastSeen.getText().toUpperCase()).equals("THIRD") | (txtFloorLastSeen.getText().toUpperCase()).equals("FOURTH") | (txtFloorLastSeen.getText().toUpperCase()).equals("FIFTH")) {
                            try {
                                File myObj = new File("C:\\Users\\Akalanka Perera\\Downloads\\JavaFX project\\Lost items\\Record Files\\Wallets\\Building 1\\WB1Details.txt");
                                Scanner myReader = new Scanner(myObj);
                                while (myReader.hasNext() && found == false) {
                                    data = myReader.nextLine();
                                    count = 0;
                                    String Color = "";
                                    String IDNum = "";
                                    String Floor = "";
                                    String Name = "";
                                    String Contact = "";
                                    while (!data.substring(count, count + 1).equals(" ")) {
                                        Color = Color + (data.substring(count, (count + 1)));
                                        count += 1;
                                    }
                                    count += 1;
                                    while (!data.substring(count, count + 1).equals(" ")) {
                                        IDNum = IDNum + (data.substring(count, (count + 1)));
                                        count += 1;
                                    }
                                    count += 1;
                                    while (!data.substring(count, count + 1).equals(" ")) {
                                        Floor = Floor + (data.substring(count, (count + 1)));
                                        count += 1;
                                    }
                                    count += 1;
                                    while (!data.substring(count, count + 1).equals(" ")) {
                                        Name = Name + (data.substring(count, (count + 1)));
                                        count += 1;
                                    }
                                    count += 1;
                                    Contact = data.substring(count, data.length());
                                    if (((txtColor.getText().toUpperCase()).equals(Color.toUpperCase())) && ((txtID.getText().toUpperCase()).equals(IDNum.toUpperCase())) && ((txtFloorLastSeen.getText().toUpperCase()).equals(Floor.toUpperCase()))) {
                                        Alert a = new Alert(Alert.AlertType.NONE);
                                        a.setAlertType(Alert.AlertType.INFORMATION);
                                        a.setContentText("Your wallet has been found. Contact " + Contact + " to reclaim it");
                                        a.showAndWait().ifPresent(response -> {
                                            if (response == ButtonType.OK) {
                                                selectionControllerWallet.lostWallet.close();
                                                SignUp.chooseItem.show();
                                            }
                                        });
                                        found = true;
                                    } else {
                                        found = false;
                                    }
                                    //System.out.println(Username + " " + Password);
                                }
                                if (found == false) {
                                    Alert wrongLoginDetails = new Alert(Alert.AlertType.NONE);
                                    wrongLoginDetails.setAlertType(Alert.AlertType.INFORMATION);
                                    wrongLoginDetails.setContentText("Sorry, your wallet is not in the found list");
                                    wrongLoginDetails.showAndWait();
                                }
                                myReader.close();
                                found = false;


                            } catch (FileNotFoundException e) {
                                System.out.println("An error occurred.");
                                e.printStackTrace();
                            }
                        } else {
                            Alert invalidFloor = new Alert(Alert.AlertType.NONE);
                            invalidFloor.setAlertType(Alert.AlertType.WARNING);
                            invalidFloor.setContentText("Floor " + txtFloorLastSeen.getText() + " does not exist. Please re-enter");
                            invalidFloor.showAndWait();
                        }
                    } else if (txtBuildingLostIn.getText().toUpperCase().equals("TWO")) {
                        if ((txtFloorLastSeen.getText().toUpperCase()).equals("GROUND") | (txtFloorLastSeen.getText().toUpperCase()).equals("SECOND") | (txtFloorLastSeen.getText().toUpperCase()).equals("THIRD")) {
                            try {
                                File myObj = new File("C:\\Users\\Akalanka Perera\\Downloads\\JavaFX project\\Lost items\\Record Files\\Wallets\\Building 2\\WB2Details.txt");
                                Scanner myReader = new Scanner(myObj);
                                while (myReader.hasNext() && found == false) {
                                    data = myReader.nextLine();
                                    count = 0;
                                    String Color = "";
                                    String IDNum = "";
                                    String Floor = "";
                                    String Name = "";
                                    String Contact = "";
                                    while (!data.substring(count, count + 1).equals(" ")) {
                                        Color = Color + (data.substring(count, (count + 1)));
                                        count += 1;
                                    }
                                    count += 1;
                                    while (!data.substring(count, count + 1).equals(" ")) {
                                        IDNum = IDNum + (data.substring(count, (count + 1)));
                                        count += 1;
                                    }
                                    count += 1;
                                    while (!data.substring(count, count + 1).equals(" ")) {
                                        Floor = Floor + (data.substring(count, (count + 1)));
                                        count += 1;
                                    }
                                    count += 1;
                                    while (!data.substring(count, count + 1).equals(" ")) {
                                        Name = Name + (data.substring(count, (count + 1)));
                                        count += 1;
                                    }
                                    count += 1;
                                    Contact = data.substring(count, data.length());
                                    if (((txtColor.getText().toUpperCase()).equals(Color.toUpperCase())) && ((txtID.getText().toUpperCase()).equals(IDNum.toUpperCase())) && ((txtFloorLastSeen.getText().toUpperCase()).equals(Floor.toUpperCase()))) {
                                        Alert a = new Alert(Alert.AlertType.NONE);
                                        a.setAlertType(Alert.AlertType.INFORMATION);
                                        a.setContentText("Your wallet has been found. Contact " + Contact + " to reclaim it");
                                        a.showAndWait().ifPresent(response -> {
                                            if (response == ButtonType.OK) {
                                                selectionControllerWallet.lostWallet.close();
                                                SignUp.chooseItem.show();
                                            }
                                        });
                                        found = true;
                                    } else {
                                        found = false;
                                    }
                                    //System.out.println(Username + " " + Password);
                                }
                                if (found == false) {
                                    Alert wrongLoginDetails = new Alert(Alert.AlertType.NONE);
                                    wrongLoginDetails.setAlertType(Alert.AlertType.INFORMATION);
                                    wrongLoginDetails.setContentText("Sorry, your wallet is not in the found list");
                                    wrongLoginDetails.showAndWait();
                                }
                                myReader.close();
                                found = false;


                            } catch (FileNotFoundException e) {
                                System.out.println("An error occurred.");
                                e.printStackTrace();
                            }
                        } else {
                            Alert invalidFloor = new Alert(Alert.AlertType.NONE);
                            invalidFloor.setAlertType(Alert.AlertType.WARNING);
                            invalidFloor.setContentText("Floor " + txtFloorLastSeen.getText() + " does not exist. Please re-enter");
                            invalidFloor.showAndWait();
                        }
                    } else if (txtBuildingLostIn.getText().toUpperCase().equals("THREE")) {
                        if ((txtFloorLastSeen.getText().toUpperCase()).equals("GROUND") | (txtFloorLastSeen.getText().toUpperCase()).equals("FIRST") | (txtFloorLastSeen.getText().toUpperCase()).equals("SECOND") | (txtFloorLastSeen.getText().toUpperCase()).equals("THIRD")) {
                            try {
                                File myObj = new File("C:\\Users\\Akalanka Perera\\Downloads\\JavaFX project\\Lost items\\Record Files\\Wallets\\Building 3\\WB3Details.txt");
                                Scanner myReader = new Scanner(myObj);
                                while (myReader.hasNext() && found == false) {
                                    data = myReader.nextLine();
                                    count = 0;
                                    String Color = "";
                                    String IDNum = "";
                                    String Floor = "";
                                    String Name = "";
                                    String Contact = "";
                                    while (!data.substring(count, count + 1).equals(" ")) {
                                        Color = Color + (data.substring(count, (count + 1)));
                                        count += 1;
                                    }
                                    count += 1;
                                    while (!data.substring(count, count + 1).equals(" ")) {
                                        IDNum = IDNum + (data.substring(count, (count + 1)));
                                        count += 1;
                                    }
                                    count += 1;
                                    while (!data.substring(count, count + 1).equals(" ")) {
                                        Floor = Floor + (data.substring(count, (count + 1)));
                                        count += 1;
                                    }
                                    count += 1;
                                    while (!data.substring(count, count + 1).equals(" ")) {
                                        Name = Name + (data.substring(count, (count + 1)));
                                        count += 1;
                                    }
                                    count += 1;
                                    Contact = data.substring(count, data.length());
                                    if (((txtColor.getText().toUpperCase()).equals(Color.toUpperCase())) && ((txtID.getText().toUpperCase()).equals(IDNum.toUpperCase())) && ((txtFloorLastSeen.getText().toUpperCase()).equals(Floor.toUpperCase()))) {
                                        Alert a = new Alert(Alert.AlertType.NONE);
                                        a.setAlertType(Alert.AlertType.INFORMATION);
                                        a.setContentText("Your wallet has been found. Contact " + Contact + " to reclaim it");
                                        a.showAndWait().ifPresent(response -> {
                                            if (response == ButtonType.OK) {
                                                selectionControllerWallet.lostWallet.close();
                                                SignUp.chooseItem.show();
                                            }
                                        });
                                        found = true;
                                    } else {
                                        found = false;
                                    }
                                    //System.out.println(Username + " " + Password);
                                }
                                if (found == false) {
                                    Alert mobileNotFound = new Alert(Alert.AlertType.NONE);
                                    mobileNotFound.setAlertType(Alert.AlertType.INFORMATION);
                                    mobileNotFound.setContentText("Sorry, your wallet is not in the found list");
                                    mobileNotFound.showAndWait();
                                }
                                myReader.close();
                                found = false;


                            } catch (FileNotFoundException e) {
                                System.out.println("An error occurred.");
                                e.printStackTrace();
                            }
                        } else {
                            Alert invalidFloor = new Alert(Alert.AlertType.NONE);
                            invalidFloor.setAlertType(Alert.AlertType.WARNING);
                            invalidFloor.setContentText("Floor " + txtFloorLastSeen.getText() + " does not exist. Please re-enter");
                            invalidFloor.showAndWait();
                        }
                    } else {
                        Alert wrongBuilding = new Alert(Alert.AlertType.NONE);
                        wrongBuilding.setAlertType(Alert.AlertType.WARNING);
                        wrongBuilding.setContentText("Building " + txtBuildingLostIn.getText() + " does not exist. Please re-enter");
                        wrongBuilding.showAndWait();
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
        selectionControllerWallet.lostWallet.close();
        chooseItemController.foundOrLostWallet.show();
    }
}
