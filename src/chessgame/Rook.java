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
     * Gets the position of the unit.
     *
     * @return The unit's position
     */
    @Override
    public Position getPos() {
        return this.pos;
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
            if (Position.turnUp(current).equals(current) ){
                break;
            }
            else {
                if (!Board.isOccupied(Position.turnUp(current))){
                    moves.add(Position.turnUp(current));
                    current = Position.turnUp(current);
                }
            }
        }

        current = this.getPos();
        for (int i = 0; i < 8; i++){
            if (Position.turnLeft(current).equals(current) ){
                break;
            }
            else {
                if (!Board.isOccupied(Position.turnLeft(current))){
                    moves.add(Position.turnLeft(current));
                    current = Position.turnLeft(current);
                }
            }
        }

        current = this.getPos();
        for (int i = 0; i < 8; i++){
            if (Position.turnDown(current).equals(current) ){
                break;
            }
            else {
                if (!Board.isOccupied(Position.turnDown(current))){
                    moves.add(Position.turnDown(current));
                    current = Position.turnDown(current);
                }
            }
        }

        current = this.getPos();
        for (int i = 0; i < 8; i++){
            if (Position.turnDownRight(current).equals(current) ){
                break;
            }
            else {
                if (!Board.isOccupied(Position.turnRight(current))){
                    moves.add(Position.turnRight(current));
                    current = Position.turnRight(current);
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
     * Gets a list of positions where the unit can kill a unit and move to it.
     *
     * @return A list of positions where the unit can kill, then move to it.
     */
    @Override
    public List<Position> canKill() {
        List<Position> kills = new ArrayList<Position>();

        Position current = this.getPos();
        for (int i = 0; i < 8; i++){
            if (Position.turnUp(current).equals(current) ){
                break;
            }
            else {
                if (Board.isEnemyOccupied(this, Position.turnUp(current))){
                    kills.add(Position.turnUp(current));
                    break;
                }
                else if (Board.isAllyOccupied(this, Position.turnUp(current))){
                    break;
                }
                current = Position.turnUp(current);
            }
        }

        current = this.getPos();
        for (int i = 0; i < 8; i++){
            if (Position.turnLeft(current).equals(current) ){
                break;
            }
            else {
                if (Board.isEnemyOccupied(this, Position.turnLeft(current))){
                    kills.add(Position.turnLeft(current));
                    break;
                }
                else if (Board.isAllyOccupied(this, Position.turnLeft(current))){
                    break;
                }
                current = Position.turnLeft(current);
            }
        }

        current = this.getPos();
        for (int i = 0; i < 8; i++){
            if (Position.turnDown(current).equals(current) ){
                break;
            }
            else {
                if (Board.isEnemyOccupied(this, Position.turnDown(current))){
                    kills.add(Position.turnDown(current));
                    break;
                }
                else if (Board.isAllyOccupied(this, Position.turnDown(current))){
                    break;
                }
                current = Position.turnDown(current);
            }
        }

        current = this.getPos();
        for (int i = 0; i < 8; i++){
            if (Position.turnRight(current).equals(current) ){
                break;
            }
            else {
                if (Board.isEnemyOccupied(this, Position.turnRight(current))){
                    kills.add(Position.turnRight(current));
                    break;
                }
                else if (Board.isAllyOccupied(this, Position.turnRight(current))){
                    break;
                }
                current = Position.turnRight(current);
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
        return "Rook [pos=" + pos + ", color=" + color + "]";
    }
}