package lab5.components;

import lab5.people.Human;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    public MainFrame(ArrayList<Human> db) {
        super("DS&A. Assignment");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        MainPanel testPanel = new MainPanel(db);
        getContentPane().add(testPanel);
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 3 + 150, Toolkit.getDefaultToolkit().getScreenSize().height / 3);
        setSize (400, 500);
        setVisible(true);
    }
}