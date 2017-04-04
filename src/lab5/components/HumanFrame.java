package lab5.components;

import lab5.people.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class HumanFrame extends JFrame implements ActionListener, KeyListener {
    private JTextField text1, text2;
    private JButton button1, button2, button3;
    private String txt = "";
    private ArrayList<Human> db;
    private boolean isStudent;
    private boolean isWindowOpen;

    HumanFrame(String s, ArrayList<Human> db) {
        super(s);
        isWindowOpen = true;
        this.db = db;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 3 + 180, Toolkit.getDefaultToolkit().getScreenSize().height / 3);
        setSize (360, 120);
        setVisible(true);
        JLabel lb2;
        if  (s.contains("Student")) {
            lb2 = new JLabel("   Age: ");
            isStudent = true;
        } else {
            lb2 = new JLabel("   Degree: ");
        }

        text1 = new JTextField("", 12);
        text2 = new JTextField("", 7);
        button1 = new JButton("Accept");
        button2 = new JButton("Clear");
        button3 = new JButton("Close");
        add(new JLabel("Name: "));
        MyPanel jp = new MyPanel();
        jp.add(text1);
        jp.add(lb2);
        jp.add(text2);
        jp.add(button1);
        jp.add(button2);
        jp.add(button3);
        jp.add(button3);
        getContentPane().add(jp);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        text1.addKeyListener(this);
        if (isStudent) {
            text2.addKeyListener(this);
        }
    }

    private class MyPanel extends JPanel{
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString(txt, 30, 70);
        }
    }

    boolean getIsWindowOpen() {
        return isWindowOpen;
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == button1) {
            if (!text1.getText().isEmpty()) {
                if (isStudent) {
                    if (!text2.getText().isEmpty()) {
                        db.add(new Student(text1.getText(), Integer.parseInt(text2.getText())));
                        txt = "ACCEPTED";
                    }
                } else {
                    db.add(new Faculty(text1.getText(), text2.getText()));
                    txt = "ACCEPTED";
                }
            }
        } else if (event.getSource() == button2) {
            text1.setText("");
            text2.setText("");
            txt = "CLEARED";
        }
        else if (event.getSource() == button3) {
            dispose();
            isWindowOpen = false;
        }
        repaint();
    }

    public void keyTyped(KeyEvent event) {
        if (event.getSource() == text1) {
            char ch = String.valueOf(event.getKeyChar()).toLowerCase().charAt(0);
            if ((ch < 'a' || ch > 'z') && (ch < 'а' || ch >'я') && (ch != '-') && (ch != '.') && (ch != ' ')) {
                event.consume();
            }
        } else if (event.getSource() == text2) {
            char ch = event.getKeyChar();
            if (ch < '0' || ch > '9') {
                event.consume();
            }
        }
    }

    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}