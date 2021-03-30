package GridTests;

import Model.Grid;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Checks to see if true is returned on a full grid
 *
 * @author Jairus M. & Andrew B.
 */
public class GridFullTest {
    
    public GridFullTest() {
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
    public void testGridFullChecker() {
        Grid myGrid = new Grid();
        
        // Fills grid with x's
        for(int i = 0; i < myGrid.getGridRows(); i++){
            for(int j = 0; j < myGrid.getGridColumns(); j++){
                myGrid.getGrid()[i][j] = 'x';
            }
        }
        
        boolean expected = true;
        boolean actual = myGrid.gridFull(); // Checks to see if there are any ' ' in grid top
        
        Assert.assertEquals(expected, actual);
    }
}
