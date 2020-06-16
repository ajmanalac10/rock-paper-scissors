package com.rps.context;

import com.rps.model.Player;
import com.rps.service.RPSService;

public class RPSContext {
	RPSService rpsService;
	
	public RPSContext (RPSService rpsService) {
		this.rpsService = rpsService;
	}
	
	public void executeGame(Player player1, Player player2) {
		rpsService.startGame(player1, player2);
	}
}
