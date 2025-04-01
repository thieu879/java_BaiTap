package Bt1;

public class SalaryCalculator {
    public double calculateSalary(Employee employee) {
        double bonus = employee.getBaseSalary() * 0.1;
        return employee.getBaseSalary() + bonus;
    }
}
