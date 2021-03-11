package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MobileSearch {
    public static Integer count;
    public static String data;
    public boolean found = false;

    @FXML
    Button btnSearch;

    @FXML
    TextField txtBrand;

    @FXML
    TextField txtModel;

    @FXML
    TextField txtBuildingLostIn;

    @FXML
    TextField txtFloorLastSeen;

    @FXML
    public void Search() throws Exception {
        if (!txtBrand.getText().equals("") && !txtModel.getText().equals("") && !txtBuildingLostIn.getText().equals("") && !txtFloorLastSeen.getText().equals("")) {
            if (txtBuildingLostIn.getText().toUpperCase().equals("ONE")) {
                if ((txtFloorLastSeen.getText().toUpperCase()).equals("GROUND") | (txtFloorLastSeen.getText().toUpperCase()).equals("FIRST") | (txtFloorLastSeen.getText().toUpperCase()).equals("SECOND") | (txtFloorLastSeen.getText().toUpperCase()).equals("THIRD") | (txtFloorLastSeen.getText().toUpperCase()).equals("FOURTH") | (txtFloorLastSeen.getText().toUpperCase()).equals("FIFTH")) {
                    try {
                        File myObj = new File("C:\\Users\\Akalanka Perera\\Downloads\\JavaFX project\\Lost items\\Record Files\\Mobiles\\Building 1\\MB1Details.txt");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNext() && found == false) {
                            data = myReader.nextLine();
                            count = 0;
                            String Brand = "";
                            String Model = "";
                            String Floor = "";
                            String Name = "";
                            String Contact = "";
                            while (!data.substring(count, count + 1).equals(" ")) {
                                Brand = Brand + (data.substring(count, (count + 1)));
                                count += 1;
                            }
                            count += 1;
                            while (!data.substring(count, count + 1).equals(" ")) {
                                Model = Model + (data.substring(count, (count + 1)));
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
                            if (((txtBrand.getText().toUpperCase()).equals(Brand.toUpperCase())) && ((txtModel.getText().toUpperCase()).equals(Model.toUpperCase())) && ((txtFloorLastSeen.getText().toUpperCase()).equals(Floor.toUpperCase()))) {
                                Alert a = new Alert(Alert.AlertType.NONE);
                                a.setAlertType(Alert.AlertType.INFORMATION);
                                a.setContentText("Your mobile has been found. Contact " + Contact + " to reclaim it");
                                a.showAndWait().ifPresent(response -> {
                                    if (response == ButtonType.OK) {
                                        selectionControllerMobile.lostMobile.close();
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
                            wrongLoginDetails.setContentText("Sorry, your mobile is not in the found list");
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
                        File myObj = new File("C:\\Users\\Akalanka Perera\\Downloads\\JavaFX project\\Lost items\\Record Files\\Mobiles\\Building 2\\MB2Details.txt");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNext() && found == false) {
                            data = myReader.nextLine();
                            count = 0;
                            String Brand = "";
                            String Model = "";
                            String Floor = "";
                            String Name = "";
                            String Contact = "";
                            while (!data.substring(count, count + 1).equals(" ")) {
                                Brand = Brand + (data.substring(count, (count + 1)));
                                count += 1;
                            }
                            count += 1;
                            while (!data.substring(count, count + 1).equals(" ")) {
                                Model = Model + (data.substring(count, (count + 1)));
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
                            if (((txtBrand.getText().toUpperCase()).equals(Brand.toUpperCase())) && ((txtModel.getText().toUpperCase()).equals(Model.toUpperCase())) && ((txtFloorLastSeen.getText().toUpperCase()).equals(Floor.toUpperCase()))) {
                                Alert a = new Alert(Alert.AlertType.NONE);
                                a.setAlertType(Alert.AlertType.INFORMATION);
                                a.setContentText("Your mobile has been found. Contact " + Contact + " to reclaim it");
                                a.showAndWait().ifPresent(response -> {
                                    if (response == ButtonType.OK) {
                                        selectionControllerMobile.lostMobile.close();
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
                            wrongLoginDetails.setContentText("Sorry, your mobile is not in the found list");
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
                        File myObj = new File("C:\\Users\\Akalanka Perera\\Downloads\\JavaFX project\\Lost items\\Record Files\\Mobiles\\Building 3\\MB3Details.txt");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNext() && found == false) {
                            data = myReader.nextLine();
                            count = 0;
                            String Brand = "";
                            String Model = "";
                            String Floor = "";
                            String Name = "";
                            String Contact = "";
                            while (!data.substring(count, count + 1).equals(" ")) {
                                Brand = Brand + (data.substring(count, (count + 1)));
                                count += 1;
                            }
                            count += 1;
                            while (!data.substring(count, count + 1).equals(" ")) {
                                Model = Model + (data.substring(count, (count + 1)));
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
                            if (((txtBrand.getText().toUpperCase()).equals(Brand.toUpperCase())) && ((txtModel.getText().toUpperCase()).equals(Model.toUpperCase())) && ((txtFloorLastSeen.getText().toUpperCase()).equals(Floor.toUpperCase()))) {
                                Alert a = new Alert(Alert.AlertType.NONE);
                                a.setAlertType(Alert.AlertType.INFORMATION);
                                a.setContentText("Your mobile has been found. Contact " + Contact + " to reclaim it");
                                a.showAndWait().ifPresent(response -> {
                                    if (response == ButtonType.OK) {
                                        selectionControllerMobile.lostMobile.close();
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
                            mobileNotFound.setContentText("Sorry, your mobile is not in the found list");
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
            }else {
                Alert wrongBuilding = new Alert(Alert.AlertType.NONE);
                wrongBuilding.setAlertType(Alert.AlertType.WARNING);
                wrongBuilding.setContentText("Building " + txtBuildingLostIn.getText() + " does not exist. Please re-enter");
                wrongBuilding.showAndWait();
            }
        }else {
                Alert emptyDetails = new Alert(Alert.AlertType.NONE);
                emptyDetails.setAlertType(Alert.AlertType.WARNING);
                emptyDetails.setContentText("All details have not been entered. Please fill them");
                emptyDetails.showAndWait();
            }
        }





    public void goBacktoFoundOrLost() throws Exception{
        selectionControllerMobile.lostMobile.close();
        chooseItemController.foundOrLostMobile.show();
    }
}
