/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;

public class Player implements java.io.Serializable{
    private Chip playerChip;
    private boolean isPlayerTurn;
    
    public Player(Chip c, boolean isPlayerTurn){
        this.playerChip = c;
        this.isPlayerTurn = isPlayerTurn;
    }

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
