package chessgame;

import java.util.ArrayList;
import java.util.List;

/**
 * A representation a pawn and what it can do.
 */
public class Pawn implements Unit{

	private Position pos;
	private int color;

	/**
	 * Create a pawn.
	 * @param pos The initial position where the pawn is to be spawned.
	 * @param color The color of the pawn.
	 */
	public Pawn(Position pos, int color){
		this.pos = pos;
		this.color = color;
	}

	/**
	 * Gets the position of the pawn.
	 * @return The position of the pawn.
	 */
	@Override
	public Position getPos() {
		return pos;
	}

	/**
	 * Gets the color of the unit, 0 if white, 1 if black.
	 *
	 * @return 0 = white, 1 = black.
	 */
	@Override
	public int getColor() {
		return this.color;
	}

	/**
	 * Sets the position of the pawn.
	 * @param pos The position of the pawn.
	 */
	@Override
	public void setPos(Position pos) {
		this.pos = new Position(pos);
	}

	/**
	 * Gets a list of positions that the pawn can move to.
	 * @return A list of positions that the pawn can move to, empty list if cannot move.
	 */
	@Override
	public List<Position> canMove() {
		//Implement en passant!
		List<Position> paths = new ArrayList<Position>();
		Position current = this.getPos();
		Position move, twoTileMove;

		//If white pawn, then try to move up the board, and down if black.
		if (this.color == 0) {
			move = Position.turnUp(current);
			if (!Board.isOccupied(move)) {
				//If the pawn is at its starting position, then allow it to move 2 tiles up or down
				for (int i = 0; i < 8; i++) {
					if (this.getPos().equals(new Position(6, i))) {
						twoTileMove = Position.turnUp(move);
						if (!Board.isOccupied(twoTileMove)) {
							paths.add(twoTileMove);
						}
					}
				}
			}
		}
		else {
			move = Position.turnDown(current);
			if (!Board.isOccupied(move)) {
				for (int i = 0; i < 8; i++) {
					if (this.getPos().equals(new Position(1, i))) {
						twoTileMove = Position.turnDown(move);
						if (!Board.isOccupied(twoTileMove)) {
							paths.add(twoTileMove);
						}
					}
				}
			}
		}
		if (!Board.isOccupied(move)){
			paths.add(move);
		}



		return paths;
	}

	/**
	 * True if the pawn can move, false otherwise.
	 * @param pos The position that a unit wants to move to.
	 * @return True if the pawn can move, false otherwise.
	 */
	@Override
	public boolean canMove(Position pos) {
		if (!this.canMove().isEmpty()){
			return true;
		}
		return false;
	}

	/**
	 * Gets a list of positions where the pawn can kill the unit and move to its position.
	 * @return A list of positions where the pawn can kill the unit occupying it and move to its position.
	 */
	@Override
	public List<Position> canKill() {
		List<Position> killPositions = new ArrayList<Position>();
		Position current = this.getPos();
		Position killPos1, killPos2;

		if (this.color == 0) {
			killPos1 = new Position(current.getRank() - 1, current.getFile() + 1);
			killPos2 = new Position(current.getRank() - 1, current.getFile() - 1);
		}
		else {
			killPos1 = new Position(current.getRank() + 1, current.getFile() + 1);
			killPos2 = new Position(current.getRank() + 1, current.getFile() - 1);
		}
		// Implement en passant later!
		if (Board.isEnemyOccupied(this, killPos1)){
			killPositions.add(killPos1);
		}
		if (Board.isEnemyOccupied(this, killPos2)){
			killPositions.add(killPos2);
		}
		return killPositions;
	}

	/**
	 * True if the pawn can kill a unit and move to its position.
	 * @param pos The position that a unit wants to kill and move to.
	 * @return true if the pawn can kill a unit and move to is position, false otherwise.
	 */
	@Override
	public boolean canKill(Position pos) {
		if (this.canKill().contains(pos)){
			return true;
		}
		return false;
	}

	/**
	 * A string representation of the pawn.
	 * @return A string representation in the format of "Pawn [pos= position, color= color]".
	 */
	@Override
	public String toString() {
		return "Pawn [pos=" + pos + ", color=" + color + "]";
	}
}
