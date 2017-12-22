package chessgame;

import java.util.ArrayList;
import java.util.List;

public class Bishop implements Unit{

    private Position pos;
    private int color;

    /**
     * Create a bishop.
     * @param pos The initial position where the bishop is to be spawned.
     * @param color The color of the bishop.
     */
    public Bishop(Position pos, int color){
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
        for (int i = 0; i < 8; i++){
            if (Position.turnUpRight(current).equals(current) ){
                break;
            }
            else {
                if (!Board.isOccupied(Position.turnUpRight(current))){
                    moves.add(Position.turnUpRight(current));
                    current = Position.turnUpRight(current);
                }
            }
        }

        current = this.getPos();
        for (int i = 0; i < 8; i++){
            if (Position.turnUpLeft(current).equals(current) ){
                break;
            }
            else {
                if (!Board.isOccupied(Position.turnUpLeft(current))){
                    moves.add(Position.turnUpLeft(current));
                    current = Position.turnUpLeft(current);
                }
            }
        }

        current = this.getPos();
        for (int i = 0; i < 8; i++){
            if (Position.turnDownLeft(current).equals(current) ){
                break;
            }
            else {
                if (!Board.isOccupied(Position.turnDownLeft(current))){
                    moves.add(Position.turnDownLeft(current));
                    current = Position.turnDownLeft(current);
                }
            }
        }

        current = this.getPos();
        for (int i = 0; i < 8; i++){
            if (Position.turnDownRight(current).equals(current) ){
                break;
            }
            else {
                if (!Board.isOccupied(Position.turnDownRight(current))){
                    moves.add(Position.turnDownRight(current));
                    current = Position.turnDownRight(current);
                }
            }
        }

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
        this.pos = new Position(pos);
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
        for (int i = 0; i < 8; i++){
            if (Position.turnUpRight(current).equals(current) ){
                break;
            }
            else {
                if (Board.isEnemyOccupied(this, Position.turnUpRight(current))){
                    kills.add(Position.turnUpRight(current));
                    break;
                }
                else if (Board.isAllyOccupied(this, Position.turnUpRight(current))){
                    break;
                }
                current = Position.turnUpRight(current);
            }
        }

        current = this.getPos();
        for (int i = 0; i < 8; i++){
            if (Position.turnUpLeft(current).equals(current) ){
                break;
            }
            else {
                if (Board.isEnemyOccupied(this, Position.turnUpLeft(current))){
                    kills.add(Position.turnUpLeft(current));
                    break;
                }
                else if (Board.isAllyOccupied(this, Position.turnUpLeft(current))){
                    break;
                }
                current = Position.turnUpLeft(current);
            }
        }

        current = this.getPos();
        for (int i = 0; i < 8; i++){
            if (Position.turnDownLeft(current).equals(current) ){
                break;
            }
            else {
                if (Board.isEnemyOccupied(this, Position.turnDownLeft(current))){
                    kills.add(Position.turnDownLeft(current));
                    break;
                }
                else if (Board.isAllyOccupied(this, Position.turnDownLeft(current))){
                    break;
                }
                current = Position.turnDownLeft(current);
            }
        }

        current = this.getPos();
        for (int i = 0; i < 8; i++){
            if (Position.turnDownRight(current).equals(current) ){
                break;
            }
            else {
                if (Board.isEnemyOccupied(this, Position.turnDownRight(current))){
                    kills.add(Position.turnDownRight(current));
                    break;
                }
                else if (Board.isAllyOccupied(this, Position.turnDownRight(current))){
                    break;
                }
                current = Position.turnDownRight(current);
            }
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
        return "Bishop [pos=" + pos + ", color=" + color + "]";
    }
}
