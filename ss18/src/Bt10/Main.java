package Bt10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();

        do {
            System.out.println("\n=== QUẢN LÝ LƯƠNG NHÂN VIÊN ===");
            System.out.println("1. Thêm nhân viên mới");
            System.out.println("2. Hiển thị danh sách nhân viên");
            System.out.println("3. Tính tổng lương");
            System.out.println("4. Tính lương trung bình");
            System.out.println("5. Tìm nhân viên lương cao nhất");
            System.out.println("6. Tìm nhân viên lương thấp nhất");
            System.out.println("7. Thoát");
            System.out.print("Chọn: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm

            switch (choice) {
                case 1:
                    manager.addEmployee();
                    break;
                case 2:
                    manager.displayAllEmployees();
                    break;
                case 3:
                    manager.calculateTotalSalary();
                    break;
                case 4:
                    manager.calculateAverageSalary();
                    break;
                case 5:
                    manager.findHighestSalaryEmployee();
                    break;
                case 6:
                    manager.findLowestSalaryEmployee();
                    break;
                case 7:
                    System.out.println("Tạm biệt!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (true);
    }
}