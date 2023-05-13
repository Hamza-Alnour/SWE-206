package com.example.swe_206;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Match implements Serializable {
	private List<Participant> participants;
	private LocalDate date;
	private String status;
	private List<Integer> scores;

	public List<Participant> getParticipants() {
		return this.participants;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getStatus() {
		return status;
	}

	public List<Integer> getScores() {
		return scores;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}
}
