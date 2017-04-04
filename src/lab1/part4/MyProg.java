package lab1.part4;

import lab1.part4.animals.*;

public class MyProg {
    public static void main(String[] args) {
        Animal[] animals = new Animal[4];
        animals[0] = new Fish("shark");
        animals[1] = new Bird("eagle");
        animals[2] = new SeaMammal("whale", "whooaa");
        animals[3] = new TerreMammal("dog", "woof");

        animals[0].output();
        System.out.println(animals[0].getName() + "'s move: " + animals[0].moves());
        System.out.println(animals[0].getName() + "'s sound: " + animals[0].sound());
        System.out.println();
        animals[1].output();
        System.out.println(animals[1].getName() + "'s move: " + animals[1].moves());
        System.out.println(animals[1].getName() + "'s sound: " + animals[1].sound());
        System.out.println();
        animals[2].output();
        System.out.println(animals[2].getName() + "'s move: " + animals[2].moves());
        System.out.println(animals[2].getName() + "'s sound: " + animals[2].sound());
        System.out.println();
        animals[3].output();
        System.out.println(animals[3].getName() + "'s move: " + animals[3].moves());
        System.out.println(animals[3].getName() + "'s sound: " + animals[3].sound());
    }
}