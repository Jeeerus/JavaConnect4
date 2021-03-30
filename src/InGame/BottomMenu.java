package InGame;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * BottomMenu contains buttons that allow the user to Save, Start a new game or
 * Exit to the main menu, from the game.
 *
 * @author Jairus M. & Andrew B.
 */
public class BottomMenu extends JPanel {

    private JButton saveButton;
    private JButton newGameButton;
    private JButton exitButton;
    private JLabel playerTurn;

    public BottomMenu() {
        this.setPreferredSize(new Dimension(600, 50));
        this.setBackground(Color.DARK_GRAY);

        this.playerTurn = new JLabel();
        this.playerTurn.setPreferredSize(new Dimension(250, 40));
        this.playerTurn.setIcon(new ImageIcon("ingameimages\\player1turn.png"));
        this.add(playerTurn);

        this.newGameButton = new JButton();
        this.newGameButton.setPreferredSize(new Dimension(100, 30));
        this.newGameButton.setOpaque(false);
        this.newGameButton.setContentAreaFilled(false);
        this.newGameButton.setBorderPainted(false);
        this.newGameButton.setIcon(new ImageIcon("ingameimages\\newgame.png"));
        this.newGameButton.setRolloverIcon(new ImageIcon("ingameimages\\newgamehover.png"));
        this.add(newGameButton);

        this.saveButton = new JButton();
        this.saveButton.setPreferredSize(new Dimension(100, 30));
        this.saveButton.setOpaque(false);
        this.saveButton.setContentAreaFilled(false);
        this.saveButton.setBorderPainted(false);
        this.saveButton.setIcon(new ImageIcon("ingameimages\\save.png"));
        this.saveButton.setRolloverIcon(new ImageIcon("ingameimages\\savehover.png"));
        this.add(saveButton);

        this.exitButton = new JButton();
        this.exitButton.setPreferredSize(new Dimension(90, 30));
        this.exitButton.setOpaque(false);
        this.exitButton.setContentAreaFilled(false);
        this.exitButton.setBorderPainted(false);
        this.exitButton.setIcon(new ImageIcon("ingameimages\\exit.png"));
        this.exitButton.setRolloverIcon(new ImageIcon("ingameimages\\exithover.png"));
        this.add(exitButton);
    }

    //------------------ GETTERS AND SETTERS ------------------\\
    public JButton getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }

    public JButton getNewGameButton() {
        return newGameButton;
    }

    public void setNewGameButton(JButton newGameButton) {
        this.newGameButton = newGameButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public void setExitButton(JButton exitButton) {
        this.exitButton = exitButton;
    }

    public JLabel getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(JLabel playerTurn) {
        this.playerTurn = playerTurn;
    }

}
