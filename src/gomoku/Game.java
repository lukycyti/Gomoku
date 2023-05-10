
package gomoku;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe contenant les informations d'une partie.
 *
 * @author lukyc
 */
public class Game {

    Color nextPlayer;
    Board board;
    // Liste des coups joués durant la partie.
    List<Position> moves = new ArrayList<>();
    protected boolean win, nulle = false;


    /**
     * Pose un pion à une position donnée si les coordonnées sont correctes.
     *
     * @param p position sur laquelle on veut poser un pion.
     * @return vrai si le pion a été posé sinon retourne faux.
     */
    protected boolean play(Position p){
        if (!board.movePossible(p, moves.isEmpty())) {
            // Si la coordonnée existe
            if(p != null || !board.containPos(p)){
                System.out.println("Coup impossible, veuillez réessayer");
            }
            return false;
        } else {
            board.setColor(p, nextPlayer);
            moves.add(p);
            win = win(p);
            nulle = board.isFull();
            return true;
        }
    }
    
    
    /**
     * Retourne si le joueur en cours a gagné.
     * 
     * @param p le dernier coup joué.
     * @return vrai si le joueur à gagné.
     */
    private boolean win(Position p){
        for(Direction d : Direction.values()){
            int nbPawnsAlign = -1;
            for(Direction twin : d.twins()){
                Position next = board.nextPosition(p, d);
                while(nbPawnsAlign < 5 && validSearch(next)){
                    next = board.nextPosition(next, twin);
                    nbPawnsAlign++;
                }
                if(nbPawnsAlign > 4){
                    return true;
                }
            }
            
        }
        return false;
    }

    
    /**
     * Verifie si la position donnée est valide pour une potentielle victoire.
     * 
     * @param p la position qui est en cours de recherche.
     * @return vrai si la position existe et que celle ci est de
     *      même couleur que la position d'origine.
     */
    private boolean validSearch(Position p){
        return board.containPos(p) && board.getColor(p) == nextPlayer;
    }
    
    /**
     * Affiche l'ensemble des coups joués au cours de la partie.
     */
    protected void displayMoves(){
        System.out.print("{");
        moves.forEach((p) -> {
            System.out.print(p.toLetter());
            if (moves.indexOf(p) != moves.size() - 1) {
                System.out.print("-");
            }
        });
        System.out.println("}");
    }
}
