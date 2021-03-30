/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jairus
 */
public class OptionsPanel extends JPanel{
    private JLabel player1Label;
    private JLabel player2Label;
    private JButton[] p1ColourButtons = new JButton[6];
    private JButton[] p2ColourButtons = new JButton[6];
    private JButton saveColoursButton;
    private JButton backButton;
    
    public OptionsPanel(){
        this.setPreferredSize(new Dimension(600, 600));
        this.setLayout(null);
        
        this.player1Label = new JLabel("Player 1");
        this.player2Label = new JLabel("Player 2");
        this.player1Label.setBounds(10, 100, 100, 100);
        this.player2Label.setBounds(10, 200, 100, 100);
        
        this.saveColoursButton = new JButton("Save and Exit");
        this.saveColoursButton.setBounds(10, 300, 150, 50);
        this.add(saveColoursButton);
        
        this.backButton = new JButton("Exit without saving");
        //this.backButton.setIcon(new ImageIcon("mainmenuimages\\backbutton.png"));
        //this.backButton.setRolloverIcon(new ImageIcon("mainmenuimages\\backbuttonhover.png"));
        this.backButton.setSize(new Dimension(160,40));
        this.backButton.setBounds(400, 570, 160, 40);
        //this.backButton.setContentAreaFilled(false);
        //this.backButton.setBorderPainted(false);
        //this.backButton.setOpaque(false);
        this.add(backButton);
        
        this.add(player1Label);
        this.add(player2Label);
        
        for(int i = 0; i < 6; i++){
            this.p1ColourButtons[i] = new JButton();
            this.p2ColourButtons[i] = new JButton();
            this.add(p1ColourButtons[i]);
            this.add(p2ColourButtons[i]);
        }
        
        setButtonBounds();
        setColoursP2();
        setColoursP1();
    }
    
    public void setButtonBounds(){
        int y = 100;
        for(int i = 0; i < 6; i++){
            this.p1ColourButtons[i].setBounds(y, 130, 50, 50);
            this.p2ColourButtons[i].setBounds(y, 230, 50, 50);
            y += 75;
        }
    }
    
    public void setColoursP2(){
        this.p1ColourButtons[0].setBackground(Color.red);
        this.p1ColourButtons[1].setBackground(Color.yellow);
        this.p1ColourButtons[2].setBackground(Color.blue);
        this.p1ColourButtons[3].setBackground(Color.green);
        this.p1ColourButtons[4].setBackground(Color.magenta);
        this.p1ColourButtons[5].setBackground(Color.cyan);
    }
    
    public void setColoursP1(){
        this.p2ColourButtons[0].setBackground(Color.red);
        this.p2ColourButtons[1].setBackground(Color.yellow);
        this.p2ColourButtons[2].setBackground(Color.blue);
        this.p2ColourButtons[3].setBackground(Color.green);
        this.p2ColourButtons[4].setBackground(Color.magenta);
        this.p2ColourButtons[5].setBackground(Color.cyan);
    }

    public JLabel getPlayer1Label() {
        return player1Label;
    }

    public void setPlayer1Label(JLabel player1Label) {
        this.player1Label = player1Label;
    }

    public JLabel getPlayer2Label() {
        return player2Label;
    }

    public void setPlayer2Label(JLabel player2Label) {
        this.player2Label = player2Label;
    }

    public JButton[] getP1ColourButtons() {
        return p1ColourButtons;
    }

    public void setP1ColourButtons(JButton[] p1ColourButtons) {
        this.p1ColourButtons = p1ColourButtons;
    }

    public JButton[] getP2ColourButtons() {
        return p2ColourButtons;
    }

    public void setP2ColourButtons(JButton[] p2ColourButtons) {
        this.p2ColourButtons = p2ColourButtons;
    }

    public JButton getSaveColoursButton() {
        return saveColoursButton;
    }

    public void setSaveColoursButton(JButton saveColoursButton) {
        this.saveColoursButton = saveColoursButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }
    
    
    
    
}
