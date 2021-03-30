package StartGame;

import Model.Chip;
import Model.Grid;
import Model.Player;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

/**
 * Controller Class for the Game. Contains all the event handling that changes
 * and displays specific panels depending on the situation.
 *
 * @author Jairus M. & Andrew B.
 */
public class ConnectFourController {

    private ConnectFourModel model;
    private ConnectFourView view;
    private ConnectFourDatabase db;
    private Color tempColour[];
    private Color chipColourP1;
    private Color chipColourP2;

    public ConnectFourController() {

        db = new ConnectFourDatabase();
        db.createColourTable();
        db.createGameTable();

        chipColourP1 = db.loadSavedColour(1);
        chipColourP2 = db.loadSavedColour(2);
        tempColour = new Color[]{chipColourP1, chipColourP2};

        view = new ConnectFourView();
        model = new ConnectFourModel(new Chip(chipColourP1), new Chip(chipColourP2));

        // -------------------- DROP BUTTONS ACTION LISTENER -------------------- \\
        System.out.println("Controller Created");
        for (int i = 0; i < 7; i++) {
            view.getDropPanel().getDropButton()[i].addActionListener((ActionEvent e) -> {
                for (int i1 = 0; i1 < 7; i1++) {
                    if (e.getSource() == view.getDropPanel().getDropButton()[i1]) {
                        dropChiptoGrid(e, i1);
                    }
                }
            });
        }

        // -------------------- Buttom MENU ACTION LISTENER -------------------- \\
        // New Game Button
        view.getBottomMenu().getNewGameButton().addActionListener((ActionEvent e) -> {
            System.out.println("New Game Started");
            resetGame();
        });

        // Exit Button
        view.getBottomMenu().getExitButton().addActionListener((ActionEvent e) -> {
            System.out.println("Exiting to Main Menu...");
            exitToMenu();
        });

        // Save Button
        view.getBottomMenu().getSaveButton().addActionListener((ActionEvent e) -> {
            System.out.println("Saving game...");
            saveGame();
        });

        // -------------------- MAIN MENU ACTION LISTENER -------------------- \\
        // New Game Button
        view.getMainMenu().getNewGame().addActionListener((ActionEvent e) -> {
            System.out.println("New Game Started");
            startNewGame();
        });

        // Continue Game Button
        view.getMainMenu().getContinueGame().addActionListener((ActionEvent e) -> {
            System.out.println("Continuing Game...");
            continueGame();
        });

        // Exit Game Button
        view.getMainMenu().getExitGame().addActionListener((ActionEvent e) -> {
            System.out.println("Exiting Game...");
            exitGame();
        });

        // ------------------ INSTRUCTIONS MENU ACTION LISTENER ------------------ \\
        // Instructions Button
        view.getMainMenu().getInstructions().addActionListener((ActionEvent e) -> {
            displayInstructions();
        });

        // Back to Menu Button
        view.getInstructions().getBackButton().addActionListener((ActionEvent e) -> {
            System.out.println("Returning to Main Menu...");
            returnToMainMenu();
        });

        // Left Button
        view.getInstructions().getRightPageButton().addActionListener((ActionEvent e) -> {
            for (int i = 1; i <= 3; i++) {
                if (view.getInstructions().getPage() == 1) {
                    view.getInstructions().getInstructionsbg().setIcon(new ImageIcon("mainmenuimages\\instructionspage2.png"));
                    view.getInstructions().addPage();
                    break;
                }
                if (view.getInstructions().getPage() == 2) {
                    view.getInstructions().getInstructionsbg().setIcon(new ImageIcon("mainmenuimages\\instructionspage3.png"));
                    view.getInstructions().addPage();
                    break;
                }
            }
        });

        // Right Button
        view.getInstructions().getLeftPageButton().addActionListener((ActionEvent e) -> {
            for (int i = 0; i <= 3; i++) {
                if (view.getInstructions().getPage() == 3) {
                    view.getInstructions().getInstructionsbg().setIcon(new ImageIcon("mainmenuimages\\instructionspage2.png"));
                    view.getInstructions().deductPage();
                    break;
                }
                if (view.getInstructions().getPage() == 2) {
                    view.getInstructions().getInstructionsbg().setIcon(new ImageIcon("mainmenuimages\\instructionspage1.png"));
                    view.getInstructions().deductPage();
                    break;
                }
            }
        });

        // -------------------- OPTIONS MENU ACTION LISTENER -------------------- \\
        // Display Options Button
        view.getMainMenu().getOptions().addActionListener((ActionEvent e) -> {
            System.out.println("Displaying Options...");
            displayOptions();
            borderSelectedChipColour();
        });

        // Options Back Button
        view.getOptionsPanel().getBackButton().addActionListener((ActionEvent e) -> {
            System.out.println("Returning to Main Menu...");
            tempColour[0] = chipColourP1;
            tempColour[1] = chipColourP2;
            returnToMainMenu();
        });

        // Options Save Colours Button
        view.getOptionsPanel().getSaveColoursButton().addActionListener((ActionEvent e) -> {
            saveColor(tempColour, model.getPlayer1(), model.getPlayer2());
            if (!tempColour[0].equals(tempColour[1])) {
                returnToMainMenu();
            }
        });

        // Player 1 Colour Buttons
        for (int i = 0; i < 6; i++) {
            view.getOptionsPanel().getP1ColourButtons()[i].addActionListener((ActionEvent e) -> {
                for (int i1 = 0; i1 < 6; i1++) {
                    if (e.getSource() == view.getOptionsPanel().getP1ColourButtons()[i1]) {
                        tempColour[0] = selectChipColor(e, i1, view.getOptionsPanel().getP1ColourButtons());
                    }
                }
            });

            // Player 2 Colour Buttons
            view.getOptionsPanel().getP2ColourButtons()[i].addActionListener((ActionEvent e) -> {
                for (int i1 = 0; i1 < 6; i1++) {
                    if (e.getSource() == view.getOptionsPanel().getP2ColourButtons()[i1]) {
                        tempColour[1] = selectChipColor(e, i1, view.getOptionsPanel().getP2ColourButtons());
                    }
                }
            });
        }
    }

