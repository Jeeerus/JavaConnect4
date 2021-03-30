/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StartGame;

import InGame.BottomMenu;
import InGame.DropPanel;
import InGame.GameWinnerPanel;
import InGame.GridPanel;
import MainMenu.Instructions;
import MainMenu.MainMenuPanel;
import MainMenu.OptionsPanel;
import Model.Chip;
import Model.Player;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jairus
 */
public class ConnectFourView extends JFrame{
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
    
    public ConnectFourView(){
        super("Connect Four");
        setPreferredSize(new Dimension(600,670));
        //setLayout(null);
        gridPanel = new GridPanel();
        dropPanel = new DropPanel();
        bottomMenu = new BottomMenu();
        gameWinner = new GameWinnerPanel(); 
        mainMenu = new MainMenuPanel();
        instructions = new Instructions();
        options = new OptionsPanel();
        
        //player1 = new Player(new Chip(Color.BLUE), true);
        //player2 = new Player(new Chip(Color.GREEN), false);
        isGameOver = false;
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setLayout(new BorderLayout());
        setVisible(true);
        setResizable(false);
        setLocation(600,200);
        
        // GAME GUI
        /*
        this.add(this.dropPanel, BorderLayout.NORTH);
        this.dropPanel.setVisible(false);
        this.add(this.gridPanel, BorderLayout.CENTER);
        this.gridPanel.setVisible(false);
        this.add(this.bottomMenu, BorderLayout.SOUTH);
        this.bottomMenu.setVisible(false);
        */
        
        
        // MAIN MENU
        //this.add(this.instructions);
        
        this.add(this.mainMenu);
        
        this.pack();
    }

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
