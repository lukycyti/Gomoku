
package gomoku;

/**
 * Classe contenant les informations sur les positions.
 *
 * @author lukyc
 */
public class Position {

    final int col, row;

    /**
     * Constructeur d'une postion à partir de coordonnées sous forme de nombre.
     *
     * @param col colonne de la position.
     * @param row ligne de la position.
     * @throws NumberFormatException
     */
    public Position(int col, int row){
        this.col = col;
        this.row = row;
    }

    /**
     * Constructeur d'une position à partir d'une chaîne de caractères.
     *
     * @param coord coordonnée de la position en chaîne de caractères.
     * @throws gomoku.InvalidCoordonates
     */
    public Position(String coord) throws InvalidCoordonates {
        if(isValidCoordonate(coord)){
        this.col = getColChar(coord);
        this.row = getRowChar(coord);
        }
        else{
            throw new InvalidCoordonates("Coordonées invalides");
        }
    }

    /**
     * Retourne la colonne d'une position sous forme de nombre à partir d'une
     * coordonnée sous forme de chaîne de caractères.
     *
     * @param col coordonnées donnée.
     * @return la colonne de la coordonée.
     */
    public static int getColChar(String col){
        return Character.getNumericValue(col.charAt(0)) - 10;
    }

    /**
     * Retourne la colonne d'une ligne sous forme de nombre à partir d'une
     * coordonnée sous forme de chaîne de caractères.
     *
     * @param row coordonnées donnée.
     * @return la ligne de la coordonée.
     */
    public static int getRowChar(String row){
        return Integer.parseInt(row.substring(1)) - 1;
    }

    /**
     * Verifie si une coordonnée est valide.
     *
     * @param coord coordonnées à tester
     * @return vrai si elle est valide, faux sinon
     */
    public static boolean isValidCoordonate(String coord) {
        switch(coord.length()){
            case 2:
                return isLetter(coord.charAt(0)) 
                        && isNumber(coord.charAt(1));
            case 3:
                return isLetter(coord.charAt(0)) 
                        && isNumber(coord.charAt(1))
                        && isNumber(coord.charAt(2));
            default:
                return false;
        }

    }
    
    
    /**
     * verifie si le caractère est une lettre.
     * 
     * @param col le numéro de colonne.
     * @return vrai si le caratère est une lettre
     */
    private static boolean isLetter(char col){
        return col > 64 && col < 91;
    }
    
    /**
     * verifie si le caractère est un chiffre.
     * 
     * @param row le numéro de ligne
     * @return vrai si le caratère est un chiffre
     */
    private static boolean isNumber(char row){
        return row > 47 && row < 58;
    }
    
    
    /**
     * Convertit une position en chaîne de caractère.
     * 
     * @return la chaîne de caractère
     */
    public String toLetter(){
        String colStr = String.valueOf((char) ('A' + col));
        String rowStr = String.valueOf((char) ('1' + row));
        // Si le numero de ligne comporte 2 chiffres
        if(row >= 9){
            int unit = row % 9;
            int ten = row / 9;
            String rowStrTen = String.valueOf((char) ('0' + ten));
            String rowStrUnit = String.valueOf((char) ('0' + unit - (ten - 1)));
            rowStr = rowStrTen.concat(rowStrUnit);
        }
        return colStr.concat(rowStr);
    }
}
