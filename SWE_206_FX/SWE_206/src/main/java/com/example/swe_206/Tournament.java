package com.example.swe_206;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.scene.control.Button;

public class Tournament implements Serializable {
    private String name;
    private String participationType;
    private String tournamentType;
    private String sport;
    private int id;
    private int playersPerTeam;
    private ArrayList<Match> matches;
    private ArrayList<Participant> allParticipants;
    private boolean archived;

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    LocalDate startDate;
    LocalDate endDate;

    Button registerButton = new Button();
    
    public Tournament(String _type) {
        name = "name";
        participationType = _type;
        sport = "sport";
        startDate = LocalDate.now();
        endDate = LocalDate.of(2024, 4,10 );
        // rounds = 3;
        tournamentType = "Elimination";
        if (_type.equals("Individual")) {
            playersPerTeam = 1;
        } else {
            playersPerTeam = 3;
        }
    }
    
    public Tournament(String name, String participationType, String tournamentType, String sport, int playersPerTeam, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.participationType = participationType;
        this.tournamentType = tournamentType;
        this.sport = sport;
        this.playersPerTeam = playersPerTeam;
        this.startDate = startDate;
        this.endDate = endDate;
        this.id = HelloApplication.generateUniqueID();
        HelloApplication.tournamentList.add(this);
    }


    public String getTournamentType() {
        return tournamentType;
    }
    public int getid() {
        return id;
    }
    public String getParticipationType() {
        return participationType;
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
    public String getSport() {
        return sport;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    
    public Button getButton() {
        return registerButton;
    }
}
