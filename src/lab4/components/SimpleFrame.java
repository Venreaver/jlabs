package lab4.components;

import javax.swing.*;
import java.awt.*;

public class SimpleFrame extends JFrame {
    public SimpleFrame() {
        super("Practice 4 frame!");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        MyPanel buttonPanel = new MyPanel();
        getContentPane().add(buttonPanel);
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 3, Toolkit.getDefaultToolkit().getScreenSize().height / 5);
        setSize(650, 650);
        setVisible(true);
    }
}