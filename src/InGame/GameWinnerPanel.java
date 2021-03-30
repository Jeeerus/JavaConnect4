package InGame;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * GameWinner contains the Winner or Draw image on a draw or win.
 *
 * @author Jairus M. & Andrew B.
 */
public class GameWinnerPanel extends JPanel {

    private JLabel winner;

    public GameWinnerPanel() {
        this.setPreferredSize(new Dimension(600, 90));
        this.setBackground(Color.DARK_GRAY);
        this.winner = new JLabel();
        this.winner.setPreferredSize(new Dimension(600, 90));
        this.add(winner);
    }

    //------------------ GETTERS AND SETTERS ------------------\\
    public JLabel getWinner() {
        return winner;
    }

    public void setWinner(JLabel winner) {
        this.winner = winner;
    }
}
