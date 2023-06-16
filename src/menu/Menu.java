// set package name
package menu;

// import java package
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// import files
import game.PlayerGame;
import score.Score;

// Class Main Panel
public class Menu extends JFrame {
    private static final long serialVersionUID = 1L;

    // Fields And Variables
    JFrame jFrame = new JFrame();
    JPanel jPanel = new JPanel();
    JButton jButton1 = new JButton("Player to Player");
    JButton jButton2 = new JButton("Player to Computer");
    JButton jButton3 = new JButton("Score Player");
    JButton jButton4 = new JButton("Exit");

    // Constructor
    public Menu() {
        this.setTitle("Tic Tac Toe");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setContentPane(jPanel);
        this.jPanel.setLayout(new GridLayout(4, 4));

        // Add Button And Set Font
        jPanel.add(jButton1).setFont(new Font("Courier New", Font.BOLD, 25));
        jPanel.add(jButton2).setFont(new Font("Courier New", Font.BOLD, 25));
        jPanel.add(jButton3).setFont(new Font("Courier New", Font.BOLD, 25));
        jPanel.add(jButton4).setFont(new Font("Courier New", Font.BOLD, 25));

        this.setVisible(true);

        // Default Close Operation (DO_NOTHING_ON_CLOSE)
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                int key = JOptionPane.showOptionDialog(null, "Are You Sure?", "Exit", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Yes", "Cancel"}, "No");
                switch (key) {
                    case 0:
                        System.exit(key);
                        break;
                    case 1:
                        break;
                }
            }

        });

        // Action For Buttons
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button1ActionPerformed(e);
            }
        });

        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button2ActionPerformed(e);
            }
        });

        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button3ActionPerformed(e);
            }
        });

        jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button4ActionPerformed(e);
            }
        });
    }

    // Action Method
    public void button1ActionPerformed(ActionEvent e) {
        PlayerGame game = new PlayerGame();
        game.setVisible(true);
    }

    public void button2ActionPerformed(ActionEvent e) {
        GameLevel com = new GameLevel();
        com.setVisible(true);
    }

    public void button3ActionPerformed(ActionEvent e) {
        Score score = new Score();
        score.setVisible(true);
    }

    public void button4ActionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
