package chessgame;

import java.util.Scanner;

/**
 * A class to representing a game of chess.
 */
public class Game {

	/**
	 * Displays a simple ASCII representation of the chess board. <br>
	 * The upper part of the board is the black units and the lower is the white units. <br>
	 * This still needs to be improved to show distinction between the 2 colors. <br>
	 *
	 * <pre>
	 *     a  b  c  d  e  f  g  h
	 *  8 |R||N||B||Q||K||B||N||R| 8
	 *  7 |P||P||P||P||P||P||P||P| 7
	 *  6 | || || || || || || || | 6
	 *  5 | || || || || || || || | 5
	 *  4 | || || || || || || || | 4
	 *  3 | || || || || || || || | 3
	 *  2 |P||P||P||P||P||P||P||P| 2
	 *  1 |R||N||B||Q||K||B||N||R| 1
	 *     a  b  c  d  e  f  g  h
	 * </pre>
	 *
	 * Where: <br>
	 * P = Pawn <br>
	 * R = Rook <br>
	 * N = Knight <br>
	 * K = King <br>
	 * Q = Queen <br>
	 *
	 * @param board The board to display.
	 */
	public static void display(Board board){
		Boolean exists = false;
		int file = 8;
		System.out.println("   a  b  c  d  e  f  g  h");
		for (int i = 0; i < 8; i++){
			System.out.print(file - i + " ");

			for (int j = 0; j < 8; j++){
				System.out.print("|");

				for (Unit unit : Board.units){

					if (unit.getPos().equals(new Position(i,j))) {

						if (Pawn.class.isInstance(unit)) {
							System.out.print("P");
							exists = true;
						}

						else if (King.class.isInstance(unit)) {
							System.out.print("K");
							exists = true;
						}

						else if (Rook.class.isInstance(unit)){
							System.out.print("R");
							exists = true;
						}

						else if (Bishop.class.isInstance(unit)){
							System.out.print("B");
							exists = true;
						}

						else if (Queen.class.isInstance(unit)){
							System.out.print("Q");
							exists = true;
						}

						else if (Knight.class.isInstance(unit)){
							System.out.print("N");
							exists = true;
						}
					}
				}
				//Print out blank if no unit exists at that position.
				if (!exists){
					System.out.print(" ");
				}
				System.out.print("|");
				exists = false;
			}
			System.out.print(" ");
			System.out.println(file - i);
		}
		System.out.println("   a  b  c  d  e  f  g  h");

	}

	/**
	 * Update the board and display the newest moves. Notify if there is a check or checkmate.
	 * If the last move performed ended the game, display winner.
	 * @param board
	 */
	public static boolean update(Board board, String command, int turn){
		if (command.matches("quit")){
			System.out.println("Quitting now!");
			return false;
		}

		//Check the new command in the history array
		try {
			Command newest = parse(command);
			return Board.execute(newest, turn);
		} catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
		return false;

	}

	/**
	 * Parse the user input and translate it into a command, put it into the history and return the command if valid.
	 * Otherwise return null.
	 * For now, input string should be in the form of filerank1 filerank2: e.g. f2 f3.
	 * Where filerank1 is the position from and filerank2 is the position to.
	 * @throws IllegalArgumentException if the format of the input is not filerank1 filerank2
	 * @param input the string input
	 */
	public static Command parse(String input) throws IllegalArgumentException{
		if (!input.matches("[a-hA-H][1-9] [a-hA-H][1-9]")){
			throw new IllegalArgumentException("Your input format is wrong!");
		}

		/*
		Translate file into:
		a = 0, b = 1, c = 2, d = 3, ..., h = 7
		Translate rank into:
		8 = 0, 7 = 1, 6 = 2, 5 = 3, ..., 1 = 7
		 */

		// Initially set these into invalid positions at -1.
		int fileFrom = -1, fileTo = -1, rankFrom = -1, rankTo = -1;
		String from = input.substring(0,2);
		String to = input.substring(3,5);

		// Parse from
		switch (from.charAt(0)) {
			case 'a':
				fileFrom = 0;
				break;
			case 'b':
				fileFrom = 1;
				break;
			case 'c':
				fileFrom = 2;
				break;
			case 'd':
				fileFrom = 3;
				break;
			case 'e':
				fileFrom = 4;
				break;
			case 'f':
				fileFrom = 5;
				break;
			case 'g':
				fileFrom = 6;
				break;
			case 'h':
				fileFrom = 7;
				break;
		}

		switch (from.charAt(1)) {
			case '8':
				rankFrom = 0;
				break;
			case '7':
				rankFrom = 1;
				break;
			case '6':
				rankFrom = 2;
				break;
			case '5':
				rankFrom = 3;
				break;
			case '4':
				rankFrom = 4;
				break;
			case '3':
				rankFrom = 5;
				break;
			case '2':
				rankFrom = 6;
				break;
			case '1':
				rankFrom = 7;
				break;
		}

		// Parse to
		switch (to.charAt(0)) {
			case 'a':
				fileTo = 0;
				break;
			case 'b':
				fileTo = 1;
				break;
			case 'c':
				fileTo = 2;
				break;
			case 'd':
				fileTo = 3;
				break;
			case 'e':
				fileTo = 4;
				break;
			case 'f':
				fileTo = 5;
				break;
			case 'g':
				fileTo = 6;
				break;
			case 'h':
				fileTo = 7;
				break;
		}

		switch (to.charAt(1)) {
			case '8':
				rankTo = 0;
				break;
			case '7':
				rankTo = 1;
				break;
			case '6':
				rankTo = 2;
				break;
			case '5':
				rankTo = 3;
				break;
			case '4':
				rankTo = 4;
				break;
			case '3':
				rankTo = 5;
				break;
			case '2':
				rankTo = 6;
				break;
			case '1':
				rankTo = 7;
				break;
		}

		Command command = new Command(new Position(rankFrom, fileFrom), new Position(rankTo, fileTo), input);
		if (command.isValid()){
			Board.history.add(command);
			return command;
		}
		return null;

	}

	public static void main(String[] str){
		int turn = 1; // Start at white turn (odd). While black turn is even.
		boolean success = false; // Only increment turn if this is true.
		Board board = Board.getBoardInstance(true);
		Scanner input = new Scanner(System.in);
		String command = "";

		// Game loop
		while (!command.equals("quit")){
			display(board);
			command = input.nextLine();
			success = update(board, command, turn);
			if (success){
				turn++;
			}
		}
	}
}
