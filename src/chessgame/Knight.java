package chessgame;

import java.util.ArrayList;
import java.util.List;

public class Knight implements Unit {

    private Position pos;
    private int color;

    /**
     * Create a pawn.
     * @param pos The initial position where the pawn is to be spawned.
     * @param color The color of the pawn.
     */
    public Knight(Position pos, int color){
        this.pos = pos;
        this.color = color;
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
        Position upRight = Position.turnRight(Position.turnUp(Position.turnUp(current)));
        Position upLeft = Position.turnLeft(Position.turnUp(Position.turnUp(current)));
        Position downRight = Position.turnRight(Position.turnDown(Position.turnDown(current)));
        Position downLeft = Position.turnLeft(Position.turnDown(Position.turnDown(current)));

        if (!Board.isOccupied(upRight)){
            moves.add(upRight);
        }
        if (!Board.isOccupied(upLeft)){
            moves.add(upLeft);
        }

        if (!Board.isOccupied(downRight)){
            moves.add(downRight);
        }
        if (!Board.isOccupied(downLeft)){
            moves.add(downLeft);
        }
        System.out.println(moves);
        return moves;
    }

    /**
     * True if the unit can move to said position.
     *
     * @param pos The position that a unit wants to move to.
     * @return Whether or not a unit can move to pos.
     */
    @Override
    public boolean canMove(Position pos) {
        List<Position> moves = new ArrayList<Position>();
        moves = this.canMove();
        if (moves.contains(pos)) {
            return true;
        }
        return false;
    }

    /**
     * Gets the position of the unit.
     *
     * @return The unit's position
     */
    @Override
    public Position getPos() {
        return this.pos;
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
        this.pos = pos;
    }

    /**
     * Gets a list of positions where the unit can kill a unit and move to it.
     *
     * @return A list of positions where the unit can kill, then move to it.
     */
    @Override
    public List<Position> canKill() {
        List<Position> kills = new ArrayList<Position>();

        Position current = this.getPos();
        Position upRight = Position.turnRight(Position.turnUp(Position.turnUp(current)));
        Position upLeft = Position.turnLeft(Position.turnUp(Position.turnUp(current)));
        Position downRight = Position.turnRight(Position.turnDown(Position.turnDown(current)));
        Position downLeft = Position.turnLeft(Position.turnDown(Position.turnDown(current)));

        if (Board.isEnemyOccupied(this, upRight)){
            kills.add(upRight);
        }
        if (Board.isEnemyOccupied(this, upLeft)){
            kills.add(upLeft);
        }
        if (Board.isEnemyOccupied(this, downRight)){
            kills.add(downRight);
        }
        if (Board.isEnemyOccupied(this, downLeft)){
            kills.add(downLeft);
        }

        return kills;
    }

    /**
     * True if the unit can kill a unit and move to said position.
     *
     * @param pos The position that a unit wants to kill and move to.
     * @return Whether or not a unit can kill and move to pos.
     */
    @Override
    public boolean canKill(Position pos) {
        List<Position> kills = new ArrayList<Position>();
        kills = this.canKill();
        if (kills.contains(pos)) {
            return true;
        }
        return false;
    }

    /**
     * A string representation of the rook.
     * @return A string representation in the format of "Rook [pos= position, color= color]".
     */
    @Override
    public String toString() {
        return "Knight [pos=" + pos + ", color=" + color + "]";
    }
}
