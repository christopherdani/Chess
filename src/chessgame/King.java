package chessgame;

import java.util.List;

/**
 * Created by Christopher Dani on 2017-05-06.
 */
public class King implements Unit {

    /**
     * @return A list of positions where the unit can move.
     */
    @Override
    public List<Position> canMove() {
        return null;
    }

    /**
     * @param pos The position that a unit wants to move to.
     * @return Whether or not a unit can move to pos.
     */
    @Override
    public boolean canMove(Position pos) {
        return false;
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
