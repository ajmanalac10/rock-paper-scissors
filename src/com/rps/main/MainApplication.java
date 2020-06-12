package com.rps.main;

import java.util.Random;

public class MainApplication {
	public static void main(String[] args) {
		int scoreA = 0;
		int scoreB = 0;
		
		for (int round = 1; round < 101; round++) {
			int choice = new Random().nextInt(3);
			if (choice == 0)
				scoreA++;
			else if (choice == 1)
				scoreB++;
		}

		System.out.printf("Player A wins %d of 100 games\n", scoreA);
		System.out.printf("Player B wins %d of 100 games\n", scoreB);
		System.out.printf("Tie: %s of 100 games\n", (100 - (scoreA + scoreB)));
		
		if(scoreA == scoreB) {
			System.out.println("It's a tie!\n");
		} else {
			String winner = scoreA > scoreB ? "A" : "B";
			int score1 = scoreA > scoreB ? scoreA : scoreB;
			int score2 = scoreA > scoreB ? scoreB : scoreA;
			System.out.printf("Winner is Player %s (%d to %d)\n", winner, score1, score2);
		}		
	}
}
