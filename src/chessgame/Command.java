package chessgame;

public class Command {
    /**
     * Where the unit is at initially.
     */
    public Position from;

    /**
     * Where the unit wants to go to.
     */
    public Position to;

    /**
     * Creates a Command that contains positions from and to.
     * @param init
     * @param dest
     */
    public Command(Position init, Position dest){
        this.from = init;
        this.to = dest;
    }
}
