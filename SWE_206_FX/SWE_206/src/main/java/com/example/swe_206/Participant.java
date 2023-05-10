package com.example.swe_206;

import java.io.Serializable;
import java.util.ArrayList;

public class Participant implements Serializable {

	public Participant(int id) {
		this.id = id;
	}
	private int id;
	private ArrayList<Tournament> currentTournaments;
	private ArrayList<Tournament> pastTournament;
	private ArrayList<Integer> currentRankings;
	private ArrayList<Integer> pastRankings;
	
}
