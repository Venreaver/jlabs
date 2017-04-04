package lab5.components;

import lab5.people.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class MainPanel extends JPanel implements ActionListener {
    private JMenuItem studentData, facultyData, printTheList, clearList;
    private ArrayList<Human> db;
    private HumanFrame chFrame;
    private boolean flag;
    private Font font = new Font ("Times New Roman", Font.PLAIN, 18);

    MainPanel(ArrayList<Human> db) {
        this.db = db;
        JMenuBar menuBar = new JMenuBar();
        studentData = new JMenuItem("Student Data");
        facultyData = new JMenuItem("Faculty Data");
        printTheList = new JMenuItem("Print the list");
        clearList = new JMenuItem("Clear the list");
        menuBar.add(studentData);
        menuBar.add(facultyData);
        menuBar.add(printTheList);
        menuBar.add(clearList);
        add(menuBar);
        studentData.addActionListener(this);
        facultyData.addActionListener(this);
        printTheList.addActionListener(this);
        clearList.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        boolean humanFrameOpen = chFrame != null && chFrame.getIsWindowOpen();
        if ((event.getSource() == studentData) || (event.getSource() == facultyData)) {
            if (!humanFrameOpen) {
                if (event.getSource() == studentData) {
                    chFrame = new HumanFrame("Student Frame", db);
                } else {
                    chFrame = new HumanFrame("Faculty Frame", db);
                }
                chFrame.setVisible(true);
            }
        } else if (event.getSource() == printTheList) {
            flag = true;
            repaint();
        } else if (event.getSource() == clearList) {
            flag = false;
            repaint();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(font);
        if (flag) {
            if (!db.isEmpty()) {
                g.drawString("LIST OF PEOPLE", 60,  60);
                g.drawString(db.get(0).toString(), 60,  90);
                for (int i = 1, n = db.size(); i <n; ++i) {
                    g.drawString(db.get(i).toString(), 60,  (i * 20) + 90);
                }
            }
        }
    }
}