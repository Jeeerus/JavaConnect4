package StartGame;

import MainMenu.OptionsPanel;
import Model.Chip;
import Model.Grid;
import Model.Player;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author Jairus
 */
public class ConnectFourController implements ActionListener {

    private ConnectFourModel model;
    private ConnectFourView view;
    private ConnectFourDatabase db;
    private Color tempColour[];
    private Color chipColourP1;
    private Color chipColourP2;

    public ConnectFourController() {

        db = new ConnectFourDatabase();
        db.createColourTable();
        view = new ConnectFourView();

        tempColour = new Color[2];
        chipColourP1 = db.loadSavedColour(1);
        chipColourP2 = db.loadSavedColour(2);
        model = new ConnectFourModel(new Chip(chipColourP1), new Chip(chipColourP2));

        // DROP BUTTONS ACTION LISTENER
        System.out.println("Controller Created");
        for (int i = 0; i < 7; i++) {
            view.getDropPanel().getDropButton()[i].addActionListener(this);
        }

        // BUTTON MENU ACTION LISTENER
        view.getBottomMenu().getNewGameButton().addActionListener(this);
        view.getBottomMenu().getExitButton().addActionListener(this);
        view.getBottomMenu().getSaveButton().addActionListener(this);

        // MAIN MENU ACTION LISTENER
        view.getMainMenu().getNewGame().addActionListener(this);
        view.getMainMenu().getContinueGame().addActionListener(this);
        view.getMainMenu().getExitGame().addActionListener(this);

        //INSTRUCTIONS MENU
        view.getMainMenu().getInstructions().addActionListener(this);
        view.getInstructions().getBackButton().addActionListener(this);

        //OPTIONS MENU
        view.getMainMenu().getOptions().addActionListener(this);
        view.getOptionsPanel().getBackButton().addActionListener(this);
        view.getOptionsPanel().getSaveColoursButton().addActionListener(this);
        view.getOptionsPanel().getBackButton().addActionListener(this);
        for (int i = 0; i < 6; i++) {
            view.getOptionsPanel().getP1ColourButtons()[i].addActionListener(this);
            view.getOptionsPanel().getP2ColourButtons()[i].addActionListener(this);
        }

    }

