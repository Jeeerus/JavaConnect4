package MainMenu;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jairus
 */
public class Instructions extends JPanel{
    private JLabel instructionsbg;
    private JButton backButton;
    
    public Instructions(){
        this.setPreferredSize(new Dimension(600, 660));
        this.setLayout(null);
        this.setBackground(Color.yellow);
        
        this.backButton = new JButton();
        this.backButton.setIcon(new ImageIcon("mainmenuimages\\backbutton.png"));
        this.backButton.setRolloverIcon(new ImageIcon("mainmenuimages\\backbuttonhover.png"));
        this.backButton.setSize(new Dimension(160,40));
        this.backButton.setBounds(400, 570, 160, 40);
        this.backButton.setContentAreaFilled(false);
        this.backButton.setBorderPainted(false);
        this.backButton.setOpaque(false);
        this.add(backButton);
        
        this.instructionsbg = new JLabel();
        this.instructionsbg.setPreferredSize(new Dimension(600,660));
        this.instructionsbg.setBounds(0, 0, 600, 660);
        this.instructionsbg.setIcon(new ImageIcon("mainmenuimages\\mainmenuinstructions.png"));
        this.add(instructionsbg);
    }

    public JLabel getInstructionsbg() {
        return instructionsbg;
    }

    public void setInstructionsbg(JLabel instructionsbg) {
        this.instructionsbg = instructionsbg;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }
    
    
}
