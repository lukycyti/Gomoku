
package gomoku;

/**
 *
 * @author lukyc
 */
public class Gomoku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){

        Match m = new Match(26, 26, new RobotPlayer("Lucas"), new RobotPlayer("Julian"));
        m.run();
    }

}
