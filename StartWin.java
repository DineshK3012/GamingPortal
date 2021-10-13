package GamingPortal;

//importing packages
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** a class for the home page of the Gaming portal */
public class StartWin extends stuffs {

    // constructor of the class
    public StartWin() {
        // creating a JFrame object
        JFrame jf = new JFrame("GAMING PORTAL - Home");
        jf.setSize(new Dimension(800, 680));
        jf.setLocation(100, 20);
        jf.setResizable(false);
        jf.setIconImage(gp.getImage());
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creating a gridbaglayout object
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setLayout(gb); // setting the layout of the panel as gridbaglayout

        gbc.weightx = 0.1; // requests for extra space horizontally
        gbc.weighty = 0.1; // requests for extra space vertically

        // defines the position/column of the component where it should be placed
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel welcome = new JLabel("WELCOME");
        welcome.setFont(f);
        welcome.setForeground(Color.white);
        panel.add(welcome, gbc); // adding a jlabel to the panel

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel to = new JLabel("To");
        to.setForeground(Color.white);
        to.setFont(f1);
        panel.add(to, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel game = new JLabel(gp_logo1);
        game.setForeground(Color.white);
        game.setFont(f3);
        panel.add(game, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel p = new JLabel("Please Click On START!!!");
        p.setForeground(Color.white);
        p.setFont(f1);
        panel.add(p, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        JButton start = new JButton(start_b);
        start.setBackground(new Color(33, 2, 99));
        start.setFont(f2);

        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new EnterName();
                jf.dispose();
            }
        });
        panel.add(start, gbc);

        // adding the gradient panel to the frame
        jf.add(panel);
        jf.setVisible(true);
    }

    public static void main(String[] args) throws Exception {

        // changing the look and feel of the gui program
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StartWin();
            }
        });
    }
}
