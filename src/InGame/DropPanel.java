/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InGame;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Jairus
 */
public class DropPanel extends JPanel{
     private JButton[] dropButton = new JButton[7];
    
    public DropPanel(){
        this.setPreferredSize(new Dimension(600, 90));
        this.setBackground(Color.DARK_GRAY);
        
        this.dropButton = new JButton[7];
        
        for(int i = 0; i < 7; i++){
            this.dropButton[i] = new JButton();
            this.dropButton[i].setPreferredSize(new Dimension(75, 75));
            this.dropButton[i].setIcon(new ImageIcon("ingameimages\\droparrow.png"));
            this.dropButton[i].setOpaque(false);
            this.dropButton[i].setContentAreaFilled(false);
            this.dropButton[i].setBorderPainted(false);
            this.dropButton[i].setRolloverIcon(new ImageIcon("ingameimages\\droparrowhover.png"));
            this.add(dropButton[i]);
        }
    }

    public JButton[] getDropButton() {
        return dropButton;
    }

    public void setDropButton(JButton[] dropButton) {
        this.dropButton = dropButton;
    }
}
