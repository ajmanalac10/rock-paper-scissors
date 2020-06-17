package com.rps.main;

import com.rps.context.RPSContext;
import com.rps.service.RPSServiceImpl;

public class MainApplication {
	public static void main(String[] args) {
		RPSContext rpsContext = new RPSContext(new RPSServiceImpl());
		rpsContext.executeGame();
	}
}