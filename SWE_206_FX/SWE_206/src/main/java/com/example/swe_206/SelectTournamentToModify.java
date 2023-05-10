package com.example.swe_206;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SelectTournamentToModify implements Initializable {

    static Scene scene;

    @FXML
    private TableView<Tournament> tableView;

	@FXML
    private TableColumn<Tournament, Button> buttonCol;

    @FXML
    private TableColumn<Tournament, Integer> idCol;

    @FXML
    private TableColumn<Tournament, String> nameCol;

    @FXML
    private TableColumn<Tournament, String> participationCol;

    @FXML
    private TableColumn<Tournament, String> sportCol;

    @FXML
    private TableColumn<Tournament, Integer> teamSizeCol;

    @FXML
    private TableColumn<Tournament, String> typeCol;

    @FXML
    private TableColumn<Tournament, LocalDate> startDateCol;

    @FXML
    private TableColumn<Tournament, LocalDate> endDateCol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Tournament> tournamentList = FXCollections.observableArrayList(HelloApplication.tournamentListOG);
        
        if (tournamentList.size() == 0) {
            System.out.println("empty");
        }
        for (Tournament tournament : tournamentList) {
            Button button = tournament.getButton();
            button.setText("Modify");
            if(tournament.isArchived()) {
                tournament.getButton().setDisable(true);
            }
            else {
            button.setOnAction(e -> {
                ModificationScene.selectedTournament = tournament;
                ModificationScene.init();
                HelloApplication.stage.setScene(ModificationScene.scene);
            });
        
        }
    }
        teamSizeCol.setCellValueFactory(new PropertyValueFactory<Tournament, Integer>("playersPerTeam"));
        idCol.setCellValueFactory(new PropertyValueFactory<Tournament, Integer>("id"));
        buttonCol.setCellValueFactory(new PropertyValueFactory<Tournament,Button>("button"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Tournament,String>("name"));
        participationCol.setCellValueFactory(new PropertyValueFactory<Tournament,String>("participationType"));
        sportCol.setCellValueFactory(new PropertyValueFactory<Tournament,String>("sport"));
        typeCol.setCellValueFactory(new PropertyValueFactory<Tournament, String>("tournamentType"));
        startDateCol.setCellValueFactory(new PropertyValueFactory<Tournament,LocalDate>("startDate"));
        endDateCol.setCellValueFactory(new PropertyValueFactory<Tournament,LocalDate>("endDate"));
        tableView.setItems(tournamentList);
        startDateCol.setSortType(TableColumn.SortType.DESCENDING);
        tableView.getSortOrder().add(startDateCol);
        tableView.sort();
        System.out.println("innitialized the grid");

    }
}
