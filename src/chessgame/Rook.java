package chessgame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christopher Dani on 2017-06-23.
 */
public class Rook implements Unit{

    private Position pos;
    private int color;

    /**
     * Create a pawn.
     * @param pos The initial position where the pawn is to be spawned.
     * @param color The color of the pawn.
     */
    public Rook(Position pos, int color){
        this.pos = pos;
        this.color = color;
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
     *
     * @param pos The position of the pawn.
     */
    @Override
    public void setPos(Position pos) {
        this.pos = new Position(pos);
    }

    /**
     * Gets a list of positions where the unit can move.
     *
     * @return A list of positions where the unit can move.
     */
    @Override
    public List<Position> canMove() {
        List<Position> moves = new ArrayList<Position>();

        Position current = this.getPos();
        for (int i = 0; i < 8; i++){
            if (Position.turnUp(current) != current){
                current = Position.turnUp(current);
                moves.add(current);
            }
        }
        return null;
    }

    /**
     * True if the unit can move to said position.
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
        return "Rook [pos=" + pos + ", color=" + color + "]";
    }
}