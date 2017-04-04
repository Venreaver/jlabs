package lab3.arts;

import javax.swing.*;
import java.awt.*;

public class DrawFrame extends JFrame {
    public DrawFrame () {
        super("Practice 3 frame!");
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 3, Toolkit.getDefaultToolkit().getScreenSize().height / 5);
        setSize(650, 650);
        setBackground(SystemColor.PINK);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        DrawPanel panel = new DrawPanel();
        getContentPane().add(panel);
        setVisible(true);
    }
}
