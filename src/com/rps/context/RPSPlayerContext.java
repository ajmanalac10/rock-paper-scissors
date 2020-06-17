package com.rps.context;

import com.rps.constant.Constants.Choices;
import com.rps.player.APlayerService;

public class RPSPlayerContext {
	APlayerService aPlayerService;

	public RPSPlayerContext(APlayerService aPlayerService) {
		this.aPlayerService = aPlayerService;
	}

	public void executeInitPlayer() {
		aPlayerService.initPlayer();
	}

	public void executeUpdateScore() {
		aPlayerService.updateScore();
	}

	public void executeUpdateChoice() {
		aPlayerService.updateChoice();
	}

	public String executeRetrieveName() {
		return aPlayerService.retrieveName();
	}

	public int executeRetrieveScore() {
		return aPlayerService.retrieveScore();
	}

	public Choices executeRetrieveChoice() {
		return aPlayerService.retrieveChoice();
	}
}
