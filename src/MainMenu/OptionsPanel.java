package MainMenu;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Contains components for the Options panel that allow the users to choose
 * their own colours for their chip.
 *
 * @author Jairus M. & Andrew B.
 */
public final class OptionsPanel extends JPanel {

    private JButton[] p1ColourButtons = new JButton[6];
    private JButton[] p2ColourButtons = new JButton[6];
    private JButton saveColoursButton;
    private JButton backButton;
    private JLabel optionsBackGround;

    public OptionsPanel() {
        this.setPreferredSize(new Dimension(600, 600));
        this.setLayout(null);

        this.saveColoursButton = new JButton("Save and Exit");
        this.saveColoursButton.setBounds(150, 500, 130, 40);
        this.saveColoursButton.setIcon(new ImageIcon("mainmenuimages\\optionssavebutton.png"));
        this.saveColoursButton.setRolloverIcon(new ImageIcon("mainmenuimages\\optionssavebuttonhover.png"));
        this.saveColoursButton.setContentAreaFilled(false);
        this.saveColoursButton.setBorderPainted(false);
        this.saveColoursButton.setOpaque(false);
        this.add(saveColoursButton);

        this.backButton = new JButton("Exit without saving");
        this.backButton.setIcon(new ImageIcon("mainmenuimages\\optionsback.png"));
        this.backButton.setRolloverIcon(new ImageIcon("mainmenuimages\\optionsbackhover.png"));
        this.backButton.setSize(new Dimension(130, 40));
        this.backButton.setBounds(345, 500, 130, 40);
        this.backButton.setContentAreaFilled(false);
        this.backButton.setBorderPainted(false);
        this.backButton.setOpaque(false);
        this.add(backButton);

        for (int i = 0; i < 6; i++) {
            this.p1ColourButtons[i] = new JButton();
            this.p2ColourButtons[i] = new JButton();
        }

        setButtonBounds();
        setColoursP2();
        setColoursP1();

        this.optionsBackGround = new JLabel();
        this.optionsBackGround.setIcon(new ImageIcon("mainmenuimages\\optionsPanel.png"));
        this.optionsBackGround.setBounds(0, 0, 600, 660);
        this.add(optionsBackGround);
    }

    // Sets Location and Size of the Buttons
    public void setButtonBounds() {
        int y = 210;
        for (int i = 0; i < 6; i++) {
            this.p1ColourButtons[i].setBounds(y, 315, 30, 30);
            this.p2ColourButtons[i].setBounds(y, 420, 30, 30);
            this.add(p1ColourButtons[i]);
            this.add(p2ColourButtons[i]);
            y += 50;
        }
    }

    // Sets Colours for Player 2 Buttons
    public void setColoursP2() {
        this.p1ColourButtons[0].setBackground(Color.red);
        this.p1ColourButtons[1].setBackground(Color.yellow);
        this.p1ColourButtons[2].setBackground(Color.blue);
        this.p1ColourButtons[3].setBackground(Color.green);
        this.p1ColourButtons[4].setBackground(Color.magenta);
        this.p1ColourButtons[5].setBackground(Color.cyan);
    }

    // Sets Colours for Player 1 Buttons
    public void setColoursP1() {
        this.p2ColourButtons[0].setBackground(Color.red);
        this.p2ColourButtons[1].setBackground(Color.yellow);
        this.p2ColourButtons[2].setBackground(Color.blue);
        this.p2ColourButtons[3].setBackground(Color.green);
        this.p2ColourButtons[4].setBackground(Color.magenta);
        this.p2ColourButtons[5].setBackground(Color.cyan);
    }

    //------------------ GETTERS AND SETTERS ------------------\\
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
