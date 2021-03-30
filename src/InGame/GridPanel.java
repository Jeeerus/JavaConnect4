/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InGame;

import Model.Grid;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Jairus
 */
public class GridPanel extends JPanel{
    JLabel gridBox[][] = new JLabel[6][7];
    
    public GridPanel(){
        this.setPreferredSize(new Dimension (600, 500));
        this.setLayout(new FlowLayout());
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createMatteBorder(
                                    0, 5, 5, 5, Color.DARK_GRAY));
        
        for(int r = 0; r < 6; r++){
            for (int c = 0; c < 7; c++){
                this.gridBox[r][c] = new JLabel();
                this.gridBox[r][c].setPreferredSize(new Dimension(75, 75));
                this.gridBox[r][c].setBackground(Color.white);
                this.gridBox[r][c].setOpaque(true);
                this.gridBox[r][c].setIcon(new ImageIcon("ingameimages\\openbox.png"));
                this.add(this.gridBox[r][c]);
            }
        }
        
        /*
        if(this.gridBox[5][6].getBackground() == Color.WHITE){
            this.gridBox[5][6].setBackground(Color.red);
        }*/
    }
    
    /**
     *  Drops a chip into the grid. This method takes in the colour and column
     *  number. The colour of a chosen column + open grid box will have its 
     *  colour changed, depending on whose turn it is.
     */
    public boolean dropChip(int column, Color e){
        for(int i = 6 - 1; i >= 0; i--){
            if(this.gridBox[i][column].getBackground() == Color.white){
                this.gridBox[i][column].setBackground(e);
                return false;
            }
        }
        return true;
    }
    
    public void updateGrid(Grid g, Color playerColour, char e){
        for(int r = 0; r < g.getGridRows(); r++){
            for(int c = 0; c < g.getGridColumns(); c++){
                if(g.getGrid()[r][c] == e){
                    this.gridBox[r][c].setBackground(playerColour);
                }
            }
        }
    }
    
    public void resetGrid(){
        for(int r = 0; r < 6; r++){
            for (int c = 0; c < 7; c++){
                this.gridBox[r][c].setBackground(Color.white);
            }
        }
    }
}
