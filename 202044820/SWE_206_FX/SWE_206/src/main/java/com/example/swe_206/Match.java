package com.example.swe_206;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Match implements Serializable {
	private ArrayList<Participant> participants;
	private LocalDate date;
	private boolean finished;
	private ArrayList<Integer> scores;
}
