package com.example.swe_206;

import java.util.ArrayList;
import java.util.Random;

public class Team extends Participant {
	/*public Team(int id) {
		super(id);
		//TODO Auto-generated constructor stub
	}*/

	public Team(int[] ids) {
		super((new Random()).nextInt(1000, 10000));
		
		members = new ArrayList<>(ids.length);
		for(int i = 0; i < members.size(); i++) {
			members.add(new Student(ids[i]));
		}
		maxTeamSize = ids.length;
	}
	private int maxTeamSize;
	private ArrayList<Student> members;
}
