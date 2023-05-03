package com.example.swe_206;

import java.io.IOException;
import java.net.URL;
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
    private TableColumn<Tournament, ?> endDateColumn;

    @FXML
    private TableColumn<Tournament, String> nameColumn;

    @FXML
    private TableColumn<Tournament, Button> registerButttonColumn;

    @FXML
    private TableColumn<Tournament, Integer> roundsColumn;

    @FXML
    private TableColumn<Tournament, String> sportColumn;

    @FXML
    private TableColumn<Tournament, ?> startDateColumn;

    @FXML
    private TableView<Tournament> tableView;

    @FXML
    private TableColumn<Tournament, String> typeColumn;

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
                    if (tournament.getType().equals("Individual")) {
                        FXMLLoader fxmlLoaderRegisterScene = new FXMLLoader(HelloApplication.class.getResource("Register Scene.fxml"));
                        Scene registerScene;
                        registerScene = new Scene(fxmlLoaderRegisterScene.load(), 320, 240);
                        stage.setScene(registerScene);
                    } else {
                        FXMLLoader fxmlLoaderRegisterScene = new FXMLLoader(HelloApplication.class.getResource("Register Scene.fxml"));
                        Scene registerScene;
                        registerScene = new Scene(fxmlLoaderRegisterScene.load(), 320, 240);
                        stage.setScene(registerScene);
                    }
                   } catch (IOException e1) {
                       // TODO Auto-generated catch block
                       e1.printStackTrace();
                   }
            });
        }
        registerButttonColumn.setCellValueFactory(new PropertyValueFactory<Tournament,Button>("button"));
    }

    

}
