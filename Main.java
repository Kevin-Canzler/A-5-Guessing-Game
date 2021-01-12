//Kevin Canzler
//A-5: Guessing Game

import java.util.Random;
import java.util.Scanner;

public class Main {
	static Scanner input = new Scanner(System.in);
	static Random rand = new Random();
	
	public static void main(String[] args) {
		int gameCounter = 0; int totalGuesses = 0; int temp; int bestGame = 0;
		loop: while(true) {
			gameCounter++;
			temp = guessingGame();
			totalGuesses += temp;
			if (bestGame == 0) bestGame = temp;
			if (bestGame > temp) bestGame = temp;
			if (!checkForYes("Do you want to play again?")) break loop;
		}
		System.out.println("Overall results:\nTotal games = " + gameCounter + "\nTotal guesses = " + totalGuesses);
		System.out.println("Guesses/game = " + String.format("%.1f", (double) (totalGuesses) / (double) (gameCounter)) + "\nBest game = " + bestGame);
	}
	
	public static int guessingGame() {
		int guessCounter = 0; int guess = -1; int randomNumber = rand.nextInt(100);
		System.out.println("I'm thinking of a number between 1 and 100...");
		System.out.println(randomNumber);
		loop: while(true) {
			guessCounter++;
			guess = askQuestionInt("Your guess?");
			if (guess == randomNumber) break loop;
			System.out.println((guess > randomNumber ? "It's lower." : "It's higher."));
		}
		System.out.println("You got it right in " + guessCounter + (guessCounter == 1 ? " guess!" : " guesses!"));
		return guessCounter;
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
		String userInput = input.next();
		if (userInput.toLowerCase().charAt(0) == "y".charAt(0)) return true; else return false;
	}
}