    /**
     * Event Handling
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Drop Buttons
        for (int i = 0; i < 7; i++) {
            if (e.getSource() == view.getDropPanel().getDropButton()[i]) {
                dropChiptoGrid(e, i);
            }
        }

        // BOTTOM MENU BUTTONS 
        // New Game Button
        if (e.getSource() == view.getBottomMenu().getNewGameButton()) {
            System.out.println("New Game Started");
            resetGame();
        }
        if (e.getSource() == view.getBottomMenu().getExitButton()) {
            exitToMenu();
        }

        if (e.getSource() == view.getBottomMenu().getSaveButton()) {
            System.out.println("Saving current game");
            saveGame();
        }

        // MAIN MENU BUTTONS
        if (e.getSource() == view.getMainMenu().getNewGame()) {
            System.out.println("New Game Started");
            startNewGame();
        }
        if (e.getSource() == view.getMainMenu().getContinueGame()) {
            System.out.println("Continuing game...");
            loadGameData();
        }
        if (e.getSource() == view.getMainMenu().getInstructions()) {
            displayInstructions();
        }
        if (e.getSource() == view.getMainMenu().getExitGame()) {
            System.out.println("Exiting Game...");
            exitGame();
        }
        if (e.getSource() == view.getMainMenu().getOptions()) {
            displayOptions();
            borderSelectedChipColour();

        }

        //INSTRUCTION MENU BUTTONS
        if (e.getSource() == view.getInstructions().getBackButton()) {
            System.out.println("Returning to Main Menu...");
            returnToMainMenu();
        }

        //OPTION MENU BUTTONS
        if (e.getSource() == view.getOptionsPanel().getBackButton()) {
            System.out.println("Returning to Main Menu...");
            returnToMainMenu();
        }

        for (int i = 0; i < 6; i++) {
            if (e.getSource() == view.getOptionsPanel().getP1ColourButtons()[i]) {
                tempColour[0] = selectChipColorP1(e, i, model.getPlayer1());
            }
            if (e.getSource() == view.getOptionsPanel().getP2ColourButtons()[i]) {
                tempColour[1] = selectChipColorP2(e, i, model.getPlayer2());
            }

        }

        if (e.getSource() == view.getOptionsPanel().getSaveColoursButton()) {
            saveColor(tempColour, model.getPlayer1(), model.getPlayer2());
            if (tempColour[0] != tempColour[1]) {
                returnToMainMenu();
            }
        }

    }

    /**
     * Drops chip to View Grid; Changes the color of the background depending on
     * whose turn it is. Index of Button is chosen Column by user.
     */
    private void dropChiptoGrid(ActionEvent e, int i) {
        if (e.getSource() == view.getDropPanel().getDropButton()[i]) {
            if (model.getPlayer1().isPlayerTurn()) {
                view.getBottomMenu().getPlayerTurn().setIcon(new ImageIcon("ingameimages\\player2turn.png"));
                model.getGrid().addToGrid(i, 'x');
                view.getGridPanel().updateGrid(model.getGrid(), model.getPlayer1().getPlayerChip().getChipColor(), 'x');

                if (model.getGrid().checkConnectFour(i, 'x')) {
                    displayWinnerScreen("p1");
                }

                //SwitchPlayerTurn();
            } else if (model.getPlayer2().isPlayerTurn()) {
                view.getBottomMenu().getPlayerTurn().setIcon(new ImageIcon("ingameimages\\player1turn.png"));
                model.getGrid().addToGrid(i, 'o');
                view.getGridPanel().updateGrid(model.getGrid(), model.getPlayer2().getPlayerChip().getChipColor(), 'o');

                if (model.getGrid().checkConnectFour(i, 'o')) {
                    displayWinnerScreen("p2");
                }

                //SwitchPlayerTurn();
            }
            switchPlayerTurn();
            if (model.getGrid().gridFull()) {
                displayDrawScreen();
            }

        }
    }

    public Color selectChipColorP1(ActionEvent e, int i, Player p) {
        OptionsPanel op = view.getOptionsPanel();

        if (e.getSource() == view.getOptionsPanel().getP1ColourButtons()[i]) {
            for (int j = 0; j < 6; j++) {
                op.getP1ColourButtons()[j].setBorder(new LineBorder(Color.GRAY, 1));
            }
            op.getP1ColourButtons()[i].setBorder(new LineBorder(Color.BLACK, 3));
        }
        return op.getP1ColourButtons()[i].getBackground();
    }

    public Color selectChipColorP2(ActionEvent e, int i, Player p) {
        OptionsPanel op = view.getOptionsPanel();
        for (int j = 0; j < 6; j++) {
            op.getP2ColourButtons()[j].setBorder(new LineBorder(Color.GRAY, 1));
        }
        if (e.getSource() == view.getOptionsPanel().getP2ColourButtons()[i]) {
            op.getP2ColourButtons()[i].setBorder(new LineBorder(Color.BLACK, 3));
        }
        return op.getP2ColourButtons()[i].getBackground();
    }

