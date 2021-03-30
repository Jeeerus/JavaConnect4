package GridTests;

import Model.Grid;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Checks to see if the added char at a certain point is the same as expected. 
 *
 * @author Jairus M. & Andrew B.
 */
public class GridAddToGridTest {
    
    public GridAddToGridTest() {
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
    public void testAddToGrid(){
        // Checks to see if added char is the same as expected. 
        
        Grid myGrid = new Grid();
        myGrid.addToGrid(5, 'x');
        char expected = 'x';
        
        char actual = myGrid.getGrid()[5][5];
        Assert.assertEquals(actual, expected);
    }
}
