package com.example.swe_206;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class SerializableTournament implements Serializable{
    private String name;
    private String participationType;
    private String tournamentType;
    private String sport;
    private int id;
    private int playersPerTeam;
    private ArrayList<Match> matches;
    private ArrayList<Participant> allParticipants;
    private boolean archived;
    LocalDate startDate;
    LocalDate endDate;
    SerializableTournament(Tournament t) {
        this.name = t.getName();
        this.participationType = t.getParticipationType();
        this.tournamentType = t.getTournamentType();
        this.sport = t.getSport();
        this.id = t.getid();
        this.playersPerTeam = t.getPlayersPerTeam();
        this.matches = t.getMatches();
        this.allParticipants = t.getAllParticipants();
        this.archived = t.isArchived();
        this.startDate = t.getStartDate();
        this.endDate = t.getEndDate();
    }
    public String getName() {
        return name;
    }
    public String getParticipationType() {
        return participationType;
    }
    public String getTournamentType() {
        return tournamentType;
    }
    public String getSport() {
        return sport;
    }
    public int getId() {
        return id;
    }
    public int getPlayersPerTeam() {
        return playersPerTeam;
    }
    public ArrayList<Match> getMatches() {
        return matches;
    }
    public ArrayList<Participant> getAllParticipants() {
        return allParticipants;
    }
    public boolean isArchived() {
        return archived;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
}