package lab1.part4.animals;

abstract public class Animal {
    private String name;
    public Animal(String name) {
        this.name = name;
    }
    abstract public String moves();
    abstract public String sound();
    public void output() {
        System.out.println(name + " " + getClass());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}