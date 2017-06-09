package chessgame;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton class containing an instance of the board that the game will be played on.
 */
public class Board {

	/**
	 * The list of pawns on the board.
	 */
	public static List<Pawn> pawns;

	/**
	 * The list of kings on the board.
	 */
	public static List<King> kings;

	private static Board board;
	private Position[][] game;

	/**
	 * Singleton constructor
	 * @param start Creates a new game if true.
	 */
	private Board(boolean start){
		Board.pawns = new ArrayList<Pawn>();
		Board.kings = new ArrayList<King>();
		if (start){
			//Fill the board with units in its initial positions

			//Create black king
			kings.add(new King(new Position(3,7),1));
			//Create white king
			kings.add(new King(new Position(3,0),0));

			for (int i = 0; i < 8; i++){
				for (int j = 0; j < 8; j++){
					//Create black pawns
					if (j == 1){
						Pawn pawn = new Pawn(new Position(i ,j), 1);
						pawns.add(pawn);
					}
					//Create white pawns
					else if (j == 6){
						Pawn pawn = new Pawn(new Position(i ,j), 0);
						pawns.add(pawn);
					}

				}
			}
		}
	}

	/**
	 * Get the board instance. Create one if it does not exist.
	 * @param game
	 * @return An instance of the board.
	 */
	public static Board getBoardInstance(boolean game){
		if (board == null){
			Board board = new Board(game);
			
		}
		return board;
	}

	/**
	 * True if the position is occupied by a unit, false otherwise.
	 * @param pos The position to be checked.
	 * @return True if the position is occupied by a unit, false otherwise.
	 */
	public static Boolean isOccupied(Position pos){
		for (Pawn pawn : pawns){
			if (pawn.getPos() == pos){
				return true;
			}
		}
		return false;
	}


	public void move(){
		
	}
	
	public void kill(){
		
	}
	
}
