package com.example.swe_206;

import java.io.IOException;
import java.util.ArrayList;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    static ObservableList<Tournament> selectedTournaments = FXCollections.observableArrayList();

    @FXML
    private Button individualButton;

    @FXML
    private Button teamButton;

    @FXML
    void individualTransferScene(ActionEvent event) {
        selectedTournaments.clear();
        for (Tournament tournament : allTournaments) {
            if (tournament.getParticipationType().equals("Individual")) {
                selectedTournaments.add(tournament);;
                System.out.println("got a selected tournament");
            }
        }
        System.out.println(selectedTournaments.size());
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow(); // getting the stage through the button
        try {
            FXMLLoader fxmlLoaderTournamentSelectionStudentScene = new FXMLLoader(HelloApplication.class.getResource("TournamentSelectionStudent.fxml"));
            Scene tournamentSelectionStudentScene;
            tournamentSelectionStudentScene = new Scene(fxmlLoaderTournamentSelectionStudentScene.load(), 320, 240);
            
            stage.setScene(tournamentSelectionStudentScene);
            stage.setResizable(true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @FXML
    void teamTransferScene(ActionEvent event) {
        try {
            selectedTournaments.clear();
            for (Tournament tournament : allTournaments) {
                if (tournament.getParticipationType().equals("Team")) {
                    selectedTournaments.add(tournament);
                }
            }
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow(); // getting the stage through the button
            FXMLLoader fxmlLoaderTournamentSelectionStudentScene = new FXMLLoader(HelloApplication.class.getResource("TournamentSelectionStudent.fxml"));
            Scene tournamentSelectionStudentScene;
            tournamentSelectionStudentScene = new Scene(fxmlLoaderTournamentSelectionStudentScene.load(), 320, 240);
            stage.setScene(tournamentSelectionStudentScene);
            stage.setResizable(true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public ObservableList<Tournament> getSelectedTournaments() {
        return selectedTournaments;
    }
    

}