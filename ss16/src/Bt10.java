import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public String classify() {
        if (gpa >= 8.5) return "Xuất sắc";
        if (gpa >= 7.0) return "Giỏi";
        if (gpa >= 5.5) return "Khá";
        return "Trung bình/Yếu";
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", GPA: " + gpa + " (" + classify() + ")";
    }
}

public class Bt10 {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n==== QUẢN LÝ SINH VIÊN ====");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. In danh sách sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo tên");
            System.out.println("4. Phân loại sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    inputStudents();
                    break;
                case 2:
                    printStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    classifyStudents();
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 5);
    }

    // Nhập danh sách sinh viên
    private static void inputStudents() {
        System.out.print("Nhập số lượng sinh viên: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sinh viên " + (i + 1) + ":");
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Họ và tên: ");
            String name = scanner.nextLine();
            System.out.print("GPA: ");
            double gpa = Double.parseDouble(scanner.nextLine());

            students.add(new Student(id, name, gpa));
        }
    }

    // In danh sách sinh viên
    private static void printStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống!");
            return;
        }
        System.out.println("\n==== DANH SÁCH SINH VIÊN ====");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Tìm kiếm sinh viên theo tên
    private static void searchStudent() {
        System.out.print("Nhập tên sinh viên cần tìm: ");
        String nameSearch = scanner.nextLine();
        boolean found = false;

        for (Student student : students) {
            if (student.getName().toLowerCase().contains(nameSearch.toLowerCase())) {
                System.out.println(student);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sinh viên nào có tên: " + nameSearch);
        }
    }

    // Phân loại sinh viên theo GPA
    private static void classifyStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống!");
            return;
        }

        ArrayList<Student> excellent = new ArrayList<>();
        ArrayList<Student> good = new ArrayList<>();
        ArrayList<Student> average = new ArrayList<>();
        ArrayList<Student> weak = new ArrayList<>();

        for (Student student : students) {
            if (student.getGpa() >= 8.5) excellent.add(student);
            else if (student.getGpa() >= 7.0) good.add(student);
            else if (student.getGpa() >= 5.5) average.add(student);
            else weak.add(student);
        }

        System.out.println("\n=== SINH VIÊN XUẤT SẮC ===");
        for (Student s : excellent) System.out.println(s);

        System.out.println("\n=== SINH VIÊN GIỎI ===");
        for (Student s : good) System.out.println(s);

        System.out.println("\n=== SINH VIÊN KHÁ ===");
        for (Student s : average) System.out.println(s);

        System.out.println("\n=== SINH VIÊN TRUNG BÌNH/YẾU ===");
        for (Student s : weak) System.out.println(s);
    }
}
