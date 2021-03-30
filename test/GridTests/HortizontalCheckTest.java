package GridTests;

import Model.Grid;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Checks to see if there is a winner with a horizontal
 *
 * @author Jairus M. & Andrew B.
 */
public class HortizontalCheckTest {
    
    public HortizontalCheckTest() {
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
    public void testHorizontalChecker(){
        Grid myGrid = new Grid();
        boolean expected = true;
        
        // Drops Four Chips Horizontally
        myGrid.addToGrid(0, 'x');
        myGrid.addToGrid(1, 'x');
        myGrid.addToGrid(2, 'x');
        myGrid.addToGrid(3, 'x');
        
        int row = 5;
        int col = 3;
        // column 0-3
        boolean actual = myGrid.checkHorizontal(row, col, 'x');
        
        Assert.assertEquals(expected, actual);
    }
}
