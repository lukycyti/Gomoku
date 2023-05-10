
package gomoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author lukyc
 */
public class IAChoice {
    
    /**
     * Renvoit la liste des actions possibles.
     * 
     * @param b
     * @param firstMove
     * @return la liste des actions
     */
    private static List<Position> possibleActions(Board b, boolean firstMove){
        List<Position> actions = new ArrayList<>();
        b.getPositionAll().forEach((p) -> {
            for(Direction d : Direction.values()){
                Position next = b.nextPosition(p, d);
                if(b.movePossible(next, firstMove)){
                    actions.add(next);
                }
            }
        });
        return actions;
    }
    
    /**
     * Selectionne au hasard une action parmi la liste des actions possibles.
     * 
     * @param b
     * @param firstMove
     * @return le choix de la position
     */
    public static Position choice(Board b, boolean firstMove){
        List<Position> actions = possibleActions(b, firstMove);
        Random r = new Random();
        return actions.get(r.nextInt(actions.size()));
    }
}
