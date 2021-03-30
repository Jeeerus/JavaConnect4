package Model;

/**
 * Grid Glass: The play field of the game. The grid's dimension is a 7 by 6.
 *
 * @author Jairus M. & Andrew B.
 */
public final class Grid implements java.io.Serializable {

    private char[][] grid;
    private int gridColumns;
    private int gridRows;

    public Grid() {
        this.gridColumns = 7;
        this.gridRows = 6;
        this.grid = new char[6][7];
        fillGrid();
    }

    /**
     * This method fills a Grid with spaces. This method needs to be called when
     * a grid object is instantiated.
     */
    public void fillGrid() {
        for (int i = 0; i < this.getGridRows(); i++) {
            for (int j = 0; j < this.getGridColumns(); j++) {
                this.getGrid()[i][j] = ' ';
            }
        }
    }

    /**
     * Displays the contents of the character array in a grid format to mimic
     * how connect four is played in real life.
     *
     * This should be called each time the array is updated to show any changes
     * made to the grid.
     */
    public void displayGrid() {
        for (int i = 0; i < this.getGridRows(); i++) {
            for (int j = 0; j < this.getGridColumns(); j++) {
                System.out.print("|" + this.getGrid()[i][j]);
            }
            System.out.println("|");
        }

        for (int k = 0; k < (this.gridColumns * 2) + 1; k++) {
            System.out.print("=");
        }

        System.out.print("\n" + "|");
        for (int j = 0; j < this.gridColumns; j++) {
            System.out.print((j + 1) + "|");
        }
        System.out.println();
    }

    /**
     * This method 'drops' down the 'chip' into the grid, depending on the
     * user's chosen column. In terms of the program, it (method) takes in the
     * column and finds goes through the array, checks if the column is full or
     * not, and adds the character into the bottom of the array (The highest,
     * available column number).
     *
     * @param column - Column chosen by user.
     * @param c
     * @return
     */
    public boolean addToGrid(int column, char c) {
        for (int i = this.gridRows - 1; i >= 0; i--) {
            if (this.grid[i][column] == ' ') {
                this.grid[i][column] = c;
                displayGrid();
                return false;
            }
        }
        return true;
    }

    /**
     * This method checks if the latest chip dropped by the user is connected to
     * 3 more chips; Vertical, Horizontal or Diagonal to it.
     *
     * @param column is the Column the user chose to drop their chip into
     * @param chip char of the current Player
     * @return true if game won by current player else false
     */
    public boolean checkConnectFour(int column, char chip) {
        int startRow = 0;
        System.out.println("Given Col: " + (column + 1));

        for (int i = 0; i < this.grid.length; i++) {
            if (this.grid[i][column] == chip) {
                startRow = i;
                break;
            }
        }
        if (checkVertical(startRow, column, chip)) {
            return true;
        }
        if (checkHorizontal(startRow, column, chip)) {
            return true;
        }
        if (checkDiagonalNorthEast(startRow, column, chip)) {
            return true;
        }
        if (checkDiagonalNorthWest(startRow, column, chip)) {
            return true;
        }

        return false;
    }

    /**
     * A method that takes in the row and column of the chip that was last
     * dropped. Checks if there are 3 more of the same char under it using a for
     * loop. For every same char, 1 is added to the counter. counter must reach
     * four.
     *
     * @param startRow - row of latest chip
     * @param column - column of latest chip
     * @param chip - char of chip
     * @return true if counter >= 4
     */
    public boolean checkVertical(int startRow, int column, char chip) {
        int counter = 0;

        for (int i = startRow; i < this.gridRows; i++) {
            if (this.grid[i][column] == chip) {
                counter++;
            } else {
                break;
            }
        }
        if (counter >= 4) {
            //displayGrid();
            return true;
        }
        return false;
    }

    /**
     * This method checks if the latest dropped chip causes four chips to be
     * horizontally connected. Same concept as vertical checker; using a
     * counter.
     *
     * @param row - row of latest chip
     * @param column - column of latest chip
     * @param chip - char of chip
     * @return true if counter >= 4
     */
    public boolean checkHorizontal(int row, int column, char chip) {
        int counter = 0;

        //LOOP TO CHECK RIGHT
        for (int i = column; i < this.gridColumns; i++) {
            if (this.grid[row][i] == chip) {
                counter++;
            } else {
                break;
            }
        }

        if (counter >= 4) {
            //displayGrid();
            return true;
        } else {
            // CHECKS LEFT
            counter--; // chip location already added to counter
            for (int i = column; i >= 0; i--) {
                if (this.grid[row][i] == chip) {
                    counter++;
                } else {
                    break;
                }
            }
        }

        if (counter >= 4) {
            //displayGrid();
            return true;
        }
        return false;
    }

    /**
     * Method that checks if chips connected diagonally (North East and South
     * West) Using two sets of nested for loops : One that goes up and one that
     * goes down.]
     *
     * @param row - row of latest chip
     * @param column - column of latest chip
     * @param chip - char of chip
     * @return true if counter >= 4
     */
    public boolean checkDiagonalNorthWest(int row, int column, char chip) {
        int counter = 1;

        for (int r = row - 1, c = column - 1; r >= 0 && c >= 0; r--, c--) {
            if (this.grid[r][c] == chip) {
                counter++;
            } else {
                break;
            }
        }

        if (counter >= 4) {
            System.out.println();
            //displayGrid();
            return true;
        }

        for (int r = row + 1, c = column + 1; r < this.gridRows && c < this.gridColumns; r++, c++) {
            if (this.grid[r][c] == chip) {
                counter++;
            } else {
                break;
            }
        }

        if (counter >= 4) {
            System.out.println();
            //displayGrid();
            return true;
        }
        return false;
    }

    /**
     * Method that checks if chips connected diagonally (North West and South
     * East) Using two sets of nested for loops : One that goes up and one that
     * goes down.]
     *
     * @param row - row of latest chip
     * @param column - column of latest chip
     * @param chip - char of chip
     * @return true if counter >= 4
     */
    public boolean checkDiagonalNorthEast(int row, int column, char chip) {
        int counter = 1;

        for (int r = row - 1, c = column + 1; r >= 0 && c < this.gridColumns; r--, c++) {
            if (this.grid[r][c] == chip) {
                counter++;
            } else {
                break;
            }
        }

        if (counter >= 4) {
            System.out.println();
            //displayGrid();
            return true;
        }

        for (int r = row + 1, c = column - 1; r < this.gridRows && c >= 0; r++, c--) {
            if (this.grid[r][c] == chip) {
                counter++;
            } else {
                break;
            }
        }

        if (counter >= 4) {
            System.out.println();
            //displayGrid();
            return true;
        }
        return false;
    }

    /**
     * Method that checks to see if the grid is full by checking the top row [0]
     * in every column
     *
     * @return true if all the columns are full, false if not
     */
    public boolean gridFull() {
        int counter = 0;
        for (int c = 0; c < this.gridColumns; c++) {
            if (this.grid[0][c] != ' ') {
                counter++;
                if (counter >= this.gridColumns) {
                    return true;
                }
            }
        }
        return false;
    }

    //------------------ GETTERS AND SETTERS ------------------\\
    public char[][] getGrid() {
        return this.grid;
    }

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }

    public int getGridColumns() {
        return gridColumns;
    }

    public void setGridColumns(int gridColumns) {
        this.gridColumns = gridColumns;
    }

    public int getGridRows() {
        return gridRows;
    }

    public void setGridRows(int gridRows) {
        this.gridRows = gridRows;
    }
}
