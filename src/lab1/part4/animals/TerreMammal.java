package lab1.part4.animals;

public class TerreMammal extends Mammal {
    public TerreMammal(String name, String sound) {
        super(name, sound);
    }
    public String moves() {
        return "run";
    }
}