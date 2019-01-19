/*
 * The purpose of this class is to store the Snakes and Ladders' gameboard. 
 * It holds all the locations of the snakes and the ladders.
 * Created by Yolanda Yu
 * Last Modified on 06/15/2017
 */

public class GameBoard extends Player {

	// array lists of snakes' and ladders' start and end locations
	private static int ladderStart[] = { 3, 6, 20, 36, 63, 68 };
	private static int ladderEnd[] = { 51, 27, 70, 55, 95, 98 };
	private static int snakeStart[] = { 25, 34, 47, 65, 87, 91, 99 };
	private static int snakeEnd[] = { 5, 1, 19, 52, 57, 61, 69 };

	// This method checks and compares if player one's location is on a location
	// that has a ladder's bottom
	public static int laddersOne() {
		for (int l = 0; l < ladderStart.length; l++) {
			if (locationOne == ladderStart[l]) {
				// Informs the player on what is happening and the player's new
				// location
				System.out.println("Congrats! You landed on a ladder. "
						+ "You are now at " + ladderEnd[l] + "\n");
				locationOne = ladderEnd[l]; // Set player one's location to the
											// ladder's top
			}
		}
		return locationOne; // Return player's one new location
	}

	// This method checks and compares if player one's location is on a location
	// that has a snake's head
	public static int snakesOne() {
		for (int s = 0; s < snakeStart.length; s++) {
			if (locationOne == snakeStart[s]) {
				// Informs the player on what is happening and the player's new
				// location
				System.out.println("Oops! You landed on a snake. "
						+ "You are now at " + snakeEnd[s] + "\n");
				locationOne = snakeEnd[s]; // Set player one's location to the
											// snake's tail
			}
		}
		return locationOne; // Return player's one new location
	}

	// This method checks and compares if player two's location is on a location
	// that has a ladder's bottom
	public static int laddersTwo() {
		for (int l = 0; l < ladderStart.length; l++) {
			if (locationTwo == ladderStart[l]) {
				// Informs the player on what is happening and the player's new
				// location
				System.out.println("Congrats! You landed on a ladder. "
						+ "You are now at " + ladderEnd[l] + "\n");
				locationTwo = ladderEnd[l]; // Set player two's location to the
											// ladder's top
			}
		}
		return locationTwo; // Return player's two new location
	}

	// This method checks and compares if player two's location is on a location
	// that has a snake's tail
	public static int snakesTwo() {
		for (int s = 0; s < snakeStart.length; s++) {
			if (locationTwo == snakeStart[s]) {
				// Informs the player on what is happening and the player's new
				// location
				System.out.println("Oops! You landed on a snake. "
						+ "You are now at " + snakeEnd[s] + "\n");
				locationTwo = snakeEnd[s]; // Set player two's location to the
											// snake's tail
			}
		}
		return locationTwo; // Return player's two new location
	}
}
