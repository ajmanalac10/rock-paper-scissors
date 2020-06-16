package com.rps.main;

import com.rps.context.RPSContext;
import com.rps.model.Player;
import com.rps.service.RPSServiceImpl;

public class MainApplication {
	public static void main(String[] args) {
		RPSContext rpsContext = new RPSContext(new RPSServiceImpl());
		
		Player player1 = initPlayer("A");
		Player player2 	= initPlayer("B");
		
		rpsContext.executeGame(player1, player2);
	}
	
	private static Player initPlayer(String name) {
		Player player = new Player();
		player.setName(name);
		player.setScore(0);
		
		return player;
	}
}