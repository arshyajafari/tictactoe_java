// set package name
package level;

// import java package
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;

// import file
import game.ComputerGame;

// Hard Levels in the Game
public class HardLevel extends ComputerGame {
    private static final long serialVersionUID = 1L;

    // Fields And Variables
    static Random rand = new Random();

    // Constructor
    public HardLevel() {
        super();
    }
    // Computer Game
    // Raw And Column move And
    public void computerTurn() {
        if (!checkForWinningO()) {
            if (!checkForWinningX()) {
                int maxColumnCount = 0;
                int maxColumnIndex = 0;
                for (int i = 0; i < 4; i++) {
                    int columnCount = 0;
                    int emptySpaces = 4;
                    boolean noEnemy = false;
                    for (int j = 0; j < 4; j++) {
                        if (btn[i + (j * 4)].getText().equals("O"))
                            columnCount++;
                        if (!btn[i + (j * 4)].getText().equals(""))
                            emptySpaces--;
                        if (btn[i + (j * 4)].getText().equals("X"))
                            noEnemy = true;
                    }
                    if (columnCount > maxColumnCount && emptySpaces != 0 && noEnemy) {
                        maxColumnCount = columnCount;
                        maxColumnIndex = i;
                    }
                }

                int maxRowCount = 0;
                int maxRowIndex = 0;
                for (int i = 0; i < 4; i++) {
                    int rowCount = 0;
                    int emptySpaces = 4;
                    boolean noEnemy = false;
                    for (int j = 0; j < 4; j++) {
                        if (btn[(i * 4) + j].getText().equals("O"))
                            rowCount++;
                        if (!btn[(i * 4) + j].getText().equals(""))
                            emptySpaces--;
                        if (btn[(i * 4) + j].getText().equals("X"))
                            noEnemy = true;
                    }
                    if (rowCount > maxColumnCount && emptySpaces != 0 && noEnemy) {
                        maxRowCount = rowCount;
                        maxRowIndex = i;
                    }
                }
                if (maxColumnIndex == 0 && maxRowCount == 0) {
                    selectRandomPlace();
                } else {
                    boolean found = false;
                    boolean found2 = false;
                    if (maxRowCount > maxColumnCount) {
                        for (int j = 0; j < 4; j++) {
                            if (btn[(maxRowIndex * 4) + j].getText().equals("")) {
                                found = true;
                                btn[(maxRowIndex * 4) + j].setText("O");
                                btn[(maxRowIndex * 4) + j].setEnabled(false);
                                break;
                            }
                        }
                    } else {
                        for (int j = 0; j < 4; j++) {
                            if (btn[maxColumnIndex + (j * 4)].getText().equals("")) {
                                btn[maxColumnIndex + (j * 4)].setText("O");
                                btn[maxColumnIndex + (j * 4)].setEnabled(false);
                                found2 = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    // Check Win O
    public boolean checkForWinningO() {
        for (int j = 0; j < 16; j++) {
            JButton[] tmpBtn = new JButton[16];
            for (int i = 0; i < 16; i++) {
                tmpBtn[i] = new JButton();
                tmpBtn[i].setText(btn[i].getText());
            }
            if (tmpBtn[j].getText().equals("")) {
                tmpBtn[j].setText("O");

                if (checkForWin(tmpBtn) == 2) {
                    btn[j].setText("O");
                    btn[j].setEnabled(false);
                    return true;
                }
            }
        }
        return false;
    }

    // Block Win X
    public boolean checkForWinningX() {
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
                    return true;
                }
            }
        }
        return false;
    }

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
