package chessgame;

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

	public int getFile() {
		return this.file;
	}

	public int getRank() {
		return this.rank;
	}


	public static Position turnLeft (Position pos) {
		if (pos.getRank() < 1){
			return pos;
		}
		return new Position(pos.getFile(), pos.getRank() - 1);
	}

	public static Position turnRight (Position pos) {
		if (pos.getRank() > 7){
			return pos;
		}
		return new Position(pos.getFile(), pos.getRank() + 1);
	}

	public static Position turnUp (Position pos) {
		if (pos.getFile() < 1){
			return pos;
		}
		return new Position(pos.getFile() - 1, pos.getRank());
	}

	public static Position turnDown (Position pos) {
		if (pos.getRank() > 7){
			return pos;
		}
		return new Position(pos.getFile() + 1, pos.getRank());
	}

	@Override
	public String toString() {
		return "(" +file + ", " + rank+ ")";
	}
	
	
	
}
