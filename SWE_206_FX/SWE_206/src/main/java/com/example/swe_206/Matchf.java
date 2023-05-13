package com.example.swe_206;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.Serializable;

public class Matchf implements Serializable {
	String team1Name = "x";
	String team2Name = "y";
	TextField team1Score = new TextField("");
	TextField team2Score = new TextField("");

	public String getTeam1Name() {
		return team1Name;
	}

	public TextField getTeam1Score() {
		return team1Score;
	}

	public String getTeam2Name() {
		return team2Name;
	}

	public TextField getTeam2Score() {
		return team2Score;
	}

	TableView<Matchf> tv = new TableView<>();

	public Matchf(Tournament selectedTournament) {
		for (int i = 0; i < 3; i++) {
			ObservableList<Matchf> matches = FXCollections.observableArrayList();
			for (int j = 0; j < 5; j++) {
				matches.add(new Matchf(selectedTournament));
			}
			TableColumn round = new TableColumn<>("Round" + i);
			TableColumn<Matchf, String> team1Name = new TableColumn<>(selectedTournament.getName());
			TableColumn<Matchf, TextField> team1Score = new TableColumn<>("team1Score");
			TableColumn<Matchf, String> team2Name = new TableColumn<>(selectedTournament.getName());
			TableColumn<Matchf, TextField> team2Score = new TableColumn<>("team1Name");
			team1Name.setCellValueFactory(new PropertyValueFactory<Matchf, String>("team1Name"));
			team2Name.setCellValueFactory(new PropertyValueFactory<Matchf, String>("team2Name"));
			team1Score.setCellValueFactory(new PropertyValueFactory<Matchf, TextField>("team1Score"));
			team2Score.setCellValueFactory(new PropertyValueFactory<Matchf, TextField>("team2Score"));
			round.getColumns().add(team1Name);
			round.getColumns().add(team1Score);
			round.getColumns().add(team2Name);
			round.getColumns().add(team2Score);
			tv.getColumns().add(round);
			tv.setItems(matches);
		}
	}

	public TableView<Matchf> getTV(){
		return tv;
	}



	public void setTeam1Score(TextField team1Score) {
		this.team1Score = team1Score;
	}

	public void setTeam1Name(String team1Name) {
		this.team1Name = team1Name;
	}

	public void setTeam2Name(String team2Name) {
		this.team2Name = team2Name;
	}

	public void setTeam2Score(TextField team2Score) {
		this.team2Score = team2Score;
	}

	public void setTv(TableView<Matchf> tv) {
		this.tv = tv;
	}
}
