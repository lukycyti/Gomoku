package gomoku;

import java.util.Scanner;

/**
 * Classe contenant les informations sur les joueurs humain.
 *
 * @author lbrouet
 */
public class HumanPlayer implements Player {

    private final String name;
    static Scanner in = new Scanner(System.in);

    /**
     * Constructeur d'un joueur humain.
     *
     * @param name nom du joueur.
     */
    public HumanPlayer(String name) {
        this.name = name;
    }

    /**
     * Retourne le nom du joueur.
     *
     * @return le nom du joueur.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Choix du joueur concernant la position.
     *
     * @param b plateau sur lequelle le joueur veut jouer.
     * @throws InvalidCoordonates 
     * @throws GamePlayerLeaves
     * @return la position sur le plateau.
     */
    @Override
    public Position choice(Board b) throws InvalidCoordonates, GamePlayerLeaves{
        String choice = in.nextLine().trim();
        if(choice.equals("/quit")){
            throw new GamePlayerLeaves("Abandon de partie");
        }
        return b.getPosition(choice);
    }
}
