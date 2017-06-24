package chessgame;

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
	 *  8 |R||N||B||K||Q||B||N||R| 8
	 *  7 |P||P||P||P||P||P||P||P| 7
	 *  6 | || || || || || || || | 6
	 *  5 | || || || || || || || | 5
	 *  4 | || || || || || || || | 4
	 *  3 | || || || || || || || | 3
	 *  2 |P||P||P||P||P||P||P||P| 2
	 *  1 |R||N||B||K||Q||B||N||R| 1
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

	public static void main(String[] str){
		Board board = Board.getBoardInstance(true);
		display(board);

		Position init = new Position(1,0);
		Position init2 = new Position(1,1);
		Position des = new Position(3,0);
		Position des2 = new Position(2,1);
		Board.move(init, des);
		Board.move(init2, des2);
		display(board);

		Position init3 = new Position(2,1);
		Position des3 = new Position(4, 1);
		Board.move(init3, des3);
		display(board);

		Position init4 = new Position(3,0);
		Position des4 = new Position(2,0);
		Board.move(init4, des4);
		display(board);
	}
}
