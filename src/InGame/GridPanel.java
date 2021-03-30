package InGame;

import Model.Grid;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class holds information on the View Grid. Containing labels laid out as
 * a grid where each one's color is based on the actions caused by players
 * (Dropping Chips). Drop Buttons(DropPanel Class) cause these labels to change
 * colours based on which button is pressed (Column).
 *
 * @author Jairus M. & Andrew B.
 */
public class GridPanel extends JPanel {

    JLabel gridBox[][] = new JLabel[6][7];

    public GridPanel() {
        this.setPreferredSize(new Dimension(600, 500));
        this.setLayout(new FlowLayout());
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createMatteBorder(
                0, 5, 5, 5, Color.DARK_GRAY));

        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 7; c++) {
                this.gridBox[r][c] = new JLabel();
                this.gridBox[r][c].setPreferredSize(new Dimension(75, 75));
                this.gridBox[r][c].setBackground(Color.white);
                this.gridBox[r][c].setOpaque(true);
                this.gridBox[r][c].setIcon(new ImageIcon("ingameimages\\openbox.png"));
                this.add(this.gridBox[r][c]);
            }
        }
    }

    /**
     * Drops a chip into the grid. This method takes in the colour and column
     * number. The colour of a chosen column + open grid box will have its
     * colour changed, depending on whose turn it is.
     *
     * @param column - Column to drop to
     * @param playerColour - The player's colour.
     * @return
     */
    public boolean dropChip(int column, Color playerColour) {
        for (int i = 6 - 1; i >= 0; i--) {
            if (this.gridBox[i][column].getBackground() == Color.white) {
                this.gridBox[i][column].setBackground(playerColour);
                return false;
            }
        }
        return true;
    }

    /**
     * Updates the View Grid based on the Model Grid. Compares the char with the
     * corresponding player colour.
     *
     * @param modelGrid - The Model Grid
     * @param playerColour - The Player's colour
     * @param playerChar - The Player's char
     */
    public void updateGrid(Grid modelGrid, Color playerColour, char playerChar) {
        for (int r = 0; r < modelGrid.getGridRows(); r++) {
            for (int c = 0; c < modelGrid.getGridColumns(); c++) {
                if (modelGrid.getGrid()[r][c] == playerChar) {
                    this.gridBox[r][c].setBackground(playerColour);
                }
            }
        }
    }

    /**
     * Resets the View Grid by turning the label backgrounds to white.
     */
    public void resetGrid() {
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 7; c++) {
                this.gridBox[r][c].setBackground(Color.white);
            }
        }
    }

    //------------------ GETTERS AND SETTERS ------------------\\
    public JLabel[][] getGridBox() {
        return gridBox;
    }

    public void setGridBox(JLabel[][] gridBox) {
        this.gridBox = gridBox;
    }
}
