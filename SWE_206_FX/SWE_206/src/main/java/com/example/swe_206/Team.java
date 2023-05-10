package com.example.swe_206;

import java.util.ArrayList;

public class Team extends Participant {
	public Team(int loggedInStudentId) {
		super(loggedInStudentId);
		//TODO Auto-generated constructor stub
	}
	private int maxTeamSize;
	private ArrayList<Student> members;
}
