package chessgame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christopher Dani on 2017-05-06.
 */
public class King implements Unit {

    private Position pos;
    private int color;

    public King(Position pos, int color){
        this.pos = pos;
        this.color = color;
    }

    /**
     * @return A list of positions where the king can move.
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
     * @param pos The position that a unit wants to move to.
     * @return Whether or not a unit can move to pos.
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

    @Override
    public Position getPos() {
        return this.pos;
    }

    @Override
    public List<Position> canKill() {
        return null;
    }

    @Override
    public boolean canKill(Position pos) {
        return false;
    }
}