    /**
     * Drops chip to View Grid; Changes the color of the background depending on
     * whose turn it is. Index of Button is chosen Column by user.
     *
     * @param e ActionEvent
     * @param i index of JButton array
     */
    private void dropChiptoGrid(ActionEvent e, int i) {
        if (e.getSource() == view.getDropPanel().getDropButton()[i]) {
            if (model.getPlayer1().isPlayerTurn()) {
                boolean columnFull = model.getGrid().addToGrid(i, 'x');
                view.getGridPanel().updateGrid(model.getGrid(), model.getPlayer1().getPlayerChip().getChipColor(), 'x');

                if (!columnFull) {
                    switchPlayerTurn();
                }
                if (model.getGrid().checkConnectFour(i, 'x')) {
                    displayWinnerScreen("p1");
                }
            } else if (model.getPlayer2().isPlayerTurn()) {
                boolean columnFull = model.getGrid().addToGrid(i, 'o');
                view.getGridPanel().updateGrid(model.getGrid(), model.getPlayer2().getPlayerChip().getChipColor(), 'o');

                if (!columnFull) {
                    switchPlayerTurn();
                }
                if (model.getGrid().checkConnectFour(i, 'o')) {
                    displayWinnerScreen("p2");
                }
            }
            if (model.getGrid().gridFull()) {
                displayDrawScreen();
            }
        }
    }

    /**
     * Changes the colour of the borders on the JButtons when first opening the
     * options menu. Sets the current chip colours to have a black border.
     */
    private void borderSelectedChipColour() {
        for (int i = 0; i < 6; i++) {
            view.getOptionsPanel().getP1ColourButtons()[i].setBorder(new LineBorder(Color.GRAY, 1));
            view.getOptionsPanel().getP2ColourButtons()[i].setBorder(new LineBorder(Color.GRAY, 1));

            if (chipColourP1.equals(view.getOptionsPanel().getP1ColourButtons()[i].getBackground())) {
                view.getOptionsPanel().getP1ColourButtons()[i].setBorder(new LineBorder(Color.BLACK, 3));
            }
            if (chipColourP2.equals(view.getOptionsPanel().getP2ColourButtons()[i].getBackground())) {
                view.getOptionsPanel().getP2ColourButtons()[i].setBorder(new LineBorder(Color.BLACK, 3));
            }
        }
    }

    /**
     * Changes the border colour of the currently selected colour option
     * (JButton) to be black. After setting the border to gray on all JButtons.
     * This makes it so as you click the different colour options, you can see
     * which colour is currently selected.
     *
     * @param e ActionEvent
     * @param i index of the JButton array
     * @param ba JButton array which changes are being made on.
     * @return
     */
    private Color selectChipColor(ActionEvent e, int i, JButton[] ba) {
        for (int j = 0; j < 6; j++) {
            ba[j].setBorder(new LineBorder(Color.GRAY, 1));
        }
        if (e.getSource() == ba[i]) {
            ba[i].setBorder(new LineBorder(Color.BLACK, 3));
        }
        return ba[i].getBackground();
    }

