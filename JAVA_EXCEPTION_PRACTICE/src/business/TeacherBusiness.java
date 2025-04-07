package business;

import entity.Teacher;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TeacherBusiness {
    private List<Teacher> teachers = new ArrayList<>();

    public void addTeacher(Scanner scanner) {
        Teacher teacher = new Teacher();
        teacher.inputData(scanner);
        teachers.add(teacher);
        System.out.println("Thêm giảng viên thành công!");
    }

    public void displayTeachers() {
        teachers.sort(Comparator.comparing(Teacher::getTeacherId, Comparator.reverseOrder()));
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    public void updateTeacher(Scanner scanner) {
        System.out.print("Nhập mã giảng viên để cập nhật: ");
        int teacherId = Integer.parseInt(scanner.nextLine());
        Teacher teacher = findTeacherById(teacherId);
        if (teacher != null) {
            teacher.inputData(scanner);
            System.out.println("Cập nhật giảng viên thành công!");
        } else {
            System.out.println("Không tìm thấy giảng viên!");
        }
    }

    public void deleteTeacher(int teacherId, ClassRoomBusiness classRoomBusiness) {
        if (classRoomBusiness.isTeacherInUse(teacherId)) {
            System.out.println("Không thể xóa giảng viên: giảng viên đã được xếp lớp!");
        } else {
            teachers.removeIf(t -> t.getTeacherId() == teacherId);
            System.out.println("Xóa giảng viên thành công!");
        }
    }

    public Teacher findTeacherById(int teacherId) {
        return teachers.stream().filter(t -> t.getTeacherId() == teacherId).findFirst().orElse(null);
    }
}