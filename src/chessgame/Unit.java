package chessgame;

import java.util.List;
import java.util.ArrayList;

/**
 * An interface that describes a unit in a chess game.
 */
public interface Unit {
	
	//COLOR 0 = white
	//COLOR 1 = black
	
	/**
	 * Gets a list of positions where the unit can move.
	 * @return A list of positions where the unit can move.
	 */
	List<Position> canMove();
	
	/**
	 * True if the unit can move to said position.
	 * @param pos The position that a unit wants to move to.
	 * @return Whether or not a unit can move to pos.
	 */
	boolean canMove(Position pos);

	/**
	 * Gets the position of the unit.
	 * @return The unit's position
	 */
	Position getPos();

	/**
	 * Gets the color of the unit, 0 if white, 1 if black.
	 * @return 0 = white, 1 = black.
	 */
	int getColor();

	/**
	 * Sets the position of the pawn.
	 * @param pos The position of the pawn.
	 */
	void setPos(Position pos);

	/**
	 * Gets a list of positions where the unit can kill a unit and move to it.
	 * @return A list of positions where the unit can kill, then move to it.
	 */
	List<Position> canKill();

	/**
	 * True if the unit can kill a unit and move to said position.
	 * @param pos The position that a unit wants to kill and move to.
	 * @return Whether or not a unit can kill and move to pos.
	 */
	boolean canKill(Position pos);


}
