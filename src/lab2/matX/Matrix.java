package lab2.matX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Matrix {
    private int n;
    private int m;
    private int[][] data;

    // Создание 0вой матрицы
    public Matrix(int x, int y, boolean flag) {
        n = x;
        m = y;
        data = new int[n][m];
    }

    // Создание 0вой матрицы и заполнение ее
    public Matrix(int x, int y) {
        n = x;
        m = y;
        data = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                data[i][j] =  (int) (Math.random() * 10) - 2 + 4;
            }
        }
    }

    // Создание матрицы NxN
    public Matrix(int x) {
        this(x, x);
    }

    // Создание нулевой матрицы NxN
    public Matrix(int x, boolean flag) {
        this(x, x, flag);
    }

    // Создание матрицы из двумерного массива
    public Matrix(int[][] array) {
        n = array.length;
        m = array[0].length;
        for (int i = 1; i < array.length; ++i) {
            if (array[i].length > m) {
                m = array[i].length;
            }
        }
        data = new int[n][m];
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[i].length; ++j) {
                data[i][j] = array[i][j];
            }
        }
    }

    // получить значение поля матрицы
    public int getField(int indX, int indY) throws IndexOutOfBoundsException {
        return data[indX][indY];
    }

    // получить количество строк в матрице
    public int getRows() {
        return n;
    }

    // получить количество столбцов в матрице
    public int getColumns() {
        return m;
    }

    // получить двумерный массив-матрицу
    public int[][] getData() {
        int[][] array = new int[n][m];
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[i].length; ++j) {
                array[i][j] = data[i][j];
            }
        }
        return array;
    }

    // изменить значение поля матрицы
    public void setField(int indX, int indY, int value) throws IndexOutOfBoundsException {
        data[indX][indY] = value;
    }

    // вывод матрицы на экран
    public void output() {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    // сложение матриц
    public static Matrix add(Matrix a, Matrix b) throws MatrixException {
        if ((a.m != b.m) || (a.n != b.n)) {
            throw new MatrixException("Ranges of matrices aren't equal!");
        }
        Matrix res = new Matrix(a.n, a.m, false);
        for (int i = 0; i < a.n; ++i) {
            for (int j = 0; j < a.m; ++j) {
                res.data[i][j] = a.data[i][j] + b.data[i][j];
            }
        }
        return res;
    }

    // вычитание матриц
    public static Matrix subtract(Matrix a, Matrix b) throws MatrixException {
        if ((a.m != b.m) || (a.n != b.n)) {
            throw new MatrixException("Ranges of matrices aren't equal!");
        }
        Matrix res = new Matrix(a.n, a.m, false);
        for (int i = 0; i < a.n; ++i) {
            for (int j = 0; j < a.m; ++j) {
                res.data[i][j] = a.data[i][j] - b.data[i][j];
            }
        }
        return res;
    }

    // сравнение матриц статическим методом
    public static boolean equal(Matrix a, Matrix b) {
        if ((a.m != b.m) || (a.n != b.n)) {
            return false;
        }
        for (int i = 0; i < a.n; ++i) {
            for (int j = 0; j < a.m; ++j) {
                if (a.data[i][j] != b.data[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // сравнение матриц
    public boolean equals(Matrix a) {
        if ((a.m != m) || (a.n != n)) {
            return false;
        }
        for (int i = 0; i < a.n; ++i) {
            for (int j = 0; j < a.m; ++j) {
                if (a.data[i][j] != data[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // чтение матрицы из файла
    public static Matrix read(String fileName) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String line;
        ArrayList<String[]> list = new ArrayList<>();
        while ((line = fileReader.readLine()) != null) {
            list.add(line.split(" "));
        }
        fileReader.close();
        Matrix res = new Matrix(list.size(), list.get(0).length, false);
        for (int i = 0; i < res.n; ++i) {
            for (int j = 0; j < res.m; ++j) {
                res.setField(i, j, Integer.parseInt(list.get(i)[j]));
            }
        }
        return res;
    }

    // запись матрицы в файл
    public void write(String fileName) throws IOException {
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
        String line = "";
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                line += data[i][j] + " ";
            }
            fileWriter.write(line.trim());
            line = "";
            if (i == n - 1) {
                continue;
            }
            fileWriter.newLine();
        }
        fileWriter.close();
    }
}