    /**
     * Saves the colour choice of the players from the options menu into the
     * database. Also sets the current player chips colours to be the selected
     * colour. If the 2 selected colours are the same, returns a popup with an
     * error.
     *
     * @param c the temporary colour array that stores the selected colour
     * @param p1 Player1 object
     * @param p2 Player2 object
     */
    private void saveColor(Color[] c, Player p1, Player p2) {
        if (c[0].equals(c[1])) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", new Color(40, 40, 40));
            UI.put("Panel.background", new Color(40, 40, 40));
            UI.put("OptionPane.messageForeground", Color.LIGHT_GRAY);
            JOptionPane.showMessageDialog(null,
                    "Chips can't be the same colour",
                    "Save Failed!",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            chipColourP1 = c[0];
            chipColourP2 = c[1];
            p1.getPlayerChip().setChipColor(chipColourP1);
            p2.getPlayerChip().setChipColor(chipColourP2);

            db.insertSavedColours(chipColourP1.hashCode(), chipColourP2.hashCode());
        }
    }

    /**
     * Clears the Grid and Resets the Game.
     */
    private void resetGame() {
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

    /**
     * Saves the current game to the database.
     */
    private void saveGame() {
        Object[] obj = {model.getPlayer1(), model.getPlayer2(), model.getGrid()};
        try {
            db.insertSavedGameData(obj);
        } catch (Exception e) {
            System.out.println("Save failed...");
            e.printStackTrace();
            exitToMenu();
        }
        exitToMenu();
    }

    /**
     * Loads the game from the database and sets the returned object array to
     * the player and grid objects. Starts a new game, and updates the grid with
     * the loaded changes. ArrayList<Object> gives unchecked error, and is
     * suppressed.
     */
    @SuppressWarnings("unchecked")
    private void continueGame() {
        try {
            startNewGame();
            ArrayList<Object> obj = db.loadSavedGameData();

            model.setPlayer1((Player) obj.get(0));
            model.setPlayer2((Player) obj.get(1));
            model.setGrid((Grid) obj.get(2));

            if (model.getPlayer2().isPlayerTurn()) {
                view.getBottomMenu().getPlayerTurn().setIcon(new ImageIcon("ingameimages\\player2turn.png"));
            }

            view.getGridPanel().updateGrid(model.getGrid(), model.getPlayer1().getPlayerChip().getChipColor(), 'x');
            view.getGridPanel().updateGrid(model.getGrid(), model.getPlayer2().getPlayerChip().getChipColor(), 'o');
        } catch (NullPointerException ex) {
            System.out.println("No game saved! ");
            exitToMenu();
        } catch (Exception ex) {
            System.out.println("Load Failed! ");
            ex.printStackTrace();
            exitToMenu();
        }
    }

    /**
     * Displays the Instructions Panel
     */
    private void displayInstructions() {
        System.out.println("Displaying Instructions");
        view.getMainMenu().setVisible(false);
        view.add(view.getInstructions());
    }

    /**
     * Displays the Options Panel
     */
    private void displayOptions() {
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

    /**
     * Exits from the options or instructions page back to the main menu"
     */
    private void returnToMainMenu() {
        view.remove(view.getInstructions());
        view.remove(view.getOptionsPanel());
        view.getMainMenu().setVisible(true);
    }

    /**
     * Replaces Drop buttons with "Player x Has Won"
     */
    private void displayWinnerScreen(String player) {
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

    /**
     * Replaces Drop buttons with "Draw"
     */
    private void displayDrawScreen() {
        System.out.println("Game Over");
        view.getDropPanel().setVisible(false);
        view.getBottomMenu().getSaveButton().setVisible(false);
        view.getBottomMenu().getPlayerTurn().setVisible(false);
        view.add(view.getGameWinner());
        view.getGameWinner().getWinner().setIcon(new ImageIcon("ingameimages\\gamedraw.png"));

    }

    /**
     * Changes the color turn state for each player.
     */
    private void switchPlayerTurn() {
        model.getPlayer1().setIsPlayerTurn(!model.getPlayer1().isPlayerTurn());
        model.getPlayer2().setIsPlayerTurn(!model.getPlayer2().isPlayerTurn());
        if (model.getPlayer1().isPlayerTurn()) {
            view.getBottomMenu().getPlayerTurn().setIcon(new ImageIcon("ingameimages\\player1turn.png"));
        } else if (model.getPlayer2().isPlayerTurn()) {
            view.getBottomMenu().getPlayerTurn().setIcon(new ImageIcon("ingameimages\\player2turn.png"));
        }
    }

    /**
     *
     * Exits the Game
     */
    public void exitGame() {
        System.exit(0);
    }

    //------------------ GETTERS AND SETTERS ------------------\\
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
