package Model;

/**
 * The Player class creates a new Player containing all the player information
 * to be included in the game
 *
 * @author Jairus M. & Andrew B.
 */
public class Player implements java.io.Serializable {

    private Chip playerChip;
    private boolean isPlayerTurn;

    public Player(Chip c, boolean isPlayerTurn) {
        this.playerChip = c;
        this.isPlayerTurn = isPlayerTurn;
    }

    //------------------ GETTERS AND SETTERS ------------------\\
    public Chip getPlayerChip() {
        return playerChip;
    }

    public void setPlayerChip(Chip playerChip) {
        this.playerChip = playerChip;
    }

    public boolean isPlayerTurn() {
        return isPlayerTurn;
    }

    public void setIsPlayerTurn(boolean isPlayerTurn) {
        this.isPlayerTurn = isPlayerTurn;
    }
}
