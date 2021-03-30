package GridTests;

import Model.Grid;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Checks to see if there is a winner with a north-west diagonal
 *
 * @author Jairus M. & Andrew B.
 */
public class DiagonalNorthWestCheckTest {
    
    public DiagonalNorthWestCheckTest() {
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
    public void testDiagonalNorthWestChecker() {
        Grid myGrid = new Grid();
        
        // Adds four 'x' in a row diagonally
        myGrid.addToGrid(0, 'o');
        myGrid.addToGrid(0, 'o');
        myGrid.addToGrid(0, 'o');
        myGrid.addToGrid(0, 'x');
        myGrid.addToGrid(1, 'o');
        myGrid.addToGrid(1, 'o');
        myGrid.addToGrid(1, 'x');
        myGrid.addToGrid(2, 'o');
        myGrid.addToGrid(2, 'x');
        myGrid.addToGrid(3, 'x');
        
        boolean expected = true;
        boolean actual = myGrid.checkDiagonalNorthWest(5, 3, 'x');
        
        Assert.assertEquals(expected, actual);
    }
}
