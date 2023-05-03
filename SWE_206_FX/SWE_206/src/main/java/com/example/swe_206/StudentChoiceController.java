package com.example.swe_206;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StudentChoiceController {
    HelloApplication h = new HelloApplication();
    ArrayList<Tournament> allTournaments = h.getTournamentList();
    ArrayList<Tournament> selectedTournaments = new ArrayList<>();

    @FXML
    private Button individualButton;

    @FXML
    private Button teamButton;

    @FXML
    void individualTransferScene(ActionEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow(); // getting the stage through the button
        try {
            FXMLLoader fxmlLoaderTournamentSelectionStudentScene = new FXMLLoader(HelloApplication.class.getResource("TournamentSelectionStudent.fxml"));
            Scene tournamentSelectionStudentScene;
            tournamentSelectionStudentScene = new Scene(fxmlLoaderTournamentSelectionStudentScene.load(), 320, 240);
            for (Tournament tournament : allTournaments) {
                if (tournament.getType().equals("Individual")) {
                    selectedTournaments.add(tournament);
                }
            }
            stage.setScene(tournamentSelectionStudentScene);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @FXML
    void teamTransferScene(ActionEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow(); // getting the stage through the button
        try {
            FXMLLoader fxmlLoaderTournamentSelectionStudentScene = new FXMLLoader(HelloApplication.class.getResource("TournamentSelectionStudent.fxml"));
            Scene tournamentSelectionStudentScene;
            tournamentSelectionStudentScene = new Scene(fxmlLoaderTournamentSelectionStudentScene.load(), 320, 240);
            for (Tournament tournament : allTournaments) {
                if (tournament.getType().equals("Team")) {
                    selectedTournaments.add(tournament);
                }
            }
            stage.setScene(tournamentSelectionStudentScene);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public ArrayList<Tournament> getSelectedTournaments() {
        return selectedTournaments;
    }
    

}