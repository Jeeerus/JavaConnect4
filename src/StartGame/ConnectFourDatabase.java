package StartGame;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andyb
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

    public void createColourTable() {
        try {
            boolean exists = checkTableExisting("COLOUR");
            if (!exists) {
                System.out.println("Creating colour table...");
                statement.execute("CREATE TABLE COLOUR (PLAYERID INT, COLOUR INT)");
                statement.executeUpdate("INSERT INTO COLOUR VALUES (1, -65536), " // Insert Values into COLOUR table (Default Red and Yellow)
                        + "(2, -256)");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

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

    public Color loadSavedColour(int playerID){
        try {
            System.out.println("Load colour for player " + playerID);
            String getColour = "SELECT COLOUR "
                    + "FROM COLOUR "
                    + "WHERE PLAYERID = " + playerID;
            int colourHash = -1;
            rs = statement.executeQuery(getColour);
            while(rs.next()){
                colourHash  = rs.getInt(1);
            }
            Color color = new Color(colourHash);
            return color;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private boolean checkTableExisting(String newTableName) {
        try {
            System.out.println("check existing tables.... ");
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);//types);
            Statement dropStatement = null;

            while (rsDBMeta.next()) {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                System.out.println("found: " + tableName);
                if (tableName.compareToIgnoreCase(newTableName) == 0) {
                    return true;
                }
            }
            if (rsDBMeta != null) {
                rsDBMeta.close();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
