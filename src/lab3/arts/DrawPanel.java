package lab3.arts;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class DrawPanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        Stroke pen = new BasicStroke(15);
        g2.setStroke(pen);

        for (int i = 0; i < 12; ++i) {
            Shape shape;
            int figure = (int) (Math.random() * 3);
            switch (figure) {
                case 1 :
                    shape = new Rectangle2D.Double((int) (Math.random() * 400), (int) (Math.random() * 400), (int) (Math.random() * 350), (int) (Math.random() * 280));
                    break;
                case 2 :
                    shape = new Ellipse2D.Double((int) (Math.random() * 400), (int) (Math.random() * 400), (int) (Math.random() * 350), (int) (Math.random() * 280));
                    break;
                default :
                    shape = new Line2D.Double((int) (Math.random() * 400), (int) (Math.random() * 400), (int) (Math.random() * 600), (int) (Math.random() * 600));
            }
            g2.setColor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
            g2.draw(shape);
        }
    }
}
