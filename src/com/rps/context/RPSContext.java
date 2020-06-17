package com.rps.context;

import com.rps.service.IRPSService;

public class RPSContext {
	IRPSService rpsService;

	public RPSContext(IRPSService rpsService) {
		this.rpsService = rpsService;
	}

	public void executeGame() {
		rpsService.startGame();
	}
}
