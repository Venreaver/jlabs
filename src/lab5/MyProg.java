package lab5;

import lab5.components.MainFrame;
import lab5.people.Human;
import java.util.ArrayList;

public class MyProg {
    public static void main(String[] args) {
        ArrayList<Human> db = new ArrayList<>();
        new MainFrame(db);
    }
}