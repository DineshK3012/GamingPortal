package GamingPortal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Main class of sudoku game
 *
 */
public class Sudoku {

    static JFrame jf;

    public Sudoku() {
        jf = new JFrame("SUDOKU");

        jf.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                new Games();
                jf.dispose();
            }
        });

        jf.getContentPane().setLayout(new BorderLayout());
        ImageIcon sui = new ImageIcon("sudoku_icon.jpg");
        jf.setIconImage(sui.getImage());

        Game game = new Game();

        ButtonController buttonController = new ButtonController(game);
        ButtonPanel buttonPanel = new ButtonPanel();
        buttonPanel.setController(buttonController);
        jf.add(buttonPanel, BorderLayout.EAST);

        SudokuPanel sudokuPanel = new SudokuPanel();
        SudokuController sudokuController = new SudokuController(sudokuPanel, game);
        sudokuPanel.setGame(game);
        sudokuPanel.setController(sudokuController);
        jf.add(sudokuPanel, BorderLayout.CENTER);

        game.addObserver(buttonPanel);
        game.addObserver(sudokuPanel);

        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

    public static void exit() {
        jf.dispose();
    }

    /**
     * Main entry point of program.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        new Sudoku();
    }
}
