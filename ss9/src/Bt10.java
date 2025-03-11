import java.util.Scanner;

enum Gender {
    MALE, FEMALE, OTHER;
}

class Student {
    private int id;
    private String name;
    private int age;
    private Gender gender;
    private String address;
    private String phoneNumber;

    public Student() {}

    public Student(int id, String name, int age, Gender gender, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã HS: ");
        this.id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập tên HS: ");
        this.name = scanner.nextLine();
        System.out.print("Nhập tuổi: ");
        this.age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập giới tính (MALE/FEMALE/OTHER): ");
        this.gender = Gender.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Nhập địa chỉ: ");
        this.address = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        this.phoneNumber = scanner.nextLine();
    }

    public void displayData() {
        System.out.println("Mã HS: " + id + ", Tên: " + name + ", Tuổi: " + age + ", Giới tính: " + gender + ", Địa chỉ: " + address + ", SĐT: " + phoneNumber);
    }

    public int getId() {
        return id;
    }

    public void updateStudent(Scanner scanner) {
        System.out.print("Nhập tên mới: ");
        this.name = scanner.nextLine();
        System.out.print("Nhập tuổi mới: ");
        this.age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập giới tính mới (MALE/FEMALE/OTHER): ");
        this.gender = Gender.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Nhập địa chỉ mới: ");
        this.address = scanner.nextLine();
        System.out.print("Nhập số điện thoại mới: ");
        this.phoneNumber = scanner.nextLine();
    }
}

public class Bt10 {
    private static Student[] students = new Student[100];
    private static int studentCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Hiển thị danh sách tất cả sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Sửa thông tin sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayAllStudents();
                    break;
                case 2:
                    addStudent(scanner);
                    break;
                case 3:
                    updateStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void displayAllStudents() {
        if (studentCount == 0) {
            System.out.println("Danh sách sinh viên trống.");
            return;
        }
        for (int i = 0; i < studentCount; i++) {
            students[i].displayData();
        }
    }

    private static void addStudent(Scanner scanner) {
        if (studentCount >= students.length) {
            System.out.println("Danh sách đã đầy.");
            return;
        }
        Student student = new Student();
        student.inputData(scanner);
        students[studentCount++] = student;
        System.out.println("Thêm sinh viên thành công!");
    }

    private static void updateStudent(Scanner scanner) {
        System.out.print("Nhập mã HS cần sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == id) {
                students[i].updateStudent(scanner);
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên với mã đã nhập.");
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Nhập mã HS cần xóa: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == id) {
                for (int j = i; j < studentCount - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[--studentCount] = null;
                System.out.println("Xóa sinh viên thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên với mã đã nhập.");
    }
}
