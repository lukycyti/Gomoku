
package gomoku;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Classe qui contient les informations et méthodes sur le plateau de jeu
 *
 * @author lukyc
 */
public class Board {

    final int nbRows;
    final int nbColumns;
    static char PREMIER_CHAR = 'A';
    // Map dans laquelle on associe une position à une couleur
    private final Map<Position, Color> colors = new HashMap<>();
    // Tableau qui contiens les pions
    private final char[][] pawns;

    /**
     * Constructeur d'un tableau.
     *
     * @param nbRows Nombres de lignes du plateau
     * @param nbColumns Nombres de colonnes du plateau
     */
    public Board(int nbRows, int nbColumns) {
        this.nbRows = nbRows;
        this.nbColumns = nbColumns;
        this.pawns = new char[nbColumns][nbRows];
        initialize();
    }

    /**
     * Change la couleur d'une position.
     *
     * @param p la position
     * @param c la nouvelle couleur
     */
    public void setColor(Position p, Color c) {
        putChar(p, c);
        colors.put(p, c);
    }

    /**
     * Renvoie la couleur d'une position donnée.
     *
     * @param p position à laquelle on veut savoir la couleur.
     * @return la couleur de la position.
     */
    public Color getColor(Position p) {
        return colors.get(p);
    }

    /**
     * Initialise le tableau en le remplissant d'espace et
     * place les positions jouables.
     */
    private void initialize() {
        colors.clear();
        for (int i = 0; i < nbColumns; i++) {
            for (int j = 0; j < nbRows ; j++) {
                this.pawns[i][j] = '-';
                Position p = new Position(i, j);
                setColor(p, Color.NONE);
            }
        }
    }

    /**
     * Pose un pion sur une position donnée.
     *
     * @param p position de l'emplacement.
     * @param c couleur du joueur qui pose le pion.
     */
    private void putChar(Position p, Color c) {
        if (c == Color.WHITE) {
            pawns[p.col][(nbRows - 1) - p.row] = 'O';
        } else if (c == Color.BLACK) {
            pawns[p.col][(nbRows - 1) - p.row] = 'X';
        }
    }

    /**
     * Affiche les lettres au dessus du plateau.
     */
    private void letterDisplay() {
        char lettre = PREMIER_CHAR;
        System.out.print("     ");
        for (int i = 0; i < nbColumns; i++) {
            System.out.print(lettre + " ");
            lettre++;
        }
        System.out.println();
    }

    /**
     * Affiche les bordures (haut et bas) du plateau.
     */
    private void borderDisplay() {
        System.out.print("   +-");
        for (int i = 0; i < nbColumns; i++) {
            System.out.print("--");
        }
        System.out.println("+");
    }

    /**
     * Affiche le plateau
     */
    public void display() {
        letterDisplay();
        borderDisplay();
        for (int i = 0; i < nbRows; i++) {
            if (nbRows - i < 10) {
                System.out.print(" ");
            }
            System.out.print(nbRows - i + " |");
            for (int j = 0; j < nbColumns; j++) {
                System.out.print(" " + pawns[j][i]);
            }
            System.out.println(" |");
        }
        borderDisplay();
    }

    /**
     * Renvoit la position choisie par l'utilisateur.
     *
     * @param choice chaine de caractere donnée par l'utilisateur
     * @return la position dans le plateau si elle existe sinon null
     */
    public Position getPosition(String choice) {
        try {
            Position test = new Position(choice);
            for (Position p : colors.keySet()) {
                if (p.col == test.col
                        && p.row == test.row) {
                    return p;
                }
            }
        } catch (InvalidCoordonates e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    /**
     * Renvoit l'ensemble des positions du plateau
     * 
     * @return les positions
     */
    public Set<Position> getPositionAll(){
        return colors.keySet();
    }
    
    /**
     * Verifie si la position est dans le plateau.
     * @param pos la position
     * @return vrai si la position est dans le plateau.
     */
    public boolean containPos(Position pos){
        return colors.containsKey(pos);
    }

    /**
     * Retourne la position d'une case voisine dans une direction donnée.
     *
     * @param pos position de départ
     * @param dir direction donnée
     * @return la position voisine si elle existe sinon null
     */
    public Position nextPosition(Position pos, Direction dir) {
        for (Position p : colors.keySet()) {
            if (p.col == pos.col + dir.getVertical()
                    && p.row == pos.row + dir.getHorizontal()) {
                return p;
            }
        }
        return null;
    }

    /**
     * retourne vrai si la position possède au moins une voisine occupée.
     *
     * @param p la position testée
     * @return si la position a une ou plusieurs voisine(s).
     */
    boolean hasAdjacent(Position p) {
        for (Direction d : Direction.values()) {
            Position nextPos = nextPosition(p, d);
            if (nextPos != null && getColor(nextPos) != Color.NONE) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Retourne vrai si le plateau est plein.
     * 
     * @return vrai si le plateau est plein.
     */
    public boolean isFull(){
        return !colors.containsValue(Color.NONE);
    }
    
    /**
     * Retourne vrai si le plateau est vide.
     * 
     * @return vrai si le plateau est vide.
     */
    public boolean isEmpty(){
        return !colors.containsValue(Color.BLACK) && !colors.containsValue(Color.WHITE);
    }
    
    
    /**
     * Renvoit vrai si la pose du pion est possible
     *
     * @param p position sur laquelle on veut poser un pion.
     * @param firstMove Si l'action jouée est la première de la partie
     * @return vrai si l'action est possible sinon renvoie faux.
     */
    public boolean movePossible(Position p, boolean firstMove) {
        if (firstMove) {
            return getColor(p) == Color.NONE;
        }
        return getColor(p) == Color.NONE && hasAdjacent(p);
    }
}
