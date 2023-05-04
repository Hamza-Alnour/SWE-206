package com.example.swe_206;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisterSceneController {

    @FXML
    private Button HomeButton;

    @FXML
    private Button RegisterButton;

    @FXML
    private Text conformationText;

    @FXML
    void HomeClicked(ActionEvent event) {
        
        try {
            conformationText.setOpacity(0);
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow(); // getting the stage through the button
            FXMLLoader fxmlLoaderStudentChoiceScene = new FXMLLoader(HelloApplication.class.getResource("StudentChoice.fxml"));
            Scene studentChoiceScene = new Scene(fxmlLoaderStudentChoiceScene.load(), 600, 600);
            stage.setScene(studentChoiceScene);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void RegisterClicked(ActionEvent event) {
        conformationText.setOpacity(1);
    }

}
