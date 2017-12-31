package chessgame;

import java.util.Scanner;

/**
 * A class to display the chess board.
 */
public class Display {

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
	public static void update(Board board){
		display(board);
	}

	/**
	 * Parse the user input and translate it into commands if valid.
	 * For now, input string should be in the form of filerank1 filerank2: e.g. f2 f3.
	 * Where filerank1 is the position from and filerank2 is the position to.
	 * @param input
	 */
	public static void parse(String input){


		//Board.history.add(new Command(new Position(), new Position()));

	}

	public static void main(String[] str){
		Board board = Board.getBoardInstance(true);

		Scanner input = new Scanner(System.in);
		String command;

		while (input.equals("quit")){
			command = input.nextLine();
			update(board);
		}


		//System.out.println(Board.checkMate(board));

//		Position init = new Position(3,3);
//		Position des = new Position(5,4);
//		Board.move(init, des);
//		display(board);


//		Position init = new Position(1,0);
//		Position des = new Position(3,0);
//		Board.move(init, des);
//		display(board);
//
//		Position init5 = new Position(6,1);
//		Position des5 = new Position(4,1);
//		Board.move(init5,des5);
//		display(board);
//
//
//		Board.kill(des, des5);
//		display(board);
//
//
//		Position rookCheck1 = new Position(7,0);
//		Position rookCheck2 = new Position(7,2);
//		Board.move(rookCheck1, rookCheck2);
//		display(board);

	}
}
