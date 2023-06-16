// set package name
package score;

// import java library
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;

// import files
import FileIO.FileIO;
import level.EasyLevel;

// Class Score For Game
public class Score extends JFrame {
    private static final long serialVersionUID = 1L;

    JFrame jFrame = new JFrame();
    JPanel jPanel = new JPanel();

    // Constructor
    public Score() {
        this.setTitle("Score");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setContentPane(jPanel);
        this.jPanel.setLayout(new GridLayout(6, 6));

        File[] files = FileIO.readFiles();
        for (File file : files) {
            try {
                FileReader fr = new FileReader(file);
                StringBuilder data = new StringBuilder();
                int charInt;
                while ((charInt = fr.read()) != -1) {
                    data.append((char) charInt);
                }
                String[] lines = data.toString().split("\n");
                JButton btn = new JButton(lines[0] + " - " + lines[1]);
                btn.addActionListener(new ActionListener() {
                    // Action For Button
                    public void actionPerformed(ActionEvent arg0) {
                        String[] data = lines[2].replace(",,", ", ,").split(",");
                        JButton[] btns = new JButton[16];
                        EasyLevel easy = new EasyLevel();
                        easy.jPanel.removeAll();
                        easy.setVisible(true);
                        for (int j = 0; j < data.length; j++) {
                            btns[j] = new JButton(data[j]);
                            btns[j].setEnabled(false);
                            easy.jPanel.add(btns[j]).setFont(new Font("Courier New", Font.BOLD, 60));
                        }
                    }
                });
                this.jPanel.add(btn);
                fr.close();
            } catch (Exception ignored) {
            }
        }
    }
}
