package StartGame;

import InGame.BottomMenu;
import InGame.DropPanel;
import InGame.GameWinnerPanel;
import InGame.GridPanel;
import MainMenu.Instructions;
import MainMenu.MainMenuPanel;
import MainMenu.OptionsPanel;
import Model.Player;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * Contains all the components that need to be displayed during the game based
 * on which buttons are pressed.
 *
 * @author Jairus M. & Andrew B.
 */
public class ConnectFourView extends JFrame {

    private DropPanel dropPanel;
    private GridPanel gridPanel;
    private BottomMenu bottomMenu;
    private GameWinnerPanel gameWinner;
    private MainMenuPanel mainMenu;
    private Instructions instructions;
    private OptionsPanel options;

    private Player player1;
    private Player player2;
    private boolean isGameOver;

    public ConnectFourView() {
        super("Connect Four");
        this.setPreferredSize(new Dimension(600, 670));
        this.gridPanel = new GridPanel();
        this.dropPanel = new DropPanel();
        this.bottomMenu = new BottomMenu();
        this.gameWinner = new GameWinnerPanel();
        this.mainMenu = new MainMenuPanel();
        this.instructions = new Instructions();
        this.options = new OptionsPanel();
        this.isGameOver = false;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocation(600, 200);
        this.add(this.mainMenu);

        this.pack();
    }

    //------------------ GETTERS AND SETTERS ------------------\\
    public DropPanel getDropPanel() {
        return dropPanel;
    }

    public void setDropPanel(DropPanel dropPanel) {
        this.dropPanel = dropPanel;
    }

    public GridPanel getGridPanel() {
        return gridPanel;
    }

    public void setGridPanel(GridPanel gridPanel) {
        this.gridPanel = gridPanel;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public boolean isIsGameOver() {
        return isGameOver;
    }

    public void setIsGameOver(boolean isGameOver) {
        this.isGameOver = isGameOver;
    }

    public BottomMenu getBottomMenu() {
        return bottomMenu;
    }

    public void setBottomMenu(BottomMenu bottomMenu) {
        this.bottomMenu = bottomMenu;
    }

    public GameWinnerPanel getGameWinner() {
        return gameWinner;
    }

    public void setGameWinner(GameWinnerPanel gameWinner) {
        this.gameWinner = gameWinner;
    }

    public MainMenuPanel getMainMenu() {
        return mainMenu;
    }

    public void setMainMenu(MainMenuPanel mainMenu) {
        this.mainMenu = mainMenu;
    }

    public Instructions getInstructions() {
        return instructions;
    }

    public void setInstructions(Instructions instructions) {
        this.instructions = instructions;
    }

    public OptionsPanel getOptionsPanel() {
        return options;
    }

    public void setOptionsPanel(OptionsPanel options) {
        this.options = options;
    }
}
