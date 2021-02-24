//Kevin Canzler
//A-5: Guessing Game

import java.util.Random;
import java.util.Scanner;

public class Main {
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		int[] gameStats = {0, 0, 0};
		loop: while(true) {
			int currentGame = guessingGame();
			gameStats = new int[] {++gameStats[0], gameStats[1] + currentGame, gameStats[2] == 0 || currentGame < gameStats[2] ? currentGame : gameStats[2]};
			if (!checkForYes("Do you want to play again?")) break loop;
		}
		System.out.println("Overall results:\nTotal games = " + gameStats[0] + "\nTotal guesses = " + gameStats[1]);
		System.out.println("Guesses/game = " + String.format("%.1f", (double) (gameStats[1]) / (double) (gameStats[0])) + "\nBest game = " + gameStats[2]);
	}
	
	public static int guessingGame() {
		int[] gameStats = {0, -1}; int randomNumber = new Random() {/*magic*/}.nextInt(100);
		System.out.println("I'm thinking of a number between 1 and 100...\n" + randomNumber);
		loop: while(true) {
			gameStats = new int[] {++gameStats[0], askQuestionInt("Your guess?")};
			if (gameStats[1] == randomNumber) break loop;
			System.out.println((gameStats[1] > randomNumber ? "It's lower." : "It's higher."));
		}
		System.out.println("You got it right in " + gameStats[0] + (gameStats[0] == 1 ? " guess!" : " guesses!"));
		return gameStats[0];
	}
	
	public static int askQuestionInt(String question) {
		System.out.println(question);
		try {
			return input.nextInt();
		} catch(Exception e) {
			input.next();
			return askQuestionInt("Put an int in you f*ck");
		}
	}
	
	public static boolean checkForYes(String question) {
		System.out.println(question);
		return input.next().toLowerCase().charAt(0);
	}
}
