/*
 * The purpose of this class is setting up the actions of the players. 
 * Creates the playing interface of the game so players can take turn spinning the spinner and move according spots
 * Created by Yolanda Yu
 * Last Modified on 06/15/2017
 */

import java.util.Scanner;

public class Player {

	// fields of Player class
	public static int locationOne;
	public static int locationTwo;
	public static String playerOne;
	public static String playerTwo;
	public static int countOne;
	public static int countTwo;
	public static long endTime;
	public static long time;

	// This method initialize the start of a new game by getting the player's
	// information
	public static void players() {
		Scanner names = new Scanner(System.in);
		System.out.println("Enter Player One's Name");
		playerOne = names.nextLine(); // Get player one's name
		System.out.println("Welcome " + playerOne + "!!" + "\n");
		System.out.println("Enter Player Twos's Name");
		playerTwo = names.nextLine(); // Get player two's name
		System.out.println("Welcome " + playerTwo + "!!" + "\n");

		System.out.println("The game will now begin" + "\n");
		// reset the players location to 0 to start from the beginning
		locationOne = 0;
		locationTwo = 0;

		time = System.currentTimeMillis(); // Starts timing the game
		spinOne(); // Player one will spin first
	}

	// This method checks if player one has win the game, if the player has then
	// this method outputs the number of steps and amount of time it took for
	// the player to win
	private static boolean checkOne() {
		// Returns false when player one did not go past 100, therefore it's
		// player two's turn
		while (locationOne < 100) {
			spinTwo();
			return true;
		}
		// Once the game is finished, information regarding the amount of steps
		// and time the player took to win will be displayed
		endTime = System.currentTimeMillis() - time; // subtract the start time with current time to get the time used
		System.out.println("Congratulations " + playerOne + "!"
				+ " You have won the game" + "\n" + "It look you " + countOne
				+ " moves" + " and " + endTime / 1000 + " seconds");
		Leaderboard.addWinnerOne(); // Update the winner list
		return false; // return false, thus ending this method
	}

	// This method checks if player two has win the game, if the player has then
	// this method outputs the number of steps and amount of time it took for
	// the player to win
	private static boolean checkTwo() {
		// Returns false when player two did not go past 100, therefore it's
		// player one's turn
		while (locationTwo < 100) {
			spinOne();
			return true;
		}
		// Once the game is finished, information regarding the amount of steps
		// and time the player took to win will be displayed
		endTime = System.currentTimeMillis() - time; // subtract the start time with current time to get the time used
		System.out.println("Congratulations " + playerTwo + "!"
				+ " You have won the game" + "\n" + "It look you " + countTwo
				+ " moves" + " and " + endTime / 1000 + " seconds");
		Leaderboard.addWinnerTwo(); // Update the winner list
		return false; // return false, thus ending this method
	}

	// This method performs the action of spinning the spinner and checking if a
	// snake or a ladder is present in the player's location
	private static int spinOne() {
		Scanner one = new Scanner(System.in);
		System.out.print(playerOne + " please press Enter to spin");
		String enter = one.nextLine(); // Player one takes a turn by pressing the "enter" key
		if (enter.equalsIgnoreCase("")) {
			countOne++;
			int spin = (int) (Math.random() * 6) + 1; // A random number from 1 to 6 will be spun
			System.out.println(playerOne + " has rolled a " + spin);
			locationOne = locationOne + spin; // Update the player's new location
			System.out.println(playerOne + " is currently on " + locationOne
					+ "\n");
			// Checks if the player landed on a ladder's bottom or a snake's head
			GameBoard.laddersOne();
			GameBoard.snakesOne();
			checkOne(); // Calls checkOne() to see if the player has won the game
		} else {
			// If the player inputs anything else than the "enter" key, it will
			// let the player try again
			System.out.println("Try Again");
			spinOne();
		}
		return locationOne;
	}

	// This method performs the action of spinning the spinner and checking if a
	// snake or a ladder is present in the player's location
	private static int spinTwo() {
		Scanner two = new Scanner(System.in);
		System.out.print(playerTwo + " please press Enter to spin");
		String enter = two.nextLine(); // Player two takes a turn by pressing the "enter" key
		if (enter.equalsIgnoreCase("")) {
			countTwo++;
			int spin = (int) (Math.random() * 6) + 1; // A random number from 1
			// to 6 will be spun
			System.out.println(playerTwo + " has rolled a " + spin);
			locationTwo = locationTwo + spin; // Update the player's new location
			System.out.println(playerTwo + " is currently on " + locationTwo
					+ "\n");
			// Checks if the player landed on a ladder's bottom or a snake's head
			GameBoard.laddersTwo();
			GameBoard.snakesTwo();
			checkTwo(); // Calls checkTwo() to see if the player has won the game
		} else {
			// If the player inputs anything else than the "enter" key, it will
			// let the player try again
			System.out.println("Try Again");
			spinTwo();
		}
		return locationTwo;
	}
}
