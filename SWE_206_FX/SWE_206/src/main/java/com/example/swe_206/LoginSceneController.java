package com.example.swe_206;

import java.io.IOException;

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
                String userType = "Student";
                Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow(); // getting the stage through the button
                if (id.equals("111") && password.equals("222")) {
                    if (userType.equals("Student")) { //student
                        FXMLLoader fxmlLoaderStudentChoiceScene = new FXMLLoader(HelloApplication.class.getResource("StudentChoice.fxml"));
                        Scene studentChoiceScene = new Scene(fxmlLoaderStudentChoiceScene.load(), 320, 240);
                        stage.setScene(studentChoiceScene);
                    } else if(userType.equals("Admin")) { // admin
                        FXMLLoader fxmlLoaderHomePageScene = new FXMLLoader(HelloApplication.class.getResource("Home page.fxml"));
                        Scene homePageScene = new Scene(fxmlLoaderHomePageScene.load(), 320, 240);
                        stage.setScene(homePageScene);
                    }
                    idError.setOpacity(0);
                    passworError.setOpacity(0);
                }else { // pass or id wrong
                    if (!id.equals(111)) {
                        idError.setOpacity(1);
                    } else {
                        idError.setOpacity(0);
                    }
                    if (!password.equals(222)) {
                        passworError.setOpacity(1);
                    } else {
                        passworError.setOpacity(0);
                    }
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
      

    }
    

}
