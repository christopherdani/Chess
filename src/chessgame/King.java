package chessgame;

import java.util.ArrayList;
import java.util.List;

/**
 * A representation a king and what it can do.
 */
public class King implements Unit {

    private Position pos;
    private int color;

    /**
     * Create a king.
     * @param pos The initial position where the king is to be spawned.
     * @param color The color of the king.
     */
    public King(Position pos, int color){
        this.pos = pos;
        this.color = color;
    }

    /**
     * Gets a list of positions that the king can move to.
     * @return A list of positions that the king can move to, empty list if cannot move.
     */
    @Override
    public List<Position> canMove() {
        List<Position> moves = new ArrayList<Position>();

        Position current = this.getPos();
        Position down = Position.turnDown(current);
        if (!down.equals(current) && !Board.isOccupied(down)){
            moves.add(down);
        }

        Position up = Position.turnUp(current);
        if (!up.equals(current) && !Board.isOccupied(up)){
            moves.add(up);
        }

        Position left = Position.turnLeft(current);
        if (!left.equals(current) && !Board.isOccupied(left)){
            moves.add(left);
        }

        Position right = Position.turnRight(current);
        if (!right.equals(current) && !Board.isOccupied(right)){
            moves.add(right);
        }

        Position upRight = Position.turnRight(current);
        if (!upRight.equals(current)){
            upRight = Position.turnUp(upRight);
            if (!upRight.equals(current) && !Board.isOccupied(upRight)) {
                moves.add(upRight);
            }
        }

        Position upLeft = Position.turnLeft(current);
        if (!upLeft.equals(current)){
            upLeft = Position.turnUp(upLeft);
            if (!upLeft.equals(current) && !Board.isOccupied(upLeft)) {
                moves.add(upLeft);
            }
        }

        Position downLeft = Position.turnLeft(current);
        if (!downLeft.equals(current)){
            downLeft = Position.turnDown(downLeft);
            if (!downLeft.equals(current) && !Board.isOccupied(downLeft)) {
                moves.add(downLeft);
            }
        }

        Position downRight = Position.turnRight(current);
        if (!downRight.equals(current)){
            downRight = Position.turnDown(downRight);
            if (!downRight.equals(current) && !Board.isOccupied(downRight)) {
                moves.add(downRight);
            }
        }

        return moves;
    }
    /**
     * Gets the position of the king.
     * @return The position of the king.
     */
    @Override
    public Position getPos() {
        return this.pos;
    }

    /**
     * True if the king can move, false otherwise.
     * @param pos The position that a unit wants to move to.
     * @return True if the king can move, false otherwise.
     */
    @Override
    public boolean canMove(Position pos) {
        List<Position> moves = new ArrayList<Position>();
        moves = this.canMove();
        if (moves.contains(pos)){
            return true;
        }
        return false;
    }

    /**
     * Gets a list of positions where the king can kill the unit and move to its position.
     * @return A list of positions where the king can kill the unit occupying it and move to its position.
     */
    @Override
    public List<Position> canKill() {
        return null;
    }

    /**
     * True if the king can kill a unit and move to its position.
     * @param pos The position that a unit wants to kill and move to.
     * @return true if the king can kill a unit and move to is position, false otherwise.
     */
    @Override
    public boolean canKill(Position pos) {
        return false;
    }
}
