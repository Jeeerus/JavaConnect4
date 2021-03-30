package MainMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jairus
 */
public class MainMenuPanel extends JPanel{
    private JLabel mainmenubg;
    private JButton newGame;
    private JButton continueGame;
    private JButton instructions;
    private JButton options;
    private JButton exitGame;
    
    public MainMenuPanel(){
        this.setPreferredSize(new Dimension(600, 660));
        this.setLayout(null);
        
        // New Game Button
        this.newGame = new JButton();
        this.newGame.setOpaque(false);
        this.newGame.setContentAreaFilled(false);
        this.newGame.setBorderPainted(false);
        this.newGame.setIcon(new ImageIcon("mainmenuimages\\newgame.png"));
        this.newGame.setRolloverIcon(new ImageIcon("mainmenuimages\\newgamehover.png"));
        this.newGame.setBounds(200, 260, 200, 30);
        this.add(newGame);
        // ---------------------------------------\\
        
       // Continue Button
        this.continueGame = new JButton();
        this.continueGame.setOpaque(false);
        this.continueGame.setContentAreaFilled(false);
        this.continueGame.setBorderPainted(false);
        this.continueGame.setIcon(new ImageIcon("mainmenuimages\\continue.png"));
        this.continueGame.setRolloverIcon(new ImageIcon("mainmenuimages\\continuehover.png"));
        this.continueGame.setBounds(200, 315, 200, 30);
        this.add(continueGame);
        // ---------------------------------------\\
        
        // Instructions Button
        this.instructions = new JButton();
        this.instructions.setOpaque(false);
        this.instructions.setContentAreaFilled(false);
        this.instructions.setBorderPainted(false);
        this.instructions.setIcon(new ImageIcon("mainmenuimages\\instructions.png"));
        this.instructions.setRolloverIcon(new ImageIcon("mainmenuimages\\instructionshover.png"));
        this.instructions.setBounds(200, 370, 200, 30);
        this.add(instructions);
        // ---------------------------------------\\
        
        // Options Button
        this.options = new JButton();
        this.options.setOpaque(false);
        this.options.setContentAreaFilled(false);
        this.options.setBorderPainted(false);
        this.options.setIcon(new ImageIcon("mainmenuimages\\options.png"));
        this.options.setRolloverIcon(new ImageIcon("mainmenuimages\\optionshover.png"));
        this.options.setBounds(200, 425, 200, 30);
        this.add(options);
        //-----------------------------------------\\
        
        // Exit Button
        this.exitGame = new JButton();
        this.exitGame.setOpaque(false);
        this.exitGame.setContentAreaFilled(false);
        this.exitGame.setBorderPainted(false);
        this.exitGame.setIcon(new ImageIcon("mainmenuimages\\exit.png"));
        this.exitGame.setRolloverIcon(new ImageIcon("mainmenuimages\\exithover.png"));
        this.exitGame.setBounds(200, 480, 200, 30);
        this.add(exitGame);
        //-----------------------------------------\\
        
        this.mainmenubg = new JLabel();
        this.mainmenubg.setPreferredSize(new Dimension(600,660));
        this.mainmenubg.setBounds(0, 0, 600, 660);
        this.mainmenubg.setIcon(new ImageIcon("mainmenuimages\\mainmenubg.png"));
        this.add(mainmenubg);
    }

    public JButton getNewGame() {
        return newGame;
    }

    public void setNewGame(JButton newGame) {
        this.newGame = newGame;
    }

    public JButton getContinueGame() {
        return continueGame;
    }

    public void setContinueGame(JButton continueGame) {
        this.continueGame = continueGame;
    }

    public JButton getInstructions() {
        return instructions;
    }

    public void setInstructions(JButton instructions) {
        this.instructions = instructions;
    }

    public JButton getOptions() {
        return options;
    }

    public void setOptions(JButton options) {
        this.options = options;
    }

    public JButton getExitGame() {
        return exitGame;
    }

    public void setExitGame(JButton exitGame) {
        this.exitGame = exitGame;
    }
    
    
}
