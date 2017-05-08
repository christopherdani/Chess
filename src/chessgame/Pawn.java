package chessgame;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that describes a pawn object and what it can do.
 */
public class Pawn implements Unit{

	private Position pos;
	private int color;

	
	public Pawn(Position pos, int color){
		this.pos = pos;
		this.color = color;

	}

	@Override
	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}
	

	@Override
	public List<Position> canMove() {
		//Implement en passant!
		List<Position> paths = new ArrayList<Position>();
		Position current = this.getPos();
		Position move;
		if (this.color == 0) {
			move = new Position(current.getFile() + 1, current.getRank());
		}
		else {
			move = new Position(current.getFile() - 1, current.getRank());
		}
		if (!Board.isOccupied(move)){
			paths.add(move);
		}
		return paths;
	}

	@Override
	public boolean canMove(Position pos) {
		if (this.color == 0 && !Board.isOccupied(new Position(pos.getFile() + 1, this.getPos().getRank()))){
			return true;
		}
		else if (this.color == 1 && !Board.isOccupied(new Position(pos.getFile() - 1, this.getPos().getRank()))){
			return true;
		}
		return false;
	}

	@Override
	public List<Position> canKill() {
		List<Position> killPositions = new ArrayList<Position>();
		Position current = this.getPos();
		Position killPos1, killPos2;
		if (this.color == 0) {
			killPos1 = new Position(current.getFile() + 1, current.getRank() + 1);
			killPos2 = new Position(current.getFile() + 1, current.getRank() - 1);
		}
		else {
			killPos1 = new Position(current.getFile() - 1, current.getRank() + 1);
			killPos2 = new Position(current.getFile() - 1, current.getRank() - 1);
		}
		// Implement en passant later!
		if (Board.isOccupied(killPos1)){
			killPositions.add(killPos1);
		}
		if (Board.isOccupied(killPos2)){
			killPositions.add(killPos2);
		}
		return killPositions;
	}

	@Override
	public boolean canKill(Position pos) {
		if (!this.canKill().isEmpty()){
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Pawn [pos=" + pos + ", color=" + color + "]";
	}
	
	




}
