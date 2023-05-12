package com.example.swe_206;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ModificationController implements Initializable {
    static Scene scene;
    @FXML
    private TextField idTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField teamSizeTextField;
    @FXML
    private Button homeButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;

    static Tournament selectedTournament;

    public ModificationController() {
    }

    public void initialize(URL location, ResourceBundle resources) {
        if (selectedTournament != null) {
            idTextField.setText(String.valueOf(selectedTournament.getId()));
            nameTextField.setText(selectedTournament.getName());
            teamSizeTextField.setText(String.valueOf(selectedTournament.getPlayersPerTeam()));
        }
    }

    @FXML
    void homeButtonClicked() {
        HelloApplication.stage.setScene(HomePageController.scene);
    }

    @FXML
    void saveButtonClicked() {
        if (selectedTournament != null) {
            try {
                int id = Integer.parseInt(idTextField.getText());
                String name = nameTextField.getText();
                int teamSize = Integer.parseInt(teamSizeTextField.getText());
                selectedTournament.setId(id);
                selectedTournament.setName(name);
                selectedTournament.setPlayersPerTeam(teamSize);
                //selectedTournament.setLastModifiedDate(LocalDate.now());
                //HelloApplication.showAlert("Tournament updated successfully.");
                HelloApplication.stage.setScene(SelectTournamentToModify.scene);
            } catch (NumberFormatException e) {
                //HelloApplication.showAlert("Please enter valid values for ID and Team Size fields.");
            }
        }
    }

    @FXML
    void cancelButtonClicked() {
        HelloApplication.stage.setScene(SelectTournamentToModify.scene);
    }
}
