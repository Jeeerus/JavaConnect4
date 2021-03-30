package StartGame;

import Model.Chip;
import Model.Grid;
import Model.Player;
import java.awt.Color;

/**
 * Contains the Model for the Game. The view will be based on the contents of
 * this class.
 *
 * @author Jairus M. & Andrew B.
 */
public class ConnectFourModel {

    private Player player1;
    private Player player2;
    private Grid grid;

    /**
     * Player 1 Default Color Yellow and has first turn. Player 2 Default Red
     */
    public ConnectFourModel() {
        this.player1 = new Player(new Chip(Color.RED), true);
        this.player2 = new Player(new Chip(Color.YELLOW), false);
        this.grid = new Grid();
    }

    /**
     * Creates the model to be used by the controller
     *
     * @param p1 the colour of the chip loaded from the database where the
     * playerID = 1
     * @param p2 the colour of the chip loaded from the database where the
     * playerID = 2
     */
    public ConnectFourModel(Chip p1, Chip p2) {
        this.player1 = new Player(p1, true);
        this.player2 = new Player(p2, false);
        this.grid = new Grid();
    }

    //------------------ GETTERS AND SETTERS ------------------\\
    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

}
