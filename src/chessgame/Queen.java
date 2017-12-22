package chessgame;

import java.util.List;

public class Queen implements Unit {
    private Position pos;
    private int color;

    public Queen(Position pos, int color) {
        this.pos = pos;
        this.color = color;
    }

    /**
     * Gets a list of positions where the queen can move.
     *
     * @return A list of positions where the unit can move.
     */
    @Override
    public List<Position> canMove() {
        return null;
    }

    /**
     * True if the queen can move to said position.
     *
     * @param pos The position that a unit wants to move to.
     * @return Whether or not a unit can move to pos.
     */
    @Override
    public boolean canMove(Position pos) {
        return false;
    }

    /**
     * Gets the position of the unit.
     *
     * @return The unit's position
     */
    @Override
    public Position getPos() {
        return null;
    }

    /**
     * Gets the color of the unit, 0 if white, 1 if black.
     *
     * @return 0 = white, 1 = black.
     */
    @Override
    public int getColor() {
        return 0;
    }

    /**
     * Sets the position of the pawn.
     *
     * @param pos The position of the pawn.
     */
    @Override
    public void setPos(Position pos) {

    }


    /**
     * Gets a list of positions where the unit can kill a unit and move to it.
     *
     * @return A list of positions where the unit can kill, then move to it.
     */
    @Override
    public List<Position> canKill() {
        return null;
    }

    /**
     * True if the unit can kill a unit and move to said position.
     *
     * @param pos The position that a unit wants to kill and move to.
     * @return Whether or not a unit can kill and move to pos.
     */
    @Override
    public boolean canKill(Position pos) {
        return false;
    }

    @Override
    public String toString() {
        return "Queen [pos=" + pos + ", color=" + color + "]";
    }
}
