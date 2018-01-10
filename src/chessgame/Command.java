package chessgame;

public class Command {
    /**
     * Where the unit is at initially.
     */
    private Position from;

    /**
     * Where the unit wants to go to.
     */
    private Position to;

    /**
     * The original input string.
     */
    public String represent;


    public Position getFrom() {
        return from;
    }

    public Position getTo() {
        return to;
    }

    /**
     * Creates a Command that contains positions from and to.
     * @param init
     * @param dest
     */
    public Command(Position init, Position dest, String represent){
        this.represent = represent;
        this.from = init;
        this.to = dest;
    }

    /**
     * Returns true if the command is valid, false if invalid.
     * @return true if the command is valid, false if invalid.
     */
    public boolean isValid(){
        if (this.from.getFile() == -1 || this.from.getRank() == -1 ||this.to.getFile() == -1 || this.to.getRank() == -1){
            return false;
        }
        return true;
    }


    public String toString(){
       return "From: " + this.getFrom().toString() + " to: " + this.getTo().toString();
    }

}
