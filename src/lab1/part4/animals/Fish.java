package lab1.part4.animals;

public class Fish extends Animal {
    public Fish(String name) {
        super(name);
    }
    public String moves() {
        return "swim";
    }
    public String sound() {
        return "nothing";
    }
}