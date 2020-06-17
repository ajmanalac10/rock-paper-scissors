package com.rps.player;

import com.rps.constant.Constants.Choices;

class Player {
	private String name;
	private Choices choice;
	private int score;

	Choices getChoice() {
		return choice;
	}

	void setChoice(Choices choice) {
		this.choice = choice;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	int getScore() {
		return score;
	}

	void setScore(int score) {
		this.score = score;
	}
}
