
package gomoku;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test de la classe Position
 */
public class PositionTest {

    /**
     * Test de la levée d'exception quand une position est invalide.
     *
     * @throws InvalidCoordonates
     */
    @Test(expected = InvalidCoordonates.class)
    public void postionException() throws InvalidCoordonates {
        // Quand le joueur choisi une ligne égale à 0 
        String coord1 = "J0";
        Position pos1 = new Position(coord1);

        // Quand le joueur choisi une position sans chiffre
        String coord2 = "AA";
        Position pos2 = new Position(coord2);

        // Quand le joueur choisi une position avec deux lettres
        String coord3 = "C1B";
        Position pos3 = new Position(coord3);

        // Quand le joueur choissi une position avec une chaîne de caractère de plus de 3 caractères
        String coord4 = "1234";
        Position pos4 = new Position(coord4);
    }

    /**
     * Test de la méthode valid de la classe Position.
     */
    @Test
    public void testValid() {
        String coord = "A10";
        assertTrue(Position.isValidCoordonate(coord));

        String coord2 = "H2";
        assertTrue(Position.isValidCoordonate(coord2));
    }

    /**
     * Test de la méthode charToInt de la classe Position.
     */
    @Test
    public void testCharToInt() throws InvalidCoordonates {
        String coord1 = "A14";
        assertEquals(0, Position.getColChar(coord1));
        assertEquals(13, Position.getRowChar(coord1));
    }

    /**
     * Test de la méthode toLetter de la classe Position.
     */
    @Test
    public void testToLetter() {
        Position p = new Position(5, 5);
        assertEquals(p.toLetter(), "F6");
        Position p2 = new Position(5, 12);
        assertEquals(p2.toLetter(), "F13");
        Position p3 = new Position(5, 80);
        assertEquals(p3.toLetter(), "F81");
    }
}
