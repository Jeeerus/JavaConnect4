package Model;

import java.awt.Color;

/**
 * Chip class creates a chip to be used by the Player class. It holds the colour
 * of the chip.
 *
 * @author Jairus M. & Andrew B.
 */
public class Chip implements java.io.Serializable {

    private Color chipColor;

    public Chip(Color chipColor) {
        this.chipColor = chipColor;
    }

    //------------------ GETTERS AND SETTERS ------------------\\
    public Color getChipColor() {
        return chipColor;
    }

    public void setChipColor(Color chipColor) {
        this.chipColor = chipColor;
    }
}
