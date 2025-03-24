package Bt10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeManager {
    Map<Integer, Employee> employeeMap = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    public void addEmployee() {
        System.out.println("Nhập Tên nhân viên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập số lương của nhân viên: ");
        double salary = scanner.nextInt();
        Employee employee = new Employee(name, salary);
        employeeMap.put(employee.getId(), employee);
        System.out.println("Thêm thành công rồi đấy");
    }
    public void displayAllEmployees() {
        if (employeeMap.isEmpty()) {
            System.out.println("Danh sách nhân viên trống.");
            return;
        }
        System.out.println("Danh sách nhân viên:");
        for (Employee employee : employeeMap.values()) {
            System.out.println(employee);
        }
    }
    public void calculateTotalSalary(){
        if (employeeMap.isEmpty()) {
            System.out.println("Chưa có nhân viên nào");
        }
        double totalSalary = 0;
        for (Employee employee : employeeMap.values()) {
            totalSalary += employee.getSalary();
        }
        System.out.println("Tổng lương của nhân viên: " + totalSalary);
    }
    public void calculateAverageSalary(){
        if (employeeMap.isEmpty()) {
            System.out.println("Chưa có nhân viên nào");
        }
        double totalSalary = 0;
        for (Employee employee : employeeMap.values()) {
            totalSalary += employee.getSalary();
        }
        double averageSalary = totalSalary / employeeMap.size();
        System.out.println("Lương trung bình của nhân viên là:  " + averageSalary);
    }
    public void findHighestSalaryEmployee() {
        if (employeeMap.isEmpty()) {
            System.out.println("Chưa có nhân viên nào!");
            return;
        }

        Employee highest = null;
        for (Employee emp : employeeMap.values()) {
            if (highest == null || emp.getSalary() > highest.getSalary()) {
                highest = emp;
            }
        }
        System.out.println("Lương cao nhất: " + highest);
    }

    public void findLowestSalaryEmployee() {
        if (employeeMap.isEmpty()) {
            System.out.println("Chưa có nhân viên nào!");
            return;
        }

        Employee lowest = null;
        for (Employee emp : employeeMap.values()) {
            if (lowest == null || emp.getSalary() < lowest.getSalary()) {
                lowest = emp;
            }
        }
        System.out.println("Lương thấp nhất: " + lowest);
    }
}
