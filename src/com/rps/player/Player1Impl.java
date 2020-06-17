package com.rps.player;

import com.rps.constant.Constants.Choices;

public class Player1Impl extends APlayerService {

	@Override
	public void initPlayer() {
		player = new Player();
		player.setName("A");
		player.setScore(0);
	}

	@Override
	public void updateChoice() {
		player.setChoice(Choices.PAPER);
	}
}
