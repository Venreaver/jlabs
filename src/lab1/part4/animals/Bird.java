package lab1.part4.animals;

public class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }
    public String moves() {
        return "fly";
    }
    public String sound() {
        return "Chirp!";
    }
}