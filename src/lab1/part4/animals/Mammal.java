package lab1.part4.animals;

abstract public class Mammal extends Animal {
    String sound;
    public Mammal(String name, String sound) {
        super(name);
        this.sound = sound;
    }
    public String sound() {
        return sound;
    }
}