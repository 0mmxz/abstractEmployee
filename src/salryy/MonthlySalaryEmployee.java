package salryy;

public class MonthlySalaryEmployee extends Employee {
    private double monthlySalary;

    public MonthlySalaryEmployee(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}