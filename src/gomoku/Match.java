
package gomoku;

import java.util.Scanner;

/**
 * Classe contenant les information d'un match.
 *
 * @author lukyc
 */
public class Match extends Game {

    final int nbCol;
    final int nbRow;
    final Player player1;
    final Player player2;
    Player playerTurn;
    static Scanner in = new Scanner(System.in);

    /**
     * Constructeur d'un match.
     *
     * @param nbCol nombres de colonnes du plateau
     * @param nbRow nombres de lignes du plateau
     * @param player1 joueur 1, peut être soit un humain soit une machine.
     * @param player2 joueur 2, peut être soit un humain soit une machine.
     */
    public Match(int nbCol, int nbRow, Player player1, Player player2) {
        this.nbCol = nbCol;
        this.nbRow = nbRow;
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * Lancement d'un match.
     */
    public void run(){
        // Taille minimum du plateau : 5 * 5
        // Taille maximum : 26 * 26
        if(!isValidSize()){
            System.out.println("Taille du plateau invalide");
            return;
        }
        // Initialisation
        this.board = new Board(nbCol, nbRow);
        System.out.println("Nouveau match entre " + player1.getName() + " et " + player2.getName());
        nextPlayer = Color.WHITE;
        playerTurn = player1;
        // Partie en cours
        while (!win && !nulle) {
            board.display();
            System.out.println("C'est à " + playerTurn.getName() + " de jouer");
            try{
                if (play(playerTurn.choice(board)) && !win) {
                    changePlayer();
                }
            } catch(InvalidCoordonates e){
                System.out.println(e.getMessage());
            } catch(GamePlayerLeaves e){
                System.out.println(e.getMessage());
                break;
            }
        }
        // Fin de partie
        board.display();
        System.out.println("Fin du Jeu!");
        if(win){
            System.out.println(playerTurn.getName() + " a gagné la partie !");
        }
        else if(nulle){
            System.out.println("Egalité !");
        }
        System.out.println("Liste des coups joués");
        displayMoves();
    }

    /**
     * Change le joueur qui doit effectuer un coup.
     */
    private void changePlayer() {
        if(playerTurn.equals(player1)){
            playerTurn = player2;
            nextPlayer = Color.BLACK;
        }
        else{
            playerTurn = player1;
            nextPlayer = Color.WHITE;
        }
    }
    
    private boolean isValidSize(){
        return nbCol > 10 && nbRow > 10 && nbCol < 27 && nbRow < 27;
    }
    
}
