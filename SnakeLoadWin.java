package GamingPortal;

//importing the packages
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** a loading for the snake game */
public class SnakeLoadWin extends stuffs {
    // creating a timer object
    Timer t;

    // constructor of the class
    public SnakeLoadWin() {
        // declaring and defining the JWindow object
        JWindow snd = new JWindow();
        snd.setVisible(true);
        snd.setBounds(100, 20, 800, 650);

        // Jpanel for the various components
        JPanel jp = new JPanel();
        snd.add(jp); // adding the panel to the JWindow
        jp.setBackground(Color.black);
        jp.setBorder(BorderFactory.createLineBorder(Color.black)); // setting the border to the panel
        jp.setLayout(new GridBagLayout()); // setting the layout of the panel as gridbaglayout
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.weightx = 0.1; // requests for extra space horizontally
        gbc.weighty = 0.1; // requests for extra space vertically
        gbc.gridx = 0;
        gbc.gridy = 1;
        // a JLabel for the Game Name
        JLabel game = new JLabel("SNAKE");
        game.setForeground(Color.white); // setting the color of the text of the label
        game.setFont(f9); // setting the font of the label
        jp.add(game, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel ld = new JLabel("LOADING...");
        ld.setForeground(Color.white);
        ld.setFont(f2);
        jp.add(ld, gbc);

        // a Jprogress bar which shows the loading progress of the snake game
        JProgressBar pb = new JProgressBar(0, 100);
        pb.setForeground(Color.green);
        pb.setBackground(Color.black);
        snd.add(BorderLayout.PAGE_END, pb);

        // defining a the timer object
        t = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int p = pb.getValue(); // stores the current value of the progress bar

                // checks if the progress bar completes, loads the snake game or our project
                // otherwise increment the progress bar value by 5
                if (p == 100) {
                    snd.dispose();
                    t.stop();
                    new Snake();

                } else {
                    pb.setValue(p + 5);
                }
            }
        });
        t.start();
        snd.validate();
    }

    public static void main(String args[]) throws Exception {
        // changing the look and feel of the gui program
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SnakeLoadWin();
            }
        });

    }
}
