package com.example.swe_206;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TournamentSelectionStudentController implements Initializable {

    @FXML
    private TableColumn<Tournament, LocalDate> endDateColumn;

    @FXML
    private TableColumn<Tournament, String> nameColumn;

    @FXML
    private TableColumn<Tournament, Button> registerButttonColumn;

    @FXML
    private TableColumn<Tournament, Integer> roundsColumn;

    @FXML
    private TableColumn<Tournament, String> sportColumn;

    @FXML
    private TableColumn<Tournament, LocalDate> startDateColumn;

    @FXML
    private TableView<Tournament> tableView;

    @FXML
    private TableColumn<Tournament, String> typeColumn;

    private Tournament selectedTournament;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StudentChoiceController s= new StudentChoiceController();
        ArrayList<Tournament> tournamentList = s.getSelectedTournaments();
        for (Tournament tournament : tournamentList) {
            Button button = tournament.getButton();
            button.setText("Register");
            button.setOnAction(e -> {
                try {
                    //enter code that affects the next stage
                    Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
                    selectedTournament = tournament;
                    if (tournament.getType().equals("Individual")) {
                        FXMLLoader fxmlLoaderRegisterScene = new FXMLLoader(HelloApplication.class.getResource("Register Scene.fxml"));
                        Scene registerScene;
                        registerScene = new Scene(fxmlLoaderRegisterScene.load(), 320, 240);
                        stage.setScene(registerScene);
                    } else {
                        FXMLLoader fxmlLoaderTeamForum = new FXMLLoader(HelloApplication.class.getResource("TeamForum.fxml"));
                        Scene teamForumScene;
                        teamForumScene = new Scene(fxmlLoaderTeamForum.load(), 320, 240);
                        stage.setScene(teamForumScene);
                    }
                   } catch (IOException e1) {
                       // TODO Auto-generated catch block
                       e1.printStackTrace();
                   }
            });
        }
        registerButttonColumn.setCellValueFactory(new PropertyValueFactory<Tournament,Button>("button"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Tournament,String>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Tournament,String>("type"));
        sportColumn.setCellValueFactory(new PropertyValueFactory<Tournament,String>("sport"));
        roundsColumn.setCellValueFactory(new PropertyValueFactory<Tournament,Integer>("rounds"));
        startDateColumn.setCellValueFactory(new PropertyValueFactory<Tournament,LocalDate>("starttDate"));
        endDateColumn.setCellValueFactory(new PropertyValueFactory<Tournament,LocalDate>("endDate"));
        tableView.sort();
        startDateColumn.setSortType(TableColumn.SortType.DESCENDING);
        tableView.getSortOrder().add(startDateColumn);
        tableView.sort();

    }

    public Tournament getSelectedTournament() {
        return selectedTournament;
    }

    

}
