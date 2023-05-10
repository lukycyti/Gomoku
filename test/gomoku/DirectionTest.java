
package gomoku;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lukyc
 */
public class DirectionTest {
    
    @Test
    public void testTwins(){
        Direction d = Direction.NORD_EST;
        assertTrue(d.twins().contains(Direction.SUD_OUEST));
    }
    
    @Test
    public void getVector(){
        Direction d = Direction.NORD;
        assertEquals(d.getHorizontal(), 1);
        assertEquals(d.getVertical(), 0);
    }
}
