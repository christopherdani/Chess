package chessgame;

import java.util.List;
import java.util.ArrayList;

public interface Unit {
	
	//COLOR 0 = white
	//COLOR 1 = black
	
	/**
	 * 
	 * @return A list of positions where the unit can move.
	 */
	public List<Position> canMove();
	
	/**
	 * 
	 * @param pos The position that a unit wants to move to.
	 * @return Whether or not a unit can move to pos.
	 */
	public boolean canMove(Position pos);
	
	public List<Position> canKill();
	
	public boolean canKill(Position pos);


}
