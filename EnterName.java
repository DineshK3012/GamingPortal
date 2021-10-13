package GamingPortal;

//importing packages
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** a class for registering the player name */
public class EnterName extends stuffs {

    static String cur_user = ""; // static member to store the name of the current user/player
    static String empty = "";
    static boolean s = true;

    // construtor of the class
    public EnterName() {
        // creating a JFrame Object
        JFrame jf = new JFrame("GAMING PORTAL - Fill Your Details");
        jf.setSize(new Dimension(800, 650));
        jf.setLocation(100, 20);
        jf.setResizable(false);
        jf.setIconImage(gp.getImage());
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creating a gridbagLayout object
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setLayout(gb); // setting the layout of the panel as gridbaglayout

        gbc.weightx = 0.1; // requests for extra space horizontally
        gbc.weighty = 0.1; // requests for extra space vertically

        // defines the position/column of the obejct where it should be placed
        gbc.gridx = 0;
        gbc.gridy = 0;
        JButton back = new JButton("< BACK");
        back.setBackground(new Color(67, 1, 115));
        back.setForeground(Color.yellow);
        back.setFont(f6);

        // registering the back button to an actionlistener to handle its event
        back.addActionListener(new ActionListener() {
            // overriding the actionPerformed method which handle the event
            public void actionPerformed(ActionEvent ae) {
                new StartWin();
                jf.dispose();
            }
        });
        panel.add(back, gbc); // adding button to the panel

        gbc.gridx = 2;
        gbc.gridy = 0;
        JLabel logo = new JLabel(gp_logo2);
        panel.add(logo, gbc); // adding the Gaming portal logo to the panel

        gbc.gridx = 2;
        gbc.gridy = 1;
        JLabel username = new JLabel("Enter your Name\n");
        username.setForeground(Color.white);
        username.setFont(f4);
        panel.add(username, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        JTextField user = new JTextField();
        gbc.fill = GridBagConstraints.BOTH;
        user.setText("Enter your name here!!!");
        user.setFont(f5);
        user.setHorizontalAlignment(SwingConstants.CENTER);

        // registering a focus listener to the text Field
        user.addFocusListener(new FocusAdapter() {
            // method to clear the text in the text field when if gained focus
            public void focusGained(FocusEvent fe) {
                user.setText(null);
            }
        });

        // registering the actionlistener to the text field to handle the event
        user.addActionListener((ae) -> {
            // taking the text from the name text field and write it into the file
            cur_user = user.getText().toString();

            try {
                // throws exception if the user forgot to enter his/her name
                if (cur_user.equals(empty)) {
                    s = false;
                    throw new nullName();
                }
            } catch (nullName e) {
                // Shows an error message to the user that he/she did not enter his/her name
                JOptionPane.showMessageDialog(jf, e, "Error!!!", JOptionPane.ERROR_MESSAGE);
            }

            // checks if the user enters the name of not
            if (s == true) {
                // calling inputName method of the input class to write the name of the user
                // into the file
                input.inputName(user);
                user.setText(null); // resetting the textField
                new Games();
                jf.dispose();
            } else {
                s = true;
            }
        });
        panel.add(user, gbc);

        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 2;
        gbc.gridy = 4;
        JButton enter = new JButton("ENTER");
        enter.setFont(f2);
        // registering the actionlistener to the enter button to handle its event
        enter.addActionListener(new ActionListener() {
            // taking the text from the name text field and write it into the file
            public void actionPerformed(ActionEvent e) {
                cur_user = user.getText().toString(); // takes the text from the text field

                try {
                    // throws exception if the user forgot to enter his/her name
                    if (cur_user.equals(empty)) {
                        s = false;
                        throw new nullName();
                    }
                } catch (nullName e1) {
                    // Shows an error message to the user that he/she did not enter his/her name
                    JOptionPane.showMessageDialog(jf, e1, "Error!!!", JOptionPane.ERROR_MESSAGE);
                }

                // checks if the user enters the name of not
                if (s == true) {
                    // calling inputName method of the input class to write the name of the user
                    // into the file
                    input.inputName(user);
                    user.setText(null);
                    new Games();
                    jf.dispose();
                } else {
                    s = true;
                }
            }
        });
        panel.add(enter, gbc);

        gbc.gridx = 3;
        gbc.gridy = 5;
        //a button to exit the portal
        JButton exit = new JButton(" EXIT PORTAL ");
        exit.setBackground(Color.red);
        exit.setForeground(Color.white);
        exit.setFont(f6);
        panel.add(exit, gbc);
        
        // registering the exit button to handle its event
        exit.addActionListener(new ActionListener() {
            // overriding the function to show a greeting message to the user
            public void actionPerformed(ActionEvent e) {
                input.length();
                if (input.len1 != input.len2) {
                    new LeaderBoard();
                } else {
                    // shows a greeting msg for the user
                    JOptionPane.showMessageDialog(jf, "Thanku for using our PORTAL", "THANK YOU!!!",
                            JOptionPane.PLAIN_MESSAGE);
                    System.exit(0); // exit the program
                }
            }
        });

        jf.setVisible(true);
        jf.add(panel);
    }

    public static void main(String[] args) throws Exception {
        // changing the look and feel of the gui program
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EnterName();
            }
        });
    }
}

// an exception class used when the user forgot to enter his/her name
class nullName extends Exception {
    // overriding toString method to print the exception
    public String toString() {
        return "Please Enter Your Name";
    }
}
