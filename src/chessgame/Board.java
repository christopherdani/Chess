package chessgame;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton class containing an instance of the board that the game will be played on.
 */
public class Board {
	/**
	 * List of moves
	 */
	public static ArrayList<Command> history;

	/**
	 * The list of all units on the board.
	 */
	public static List<Unit> units;

	/**
	 * The list of pawns on the board.
	 */
	private static List<Pawn> pawns;

	/**
	 * The list of kings on the board.
	 */
	private static List<King> kings;
	/**
	 * The list of rooks on the board.
	 */
	private static List<Rook> rooks;

	/**
	 * The list of bishops on the board.
	 */
	private static List<Bishop> bishops;

	/**
	 * The list of Queens on the board.
	 */
	private static List<Queen> queens;

	/**
	 * The list of Knights on the board.
	 */
	private static List<Knight> knights;

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
		Board.bishops = new ArrayList<Bishop>();
		Board.queens = new ArrayList<Queen>();
		Board.knights = new ArrayList<Knight>();
		Board.history = new ArrayList<Command>();
		if (start){
			//Fill the board with units in its initial positions

			//Create black king
			King king1 = new King(new Position(7,4),0);
			kings.add(king1);
			units.add(king1);

			//Create white king
			King king2 = new King(new Position(0,4),1);
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

			//Create black bishops
			Bishop bis1 = new Bishop(new Position(0, 2),1);
			Bishop bis2 = new Bishop(new Position(0, 5),1);
			bishops.add(bis1);
			bishops.add(bis2);
			units.add(bis1);
			units.add(bis2);

			//Create white bishops
			Bishop bis3 = new Bishop(new Position(7, 2),0);
			Bishop bis4 = new Bishop(new Position(7, 5),0);
			bishops.add(bis3);
			bishops.add(bis4);
			units.add(bis3);
			units.add(bis4);

			//Create white queen
			Queen q1 = new Queen(new Position(7,3), 0);
			queens.add(q1);
			units.add(q1);

			//Create black queen
			Queen q2 = new Queen(new Position(0, 3), 1);
			queens.add(q2);
			units.add(q2);

			//Create black knights
			Knight k1 = new Knight(new Position(0,1), 1);
			Knight k2 = new Knight(new Position(0, 6), 1);
			knights.add(k1);
			knights.add(k2);
			units.add(k1);
			units.add(k2);

			//Create white knights
			Knight k3 = new Knight(new Position(7, 1), 0);
			Knight k4 = new Knight(new Position(7, 6), 0);
			knights.add(k3);
			knights.add(k4);
			units.add(k3);
			units.add(k4);

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
	 * @param game The status of the game, start a new game if true.
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
	 * Returns the color of the occupying unit
	 * @param pos
	 * @return the color of the unit occupying pos. -1 if no unit exists.
	 */
	public static int isOccupiedBy(Position pos){
		/*
		This is probably one of the most inefficient ways of doing this. It works for now, but this should really be fixed!
		 */
		for (Unit unit : units){
			if (unit.getPos().equals((pos))){
				return unit.getColor();
			}
		}
		return -1;
	}

	/**
	 * Return unit occupying pos
	 * @param pos
	 * @return the color of the unit occupying pos. -1 if no unit exists.
	 */
	public static Unit getUnit(Position pos){
		/*
		This is probably one of the most inefficient ways of doing this. It works for now, but this should really be fixed!
		 */
		for (Unit unit : units){
			if (unit.getPos().equals((pos))){
				return unit;
			}
		}
		return null;
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
	 * @param init The position that is occupied by the unit that is the "killer"
	 * @param des The position that is occupied by the unit that is the "victim"
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

	/**
	 * Execute command if it is legal to do so.
	 * @param command The command
	 * @param turn Odd if white, even if black.
	 */
	public static boolean execute(Command command, int turn){
		Position init = command.getFrom();
		Position des = command.getTo();
		Unit unit = getUnit(init);
		int checked;
		int unitColorInit = isOccupiedBy(init);
		int unitColorDes = isOccupiedBy(des);

		if (unitColorInit != -1 && unitColorDes == -1){
			if (unitColorInit == 0 && turn % 2 != 0){
				System.out.println("Moving from " + command.represent.substring(0, 2) + " to " + command.represent.substring(3, 5));
				move(init, des);
				//We want to check if the movement causes a check after the move is executed.
				checked = check(unit);
				if (checked == 1){
					//Now we want to check if the check is actually a checkmate
					System.out.println("Black is checked!");
				}
				return true;
			}
			else if (unitColorInit == 1 && turn % 2 == 0){
				System.out.println("Moving from " + command.represent.substring(0, 2) + " to " + command.represent.substring(3, 5));
				move(init, des);
				checked = check(unit);
				if (checked == 0){
					System.out.println("White is checked!");
				}
				return true;
			}
			else {
				System.out.println("It is not your turn!");
				return false;
			}
		}
		else if (unitColorInit != unitColorDes && (unitColorInit != -1 && unitColorDes != -1)){
			if (unitColorInit == 0 && turn % 2 != 0){
				System.out.println("White unit at " + command.represent.substring(0, 2) + " killing black unit at " + command.represent.substring(3, 5));
				kill(init, des);
				checked = check(unit);
				if (checked == 1){
					System.out.println("Black is checked!");
				}
				return true;
			}
			else if (unitColorInit == 1 && turn % 2 == 0){
				System.out.println("Black unit at " + command.represent.substring(0, 2) + " killing white unit at " + command.represent.substring(3, 5));
				kill(init, des);
				checked = check(unit);
				if (checked == 0){
					System.out.println("White is checked!");
				}
				return true;
			}
			else {
				System.out.println("It is not your turn!");
				return false;
			}
		}
		return false;
	}

	/**
	 * Return 0 if white is checked, 1 if black is checked, -1 if no check.
	 * @param unit
	 * @return 0 if white is checked, 1 if black is checked, -1 if no check.
	 */
	public static int check(Unit unit){
		for (Position pos: unit.canKill()){
			Unit possibleKing = getUnit(pos);
			if (kings.contains(possibleKing)){
				if (possibleKing.getColor() == 0){
					return 0;
				}
				else {
					return 1;
				}
			}
		}
		return -1;
	}

	/**
	 * Return 0 if white is checkmated, 1 if black is checkmated, -1 otherwise.
	 * @param board
	 * @return
	 */
	public static int checkMate(Board board){
		return -1;
	}

	/**
	 * Return 0 if white wins, 1 if black wins, -1 otherwise.
	 * @param board
	 * @return 0 if white wins, 1 if black wins, -1 otherwise.
	 */
	public static int wins(Board board){
		return -1;
	}

}
