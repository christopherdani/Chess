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
	
	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}
	

	@Override
	public List<Position> canMove() {
		
		List<Position> paths = new ArrayList<Position>();
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canKill(Position pos) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "Pawn [pos=" + pos + ", color=" + color + "]";
	}
	
	




}
