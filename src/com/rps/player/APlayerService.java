package com.rps.player;

import com.rps.constant.Constants.Choices;

public abstract class APlayerService {
	Player player;

	public abstract void initPlayer();
	public abstract void updateChoice();
	
	public void updateScore() {
		player.setScore(player.getScore() + 1);
	}

	public String retrieveName() {
		return player.getName();
	}

	public int retrieveScore() {
		return player.getScore();
	}

	public Choices retrieveChoice() {
		return player.getChoice();
	}
}
