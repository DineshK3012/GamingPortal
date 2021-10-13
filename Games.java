package GamingPortal;

//importing packages
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** a class which all the games available in the portal for the user to play */
public class Games extends stuffs {
    // coonstructor for the class
    public Games() {
        // creating the object of a JFrame
        JFrame jf = new JFrame("GAMING PORTAL - Games");
        jf.setSize(new Dimension(1200, 650));
        jf.setLocation(10, 20);
        jf.setResizable(false);
        jf.setIconImage(gp.getImage());
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creating an object of the gridbaglayout
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setLayout(gb); // setting the layout of the panel to the gridbaglayout

        gbc.weightx = 0.1; // requests for extra space horizontally
        gbc.weighty = 0.1; // requests for extra space vertically

        // defines the position/column of the component where it should be placed
        gbc.gridx = 0;
        gbc.gridy = 0;
        JButton back = new JButton("< BACK");
        back.setBackground(new Color(33, 2, 99));
        back.setForeground(Color.yellow);
        back.setFont(f6);

        // registering the back button to an actionlistener to handle its event
        back.addActionListener(new ActionListener() {
            // overriding the actionPerformed method which handle the event
            public void actionPerformed(ActionEvent ae) {
                new EnterName();
                jf.dispose();
            }
        });
        panel.add(back, gbc); // adding the button to the panel

        gbc.gridx = 1;
        gbc.gridy = 0;
        JLabel logo = new JLabel(gp_logo2);
        panel.add(logo, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        // a JLabel to the show the current user name in the top right corner
        JLabel cur_user = new JLabel("- " + EnterName.cur_user);
        cur_user.setForeground(Color.white);
        cur_user.setFont(f8);
        panel.add(cur_user, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        JLabel hello = new JLabel("WELCOME");
        hello.setForeground(Color.white);
        hello.setFont(f3);
        panel.add(hello, gbc);

        gbc.weightx = 0.1; // requests for extra space horizontally
        gbc.weighty = 0.1; // requests for extra space vertically
        gbc.gridx = 1;
        gbc.gridy = 2;
        JLabel p = new JLabel("Please CLICK on the Game you want to Play!!!");
        p.setForeground(Color.white);
        p.setFont(f7);
        panel.add(p, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel il = new JLabel(img);
        panel.add(il, gbc);

        // a separate panel for the games
        JPanel jp = new JPanel();
        jp.setBackground(new Color(67, 1, 115)); // setting the background color of the user
        jp.setBorder(BorderFactory.createLineBorder(new Color(33, 2, 99), 3)); // creating a line border for the layout

        // a button to play the snake game
        JButton snake_game = new JButton(sn_game);
        snake_game.setToolTipText("Click To Start Snake Game"); // a tip for the user
        snake_game.setBackground(new Color(33, 2, 99));
        // handling the event for the snake game button
        snake_game.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
                new SnakeLoadWin();
            }
        });
        jp.add(snake_game); // adding the game button to the panel

        // a button to play the snake game
        JButton sudoku_game = new JButton(su_game);
        sudoku_game.setToolTipText("Click To Start Sudoku Game"); // a tip for the user
        sudoku_game.setBackground(new Color(33, 2, 99));
        // handling the event for the sudoku game button
        sudoku_game.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
                new sudokuLoadWin();
            }
        });
        jp.add(sudoku_game); // adding the game button to the panel

        gbc.weighty = 0.1; // requests for extra space vertically
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(jp, gbc); // aadding the games panel to the main panel

        gbc.gridx = 0;
        gbc.gridy = 4;
        // a button to go for the leaderboard
        JButton ld_BoardButton = new JButton("LEADERBOARD");
        ld_BoardButton.setFont(f6);
        panel.add(ld_BoardButton, gbc);
        // handling the leaderboardbutton event
        ld_BoardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new LeaderBoard();
                jf.dispose();
            }
        });

        gbc.gridx = 2;
        gbc.gridy = 4;
        // a button to exit the portal
        JButton exit = new JButton(" EXIT PORTAL ");
        exit.setFont(f6);
        exit.setBackground(Color.red);
        exit.setForeground(Color.white);
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

        // adding the panel to the frame
        jf.add(panel);
        jf.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        // changing the look and feel of the gui program
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Games();
            }
        });
    }
}