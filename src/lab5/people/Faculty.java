package lab5.people;

public class Faculty extends Human {
    private String degree;

    public Faculty(String name, String degree) {
        super(name);
        this.degree = degree;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String newDegree) {
        degree = newDegree;
    }

    public String toString(){
        return "Faculty: " + getName() + "       Degree: " + degree;
    }
}