package GamingPortal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** a class for the Board of the Snake game */
public class Board extends JPanel implements ActionListener {

    JPanel jp = this;

    private final int B_WIDTH = 800;
    private final int B_HEIGHT = 660;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = 2500;
    private final int RAND_POS = 29;
    private final int DELAY = 150;
    private int z = DELAY;

    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];

    private int dots;
    private int apple_x;
    private int apple_y;

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;
    private boolean s = false;

    private Timer timer;
    private Image ball;
    private Image apple;
    private Image head;

    public Board() {
        initBoard();
        // calling the highscore method of the input class to read the highscore from
        // the file
        input.highScore();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        initGame();
    }

    private void loadImages() {

        ImageIcon iid = new ImageIcon("dot.png");
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon("Apple1.png");
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon("head.png");
        head = iih.getImage();
    }

    private void initGame() {
        dots = 3;
        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }

        locateApple();
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {

        if (inGame) {
            // callling the method which prints current score and high score
            BestScore(g);
            g.drawImage(apple, apple_x, apple_y, this);

            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this);
                } else {
                    g.drawImage(ball, x[z], y[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {
            gameOver(g);

            // shows an option to the player if he wants to play again or not
            int selc = JOptionPane.showConfirmDialog(this, "Do you want to play again?", "Play Again",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            // starts the game again if the user chooses yes
            if (selc == JOptionPane.YES_OPTION) {
                Snake.stop();
                new Snake();
            } else {
                // stops the game calculate the score, write it into the file and open the
                // leaderboard if user choosed no
                Snake.stop();
                input.inputScore(score());
                new LeaderBoard();
            }
        }
    }

    // method to show the game over msg
    private void gameOver(Graphics g) {
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
    }

    /***************************
     * METHOD TO SHOW HIGHSCORE, CURRENT SCORE AND lEVEL UP NOTIC
     **************************/
    private void BestScore(Graphics g) {
        int yourScore = score();
        String msg = "";

        // Check if the current score is greater than highscore or not
        if ((input.HighestScore + 10) == yourScore) {
            // prints a msg if the player scored a new High score
            String msg2 = "🎉New High Score🎉";
            Font small = new Font("Helvetica", Font.BOLD, 20);
            g.setColor(Color.white);
            g.setFont(small);
            g.drawString(msg2, (B_WIDTH - 140) / 2, B_HEIGHT / 2);
        }

        // prints the level up msg for the player
        if (s) {
            String msg3 = "LEVEL UP";
            Font small = new Font("Helvetica", Font.BOLD, 20);
            g.setColor(Color.white);
            g.setFont(small);
            g.drawString(msg3, (B_WIDTH - 140) / 2, B_HEIGHT - 40 / 2);
        }

        // prints the current score and highscore in the top left corner of the game
        if (yourScore <= input.HighestScore) {
            msg = "Highest Score: " + input.HighestScore;
        } else {
            msg = "Highest Score: " + score();
        }
        Font small = new Font("Helvetica", Font.BOLD, 14);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, 20, 20);

        // prints the current score of the player
        String msg1 = "Your Score: " + yourScore;
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg1, 20, 40);
    }

    private void checkApple() {

        if ((x[0] == apple_x) && (y[0] == apple_y)) {

            dots++;
            s = level();
            locateApple();
        }
    }

    private void move() {

        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
        }

        if (upDirection) {
            y[0] -= DOT_SIZE;
        }

        if (downDirection) {
            y[0] += DOT_SIZE;
        }
    }

    private void checkCollision() {

        for (int z = dots; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }

        if (y[0] >= B_HEIGHT) {
            inGame = false;
        }

        if (y[0] < 0) {
            inGame = false;
        }

        if (x[0] >= B_WIDTH) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }

        if (!inGame) {
            timer.stop();
        }
    }

    private void locateApple() {

        int r = (int) (Math.random() * RAND_POS);
        apple_x = ((r * DOT_SIZE));

        r = (int) (Math.random() * RAND_POS);
        apple_y = ((r * DOT_SIZE));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {
            checkApple();
            checkCollision();
            move();
        }
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            // defining space key to pause the game
            if (key == KeyEvent.VK_SPACE) {
                timer.stop();
                // shows a pause msg to the player when he/she type space to pause the game
                JOptionPane.showMessageDialog(jp, "Game is Paused. CLICK on OK to Resume the Game", "PLAY/PAUSE",
                        JOptionPane.PLAIN_MESSAGE);
                timer.start();
            }
        }
    }

    /********************
     * Method to increase the speed of the snake according the level
     ************************/
    private boolean level() {
        if (score() % 50 == 0) {
            z = z - 30; // decreasing the delay time to increase the speed of the snake
            timer.setDelay(z);
            return true;
        }
        return false;
    }

    /*******************************
     * Method to Calculate the Score of the Player
     ****************************/
    private int score() {
        int s = 0;
        s = (dots - 3) * 10;

        return s;
    }
}