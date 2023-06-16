// set package name
package level;

// import java package
import java.util.ArrayList;
import java.util.Random;

// import file
import game.ComputerGame;

// Easy Levels in the Game
public class EasyLevel extends ComputerGame {
    private static final long serialVersionUID = 1L;

    // Fields And Variables
    static Random rand = new Random();

    // Constructor
    public EasyLevel() {
        super();
    }

    // Computer Game
    public void computerTurn() {
        ArrayList<Integer> availableSpaces = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            if (btn[i].getText().equals("")) {
                availableSpaces.add(i);
            }
        }
        int place = rand.nextInt(availableSpaces.size());
        btn[availableSpaces.get(place)].setText("O");
        btn[availableSpaces.get(place)].setEnabled(false);
    }
}
