/*
 * This is the main class of the program. 
 * The purpose of this class is to start off the game by displaying instructions and options/action that the user can do
 * Codes were modified from XML assignment, XMLApplication class lines 37-54 (repeat method)
 * Created by Yolanda Yu
 * Last Modified on 06/15/2017
 */

import java.util.Scanner;

public class startGame {

	// This is the main method of the class/program
	public static void main(String[] args) {
		instructions();
		System.out
				.println("Do you wish to start a new game or view and search the Winner List?");
		actions(); // calls actions(), which gives the user more options to
					// select what they want to do
	}

	// Utilizes a scanner that lets the user choose what they want to do with
	// the program. They can either start a new game or search or display the
	// winner list.
	public static void actions() {
		System.out.println("Enter: " + "\n" + "	1--Start a New Game" + "\n"
				+ "	2--View the Winner List" + "\n"
				+ "	3--Search the Winner List" + "\n"
				+ "	4--Display the highest score" + "\n"
				+ "	5--Exit the Program");

		Scanner one = new Scanner(System.in);
		String input = one.nextLine(); // the user's input/choice

		// depending on the response, the program will call its respective
		// method to perform the certain action.
		switch (input) {
		case "1":

			Player.players();
			System.out
					.println("\n"
							+ "Do you want to play again or view and search the Winner List?"
							+ "\n" + "1-Yes" + "\n" + "2-No");
			repeat();
			break;
		case "2":
			Leaderboard.display();
			System.out
					.println("\n"
							+ "Do you want to play a new game or search the Winner List?"
							+ "\n" + "1-Yes" + "\n" + "2-No");
			repeat();
			break;
		case "3":
			Leaderboard.search();
			System.out.println("\n"
					+ "Do you want to play a new game or view the Winner List?"
					+ "\n"  + "1-Yes" + "\n" + "2-No");
			repeat();
			break;
		case "4":
			Leaderboard.sort();
			System.out.println("\n"
					+ "Do you want to play a new game or view or search the Winner List?"
					+ "\n"  + "1-Yes" + "\n" + "2-No");
			repeat();
			break;
		case "5":
			one.close();
			break;
		// if none of the above numbers are inputed, the system asks the
		// question again
		default:
			System.out.println("Try Again");
			actions();
		}
	}

	// This method displays and outputs all the instructions of the snakes and
	// ladders game
	private static void instructions() {
		System.out
				.println("Hello Players! Welcome to Snakes and Ladders!"
						+ "\n"
						+ "\n"
						+ "This is the classic game of snakes and ladders."
						+ "\n"
						+ "The rules and instructions are simple and are as follows:"
						+ "\n"
						+ "1. Take turns spinning the spinner"
						+ "\n"
						+ "2. The player will move the amount of spots spinned."
						+ "\n"
						+ "3. If the player lands on a ladder, it will get to move to a new higher location"
						+ "\n"
						+ "4. If the player lands on a snake, it will fall down to a new location"
						+ "\n"
						+ "5. The game is won when a player goes over or reaches location 100"
						+ "\n");
	}

	// this method asks the user whether or not they want to perform another
	// action
	private static void repeat() {

		Scanner two = new Scanner(System.in);
		String response = two.nextLine();

		// if the user answered yes, the the program asks what the user wants to
		// do, if answered no then the program closes
		if (response.equalsIgnoreCase("1")) {
			actions();
		} else if (response.equalsIgnoreCase("2")) {
			two.close();
		} else {
			System.out.println("Try Again" + "\n" + "\n"
					+ "Do you wish to perform another action?" + "\n"
					 + "1-Yes" + "\n" + "2-No");
			repeat();
		}
	}
}
