package level;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;

import game.ComputerGame;

//------------------------------------------------------------------------------------------------------
// Medium Levels in the Game

public class MediumLevel extends ComputerGame {

    private static final long serialVersionUID = 1L;

    // ------------------------------------------------------------------------------------------------------
    // Fields And Variables

    static Random rand = new Random();

    // ------------------------------------------------------------------------------------------------------
    // Constructor

    public MediumLevel() {
        super();
    }

    // ------------------------------------------------------------------------------------------------------
    // Computer Game

    public void computerTurn() {
        int random = rand.nextInt(3);
        if (random != 0) {
            boolean found = false;
            for (int j = 0; j < 16; j++) {
                JButton[] tmpBtn = new JButton[16];
                for (int i = 0; i < 16; i++) {
                    tmpBtn[i] = new JButton();
                    tmpBtn[i].setText(btn[i].getText());
                }
                if (tmpBtn[j].getText().equals("")) {
                    tmpBtn[j].setText("X");

                    if (checkForWin(tmpBtn) == 1) {
                        btn[j].setText("O");
                        btn[j].setEnabled(false);
                        found = true;
                        break;
                    }
                }
            }
            if (found == false) {
                selectRandomPlace();
            }
        } else {
            selectRandomPlace();
        }
    }

    // ------------------------------------------------------------------------------------------------------
    // Select Random

    public void selectRandomPlace() {
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
