
package gomoku;

import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test de la classe Board
 */
public class BoardTest {

    /**
     * Test de la méthode SetColor de la classe Board.
     * 
     * @throws gomoku.InvalidCoordonates
     */
    @Test
    public void testSetColor() throws InvalidCoordonates {
        Board b = new Board(5, 5);
        Color c1 = Color.WHITE;
        Color c2 = Color.BLACK;

        Position pos1 = b.getPosition("C3");
        assert b.getColor(pos1) == Color.NONE;

        b.setColor(pos1, c1);
        assert b.getColor(pos1) == Color.WHITE;

        Position pos2 = b.getPosition("B4");
        b.setColor(pos2, c2);
        assert b.getColor(pos2) == Color.BLACK;
    }

    /**
     * Test de la méthode GetColor de la classe Board.
     * 
     * @throws gomoku.InvalidCoordonates
     */
    @Test
    public void testGetColor() throws InvalidCoordonates {
        Board b = new Board(5, 5);
        Color c1 = Color.WHITE;
        Color c2 = Color.BLACK;

        Position pos1 = b.getPosition("A5");
        assert b.getColor(pos1) == Color.NONE;

        Position pos2 = b.getPosition("D1");
        b.setColor(pos2, c1);
        assert b.getColor(pos2) == Color.WHITE;

        Position pos3 = b.getPosition("E3");
        b.setColor(pos3, c2);
        assert b.getColor(pos3) == Color.BLACK;
    }

    /**
     * Test de la méthode getPosition de la classe Board.
     * 
     * @throws gomoku.InvalidCoordonates
     */
    @Test
    public void testGetPosition() throws InvalidCoordonates {
        Board b = new Board(5, 5);
        Position pos1 = b.getPosition("A5");
        Position pos2 = new Position("A5");
        assert pos1.col == pos2.col;
        assert pos1.row == pos2.row;
    }

    /**
     * Test de la méthode getPositionAll de la classe Board.
     */
    @Test
    public void testGetPositionAll() {
        Board b = new Board(5, 5);
        char l = 'A';
        int k = 0;
        int taille = 1;

        Set<Position> pos = b.getPositionAll();
        assertEquals(25, pos.size());

        Position[] posAttendues = new Position[100];
        for (int i = 0; i < 5; i++) {
            for (int j = 1; j < 6; j++) {
                posAttendues[k] = b.getPosition(l + "" + j);
                taille++;
                k++;
            }
            l++;
        }
        assertEquals(25, taille - 1);

        for (int a = 0; a < pos.size(); a++) {
            assertTrue(pos.contains(posAttendues[a]));
        }
    }

    /**
     * Test de la méthode containPos de la classe Board.
     */
    @Test
    public void testContainPos() {
        Board b = new Board(5, 5);
        int taille = 1;

        Position[] posAttendues = new Position[100];
        char l = 'A';
        int k = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 5; j > 0; j--) {
                posAttendues[k] = b.getPosition(l + "" + j);
                taille++;
                k++;
            }
            l++;
        }

        for (int a = 0; a < taille - 1; a++) {
            assertTrue(b.containPos(posAttendues[a]));
        }
    }

    /**
     * Test de la méthode nextPosition de la classe Board.
     */
    @Test
    public void testNextPosition() {
        Board board = new Board(5, 5);
        Position pos1 = board.getPosition("A5");
        assertEquals(board.getPosition("A6"), board.nextPosition(pos1, Direction.NORD));

        Position pos2 = board.getPosition("A3");
        assertEquals(board.getPosition("B3"), board.nextPosition(pos2, Direction.EST));

        Position pos3 = board.getPosition("C1");
        assertEquals(board.getPosition("B1"), board.nextPosition(pos3, Direction.OUEST));

        Position pos4 = board.getPosition("D5");
        assertEquals(board.getPosition("D4"), board.nextPosition(pos4, Direction.SUD));

        Position pos5 = board.getPosition("D1");
        assertEquals(board.getPosition("E2"), board.nextPosition(pos5, Direction.NORD_EST));

        Position pos6 = board.getPosition("D1");
        assertEquals(board.getPosition("C2"), board.nextPosition(pos6, Direction.NORD_OUEST));

        Position pos7 = board.getPosition("D3");
        assertEquals(board.getPosition("C2"), board.nextPosition(pos7, Direction.SUD_OUEST));

        Position pos8 = board.getPosition("D3");
        assertEquals(board.getPosition("E2"), board.nextPosition(pos8, Direction.SUD_EST));
    }

    /**
     * Test de la méthode isFull de la classe Board.
     */
    @Test
    public void testIsFull() {
        Board b = new Board(5, 5);
        char l = 'A';
        for (int i = 0; i < 5; i++) {
            for (int j = 1; j < 6; j++) {
                b.setColor(b.getPosition(l + "" + j), Color.BLACK);
            }
            l++;
        }
        assertFalse(b.isEmpty());
        assertTrue(b.isFull());
    }

    /**
     * Test de la méthode isEmpty de la classe Board.
     */
    @Test
    public void testIsEmpty() {
        Board b = new Board(5, 5);
        assertFalse(b.isFull());
        assertTrue(b.isEmpty());
    }

    /**
     * Test de la méthode movePossible de la classe Board.
     */
    @Test
    public void testMovePossible() {
        Board b = new Board(5, 5);
        assertTrue(b.movePossible(b.getPosition("C3"), true));
        assertFalse(b.movePossible(b.getPosition("C3"), false));
        
        b.setColor(b.getPosition("C3"), Color.BLACK);
        assertTrue(b.movePossible(b.getPosition("C4"), false));
        assertTrue(b.movePossible(b.getPosition("C2"), false));
        assertTrue(b.movePossible(b.getPosition("B3"), false));
        assertFalse(b.movePossible(b.getPosition("A1"), false));
        assertFalse(b.movePossible(b.getPosition("E5"), false));
    }

}