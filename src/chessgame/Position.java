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
	public Position(int file, int rank) throws IllegalArgumentException{
		//Implement exception!
		this.file = file;
		this.rank = rank;
	}
	
	/**
	 * Copy another position.
	 * 
	 * @param other The position that is to be copied.
	 * @throws IllegalArgumentException If other is not valid.
	 */
	public Position (Position other) throws IllegalArgumentException{
		this(other.file, other.rank);
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
		if (pos.getRank() < 1){
			return pos;
		}
		return new Position(pos.getFile(), pos.getRank() - 1);
	}

	/**
	 * Turn right on the board.
	 * @param pos The position from which you want to turn to.
	 * @return A position right to pos or pos if cannot turn left.
	 */
	public static Position turnRight (Position pos) {
		if (pos.getRank() > 7){
			return pos;
		}
		return new Position(pos.getFile(), pos.getRank() + 1);
	}

	/**
	 * Turn up on the board.
	 * @param pos The position from which you want to turn to.
	 * @return A position up to pos or pos if cannot turn left.
	 */
	public static Position turnUp (Position pos) {
		if (pos.getFile() < 1){
			return pos;
		}
		return new Position(pos.getFile() - 1, pos.getRank());
	}

	/**
	 * Turn down on the board.
	 * @param pos The position from which you want to turn to.
	 * @return A position down to pos or pos if cannot turn left.
	 */
	public static Position turnDown (Position pos) {
		if (pos.getRank() > 7){
			return pos;
		}
		return new Position(pos.getFile() + 1, pos.getRank());
	}

	/**
	 * A string representation of a position.
	 * @return A string in the format of "(file, rank)".
	 */
	@Override
	public String toString() {
		return "(" +file + ", " + rank+ ")";
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
