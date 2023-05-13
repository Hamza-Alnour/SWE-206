package com.example.swe_206;

import java.io.IOException;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
      FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("modifyTournament.fxml"));
      try {
        ModificationController.scene = new Scene(fxmlLoader.load(), 800, 500);
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
		  HelloApplication.stage.setScene(SelectTournamentToModify.scene);
    }

    @FXML
    void quitClicked(ActionEvent event) {
      HelloApplication.saveTournaments("currentTournaments.dat", HelloApplication.tournamentListOG);
      HelloApplication.saveTournaments("archivedTournaments.dat",HelloApplication.tournamentListOGArchived);
      HelloApplication.saveSports();
      Platform.exit();
    }

    @FXML
    void viewClicked(ActionEvent event) {
      
		  HelloApplication.stage.setScene(SelectTournamentToViewArchivedController.scene);
    }

}
