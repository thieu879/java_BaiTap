package business;

import entity.Student;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentBusiness {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Scanner scanner) {
        Student student = new Student();
        student.inputData(scanner);
        students.add(student);
        System.out.println("Thêm sinh viên thành công!");
    }

    public void displayStudents() {
        students.sort(Comparator.comparing(Student::getName));
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void updateStudent(Scanner scanner) {
        System.out.print("Nhập mã sinh viên để cập nhật: ");
        String studentId = scanner.nextLine();
        Student student = findStudentById(studentId);
        if (student != null) {
            student.inputData(scanner);
            System.out.println("Cập nhật sinh viên thành công!");
        } else {
            System.out.println("Không tìm thấy sinh viên!");
        }
    }

    public void deleteStudent(String studentId, CourseRegistrationBusiness crBusiness) {
        if (crBusiness.isStudentRegistered(studentId)) {
            System.out.println("Không thể xóa sinh viên: sinh viên đã đăng ký khóa học!");
        } else {
            students.removeIf(s -> s.getStudentId().equals(studentId));
            System.out.println("Xóa sinh viên thành công!");
        }
    }

    public Student findStudentById(String studentId) {
        return students.stream().filter(s -> s.getStudentId().equals(studentId)).findFirst().orElse(null);
    }
}