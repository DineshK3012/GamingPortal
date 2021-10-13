package GamingPortal;

//importing packages
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** a LeaderBoard class which shows the top five player with top scores */
class LeaderBoard extends stuffs {
    JFrame jf;
    JLabel heading;
    JButton exit;
    JButton bth;

    public LeaderBoard() {
        jf = new JFrame("GAMING PORTAL - LeaderBoard");
        jf.setSize(new Dimension(850, 700));
        jf.setLocation(100, 10);
        jf.setResizable(false);
        jf.setIconImage(gp.getImage());
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creating an object of the gridbaglayout
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setLayout(gb); // setting the layout of the panel to the gridbaglayout

        gbc.weightx = 0.5; // requests for extra space horizontally
        gbc.weighty = 0.5; // requests for extra space vertically

        // defines the position/column of the component where it should be placed
        gbc.gridx = 0;
        gbc.gridy = 0;
        // registering the back button to an actionlistener to handle its event
        JButton back = new JButton("< BACK");
        back.setBackground(new Color(33, 2, 99));
        back.setForeground(Color.yellow);
        back.setFont(f6);
        back.addActionListener(new ActionListener() {
            // overriding the actionPerformed method which handle the event
            public void actionPerformed(ActionEvent ae) {
                new Games();
                jf.dispose();
            }
        });
        panel.add(back, gbc); // adding the button to the panel

        gbc.gridx = 1;
        gbc.gridy = 0;
        JLabel logo = new JLabel(gp_logo2); // adding the logo to the panel
        panel.add(logo, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        // a JLabel to the show the current user name in the top right corner
        JLabel cur_user = new JLabel("- " + EnterName.cur_user);
        cur_user.setForeground(Color.white);
        cur_user.setFont(f8);
        panel.add(cur_user, gbc);

        gbc.weightx = 0.0; // requests for extra space horizontally
        gbc.weighty = 0.0; // requests for extra space vertically
        gbc.gridx = 1;
        gbc.gridy = 1;
        heading = new JLabel("LEADERBOARD");
        heading.setForeground(Color.white);
        heading.setFont(f4);
        panel.add(heading, gbc);

        // calling the length method of the input class to calculate the number of names
        // and score in the file
        input.length();
        len(); // throws exception if the number of names and scores are not equal

        // taking input method of the input class to take input from the names and score
        // file and store it into the arrays
        input.TakingInput();
        // calling sort method to the sort the arrays into descending order
        input.sort();

        gbc.gridx = 1;
        gbc.gridy = 2;
        JPanel pnl = new JPanel(); // a separate panel for the top 5 scorers
        pnl.setBackground(new Color(67, 1, 115)); // setting the bgcolor of the leaderboard panel
        pnl.setLayout(new GridBagLayout()); // setting the layout of the leaderboard panel
        pnl.setBorder(BorderFactory.createLineBorder(new Color(33, 2, 99))); // setting border to the panel

        // creating an obejct of gbc to provide various values to the components to
        // modify it
        GridBagConstraints gbc1 = new GridBagConstraints();

        /***********************************
         * HIGHEST Score
         **********************************/
        gbc1.gridx = 1;
        gbc1.gridy = 0;
        JLabel first_ic = new JLabel(first_icon);
        pnl.add(first_ic, gbc1);

        gbc1.gridx = 1;
        gbc1.gridy = 1;
        JLabel first = new JLabel(input.scores[0] + "");
        first.setForeground(Color.white);
        first.setFont(f2);
        pnl.add(first, gbc1);

        gbc1.gridx = 1;
        gbc1.gridy = 2;
        JLabel first_name = new JLabel(input.names[0]);
        first_name.setFont(f2);
        first_name.setForeground(Color.white);
        pnl.add(first_name, gbc1);

        /**************************************
         * SECOND HIGHEST SCORE
         *******************************/
        gbc1.gridx = 0;
        gbc1.gridy = 3;
        JLabel second_ic = new JLabel(second_icon);
        pnl.add(second_ic, gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 4;
        JLabel second = new JLabel(input.scores[1] + "");
        second.setForeground(Color.white);
        second.setFont(f2);
        pnl.add(second, gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 5;
        JLabel second_name = new JLabel(input.names[1]);
        second_name.setForeground(Color.white);
        second_name.setFont(f2);
        pnl.add(second_name, gbc1);

        /**************************************
         * THIRD HIGHEST SCORE
         *******************************/
        gbc1.gridx = 2;
        gbc1.gridy = 3;
        JLabel third_ic = new JLabel(third_icon);
        pnl.add(third_ic, gbc1);

        gbc1.gridx = 2;
        gbc1.gridy = 4;
        JLabel third = new JLabel(input.scores[2] + "");
        third.setForeground(Color.white);
        third.setFont(f2);
        pnl.add(third, gbc1);

        gbc1.gridx = 2;
        gbc1.gridy = 5;
        JLabel third_name = new JLabel(input.names[2]);
        third_name.setForeground(Color.white);
        third_name.setFont(f2);
        pnl.add(third_name, gbc1);

        /**************************************
         * FOURTH HIGHEST SCORE
         *******************************/
        gbc1.gridx = 1;
        gbc1.gridy = 6;
        JLabel fourth = new JLabel(input.names[3] + " - " + input.scores[3]);
        fourth.setForeground(Color.white);
        fourth.setFont(f2);
        pnl.add(fourth, gbc1);

        /**************************************
         * FIFTH HIGHEST SCORE
         *******************************/
        gbc1.gridx = 1;
        gbc1.gridy = 7;
        JLabel fifth = new JLabel(input.names[4] + " - " + input.scores[4]);
        fifth.setForeground(Color.white);
        fifth.setFont(f2);
        pnl.add(fifth, gbc1);

        panel.add(pnl, gbc);// adding the leaderboard panel to the main panel

        gbc.weightx = 0.5; // requests for extra space horizontally
        gbc.weighty = 0.5; // requests for extra space vertically
        gbc.gridx = 0;
        gbc.gridy = 4;
        bth = new JButton("BACK TO HOME");
        bth.setFont(f6);
        bth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new StartWin();
                jf.dispose();
            }
        });

        panel.add(bth, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        // a button to exit the portal
        exit = new JButton("EXIT PORTAL");
        exit.setFont(f6);
        exit.setBackground(Color.red);
        exit.setForeground(Color.white);
        panel.add(exit, gbc);

        // registering the exit button to handle its event
        exit.addActionListener(new ActionListener() {
            // overriding the function to show a greeting message to the user
            public void actionPerformed(ActionEvent e) {
                // shows a greeting msg for the user
                JOptionPane.showMessageDialog(jf, "Thanku for using our PORTAL. Please Visit Again!!!", "THANK YOU!!!",
                        JOptionPane.PLAIN_MESSAGE);
                System.exit(0); // exit the program
            }
        });

        jf.add(panel); // adding panel to the Frame
        jf.setVisible(true);
    }

    // method to check and throw exception if the number of names and scores are not
    // equal
    public void len() {
        try {
            // check of the length of names and scores are same or not and throws exception
            if (input.len1 != input.len2) {
                throw new Length(input.len1, input.len2);
            }
        } catch (Length l) {
            // shows warning to the user if the length is not equal
            JOptionPane.showMessageDialog(jf, l, "Warning!!!", JOptionPane.WARNING_MESSAGE);
            // handles the exception
            if (input.len1 > input.len2) {
                input.inputScore(0);
                input.len2 = input.len1;
            } else {
                input.len2 = input.len1;
            }
        }
        // allocating memory to the names and scores array according to their
        // length(Len1 and Len2)
        input.names = new String[input.len1];
        input.scores = new int[input.len2];
    }

    public static void main(String args[]) throws Exception {
        // changing the look and feel of the gui program
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LeaderBoard();
            }
        });

    }
}

// an exception class when the length of names and scores are not same
class Length extends Exception {
    private int length1; // to store no. of names
    private int length2; // to store no. of scores

    // parameterized constructor to take values for data members
    Length(int a, int b) {
        length1 = a;
        length2 = b;
    }

    // overriding toString method to print the exception
    public String toString() {
        return "Number Of Names(" + length1 + ") is not Equal to the Number of Scores(" + length2 + ")";
    }
}