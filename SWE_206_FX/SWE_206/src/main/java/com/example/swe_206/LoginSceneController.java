package com.example.swe_206;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LoginSceneController {

    @FXML
    private Button LoginButton;

    @FXML
    private Text idError;
    @FXML
    private TextField idTextField;

    @FXML
    private Text passworError;

    @FXML
    private TextField passwordTextField;

    @FXML
    void loginAttempt(ActionEvent event) {


        try {
            String id = idTextField.getText();
            String password = passwordTextField.getText();

            String userType =  APITest.checkCredentials(id, password);

            if (userType.isEmpty()) {
                // pass or id wrong
                idError.setOpacity(1);
                passworError.setOpacity(1);
            } else {
                // Check the userType and load the appropriate scene
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                if (userType.equals("Student")) {
                    FXMLLoader fxmlLoaderStudentChoiceScene = new FXMLLoader(HelloApplication.class.getResource("StudentChoice.fxml"));
                    Scene studentChoiceScene = new Scene(fxmlLoaderStudentChoiceScene.load(), 320, 240);
                    stage.setScene(studentChoiceScene);
                } else if (userType.equals("Admin")) {
                    FXMLLoader fxmlLoaderHomePageScene = new FXMLLoader(HelloApplication.class.getResource("Home page.fxml"));
                    Scene homePageScene = new Scene(fxmlLoaderHomePageScene.load(), 320, 240);
                    stage.setScene(homePageScene);
                } else { // If userType is still empty, show error messages
                    idError.setOpacity(1);
                    passworError.setOpacity(1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

// Method to check if the ID and password match any record in the given file
        public boolean checkCredentials(String id, String password, String filename) {
            boolean found = false;
            try {
                Scanner scanner = new Scanner(new File(filename));
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] fields = line.split(",");
                    if (fields.length >= 2 && fields[0].equals(id) && fields[1].equals(password)) {
                        found = true;
                        break;
                    }
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return found;
        }
}
