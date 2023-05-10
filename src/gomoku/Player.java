
package gomoku;

/**
 * Interface contenant des méthodes destinées au joueurs.
 * 
 * @author lukyc
 */
public interface Player {
    
    /**
     * Méthode qui va permettre de placer des pions sur un plateau.
     * 
     * @param b plateau sur lequel on veut jouer
     * @throws InvalidCoordonates
     * @throws GamePlayerLeaves
     * @return la position sur laquelle on veut poser un pion.
     */
    Position choice(Board b) throws InvalidCoordonates, GamePlayerLeaves;
    
    /**
     * Retourne le nom du joueur
     * 
     * @return le nom du joueur 
     */
    String getName() ;
}
