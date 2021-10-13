package GamingPortal;

//importing packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** a loading window class of the gaming portal */
public class loadingWin extends stuffs {
    // timer class object
    Timer t;

    // contructor of the class
    public loadingWin() {
        // creating a JWindow object
        JWindow lw = new JWindow();
        lw.setVisible(true);
        lw.setBounds(100, 20, 800, 650);

        // Setting logo in the loading window
        JLabel bg = new JLabel(gp_logo);
        bg.setLayout(null); // setting layout to null

        // a JLabel to print a string on the background image
        JLabel ld = new JLabel("LOADING...");
        ld.setForeground(Color.white);
        ld.setFont(f0);
        ld.setBounds(310, 500, 200, 200);
        bg.add(ld);

        lw.add(bg); // adding the image in the background

        // a Jprogress bar which shows the loading progress of the portal
        JProgressBar pb = new JProgressBar(0, 100);
        pb.setForeground(Color.green);
        pb.setBackground(Color.black);
        lw.add(BorderLayout.PAGE_END, pb);

        lw.validate();

        // defining a the timer object
        t = new Timer(100, new ActionListener() {
            // defining a the timer object
            public void actionPerformed(ActionEvent e) {
                int p = pb.getValue(); // stores the current value of the progress bar

                // checks if the progress bar completes loads the home page or our project
                // otherwise increment the progress bar value by 5
                if (p == 100) {
                    new StartWin();
                    lw.dispose();
                    t.stop();
                } else {
                    pb.setValue(p + 5);
                }
            }
        });
        t.start();
    }

    public static void main(String args[]) throws Exception {
        // changing the look and feel of the gui program
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new loadingWin();
            }
        });
    }
}
