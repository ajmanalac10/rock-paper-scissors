package com.rps.constant;

public class Constants {
	public final static int NO_OF_ROUNDS = 100;

	public enum Choices {
		ROCK, PAPER, SCISSORS;

		public static Choices choiceRandomizer () {
			return values()[(int) (Math.random() * values().length)];
		}
	}

	public enum Winner {
		PLAYER1, PLAYER2, TIE
	}
}
