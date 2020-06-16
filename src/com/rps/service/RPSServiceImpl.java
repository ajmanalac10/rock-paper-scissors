package com.rps.service;

import com.rps.model.Player;
import com.rps.constant.Constants.Winner;
import com.rps.constant.Constants.Choices;
import com.rps.constant.Constants;

public class RPSServiceImpl implements RPSService {

	@Override
	public void startGame(Player player1, Player player2) {
		for (int round = 0; round < Constants.NO_OF_ROUNDS; round++) {
			Choices playerChoice1 = Choices.PAPER;
			Choices playerChoice2 = Choices.choiceRandomizer();  
			Winner winner = evaluateChoices(playerChoice1, playerChoice2);

			if (winner.equals(Winner.PLAYER1)) {
				player1.setScore(player1.getScore() + 1);
			} else if (winner.equals(Winner.PLAYER2)) {
				player2.setScore(player2.getScore() + 1);
			}
		}

		printResults(player1, player2);
	}
	
	private Winner evaluateChoices(Choices playerChoice1, Choices playerChoice2) {
		if (playerChoice1.equals(Choices.PAPER)) {
			if (playerChoice2.equals(Choices.PAPER)) {
				return Winner.TIE;
			} else if (playerChoice2.equals(Choices.ROCK)) {
				return Winner.PLAYER1;
			} else {
				return Winner.PLAYER2;
			}
		} else if (playerChoice1.equals(Choices.ROCK)) {
			if (playerChoice2.equals(Choices.PAPER)) {
				return Winner.PLAYER2;
			} else if (playerChoice2.equals(Choices.ROCK)) {
				return Winner.TIE;
			} else {
				return Winner.PLAYER1;
			}
		} else {
			if (playerChoice2.equals(Choices.PAPER)) {
				return Winner.PLAYER1;
			} else if (playerChoice2.equals(Choices.ROCK)) {
				return Winner.PLAYER2;
			} else {
				return Winner.TIE;
			}
		}
	}

	private void printResults(Player player1, Player player2) {
		int score1 = player1.getScore();
		int score2 = player2.getScore();
		String playerName1 = player1.getName();
		String playerName2 = player2.getName();
		
		System.out.printf("Player %s wins %d of %d games\n", playerName1, score1, Constants.NO_OF_ROUNDS);
		System.out.printf("Player %s wins %d of %d games\n", playerName2, score2, Constants.NO_OF_ROUNDS);
		System.out.printf("Tie: %s of %d games\n", (Constants.NO_OF_ROUNDS - (score1 + score2)), Constants.NO_OF_ROUNDS);
		
		if(score1 == score2) {
			System.out.println("It's a tie!\n");
		} else {
			String winner = score1 > score2 ? playerName1 : playerName2;
			int scoreA = score1 > score2 ? score1 : score2;
			int scoreB = score1 > score2 ? score2 : score1;
			System.out.printf("Winner is Player %s (%d to %d)\n", winner, scoreA, scoreB);
		}	
	}

}