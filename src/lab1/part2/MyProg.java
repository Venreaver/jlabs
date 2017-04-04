package lab1.part2;

import javax.swing.*;

public class MyProg {
    public static void main(String[] args) {
        int a = Integer.parseInt(JOptionPane.showInputDialog("Input an integer"));
        int[][] ar = new int[a][];
        for (int i = 0; i < ar.length; ++i) {
            ar[i] = new int[i + 1];
            for (int j = 0; j < ar[i].length; ++j) {
                ar[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Input an integer"));
                System.out.print(ar[i][j] + " ");
            }
            System.out.println();
        }
        MyProg.closeToTen(ar);
    }

    public static void closeToTen(int[][] array) {
        int x = 0, y = 0;
        for (int i = 1; i < array.length; ++i) {
            for (int j = 0; j < array[i].length; ++j) {
                if (Math.abs(array[x][y] - 10) > Math.abs(array[i][j] - 10)) {
                    x = i; y = j;
                }
            }
            if (array[x][y] == 10) {
                break;
            }
        }
        System.out.print("Closest element to 10 is array[" + x + "][" + y + "] = " + array[x][y]);
    }
}