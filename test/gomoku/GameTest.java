package gomoku;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test de la classe Game
 */
public class GameTest {

    /**
     * Test de la méthode play de la classe Game.
     * 
     * @throws InvalidCoordonates 
     */
    @Test
    public void testPlay() throws InvalidCoordonates {
        Game game = new Game();
        game.nextPlayer = Color.BLACK;
        Board board = new Board(10, 10);
        game.board = board;

        assertTrue(game.play(board.getPosition("A9")));
        assertTrue(game.play(board.getPosition("A8")));
        assertTrue(game.play(board.getPosition("A7")));
        assertTrue(game.play(board.getPosition("A6")));
        assertTrue(game.play(board.getPosition("A5")));

        assertFalse(game.play(board.getPosition("A0")));
        assertFalse(game.play(board.getPosition("AA")));
        assertFalse(game.play(board.getPosition("A9")));

        assertTrue(game.win);
    }

    /**
     * Test n°1 de la méthode win victoire de la classe Game.
     *
     * @throws InvalidCoordonates
     */
    @Test
    public void testWin() throws InvalidCoordonates {
        Game game = new Game();
        game.nextPlayer = Color.BLACK;
        Board board = new Board(10, 10);
        game.board = board;

        assertTrue(game.play(board.getPosition("A9")));
        assertTrue(game.play(board.getPosition("A8")));
        game.nextPlayer = Color.WHITE;
        assertTrue(game.play(board.getPosition("B7")));
        game.nextPlayer = Color.BLACK;
        assertTrue(game.play(board.getPosition("A6")));
        assertTrue(game.play(board.getPosition("A5")));
        board.display();
        assertTrue(game.play(board.getPosition("A7")));
        board.display();

        assertTrue(game.win);
    }

    /**
     * Test n°2 de la méthode win de la classe Game
     * 
     */
    @Test
    public void testGameNull() {
        Game game = new Game();
        game.nextPlayer = Color.BLACK;
        Board board = new Board(4, 5);
        game.board = board;
        char l = 'A';
        board.display();
        for (int j = 1; j < 5; j++) {
            game.nextPlayer = Color.WHITE;
            for (int i = 0; i < 5; i++) {
                assertTrue(game.play(board.getPosition(l + "" + j)));
                game.nextPlayer = Color.BLACK;
                l++;
            }
            l = 'A';
        }
        board.display();
        assertFalse(game.win);
        assertTrue(game.nulle);
    }
}
