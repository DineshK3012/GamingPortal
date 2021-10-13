package GamingPortal;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/** main class of the snake game */
public class Snake extends Frame {
    static JFrame ex;

    public Snake() {
        ex = new JFrame("SNAKE");
        initUI();
        ex.setVisible(true);

        // setting the snake game window icon
        ImageIcon sni = new ImageIcon("snake_icon.jpg");
        ex.setIconImage(sni.getImage());

        ex.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                new Games();
                ex.dispose();
            }
        });
    }

    private void initUI() {
        ex.add(new Board());

        ex.setResizable(false);
        ex.pack();
        ex.setLocation(100, 20);
    }

    public static void stop() {
        ex.dispose();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new Snake();
        });
    }
}
