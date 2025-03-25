package ra.presentation;

import ra.entity.Student;
import ra.business.studentManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static studentManager studentManager = new studentManager();
    public static void main(String[] args) {
        do {
            System.out.println("********************MENU*******************");
            System.out.println("1. Danh sách sinh viên");
            System.out.println("2. Thêm mới các sinh viên");
            System.out.println("3. Xóa sinh viên theo mã sinh viên");
            System.out.println("4. Tính điểm trung bình của tất cả sinh viên");
            System.out.println("5. In thông tin sinh viên có điểm trung bình lớn nhất");
            System.out.println("6. In thông tin sinh viên có tuổi nhỏ nhất");
            System.out.println("7. Thoát");
            System.out.println("Nhập lựa chọn: ");
            int choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    studentManager.displayStudents();
                    break;
                case 2:
                    studentManager.addStudent();
                    break;
                case 3:
                    studentManager.deleteStudent();
                    break;
                case 4:
                    studentManager.displayAverageGradeStudents();
                    break;
                case 5:
                    studentManager.displayMaxAverage();
                    break;
                case 6:
                    studentManager.minAgeStudent();
                    break;
                case 7:
                    System.out.println("Tạm biệt!!!");
                    return;
                default:
                    System.out.println("Chọn sai rồi chọn lại đi: ");
                    break;
            }
        } while (true);
    }
}
