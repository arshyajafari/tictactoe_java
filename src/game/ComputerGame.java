package game;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import FileIO.FileIO;

//------------------------------------------------------------------------------------------------------
// Abstract Class And Extends JFrame And Implements Action Listener

public abstract class ComputerGame extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    // ------------------------------------------------------------------------------------------------------
    // Fields And Variables

    public JFrame jFrame = new JFrame();
    public JPanel jPanel = new JPanel();
    protected JButton[] btn = new JButton[16];
    int count = 0;
    int move = 0;
    int playAgain = 0;
    String player1 = "X";
    String player2 = "O";

    // ------------------------------------------------------------------------------------------------------
    // Constructor

    public ComputerGame() {
        gamePanel();
    }

    // ------------------------------------------------------------------------------------------------------
    // Create Panel For Game

    public void gamePanel() {
        this.setTitle("Player to Computer");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setContentPane(jPanel);
        this.jPanel.setLayout(new GridLayout(4, 4));

        for (int i = 0; i < 16; i++) {
            btn[i] = new JButton();
            jPanel.add(btn[i]).setFont(new Font("Courier New", Font.BOLD, 60));
            btn[i].setEnabled(true);
            btn[i].addActionListener(this);
        }
        this.setVisible(true);
    }

    // ------------------------------------------------------------------------------------------------------
    // Computer Game

    public abstract void computerTurn();

    // ------------------------------------------------------------------------------------------------------
    // Action For Buttons

    public void actionPerformed(ActionEvent a) {
        count++;
        for (int i = 0; i < 16; i++) {
            if (btn[i] == a.getSource()) {
                btn[i].setText("X");
                btn[i].setEnabled(false);
                computerTurn();
                move++;
                count++;
            }
        }
        winAlert(checkForWin(btn));

        // ------------------------------------------------------------------------------------------------------
        // Draw Game

        if (count >= 16) {
            FileIO.saveGame(btn, "Play with Computer - No winner", new Date());
            playAgain = JOptionPane.showConfirmDialog(null, " Game is Draw!  Do you want to Play Again?", " Draw",
                    JOptionPane.YES_NO_OPTION);

            if (playAgain == JOptionPane.YES_OPTION) {
                for (int j = 0; j < 16; j++) {
                    btn[j].setText("");
                    btn[j].setEnabled(true);
                }
                count = 0;
                move = 0;
                return;
            } else if (playAgain == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        }
        move++;
    }

    // ------------------------------------------------------------------------------------------------------
    // Check Winner

    public int checkForWin(JButton[] btn) {
        // ------------------------------------------------------------------------------------------------------
        // Horizontal XXXX

        boolean playerWon = false;
        boolean computerWon = false;
        if (btn[0].getText().equals("X") && btn[1].getText().equals("X") && btn[2].getText().equals("X")
                && btn[3].getText().equals("X")) {
            playerWon = true;
        } else if (btn[4].getText().equals("X") && btn[5].getText().equals("X") && btn[6].getText().equals("X")
                && btn[7].getText().equals("X")) {
            playerWon = true;
        } else if (btn[8].getText().equals("X") && btn[9].getText().equals("X") && btn[10].getText().equals("X")
                && btn[11].getText().equals("X")) {
            playerWon = true;
        } else if (btn[12].getText().equals("X") && btn[13].getText().equals("X") && btn[14].getText().equals("X")
                && btn[15].getText().equals("X")) {
            playerWon = true;
        }

        // ------------------------------------------------------------------------------------------------------
        // Horizontal OOOO

        if (btn[0].getText().equals("O") && btn[1].getText().equals("O") && btn[2].getText().equals("O")
                && btn[3].getText().equals("O")) {
            computerWon = true;
        } else if (btn[4].getText().equals("O") && btn[5].getText().equals("O") && btn[6].getText().equals("O")
                && btn[7].getText().equals("O")) {
            computerWon = true;
        } else if (btn[8].getText().equals("O") && btn[9].getText().equals("O") && btn[10].getText().equals("O")
                && btn[11].getText().equals("O")) {
            computerWon = true;
        } else if (btn[12].getText().equals("O") && btn[13].getText().equals("O") && btn[14].getText().equals("O")
                && btn[15].getText().equals("O")) {
            computerWon = true;
        }

        // ------------------------------------------------------------------------------------------------------
        // Vertical XXXX

        if (btn[0].getText().equals("X") && btn[4].getText().equals("X") && btn[8].getText().equals("X")
                && btn[12].getText().equals("X")) {
            playerWon = true;
        } else if (btn[1].getText().equals("X") && btn[5].getText().equals("X") && btn[9].getText().equals("X")
                && btn[13].getText().equals("X")) {
            playerWon = true;
        } else if (btn[2].getText().equals("X") && btn[6].getText().equals("X") && btn[10].getText().equals("X")
                && btn[14].getText().equals("X")) {
            playerWon = true;
        } else if (btn[3].getText().equals("X") && btn[7].getText().equals("X") && btn[11].getText().equals("X")
                && btn[15].getText().equals("X")) {
            playerWon = true;
        }

        // ------------------------------------------------------------------------------------------------------
        // Vertical OOOO

        if (btn[0].getText().equals("O") && btn[4].getText().equals("O") && btn[8].getText().equals("O")
                && btn[12].getText().equals("O")) {
            computerWon = true;
        } else if (btn[1].getText().equals("O") && btn[5].getText().equals("O") && btn[9].getText().equals("O")
                && btn[13].getText().equals("O")) {
            computerWon = true;
        } else if (btn[2].getText().equals("O") && btn[6].getText().equals("O") && btn[10].getText().equals("O")
                && btn[14].getText().equals("O")) {
            computerWon = true;
        } else if (btn[3].getText().equals("O") && btn[7].getText().equals("O") && btn[11].getText().equals("O")
                && btn[15].getText().equals("O")) {
            computerWon = true;
        }

        // ------------------------------------------------------------------------------------------------------
        // Diagonal XXXX

        else if (btn[0].getText().equals("X") && btn[5].getText().equals("X") && btn[10].getText().equals("X")
                && btn[15].getText().equals("X")) {
            playerWon = true;
        } else if (btn[3].getText().equals("X") && btn[6].getText().equals("X") && btn[9].getText().equals("X")
                && btn[12].getText().equals("X")) {
            playerWon = true;
        }

        // ------------------------------------------------------------------------------------------------------
        // Diagonal OOOO

        else if (btn[0].getText().equals("O") && btn[5].getText().equals("O") && btn[10].getText().equals("O")
                && btn[15].getText().equals("O")) {
            computerWon = true;
        } else if (btn[3].getText().equals("O") && btn[6].getText().equals("O") && btn[9].getText().equals("O")
                && btn[12].getText().equals("O")) {
            computerWon = true;
        }

        // ------------------------------------------------------------------------------------------------------

        if (playerWon || computerWon) {
            if (playerWon) {
                return 1;
            } else {
                return 2;
            }
        }
        return 0;
    }

    // ------------------------------------------------------------------------------------------------------
    // Player1 Message

    public void winAlert(int i) {
        if (i == 1) {
            FileIO.saveGame(btn, "Player with Computer - User won", new Date());
            playAgain = JOptionPane.showConfirmDialog(null,
                    "Player " + player1 + " wins the game!  Do you want to play again?", player1 + " won!",
                    JOptionPane.YES_NO_OPTION);

            if (playAgain == JOptionPane.YES_OPTION) {
                for (int j = 0; j < 16; j++) {
                    btn[j].setText("");
                    btn[j].setEnabled(true);
                }
                count = 0;
                move = 0;
                // playerWon = false;
                return;
            } else if (playAgain == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        }

        // ------------------------------------------------------------------------------------------------------
        // Player2 Message

        if (i == 2) {
            FileIO.saveGame(btn, "Player with Computer - Computer won", new Date());
            playAgain = JOptionPane.showConfirmDialog(null,
                    "Player " + player2 + " wins the game!  Do you want to play again?", player2 + " won!",
                    JOptionPane.YES_NO_OPTION);

            if (playAgain == JOptionPane.YES_OPTION) {
                for (int j = 0; j < 16; j++) {
                    btn[j].setText("");
                    btn[j].setEnabled(true);
                }
                count = 0;
                move = 0;
                // computerWon = false;
                return;
            } else if (playAgain == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        }
    }

}
