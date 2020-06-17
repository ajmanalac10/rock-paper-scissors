package com.rps.service;

import com.rps.constant.Constants;
import com.rps.constant.Constants.Choices;
import com.rps.constant.Constants.Winner;
import com.rps.context.RPSPlayerContext;
import com.rps.player.Player1Impl;
import com.rps.player.Player2Impl;

public class RPSServiceImpl implements IRPSService {

	@Override
	public void startGame() {
		RPSPlayerContext rpsPlayer1 = new RPSPlayerContext(new Player1Impl());
		RPSPlayerContext rpsPlayer2 = new RPSPlayerContext(new Player2Impl());
		
		rpsPlayer1.executeInitPlayer();
		rpsPlayer2.executeInitPlayer();
		
		for (int round = 0; round < Constants.NO_OF_ROUNDS; round++) {
			rpsPlayer1.executeUpdateChoice();
			rpsPlayer2.executeUpdateChoice();
			
			Winner winner = evaluateChoices(rpsPlayer1, rpsPlayer2);

			if (winner.equals(Winner.PLAYER1)) {
				rpsPlayer1.executeUpdateScore();
			} else if (winner.equals(Winner.PLAYER2)) {
				rpsPlayer2.executeUpdateScore();
			}
		}

		printResults(rpsPlayer1, rpsPlayer2);
	}
	
	private Winner evaluateChoices(RPSPlayerContext rpsPlayer1, RPSPlayerContext rpsPlayer2) {
		Choices playerChoice1 = rpsPlayer1.executeRetrieveChoice();
		Choices playerChoice2 = rpsPlayer2.executeRetrieveChoice();
		
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

	private void printResults(RPSPlayerContext rpsPlayer1, RPSPlayerContext rpsPlayer2) {
		int score1 = rpsPlayer1.executeRetrieveScore();
		int score2 = rpsPlayer2.executeRetrieveScore();
		String playerName1 = rpsPlayer1.executeRetrieveName();
		String playerName2 = rpsPlayer2.executeRetrieveName();
		
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