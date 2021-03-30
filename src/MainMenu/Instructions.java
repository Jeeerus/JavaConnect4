package MainMenu;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Contains components for the instructions panel that allow the users to view
 * the game instructions.
 *
 * @author Jairus M. & Andrew B.
 */
public class Instructions extends JPanel {

    private JLabel instructionsbg;
    private JButton backButton;
    private JButton leftPageButton;
    private JButton rightPageButton;
    private int page;

    public Instructions() {
        this.setPreferredSize(new Dimension(600, 660));
        this.setLayout(null);
        this.setBackground(Color.yellow);
        this.page = 1;

        this.backButton = new JButton();
        this.backButton.setIcon(new ImageIcon("mainmenuimages\\backbutton.png"));
        this.backButton.setRolloverIcon(new ImageIcon("mainmenuimages\\backbuttonhover.png"));
        this.backButton.setSize(new Dimension(160, 40));
        this.backButton.setBounds(400, 510, 130, 40);
        this.backButton.setContentAreaFilled(false);
        this.backButton.setBorderPainted(false);
        this.backButton.setOpaque(false);
        this.add(backButton);

        this.leftPageButton = new JButton();
        this.leftPageButton.setIcon(new ImageIcon("mainmenuimages\\leftarrow.png"));
        this.leftPageButton.setRolloverIcon(new ImageIcon("mainmenuimages\\leftarrowhover.png"));
        this.leftPageButton.setBounds(100, 510, 35, 35);
        this.leftPageButton.setContentAreaFilled(false);
        this.leftPageButton.setBorderPainted(false);
        this.leftPageButton.setOpaque(false);
        this.add(leftPageButton);

        this.rightPageButton = new JButton();
        this.rightPageButton.setIcon(new ImageIcon("mainmenuimages\\rightarrow.png"));
        this.rightPageButton.setRolloverIcon(new ImageIcon("mainmenuimages\\rightarrowhover.png"));
        this.rightPageButton.setBounds(150, 510, 35, 35);
        this.rightPageButton.setContentAreaFilled(false);
        this.rightPageButton.setBorderPainted(false);
        this.rightPageButton.setOpaque(false);
        this.add(rightPageButton);

        this.instructionsbg = new JLabel();
        this.instructionsbg.setPreferredSize(new Dimension(600, 660));
        this.instructionsbg.setBounds(0, 0, 600, 660);
        this.instructionsbg.setIcon(new ImageIcon("mainmenuimages\\instructionspage1.png"));
        this.add(instructionsbg);
    }

    //------------------ GETTERS AND SETTERS ------------------\\
    public void addPage() {
        this.page++;
        System.out.println(this.page);
    }

    public void deductPage() {
        this.page--;
        System.out.println(this.page);
    }

    // GETTERS AND SETTERS
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

    public JButton getLeftPageButton() {
        return leftPageButton;
    }

    public void setLeftPageButton(JButton leftPageButton) {
        this.leftPageButton = leftPageButton;
    }

    public JButton getRightPageButton() {
        return rightPageButton;
    }

    public void setRightPageButton(JButton rightPageButton) {
        this.rightPageButton = rightPageButton;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
