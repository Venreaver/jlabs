package lab2;

import lab2.matX.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MyProg {
    public static void main(String[] args) {
        Matrix mt = new Matrix(2, 3);
        mt.output();
        System.out.println();

        int[][] array = mt.getData();
        for (int[] ar : array) {
            for (int el : ar) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
        System.out.println();

        Matrix mtx = new Matrix(array);

        System.out.println(mtx.equals(mt));
        System.out.println(Matrix.equal(mt, mtx));

        array[0][0] = -1000;
        for (int[] ar : array) {
            for (int el : ar) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
        System.out.println();
        mt.output();
        System.out.println();
        try {
            mt.setField(1, 0, 200);
            System.out.println(mt.getField(2, 0));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index is out of range");
        }
        mt.output();
        System.out.println();

        Matrix one = new Matrix(5, 4);
        one.output();
        System.out.println();
        Matrix two = new Matrix(5, 4);
        two.output();
        System.out.println();
        Matrix three = new Matrix(5);
        three.output();
        System.out.println();
        try {
            Matrix four = Matrix.add(one, three);
            four.output();
        } catch (MatrixException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        try {
            Matrix five = Matrix.subtract(one, two);
            five.output();
        } catch (MatrixException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println(one.equals(two));
        System.out.println(Matrix.equal(three, two));

        String fileName = "E:\\Text\\jlabs_2016\\files\\matrix.txt";
        try {
            Matrix newOne = Matrix.read(fileName);
            newOne.output();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        catch (IOException e) {
            System.out.println("IO error!");
        }
        System.out.println();
        three.output();
        System.out.println();
        fileName = "E:\\Text\\jlabs_2016\\files\\matrix1.txt";
        try {
            three.write(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        catch (IOException e) {
            System.out.println("IO error!");
        }

        Vector v = new Vector(6);
        Vector v1 = new Vector(4);
        Vector v2 = new Vector(7);
        Vector v3 = new Vector(4);

        fileName = "E:\\Text\\jlabs_2016\\files\\vector.txt";
        try {
            v.write(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        catch (IOException e) {
            System.out.println("IO error!");
        }

        try {
            Vector v4 = Vector.add(v1, v3);
            Vector v5 = Vector.add(v1, v3);
            v4.output();
            System.out.println(v4.equals(v5));
            System.out.println(Vector.equal(v4, v5));
        } catch (MatrixException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        try {
            Vector v6 = Vector.subtract(v2, v3);
            v6.output();
        } catch (MatrixException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println(v1.equals(v3));
        System.out.println(Vector.equal(v1, v3));
        System.out.println();

        try {
            Vector v7 = Vector.read(fileName);
            v7.output();
            System.out.println("Vector's v7 length is: " + v7.length());
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        catch (IOException e) {
            System.out.println("IO error!");
        }
        System.out.println();
    }
}