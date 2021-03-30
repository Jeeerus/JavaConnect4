package StartGame;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Database Class for the Game. Contains all database methods that handle the
 * saving and loading of game data and colours.
 *
 * @author Jairus M. & Andrew B.
 */
public class ConnectFourDatabase {

    Connection conn = null;
    String url = "jdbc:derby:ConnectFourDB;create=true";  //url of the DB host
    String username = "c4";  //your DB username
    String password = "c4";   //your DB password
    Statement statement;
    ResultSet rs;

    public ConnectFourDatabase() {
        try {
            System.out.println("Connecting to database");
            conn = DriverManager.getConnection(url, username, password);
            statement = conn.createStatement();
        } catch (Throwable ex) {
            System.err.println("SQL Exception: " + ex.getMessage());
        }
    }

    /**
     * Creates the COLOUR table in the database if the COLOUR table doesn't
     * exist.
     */
    public void createColourTable() {
        try {
            boolean exists = checkTableExisting("COLOUR"); //Only create table if it doesn't exist
            if (!exists) {
                System.out.println("Creating COLOUR table...");
                statement.execute("CREATE TABLE COLOUR (PLAYERID INT, COLOUR INT)");
                statement.executeUpdate("INSERT INTO COLOUR VALUES (1, -65536), " // Insert Values into COLOUR table (Default Red and Yellow)
                        + "(2, -256)");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Creates the GAME table in the database if the GAME table doesn't exist.
     */
    public void createGameTable() {
        try {
            boolean exists = checkTableExisting("GAME"); //Only create table if it doesn't exist
            if (!exists) {
                System.out.println("Creating GAME table...");
                statement.execute("CREATE TABLE GAME (GAMEID INT, PLAYER1 BLOB, PLAYER2 BLOB, GRID BLOB)");
                statement.executeUpdate("INSERT INTO GAME VALUES (1, null, null, null)");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Saves the colours for both players into the database
     *
     * @param p1Colour hashCode value of Color
     * @param p2Colour hashCode value of Color
     */
    public void insertSavedColours(int p1Colour, int p2Colour) {
        try {
            System.out.println("Saving colours...");
            String p1Save = "UPDATE COLOUR"
                    + " SET COLOUR = " + p1Colour
                    + " WHERE PLAYERID = 1";
            String p2Save = "UPDATE COLOUR"
                    + " SET COLOUR = " + p2Colour
                    + " WHERE PLAYERID = 2";
            statement.executeUpdate(p1Save);
            statement.executeUpdate(p2Save);
            System.out.println("Success");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Saves the game data into the database
     *
     * @param obj array of Objects containing Player 1, PLayer2 and Grid
     * @throws IOException to be handled by the caller
     * @throws SQLException to be handled by the caller
     */
    public void insertSavedGameData(Object[] obj) throws IOException, SQLException {
        String[] objColumnName = {"PLAYER1", "PLAYER2", "GRID"};
        for (int i = 0; i < obj.length; i++) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj[i]);
            byte[] objAsBytes = baos.toByteArray();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE GAME SET " + objColumnName[i]
                    + " = ? where GAMEID = 1");
            ByteArrayInputStream bais = new ByteArrayInputStream(objAsBytes);
            pstmt.setBinaryStream(1, bais, objAsBytes.length);
            pstmt.executeUpdate();
            pstmt.close();
        }
        System.out.println("Success");
    }

    /**
     * Loads the saved colours from the database. Transfers them from the int
     * hashCode value into a colour
     *
     * @param playerID loads the colour of the this player
     * @return the Color object from the hashCode value
     */
    public Color loadSavedColour(int playerID) {
        try {
            System.out.println("Load colour for player " + playerID);
            String getColour = "SELECT COLOUR "
                    + "FROM COLOUR "
                    + "WHERE PLAYERID = " + playerID;
            int colourHash = -1;
            rs = statement.executeQuery(getColour);
            while (rs.next()) {
                colourHash = rs.getInt(1);
            }
            Color color = new Color(colourHash);
            return color;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Loads the game data from the database.
     *
     * @return an ArrayList of Objects, which hold Player1, PLayer2, and the
     * grid.
     * @throws IOException to be handled by caller
     * @throws SQLException to be handled by caller
     */
    public ArrayList loadSavedGameData() throws IOException, SQLException {
        System.out.println("Loading game...");
        ArrayList<Object> objArray = new ArrayList<>();
        String[] objColumnName = {"PLAYER1", "PLAYER2", "GRID"};
        for (int i = 0; i < objColumnName.length; i++) {
            rs = statement.executeQuery("SELECT " + objColumnName[i]
                    + " FROM GAME WHERE GAMEID = 1");

            while (rs.next()) {
                try {
                    byte[] st = rs.getBytes(1);
                    ByteArrayInputStream baip = new ByteArrayInputStream(st);
                    ObjectInputStream ois = new ObjectInputStream(baip);
                    objArray.add(ois.readObject());
                } catch (ClassNotFoundException ex) {
                    System.out.println("Class not found: ");
                    ex.printStackTrace();
                }
            }
        }
        System.out.println("Success");
        return objArray;
    }

    /**
     * Checks whether a table with a matching name exists in the database.
     *
     * @param newTableName the name of the table you want to see exists
     * @return true - if the table exists, false if it does not.
     */
    private boolean checkTableExisting(String newTableName) {
        try {
            System.out.println("check existing tables... ");
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);

            while (rsDBMeta.next()) {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                System.out.println("found: " + tableName);
                if (tableName.compareToIgnoreCase(newTableName) == 0) {
                    return true;
                }
            }
            rsDBMeta.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
