package com.example.swe_206;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class HomePageController {

    static Scene scene;

	@FXML
    private Button createButton;

    @FXML
    private Button editButton;

    @FXML
    private Button quitButton;

    @FXML
    private Button viewButton;

    @FXML
    void createClicked(ActionEvent event) {
		HelloApplication.stage.setScene(CreateNewTournament.scene);
    }

    @FXML
    void editClicked(ActionEvent event) {
		HelloApplication.stage.setScene(SelectTournamentToModify.scene);
    }

    @FXML
    void quitClicked(ActionEvent event) {

    }

    @FXML
    void viewClicked(ActionEvent event) {

    }

}
