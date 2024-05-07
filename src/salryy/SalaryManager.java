package salryy;

import java.io.FileWriter;
import java.io.IOException;


public class SalaryManager {
    public void writePayroll(Employee[] employees, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Employee employee : employees) {
                writer.write(employee.name + ": $" + employee.calculateSalary() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
