package com.example.swe_206;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
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
    void saveButtonClicked(ActionEvent event) {
        if (selectedTournament != null) {
            try {

                    String name = nameTextField.getText();
                    int teamSize = Integer.parseInt(teamSizeTextField.getText());
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
    void TableEvent(ActionEvent event) {
        Matchf matchf = new Matchf(selectedTournament);
        TableView<Matchf> tableView = matchf.getTV();
        scene.setRoot(tableView);
        matchf.setTeam1Name("Team 1");
        matchf.getTeam1Score().setText("2");
        matchf.setTeam2Name("Team 2");
        matchf.getTeam2Score().setText("1");
        ObservableList<Matchf> matches = FXCollections.observableArrayList();
        matches.add(new Matchf(selectedTournament));
        tableView.setItems(matches);

    }

    @FXML
    void cancelButtonClicked(ActionEvent event) {
        HelloApplication.stage.setScene(SelectTournamentToModify.scene);
    }
}
