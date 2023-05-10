
package gomoku;

import java.util.HashSet;
import java.util.Set;

/**
 * Enumération contenant les directions.
 *
 * @author lukyc
 */
public enum Direction {
    NORD(1, 0), OUEST(0, -1), EST(0, 1), SUD(-1, 0),
    NORD_EST(1, 1), NORD_OUEST(1, -1), SUD_EST(-1, 1), SUD_OUEST(-1, -1);
    
    private final int horizontal;
    private final int vertical;
    
    /**
     * Constructeur permettant de créer une direction.
     * 
     * @param horizontal correspond au déplacement horizontale à éffectuer.
     * @param vertical correspond au déplacement verticale à éffectuer.
     */
    private Direction(int horizontal, int vertical){
        this.horizontal = horizontal;
        this.vertical = vertical;
    }
    
    /**
     * Renvoit deux directions qui sont oposées
     * 
     * @return les deux directions
     */
    public Set<Direction> twins(){
        Set<Direction> twins = new HashSet<>();
        twins.add(this);
        twins.add(this.oposite());
        return twins;
    }
    
    /**
     * Direction oposée de l'instance courante
     * 
     * @return la direction oposée
     */
    private Direction oposite(){
        switch(this){
            case NORD : return SUD;
            case OUEST : return EST;
            case EST : return OUEST;
            case SUD : return NORD;
            case NORD_EST : return SUD_OUEST;
            case NORD_OUEST : return SUD_EST;
            case SUD_EST : return NORD_OUEST;
            case SUD_OUEST : return NORD_EST;
        }
        return null;
    }
    
    /**
     * Vecteur horizontal
     * 
     * @return le vecteur horizontale
     */
    public int getHorizontal(){
        return this.horizontal;
    }
    
    /**
     * Vecteur verical
     * 
     * @return le vecteur verticale
     */
    public int getVertical(){
        return this.vertical;
    }
}
