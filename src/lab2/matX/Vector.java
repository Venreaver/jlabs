package lab2.matX;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Vector extends Matrix {

    // конструктор нулевой вектор
    public Vector(int x, boolean flag) {
        super(x, 1, flag);
    }

    // конструктор
    public Vector(int x) {
        super(x, 1);
    }

    // Создание вектора из одномерного массива
    public Vector(int[] array) {
        this(array.length, false);
        for (int i = 0; i < array.length; ++i) {
            setField(i, array[i]);
        }
    }

    // получить поле
    public int getField(int indX) throws IndexOutOfBoundsException {
        return getField(indX, 0);
    }

    // изменить поле
    public void setField(int indX, int value) throws IndexOutOfBoundsException {
        setField(indX, 0, value);
    }

    // сложение матриц
    public static Vector add(Vector a, Vector b) throws MatrixException {
        if ((a.getRows() != b.getRows())) {
            throw new MatrixException("Ranges of vectors aren't equal!");
        }
        Vector res = new Vector(b.getRows(), false);
        for (int i = 0, ln = b.getRows(); i < ln; ++i) {
            res.setField(i, a.getField(i) + b.getField(i));
        }
        return res;
    }

    // вычитание матриц
    public static Vector subtract(Vector a, Vector b) throws MatrixException {
        if ((a.getRows() != b.getRows())) {
            throw new MatrixException("Ranges of vectors aren't equal!");
        }
        Vector res = new Vector(b.getRows(), false);
        for (int i = 0, ln = b.getRows(); i < ln; ++i) {
            res.setField(i, a.getField(i) - b.getField(i));
        }
        return res;
    }

    // чтение матрицы из файла
    public static Vector read(String fileName) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String line;
        ArrayList<String> list = new ArrayList<>();
        while ((line = fileReader.readLine()) != null) {
            list.add(line);
        }
        fileReader.close();
        Vector res = new Vector(list.size(), false);
        for (int i = 0; i < res.getRows(); ++i) {
            res.setField(i, Integer.parseInt(list.get(i)));
        }
        return res;
    }

    // длина вектора
    public int length() {
        int length = 0;
        for (int i = 0, ln = getRows(); i < ln; ++i) {
            length += Math.pow(getField(i), 2);
        }
        return (int) Math.sqrt(length);
    }
}