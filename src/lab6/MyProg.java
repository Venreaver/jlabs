package lab6;

public class MyProg {

    public static void main(String[] args) {
        Database myDB = new Database();
        Reader reader1 = new Reader(1, myDB);
        Reader reader2 = new Reader(2, myDB);
        Reader reader3 = new Reader(3, myDB);
        Reader reader4 = new Reader(4, myDB);
        Reader reader5 = new Reader(5, myDB);
        Writer writer1 = new Writer(1, myDB);
        Writer writer2 = new Writer(2, myDB);
        Writer writer3 = new Writer(3, myDB);
        Writer writer4 = new Writer(4, myDB);
        reader1.start();
        reader2.start();
        reader3.start();
        reader4.start();
        reader5.start();
        writer1.start();
        writer2.start();
        writer3.start();
        writer4.start();
    }
}


class Reader extends Thread {
    public Reader(int r, Database db) {
        readerNum = r;
        server = db;
    }

    public void run() {
        int c;
        for (int i = 1; i <= 3; i++)
        {
            napping();
            System.err.println("reader " + readerNum + " wants to read.");

            c = server.startRead();
            System.err.println("reader " + readerNum + " is reading. Reader Count = " + c);
            Database.something();

            c = server.endRead();
        }
    }

    public void napping() {
        try {
            sleep((int) (Math.random() * 2000));
        } catch (InterruptedException e) {
        }
    }

    private Database server;
    private int readerNum;
}


class Writer extends Thread {
    public Writer(int w, Database db) {
        writerNum = w;
        server = db;
    }

    public void run() {
        for (int i = 1; i <= 3; i++)
        {
            napping();
            System.err.println("writer " + writerNum + " wants to write.");
            server.startWrite();

            System.err.println("-------------- WRITER " + writerNum + " IS WRITING.");
            Database.something();

            System.err.println("               writer " + writerNum + " is done writing.");
            server.endWrite();
        }
    }

    public void napping() {
        try {
            sleep((int) (Math.random() * 2000));
        } catch (InterruptedException e) {
        }
    }

    private Database server;
    private int writerNum;
}


class Database {
    private int readerCount;
    Semaphore semWriting;
    Semaphore semReader;

    public Database() {
        readerCount = 0;
        semWriting = new Semaphore(1);
        semReader = new Semaphore(1);
    }

    public static void something() {
        try {
            Thread.sleep((int) (Math.random() * 2000));
        } catch (InterruptedException e) {
        }
    }

    public int startRead() {
        semReader.P();
        ++readerCount;
        if (readerCount == 1) {
            semWriting.P();
        }
        semReader.V();
        return readerCount;
    }

    public int endRead() {
        semReader.P();
        --readerCount;
        if (readerCount == 0) {
            semWriting.V();
        }
        System.err.println("Reader is done reading. Count = " + readerCount);
        semReader.V();
        return readerCount;
    }

    public void startWrite() {
        semWriting.P();
    }

    public void endWrite() {
        semWriting.V();
    }
}

class Semaphore {
    private int value;

    public Semaphore(int v) {
        value = v;
    }

    public synchronized void P() {
        value--;
        if (value < 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }

    public synchronized void V() {
        ++value;
        if (value <= 0){
            notify();
        }
    }
}