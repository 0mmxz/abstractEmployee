import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import salryy.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of employees:");
        int numEmployees = scanner.nextInt();

        Employee[] employees = new Employee[numEmployees];

        for (int i = 0; i < numEmployees; i++) {
            System.out.println("\nEnter details for employee #" + (i+1));

            System.out.println("Enter employee name:");
            String name = scanner.next();

            System.out.println("Enter 'h' for hourly employee or 'm' for monthly employee:");
            char type = scanner.next().charAt(0);

            if (type == 'h') {
                System.out.println("Enter hours worked:");
                double hoursWorked = scanner.nextDouble();
                System.out.println("Enter hourly rate:");
                double hourlyRate = scanner.nextDouble();
                employees[i] = new HourlySalaryEmployee(name, hoursWorked, hourlyRate);
            } else if (type == 'm') {
                System.out.println("Enter monthly salary:");
                double monthlySalary = scanner.nextDouble();
                employees[i] = new MonthlySalaryEmployee(name, monthlySalary);
            } else {
                System.out.println("Invalid employee type!");
                return;
            }
        }

        writePayroll(employees, "payroll.txt");

        scanner.close();
    }

    public static void writePayroll(Employee[] employees, String filename) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentDate = new Date();

        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write("Payroll generated on: " + dateFormat.format(currentDate) + "\n");

            for (Employee employee : employees) {
                writer.write("Employee: " + employee.name + ", Salary: $" + employee.calculateSalary() + "\n");
            }

            writer.write("\n"); // Add a newline for separation between different payroll entries
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}