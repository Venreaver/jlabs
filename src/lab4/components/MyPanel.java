package lab4.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

class MyPanel extends JPanel implements ActionListener {
    private String text = "No button was pressed";
    private Line2D line;
    private Color color = new Color(105, 100, 220);
    private JButton button1, button2, button3, button4, button5, button6, button7, button8;
    private Stroke pen = new BasicStroke(10);
    private Stroke zero = new BasicStroke();
    private Font font = new Font ("Times New Roman", Font.BOLD, 20);

    public MyPanel() {
        button1 = new JButton("ВЫШЕ");
        button2 = new JButton("НИЖЕ");
        button3 = new JButton("ЛЕВЕЕ");
        button4 = new JButton("ПРАВЕЕ");
        button5 = new JButton("СВЕТЛЕЕ");
        button6 = new JButton("ТЕМНЕЕ");
        button7 = new JButton("Вращение по часовой стрелке");
        button8 = new JButton("Вращение против часовой стрелки");

        JPanel northButtons = new JPanel();
        JPanel southButtons = new JPanel();

        northButtons.setLayout(new FlowLayout(FlowLayout.CENTER));
        southButtons.setLayout(new FlowLayout(FlowLayout.CENTER));

        northButtons.add(button3);
        northButtons.add(button1);
        northButtons.add(button5);
        northButtons.add(button7);
        southButtons.add(button8);
        southButtons.add(button6);
        southButtons.add(button2);
        southButtons.add(button4);

        setLayout(new BorderLayout());
        add(northButtons, BorderLayout.NORTH);
        add(southButtons, BorderLayout.SOUTH);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);

        line = new Line2D.Double(150, 150, 450, 450);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(font);
        g.drawString(text, 75, 550);
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(pen);
        g2.setColor(color);
        g2.draw(line);
        g2.setStroke(zero);
    }

    public void actionPerformed(ActionEvent event) {
        int r = color.getRed(), g = color.getGreen(), b = color.getBlue();
        int x = (int) ((line.getX1() + line.getX2()) / 2);
        int y = (int) ((line.getY1() + line.getY2()) / 2);
        double x1 = line.getX1(), y1 = line.getY1(), x2 = line.getX2(), y2 = line.getY2();

        if (event.getSource() == button1) {
            --y1;
            --y2;
        } else if (event.getSource() == button2) {
            ++y1;
            ++y2;
        } else if (event.getSource() == button3) {
            --x1;
            --x2;
        } else if (event.getSource() == button4) {
            ++x1;
            ++x2;
        } else if (event.getSource() == button5) {
            if (r < 245) {
                r += 10;
            } else {
                r = 255;
            }
            if (g < 245) {
                g += 10;
            } else {
                g = 255;
            }
            if (b < 245) {
                b += 10;
            } else {
                b = 255;
            }
        } else if (event.getSource() == button6) {
            if (r > 10) {
                r -= 10;
            } else {
                r = 0;
            }
            if (g > 10) {
                g -= 10;
            } else {
                g = 0;
            }
            if (b > 10) {
                b -= 10;
            } else {
                b = 0;
            }
        } else if (event.getSource() == button7) {
            x1 = x - Math.sin(0.12) * (line.getY1() - y)
                    + Math.cos(0.12) * (line.getX1() - x);
            y1 = y + Math.cos(0.12) * (line.getY1() - y)
                    + Math.sin(0.12) * (line.getX1() - x);
            x2 = x - Math.sin(0.12) * (line.getY2() - y)
                    + Math.cos(0.12) * (line.getX2() - x);
            y2 = y + Math.cos(0.12) * (line.getY2() - y)
                    + Math.sin(0.12) * (line.getX2() - x);
        } else if (event.getSource() == button8) {
            x1 = x - Math.sin(- 0.12) * (line.getY1() - y)
                    + Math.cos(- 0.12) * (line.getX1() - x);
            y1 = y + Math.cos(- 0.12) * (line.getY1() - y)
                    + Math.sin(- 0.12) * (line.getX1() - x);
            x2 = x - Math.sin(- 0.12) * (line.getY2() - y)
                    + Math.cos(- 0.12) * (line.getX2() - x);
            y2 = y + Math.cos(- 0.12) * (line.getY2() - y)
                    + Math.sin(- 0.12) * (line.getX2() - x);
        }
        line.setLine(x1, y1, x2, y2);
        color = new Color(r, g, b);
        text = "Кнопка \"" +  ((JButton) event.getSource()).getText() + "\" была нажата";
        repaint();
    }
}