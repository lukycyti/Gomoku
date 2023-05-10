
package gomoku;

/**
 * Classe contenant l'exception quand une coordonée donnée par le joueur est
 * invalide.
 *
 * @author lukyc
 */
public class InvalidCoordonates extends Exception {

    /**
     * Constructeur de l'exception.
     * @param message le message de l'erreur
     */
    public InvalidCoordonates(String message) {
        super(message);
    }
}
