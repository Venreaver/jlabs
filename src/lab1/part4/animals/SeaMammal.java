package lab1.part4.animals;

public class SeaMammal extends Mammal {
    public SeaMammal(String name, String sound) {
        super(name, sound);
    }
    public String moves() {
        return "swim";
    }
}