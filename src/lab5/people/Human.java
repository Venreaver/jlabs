package lab5.people;

public abstract class Human {
    private String name;
    protected Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }
}