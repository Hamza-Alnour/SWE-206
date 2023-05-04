package com.example.swe_206;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TeamForumController implements Initializable {

    @FXML
    private Button checkButton;

    @FXML
    private TableColumn<Helper, String> checkerColumn;

    @FXML
    private TableColumn<Helper, TextField> idColumn;

    @FXML
    private Button nextButton;

    @FXML
    private TableView<Helper> tableView;

    ObservableList<Helper> helperList = FXCollections.observableArrayList();

    @FXML
    void checkClicked(ActionEvent event) {
        Boolean contin = true;
        for (Helper helper : helperList) {
            if (helper.getTextField().getText().equals("111")) {
                helper.setInfo("Player Found");
            } else {
                helper.setInfo("Player not found");
                contin = false;
            }
        }
        if (contin) {
            nextButton.setDisable(false);
        }
        tableView.refresh();

    }

    @FXML
    void nextClicked(ActionEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoaderRegisterScene = new FXMLLoader(HelloApplication.class.getResource("Register Scene.fxml"));
        Scene registerScene;
        try {
            registerScene = new Scene(fxmlLoaderRegisterScene.load(), 600, 600);
            stage.setScene(registerScene);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nextButton.setDisable(true);
        TournamentSelectionStudentController t = new TournamentSelectionStudentController();
        Tournament selctedTournament = t.getSelectedTournament();
        for (int i = 0; i < selctedTournament.getPlayersPerTeam(); i++) {
            helperList.add(new Helper());
            System.out.println("helper added");
        }
        idColumn.setCellValueFactory(new PropertyValueFactory<Helper,TextField>("textField"));
        checkerColumn.setCellValueFactory(new PropertyValueFactory<Helper, String>("info"));
        tableView.setItems(helperList);
    }

}


