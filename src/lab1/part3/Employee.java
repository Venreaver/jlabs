package lab1.part3;

class Employee {
    private static int currentId = 0;
    private int id;
    private String name;
    private String position = "worker";
    private int salary = 5000;

    public Employee(String name) {
        this.name = name;
        id = ++currentId;
    }

    public Employee(String name, String position) {
        this(name);
        if (!this.position.equals(position)) {
            this.position = position;
            salary = 6000;
        }
    }

    public Employee(String name, String position, int salary) {
        this(name);
        this.position = position;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(int sal) {
        salary = sal;
    }

    public String toString() {
        return "ID number: " + id + "  name: " + name + "  position: " + position + "  salary: " + salary;
    }

    public static void printEmps(Employee[] emps) {
        for (Employee e : emps) {
            System.out.println(e);
        }
    }

    public static int sumSal(Employee[] emps) {
        int sum = 0;
        for (Employee e : emps) {
            sum += e.getSalary();
        }
        return sum;
    }

    public static Employee maxSalEmp(Employee[] emps) {
        int x = 0;
        for (int i = 1; i < emps.length; ++i) {
            if (emps[x].salary < emps[i].salary) {
                x = i;
            }
        }
        return emps[x];
    }
}