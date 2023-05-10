package com.example.swe_206;

import java.io.Serializable;
import java.util.ArrayList;

public class Compressor implements Serializable {
    ArrayList<SerializableTournament> tournamentList;
    Compressor(ArrayList<SerializableTournament> t) {
        tournamentList = t;
    }
    public ArrayList<SerializableTournament> getTournamentList() {
        return tournamentList;
    }
}