    public void saveColor(Color[] c, Player p1, Player p2) {
        if (c[0] == c[1]) {
            JOptionPane.showMessageDialog(null,
                    "Chips can't be the same colour",
                    "Chips same colour",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            chipColourP1 = c[0];
            chipColourP2 = c[1];
            p1.getPlayerChip().setChipColor(chipColourP1);
            p2.getPlayerChip().setChipColor(chipColourP2);

            db.insertSavedColours(p1.getPlayerChip().getChipColor().hashCode(), p2.getPlayerChip().getChipColor().hashCode());

//            int test = p1.getPlayerChip().getChipColor().hashCode();
//            int test2 = p2.getPlayerChip().getChipColor().getRGB();
//            System.out.println(test);
//            System.out.println(test2);
//            p1.getPlayerChip().setChipColor(new Color(test));
        }
    }

    public void borderSelectedChipColour() {

        Color currentChipColor1 = chipColourP1;
        Color currentChipColor2 = chipColourP2;

        for (int i = 0; i < 6; i++) {

            view.getOptionsPanel().getP1ColourButtons()[i].setBorder(new LineBorder(Color.GRAY, 1));
            view.getOptionsPanel().getP2ColourButtons()[i].setBorder(new LineBorder(Color.GRAY, 1));

            if (currentChipColor1.equals(view.getOptionsPanel().getP1ColourButtons()[i].getBackground())) {
                view.getOptionsPanel().getP1ColourButtons()[i].setBorder(new LineBorder(Color.BLACK, 3));
            }
            if (currentChipColor2.equals(view.getOptionsPanel().getP2ColourButtons()[i].getBackground())) {
                view.getOptionsPanel().getP2ColourButtons()[i].setBorder(new LineBorder(Color.BLACK, 3));
            }
        }
    }

    //TODO: LOAD FROM DB 
    public Color[] loadColours() {
        Color[] c = {Color.RED, Color.YELLOW};
        return c;
    }

    /**
     * Clears the Grid and Resets the Game.
     */
    public void resetGame() {
        model.getGrid().fillGrid();
        view.getGridPanel().resetGrid();
        view.add(view.getGridPanel());
        view.remove(view.getGameWinner());
        view.getDropPanel().setVisible(true);
        view.getBottomMenu().getSaveButton().setVisible(true);
        view.getBottomMenu().getPlayerTurn().setVisible(true);
        model.getPlayer1().setIsPlayerTurn(true);
        model.getPlayer2().setIsPlayerTurn(false);
        view.getBottomMenu().getPlayerTurn().setIcon(new ImageIcon("ingameimages\\player1turn.png"));
        model.getPlayer1().getPlayerChip().setChipColor(chipColourP1);
        model.getPlayer2().getPlayerChip().setChipColor(chipColourP2);

    }

    /**
     * Starts Game from Main Menu
     */
    private void startNewGame() {
        resetGame();
        view.getMainMenu().setVisible(false);
        view.add(view.getDropPanel(), BorderLayout.NORTH);
        view.add(view.getGridPanel(), BorderLayout.CENTER);
        view.add(view.getBottomMenu(), BorderLayout.SOUTH);
        view.remove(view.getGameWinner());
    }

    public void saveGame() {

        String[] txtFiles = {"player1Object.txt", "player2Object.txt", "gridObject.txt"};
        Object[] obj = {model.getPlayer1(), model.getPlayer2(), model.getGrid()};
        try {
            for (int i = 0; i < txtFiles.length; i++) {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(txtFiles[i]));
                oos.writeObject(obj[i]);
                oos.flush();
                oos.close();
            }
            System.out.println("Saved successfully...");
        } catch (IOException e) {
            System.out.println("Save failed...");
            e.printStackTrace();
            exitToMenu();
        }
        exitToMenu();
    }

