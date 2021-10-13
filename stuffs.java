package GamingPortal;

//importing classes 
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * a class for stuffs like images, fonts, logos and gradients used in this
 * project
 */
public class stuffs {

    /**********************************
     * Gradient Panel to set gradient color in the background
     **************************************/

    JPanel panel = new JPanel() {
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();

            Color color1 = new Color(33, 2, 99);
            Color color2 = new Color(67, 1, 115);
            GradientPaint gp = new GradientPaint(0, 0, color1, 180, height, color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, width, height);
        }
    };

    /*********************************
     * IMAGES used in the porject
     **************************************/
    ImageIcon gp = new ImageIcon("gp_icon.png");
    ImageIcon gp_logo = new ImageIcon("gp_logo.png");
    ImageIcon gp_logo1 = new ImageIcon("gp_logo1.png");
    ImageIcon gp_logo2 = new ImageIcon("gp_logo2.png");

    ImageIcon start_b = new ImageIcon("Start5.png");

    ImageIcon img = new ImageIcon("illustration.png");

    ImageIcon sn_game = new ImageIcon("snakegame2.png");
    ImageIcon su_game = new ImageIcon("sudoku3.png");

    ImageIcon first_icon = new ImageIcon("goldmedal2.png");
    ImageIcon second_icon = new ImageIcon("silvermedal2.png");
    ImageIcon third_icon = new ImageIcon("bronzemedal2.png");

    /*********************************
     * FONTS used in the Project
     **************************************/

    Font f0 = new Font("Serif", Font.ITALIC, 30);

    Font f = new Font("Serif", Font.BOLD, 40);
    Font f1 = new Font("Serif", Font.ITALIC, 20);
    Font f3 = new Font("Serif", Font.BOLD, 70);

    Font f4 = new Font("Britannic Bold", Font.BOLD, 60);
    Font f5 = new Font("Candara Light", Font.PLAIN, 30);
    Font f2 = new Font("Serif", Font.BOLD, 20);
    Font f6 = new Font("SansSerif", Font.BOLD, 15);

    Font f7 = new Font("Serif", Font.PLAIN, 25);
    Font f8 = new Font("Monospaced", Font.BOLD, 15);
    // Font f9 = new Font("Serif", Font.BOLD, 50);

    Font f9 = new Font("Monospaced", Font.BOLD, 100);
    // SansSerif //Serif //Dialog //Monospaced //
}
