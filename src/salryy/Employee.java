package salryy;



public abstract class Employee {
    public String name;

    public Employee(String name) {
        this.name = name;
    }



    public abstract double calculateSalary();
}



