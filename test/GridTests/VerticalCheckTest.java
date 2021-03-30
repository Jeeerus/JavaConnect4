package GridTests;

import Model.Grid;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Checks to see if there is a winner with a vertical
 *
 * @author Jairus M. & Andrew B.
 */
public class VerticalCheckTest {
    
    public VerticalCheckTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testVerticalChecker(){
        Grid myGrid = new Grid();
        
        // Drop Chip 4 Times
        myGrid.addToGrid(0, 'x');
        myGrid.addToGrid(0, 'x');
        myGrid.addToGrid(0, 'x');
        myGrid.addToGrid(0, 'x');
        
        boolean actual = false;
        boolean expected = true;
        int row = 2;
        
        // Row will always be last dropped row
        if(myGrid.checkVertical(row, 0, 'x')){
            actual = true;
        }
        
        Assert.assertEquals(expected, actual);
    }   
}
