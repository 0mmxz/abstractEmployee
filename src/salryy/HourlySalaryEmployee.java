package salryy;

public class HourlySalaryEmployee extends Employee {
    private double hoursWorked;
    private double hourlyRate;

    public HourlySalaryEmployee(String name, double hoursWorked, double hourlyRate) {
        super(name);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}