package com.example.swe_206;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javafx.scene.control.Button;

public class Tournament implements Serializable {
    String name;
    String type;
    String sport;
    int playersPerTeam;
    int rounds;
    LocalDate startDate;
    LocalDate endDate;
    Button button;
    Tournament(String _type) {
        name = "name";
        type = _type;
        sport = "sport";
        startDate = LocalDate.now();
        endDate = LocalDate.of(2024, 4,10 );
        rounds = 3;
        button = new Button("");
        if (_type.equals("Individual")) {
            playersPerTeam = 1;
        } else {
            playersPerTeam = 3;
        }
    }

    public Button getButton() {
        return button;
    }
    public String getType() {
        return type;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public String getName() {
        return name;
    }
    public int getPlayersPerTeam() {
        return playersPerTeam;
    }
    public int getRounds() {
        return rounds;
    }
    public String getSport() {
        return sport;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    
}
