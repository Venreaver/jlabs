package lab5.people;

public class Student extends Human {
    private int age = 22;
    public Student(String name, int age) {
        super(name);
        if ((age > 16) && (age < 100)) {
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        age = newAge;
    }

    public String toString(){
        return "Student: " + getName() + "       Age: " + age;
    }
}