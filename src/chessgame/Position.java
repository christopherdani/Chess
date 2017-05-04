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
	 * @param file  The column of the position
	 * @param rank  The row of the position
	 * @throws IllegalArgumentException If file or rank is outside of the board
	 */
	public Position (Position other){
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
		return file;
	}

	public int getRank() {
		return rank;
	}

	@Override
	public String toString() {
		return "(" +file + ", " + rank+ ")";
	}
	
	
	
}
