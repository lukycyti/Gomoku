
package gomoku;

/**
 *
 * @author lukyc
 */
public class RobotPlayer implements Player{
    
    private final String name;
    
    /**
     * Constructeur d'un joueur virtuel.
     *
     * @param name nom du joueur.
     */
    public RobotPlayer(String name) {
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
    public Position choice(Board b) throws InvalidCoordonates, GamePlayerLeaves {
        Position choice = IAChoice.choice(b, b.isEmpty());
        // On marque une pause
        try{
            Thread.sleep(500);
        } catch(InterruptedException ie){
            System.out.println(ie.getMessage() + "Interruption");
        }
        System.out.println(choice.toLetter());
        return choice;
    }
    
}
