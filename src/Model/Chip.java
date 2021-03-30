package Model;

import java.awt.Color;

/**
 *
 * @author andyb
 */
public class Chip implements java.io.Serializable{
    
    private Color chipColor;
    
    public Chip(Color chipColor){
        this.chipColor = chipColor;
    }

    public Color getChipColor() {
        return chipColor;
    }

    public void setChipColor(Color chipColor) {
        this.chipColor = chipColor;
    }
    
}
