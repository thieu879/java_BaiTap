package Ra.presentation;

import Ra.bussiness.StudentBusiness;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentBusiness business = new StudentBusiness();

        while (true) {
            System.out.println("\n----------------------------Student Menu----------------------------");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Chỉnh sửa thông tin sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Tìm kiếm sinh viên");
            System.out.println("6. Sắp xếp");
            System.out.println("0. Thoát chương trình");
            System.out.println("----------------------------------------------------------------------");
            System.out.print("Lựa chọn: ");

            try {
                int choice = Integer.parseInt(sc.nextLine().trim());
                switch (choice) {
                    case 1 -> business.displayAllStudents();
                    case 2 -> business.addNewStudent(sc);
                    case 3 -> business.updateStudent(sc);
                    case 4 -> business.deleteStudent(sc);
                    case 5 -> business.searchStudent(sc);
                    case 6 -> business.sortStudents(sc);
                    case 0 -> {
                        System.out.println("Thoát chương trình!");
                        sc.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }
    }
}