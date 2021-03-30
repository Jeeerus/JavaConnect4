/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StartGame;

import Model.Chip;
import Model.Grid;
import Model.Player;
import java.awt.Color;

/**
 *
 * @author Jairus
 */
public class ConnectFourModel {
    private Player player1;
    private Player player2;
    private Grid grid;
    
    /**
     * Player 1 Default Yellow and Start.
     * Player 2 Default Red
     */
    public ConnectFourModel(){
        player1 =  new Player(new Chip(Color.RED), true);
        player2 = new Player(new Chip(Color.YELLOW), false);
        grid = new Grid();
    }
    
    public ConnectFourModel(Chip p1, Chip p2){
        player1 = new Player(p1, true);
        player2 = new Player(p2, false);
        grid = new Grid();
    }

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
