package Ra.bussiness;

import Ra.entity.Student;
import Ra.validate.validateStudent;

import java.util.*;

public class StudentBusiness {
    private static final int MAX_STUDENTS = 100;
    private Student[] students;
    private int size;

    public StudentBusiness() {
        students = new Student[MAX_STUDENTS];
        size = 0;
    }

    public void displayAllStudents() {
        if (size == 0) {
            System.out.println("Danh sách sinh viên trống!");
            return;
        }
        for (int i = 0; i < size; i++) {
            students[i].displayData();
        }
    }

    public boolean addNewStudent(Scanner sc) {
        if (size >= MAX_STUDENTS) {
            System.out.println("Danh sách sinh viên đã đầy, không thể thêm mới!");
            return false;
        }
        int count;
        do {
            System.out.print("Nhập số lượng sinh viên cần thêm: ");
            try {
                count = Integer.parseInt(sc.nextLine().trim());
                if (count > 0 && count <= MAX_STUDENTS - size) break;
                System.out.println("Số lượng không hợp lệ hoặc vượt quá giới hạn!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        } while (true);

        for (int i = 0; i < count; i++) {
            System.out.println("\nNhập thông tin sinh viên thứ " + (i + 1) + ":");
            Student student = new Student();
            String studentId;
            do {
                studentId = generateStudentId();
            } while (isStudentIdExists(studentId));
            student.setStudentId(studentId);

            student.inputData(sc);
            while (isEmailExists(student.getEmail())) {
                System.out.println("Email đã tồn tại, vui lòng nhập email khác!");
                student.setEmail(validateStudent.getValidEmail(sc, "Nhập email: "));
            }
            students[size++] = student;
        }
        System.out.println("Thêm mới thành công!");
        return true;
    }

    private String generateStudentId() {
        return "SV" + String.format("%05d", (int) (Math.random() * 100000));
    }

    private boolean isStudentIdExists(String id) {
        for (int i = 0; i < size; i++) {
            if (students[i].getStudentId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private boolean isEmailExists(String email) {
        for (int i = 0; i < size; i++) {
            if (students[i].getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public void updateStudent(Scanner sc) {
        System.out.print("Nhập mã sinh viên cần sửa: ");
        String id = sc.nextLine().trim();
        int index = findStudentIndexById(id);
        if (index == -1) {
            System.out.println("Không tìm thấy sinh viên!");
            return;
        }
        Student student = students[index];
        System.out.println("Thông tin cũ:");
        student.displayData();

        while (true) {
            System.out.println("\nChọn thuộc tính cần sửa:");
            System.out.println("1. Tên sinh viên");
            System.out.println("2. Ngày sinh");
            System.out.println("3. Số điện thoại");
            System.out.println("4. Giới tính");
            System.out.println("5. Email");
            System.out.println("6. Ngành học");
            System.out.println("7. Tên lớp");
            System.out.println("8. GPA");
            System.out.println("0. Hoàn tất");
            System.out.print("Lựa chọn: ");
            int choice = Integer.parseInt(sc.nextLine().trim());
            if (choice == 0) break;

            switch (choice) {
                case 1 -> student.setStudentName(validateStudent.getNonEmptyString(sc, "Nhập tên mới: "));
                case 2 -> student.setBirthday(validateStudent.getValidDate(sc, "Nhập ngày sinh mới: "));
                case 3 -> student.setPhoneNumber(validateStudent.getValidPhoneNumber(sc, "Nhập SĐT mới: "));
                case 4 -> student.setSex(validateStudent.getBoolean(sc, "Nhập giới tính mới: "));
                case 5 -> {
                    String oldEmail = student.getEmail();
                    String newEmail = validateStudent.getValidEmail(sc, "Nhập email mới: ");
                    while (!newEmail.equals(oldEmail) && isEmailExists(newEmail)) {
                        System.out.println("Email đã tồn tại!");
                        newEmail = validateStudent.getValidEmail(sc, "Nhập email mới: ");
                    }
                    student.setEmail(newEmail);
                }
                case 6 -> student.setMajor(validateStudent.getNonEmptyString(sc, "Nhập ngành học mới: "));
                case 7 -> student.setClassName(validateStudent.getNonEmptyString(sc, "Nhập tên lớp mới: "));
                case 8 -> student.setGpa(validateStudent.getValidGpa(sc, "Nhập GPA mới: "));
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
        System.out.println("Cập nhật thành công!");
    }

    public void deleteStudent(Scanner sc) {
        System.out.print("Nhập mã sinh viên cần xóa: ");
        String id = sc.nextLine().trim();
        int index = findStudentIndexById(id);
        if (index == -1) {
            System.out.println("Không tìm thấy sinh viên!");
            return;
        }
        System.out.println("Thông tin sinh viên cần xóa:");
        students[index].displayData();
        System.out.print("Bạn có chắc chắn muốn xóa? (Y/N): ");
        if (sc.nextLine().trim().equalsIgnoreCase("Y")) {
            // Dịch chuyển các phần tử trong mảng
            for (int i = index; i < size - 1; i++) {
                students[i] = students[i + 1];
            }
            students[--size] = null; // Xóa phần tử cuối cùng
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Hủy bỏ thao tác xóa!");
        }
    }

    public void searchStudent(Scanner sc) {
        System.out.println("\n--- Menu Tìm kiếm ---");
        System.out.println("1. Tìm theo tên");
        System.out.println("2. Tìm theo lớp");
        System.out.println("3. Tìm theo khoảng GPA");
        System.out.print("Lựa chọn: ");
        int choice = Integer.parseInt(sc.nextLine().trim());
        boolean found = false;

        switch (choice) {
            case 1 -> {
                String name = validateStudent.getNonEmptyString(sc, "Nhập tên cần tìm: ");
                for (int i = 0; i < size; i++) {
                    if (students[i].getStudentName().toLowerCase().contains(name.toLowerCase())) {
                        students[i].displayData();
                        found = true;
                    }
                }
            }
            case 2 -> {
                String className = validateStudent.getNonEmptyString(sc, "Nhập tên lớp cần tìm: ");
                for (int i = 0; i < size; i++) {
                    if (students[i].getClassName().equalsIgnoreCase(className)) {
                        students[i].displayData();
                        found = true;
                    }
                }
            }
            case 3 -> {
                float minGpa = validateStudent.getValidGpa(sc, "Nhập GPA tối thiểu: ");
                float maxGpa = validateStudent.getValidGpa(sc, "Nhập GPA tối đa: ");
                for (int i = 0; i < size; i++) {
                    float gpa = students[i].getGpa();
                    if (gpa >= minGpa && gpa <= maxGpa) {
                        students[i].displayData();
                        found = true;
                    }
                }
            }
            default -> System.out.println("Lựa chọn không hợp lệ!");
        }

        if (!found && choice >= 1 && choice <= 3) {
            System.out.println("Không tìm thấy kết quả phù hợp!");
        }
    }

    public void sortStudents(Scanner sc) {
        if (size == 0) {
            System.out.println("Danh sách sinh viên trống!");
            return;
        }
        System.out.println("\n--- Menu Sắp xếp ---");
        System.out.println("1. Theo tên tăng dần");
        System.out.println("2. Theo tên giảm dần");
        System.out.println("3. Theo GPA tăng dần");
        System.out.println("4. Theo GPA giảm dần");
        System.out.print("Lựa chọn: ");
        int choice = Integer.parseInt(sc.nextLine().trim());

        // Sắp xếp mảng sử dụng Arrays.sort với Comparator
        switch (choice) {
            case 1 -> Arrays.sort(students, 0, size, Comparator.comparing(Student::getStudentName));
            case 2 -> Arrays.sort(students, 0, size, Comparator.comparing(Student::getStudentName).reversed());
            case 3 -> Arrays.sort(students, 0, size, Comparator.comparing(Student::getGpa));
            case 4 -> Arrays.sort(students, 0, size, Comparator.comparing(Student::getGpa).reversed());
            default -> {
                System.out.println("Lựa chọn không hợp lệ!");
                return;
            }
        }

        System.out.println("\nDanh sách sau khi sắp xếp:");
        displayAllStudents();
    }

    private int findStudentIndexById(String id) {
        for (int i = 0; i < size; i++) {
            if (students[i].getStudentId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}