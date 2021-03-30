/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jairus
 */
public class GameWinnerPanel extends JPanel{
    private JLabel winner;
    public GameWinnerPanel(){
        this.setPreferredSize(new Dimension(600, 90));
        this.setBackground(Color.DARK_GRAY);
        this.winner = new JLabel();
        this.winner.setPreferredSize(new Dimension (600,90));
        this.add(winner);
    }

    public JLabel getWinner() {
        return winner;
    }

    public void setWinner(JLabel winner) {
        this.winner = winner;
    }    
}