    public void loadGameData() {
        String[] txtFiles = {"player1Object.txt", "player2Object.txt", "gridObject.txt"};
        ArrayList<Object> objArray = new ArrayList<>();
        try {
            for (String txtFile : txtFiles) {
                FileInputStream fis = new FileInputStream(txtFile);
                ObjectInputStream ois = new ObjectInputStream(fis);

                System.out.println("Loading " + txtFile);

                objArray.add(ois.readObject());

                System.out.println("Load successful...\n");
                ois.close();
                fis.close();
            }
            continueGame(objArray);

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found\n");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Loading txtFiles failed...");
            e.printStackTrace();
            exitToMenu();
        }
    }

    /**
     * Starts Game from Main Menu
     *
     * @param obj
     */
    private void continueGame(ArrayList obj) {
        startNewGame();

        model.setPlayer1((Player) obj.get(0));
        model.setPlayer2((Player) obj.get(1));
        model.setGrid((Grid) obj.get(2));

        if (model.getPlayer2().isPlayerTurn()) {
            view.getBottomMenu().getPlayerTurn().setIcon(new ImageIcon("ingameimages\\player2turn.png"));
        }

        view.getGridPanel().updateGrid(model.getGrid(), model.getPlayer1().getPlayerChip().getChipColor(), 'x');
        view.getGridPanel().updateGrid(model.getGrid(), model.getPlayer2().getPlayerChip().getChipColor(), 'o');
    }

    /**
     * Displays the Instructions Panel
     */
    public void displayInstructions() {
        System.out.println("Displaying Instructions");
        view.getMainMenu().setVisible(false);
        view.add(view.getInstructions());
    }

    /**
     * Displays the Options Panel
     */
    public void displayOptions() {
        System.out.println("Displaying Options");
        view.getMainMenu().setVisible(false);
        view.add(view.getOptionsPanel());
    }

    /**
     * Exit Game to Main Menu
     */
    private void exitToMenu() {
        view.getMainMenu().setVisible(true);
        view.remove(view.getDropPanel());
        view.remove(view.getGridPanel());
        view.remove(view.getBottomMenu());
        view.remove(view.getGameWinner());
    }

    private void returnToMainMenu() {
        view.remove(view.getInstructions());
        view.remove(view.getOptionsPanel());
        view.getMainMenu().setVisible(true);
    }

    /**
     * Replaces Drop buttons with "Player x Has Won"
     */
    public void displayWinnerScreen(String player) {
        System.out.println("Game Over");
        view.getDropPanel().setVisible(false);
        view.getBottomMenu().getSaveButton().setVisible(false);
        view.getBottomMenu().getPlayerTurn().setVisible(false);
        view.add(view.getGameWinner());
        if (player.equals("p1")) {
            view.getGameWinner().getWinner().setIcon(new ImageIcon("ingameimages\\player1winner.png"));
        } else if (player.equals("p2")) {
            view.getGameWinner().getWinner().setIcon(new ImageIcon("ingameimages\\player2winner.png"));
        }
    }

    public void displayDrawScreen() {
        System.out.println("Game Over");
        view.getDropPanel().setVisible(false);
        view.getBottomMenu().getSaveButton().setVisible(false);
        view.getBottomMenu().getPlayerTurn().setVisible(false);
        view.add(view.getGameWinner());
        view.getGameWinner().getWinner().setIcon(new ImageIcon("ingameimages\\player1winner.png"));

    }

    /**
     * Changes the color turn state for each player.
     */
    public void switchPlayerTurn() {
        model.getPlayer1().setIsPlayerTurn(!model.getPlayer1().isPlayerTurn());
        model.getPlayer2().setIsPlayerTurn(!model.getPlayer2().isPlayerTurn());
    }

    /**
     * *
     * Exits the Game
     */
    public void exitGame() {
        System.exit(0);
    }

    public ConnectFourModel getModel() {
        return model;
    }

    public void setModel(ConnectFourModel model) {
        this.model = model;
    }

    public ConnectFourView getView() {
        return view;
    }

    public void setView(ConnectFourView view) {
        this.view = view;
    }

    public ConnectFourDatabase getDb() {
        return db;
    }

    public void setDb(ConnectFourDatabase db) {
        this.db = db;
    }

    public Color getChipColourP1() {
        return chipColourP1;
    }

    public void setChipColourP1(Color chipColourP1) {
        this.chipColourP1 = chipColourP1;
    }

    public Color getChipColourP2() {
        return chipColourP2;
    }

    public void setChipColourP2(Color chipColourP2) {
        this.chipColourP2 = chipColourP2;
    }
}
