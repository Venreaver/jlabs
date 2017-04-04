package lab1.part3;

public class MyProg {
    public static void main(String[] args) {
        Employee[] arEmp = new Employee[10];
        arEmp[0] = new Employee("Alina");
        arEmp[1] = new Employee("Alex", "worker");
        arEmp[2] = new Employee("Max", "manager");
        arEmp[3] = new Employee("Ivan");
        arEmp[4] = new Employee("Irina", "programmer");
        arEmp[5] = new Employee("Jhon", "manager", 7000);
        arEmp[6] = new Employee("Garry");
        arEmp[7] = new Employee("Tom", "boss", 10000);
        arEmp[8] = new Employee("Silvia", "secretary", 4000);
        arEmp[9] = new Employee("Anna", "worker", 5500);

        Employee.printEmps(arEmp);
        System.out.println("Summary salary of employees is " + Employee.sumSal(arEmp));
        System.out.println("Position with max salary of employees is " + Employee.maxSalEmp(arEmp).getPosition());
    }
}