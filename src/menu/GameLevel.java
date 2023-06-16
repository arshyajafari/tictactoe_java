// set package name
package menu;

// import java package
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// import files
import level.EasyLevel;
import level.HardLevel;
import level.MediumLevel;

// Class Game Level
public class GameLevel extends JFrame {
    private static final long serialVersionUID = 1L;

    // Fields And Variables
    JFrame jFrame = new JFrame();
    JPanel jPanel = new JPanel();
    JButton jButton1 = new JButton("Easy");
    JButton jButton2 = new JButton("Medium");
    JButton jButton3 = new JButton("Hard");

    // Constructor
    public GameLevel() {
        this.setTitle("Game Level");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setContentPane(jPanel);
        this.jPanel.setLayout(new GridLayout(3, 3));

        // Add Button And Set Font
        jPanel.add(jButton1).setFont(new Font("Courier New", Font.BOLD, 25));
        jPanel.add(jButton2).setFont(new Font("Courier New", Font.BOLD, 25));
        jPanel.add(jButton3).setFont(new Font("Courier New", Font.BOLD, 25));

        this.setVisible(true);

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
    }

    // Action Method
    public void button1ActionPerformed(ActionEvent e) {
        EasyLevel easy = new EasyLevel();
        easy.setVisible(true);
    }

    public void button2ActionPerformed(ActionEvent e) {
        MediumLevel medium = new MediumLevel();
        medium.setVisible(true);
    }

    public void button3ActionPerformed(ActionEvent e) {
        HardLevel hard = new HardLevel();
        hard.setVisible(true);
    }
}
