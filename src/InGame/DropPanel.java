package InGame;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * DropPanel contains a button array that allow the users to drop a chip into
 * the grid (Both Model and View Grid), depending on which button is pressed.
 * Each button corresponds to a column in the grid and is placed on top of its
 * corresponding row.
 *
 * @author Jairus M. & Andrew B.
 */
public class DropPanel extends JPanel {

    private JButton[] dropButton = new JButton[7];

    public DropPanel() {
        this.setPreferredSize(new Dimension(600, 90));
        this.setBackground(Color.DARK_GRAY);

        this.dropButton = new JButton[7];

        for (int i = 0; i < 7; i++) {
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

    //------------------ GETTERS AND SETTERS ------------------\\
    public JButton[] getDropButton() {
        return dropButton;
    }

    public void setDropButton(JButton[] dropButton) {
        this.dropButton = dropButton;
    }
}
