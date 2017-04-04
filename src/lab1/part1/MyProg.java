package lab1.part1;

import javax.swing.*;

public class MyProg {
    public static void main(String[] args) {
        int a = Integer.parseInt(JOptionPane.showInputDialog("Input an integer"));
        int b = Integer.parseInt(JOptionPane.showInputDialog("Input an integer"));
        int c = Integer.parseInt(JOptionPane.showInputDialog("Input an integer"));
        if (a > b) {
            a += b;
            b = a - b;
            a -= b;
        }
        if (b > c) {
            b += c;
            c = b - c;
            b -= c;
        }
        if (a > b) {
            a += b;
            b = a - b;
            a -= b;
        }
        System.out.println(a + " " + b + " " + c);
    }
}