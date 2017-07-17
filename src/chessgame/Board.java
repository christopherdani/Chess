package chessgame;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton class containing an instance of the board that the game will be played on.
 */
public class Board {

	/**
	 * The list of all units on the board.
	 */
	public static List<Unit> units;

	/**
	 * The list of pawns on the board.
	 */
	public static List<Pawn> pawns;

	/**
	 * The list of kings on the board.
	 */
	public static List<King> kings;
	/**
	 * The list of rooks on the board.
	 */
	public static List<Rook> rooks;

	private static Board board;
	private Position[][] game;

	/**
	 * Singleton constructor
	 * @param start Creates a new game if true.
	 */
	private Board(boolean start){
		Board.pawns = new ArrayList<Pawn>();
		Board.kings = new ArrayList<King>();
		Board.rooks = new ArrayList<Rook>();
		Board.units = new ArrayList<Unit>();
		if (start){
			//Fill the board with units in its initial positions

			//Create black king
			King king1 = new King(new Position(7,3),1);
			kings.add(king1);
			units.add(king1);

			//Create white king
			King king2 = new King(new Position(0,3),0);
			kings.add(king2);
			units.add(king2);


			//Create black rooks
			Rook rook1 = new Rook(new Position(0,0), 1);
			rooks.add(rook1);
			units.add(rook1);
			Rook rook2 = new Rook(new Position(0,7), 1);
			rooks.add(rook2);
			units.add(rook2);

			//Create white rooks
			Rook rook3 = new Rook(new Position(7,0), 0);
			rooks.add(rook3);
			units.add(rook3);
			Rook rook4 = new Rook(new Position(7,7), 0);
			rooks.add(rook4);
			units.add(rook4);


			for (int i = 0; i < 8; i++){
				for (int j = 0; j < 8; j++){
					//Create black pawns
					if (j == 1){
						//Put in the rank first (j)
						Pawn pawn = new Pawn(new Position(j ,i), 1);
						pawns.add(pawn);
						units.add(pawn);
					}
					//Create white pawns
					else if (j == 6){
						Pawn pawn = new Pawn(new Position(j ,i), 0);
						pawns.add(pawn);
						units.add(pawn);
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
		for (Unit unit : units) {
			if (unit.getPos().equals(pos)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the des is occupied by an enemy.
	 * @param init The unit that is to be checked against.
	 * @param des The destination position that is to be checked.
	 * @return true if it is occupied by an enemy unit. False if not occupied or occupied by ally unit.
	 */
	public static Boolean isEnemyOccupied(Unit init, Position des){
		for (Unit unit : units) {
			if (unit.getPos().equals(des)) {
				if (unit.getColor() != init.getColor()){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Checks if the des is occupied by an ally.
	 * @param init The unit that is to be checked against.
	 * @param des The destination position that is to be checked.
	 * @return true if it is occupied by an allied unit. False if not occupied or occupied by enemy unit.
	 */
	public static Boolean isAllyOccupied(Unit init, Position des){
		for (Unit unit : units) {
			if (unit.getPos().equals(des)) {
				if (unit.getColor() == init.getColor()){
					return true;
				}
			}
		}
		return false;
	}


	/**
	 * Moves the unit from init to des if possible.
	 * @param init Initial unit position
	 * @param des Destination position
	 */
	public static void move(Position init, Position des){
		//Check if a unit occupies the initial position.
		for (Unit unit : Board.units){

			if (unit.getPos().equals(init)){
				//Check if the unit can move to des

				for (Position pos : unit.canMove()){
					if (pos.equals(des)){
						unit.setPos(des);
					}
				}

			}
		}

	}

	/**
	 * Moves the unit occupying init and kills the unit occupying des if possible.
	 * @param init The unit that is the "killer"
	 * @param des The unit that is the "victim"
	 */
	public static void kill(Position init, Position des){
		for (Unit unit : Board.units){

			//Find the unit at init.
			if (unit.getPos().equals(init)){
				for (Position pos : unit.canKill()){

					if (pos.equals(des)){

						//Find and delete the unit occupying des
						for (Unit killed : Board.units){
							if (killed.getPos().equals(des)){
								killed.setPos(new Position(-1,-1));
							}
						}
						//Finally set the killer unit's new position at des.
						unit.setPos(des);
					}
				}
			}
		}
	}
	
}
