package GamingPortal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventDemo {

    JLabel jl;

    EventDemo() {
        JFrame jf = new JFrame("An Event Example");

        jf.setLayout(new FlowLayout());
        jf.setSize(220, 90);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton jb1 = new JButton("Alpha");
        JButton jb2 = new JButton("Beta");

        jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                jl.setText("Alpha is Pressed");
            }
        });

        jb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                jl.setText("Beta is pressed");
            }
        });

        jf.add(jb1);
        jf.add(jb2);

        jl = new JLabel("Press a Button");
        jf.add(jl);

        jf.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                new EventDemo();
            }

        });
    }

}
