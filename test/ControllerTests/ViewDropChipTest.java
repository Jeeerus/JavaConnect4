package ControllerTests;

import StartGame.ConnectFourController;
import java.awt.Color;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Checks to see if the Views grid is dependent on the Model's grid.
 *
 * @author Jairus M. & Andrew B.
 */
public class ViewDropChipTest {

    public ViewDropChipTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testDropChipToGrid() {
        ConnectFourController cm = new ConnectFourController();

        cm.getModel().getGrid().addToGrid(0, 'x');
        cm.getView().getGridPanel().updateGrid(cm.getModel().getGrid(), Color.red, 'x');

        char actual = 'o';
        char expected = 'x';

        // Compares Colour x,y to the char x,y to see if they match
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 7; c++) {
                if (cm.getView().getGridPanel().getGridBox()[r][c].getBackground() == Color.RED) {
                    if (cm.getModel().getGrid().getGrid()[r][c] == 'x') {
                        actual = cm.getModel().getGrid().getGrid()[r][c];
                    }
                }
            }
        }

        Assert.assertEquals(expected, actual);
    }
}
