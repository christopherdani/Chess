package chessgame;

/**
 * A class that represents a position on the chess board.
 * A position has a file and rank: file = column
 * 								   rank = row
 */
public class Position {

	//Columns
	private int file;
	//Rows
	private int rank;
	
	/**
	 * Creates a representation of the position of a chess unit on a chess board.
	 * 
	 * @param file  The column of the position
	 * @param rank  The row of the position
	 * @throws IllegalArgumentException If file or rank is outside of the board
	 */
	public Position(int rank, int file) throws IllegalArgumentException{
		//Implement exception!
		this.rank = rank;
		this.file = file;
	}
	
	/**
	 * Copy another position.
	 * 
	 * @param other The position that is to be copied.
	 * @throws IllegalArgumentException If other is not valid.
	 */
	public Position (Position other) throws IllegalArgumentException{
		this(other.rank, other.file);
	}

	/**
	 * Gets the file(column) of a unit.
	 * @return The file of the unit.
	 */
	public int getFile() {
		return this.file;
	}

	/**
	 * Gets the rank(row) of a unit.
	 * @return The rank of the unit.
	 */
	public int getRank() {
		return this.rank;
	}


	/**
	 * Turn left on the board.
	 * @param pos The position from which you want to turn to.
	 * @return A position left to pos or pos if cannot turn left.
	 */
	public static Position turnLeft (Position pos) {
		Position left = new Position(pos.getRank(), pos.getFile() - 1);

		//If the unit is not at the leftmost tile of the board, proceed
		if (pos.getFile() != 0){

				return left;
		}

		return pos;
	}

	/**
	 * Turn right on the board.
	 * @param pos The position from which you want to turn to.
	 * @return A position right to pos or pos if cannot turn right.
	 */
	public static Position turnRight (Position pos) {
		Position right = new Position(pos.getRank(), pos.getFile() + 1);

		//If the unit is not at the rightmost tile of the board, proceed
		if (pos.getFile() != 7){

				return right;

		}

		return pos;
	}

	/**
	 * Turn up on the board.
	 * @param pos The position from which you want to turn to.
	 * @return A position up to pos or pos if cannot turn up.
	 */
	public static Position turnUp (Position pos) {
		Position up = new Position(pos.getRank() - 1, pos.getFile());

		//If the unit is not at the highest tile of the board, proceed
		if (pos.getRank() != 0){

				return up;

		}

		return pos;
	}

	/**
	 * Turn down on the board.
	 * @param pos The position from which you want to turn to.
	 * @return A position down to pos or pos if cannot turn down.
	 */
	public static Position turnDown (Position pos) {
		Position down = new Position(pos.getRank() + 1, pos.getFile());

		//If the unit is not at the lowest tile of the board, proceed
		if (pos.getRank() != 7){

				return down;

		}

		return pos;
	}

	/**
	 * Turn down right on the board.
	 * @param pos The position from which you want to turn to.
	 * @return A position down right to pos or pos if cannot turn down.
	 */
	public static Position turnDownRight (Position pos) {
		//If the unit is not at the lowest tile of the board, proceed
		if (pos.getRank() != 7 && pos.getFile() != 7){

			return new Position(pos.getRank() + 1, pos.getFile() + 1);

		}

		return pos;
	}

	/**
	 * Turn down right on the board.
	 * @param pos The position from which you want to turn to.
	 * @return A position down right to pos or pos if cannot turn down.
	 */
	public static Position turnDownLeft (Position pos) {
		//If the unit is not at the lowest tile of the board, proceed
		if (pos.getRank() != 7 && pos.getFile() != 0){

			return new Position(pos.getRank() + 1, pos.getFile() - 1);

		}

		return pos;
	}

	/**
	 * Turn down right on the board.
	 * @param pos The position from which you want to turn to.
	 * @return A position down right to pos or pos if cannot turn down.
	 */
	public static Position turnUpRight (Position pos) {
		//If the unit is not at the lowest tile of the board, proceed
		if (pos.getRank() != 0 && pos.getFile() != 7){

			return new Position(pos.getRank() - 1, pos.getFile() + 1);

		}

		return pos;
	}

	/**
	 * Turn down right on the board.
	 * @param pos The position from which you want to turn to.
	 * @return A position down right to pos or pos if cannot turn down.
	 */
	public static Position turnUpLeft (Position pos) {
		//If the unit is not at the lowest tile of the board, proceed
		if (pos.getRank() != 0 && pos.getFile() != 0){

			return new Position(pos.getRank() - 1, pos.getFile() - 1);

		}

		return pos;
	}

	/**
	 * A string representation of a position.
	 * @return A string in the format of "(file, rank)".
	 */
	@Override
	public String toString() {
		return "(" +rank + ", " + file+ ")";
	}

	/**
	 * Checks if 2 Position objects are equal, returns true if its file and rank are equal.
	 * @param other The position to compare to.
	 * @return true if file and rank are equal, false otherwise.
	 */
	public boolean equals(Position other){
		if (other == null || this == null){
			return false;
		}

		if (this.file != other.file){
			return false;
		}
		if (this.rank != other.rank){
			return false;
		}
		return true;
	}
	
}
