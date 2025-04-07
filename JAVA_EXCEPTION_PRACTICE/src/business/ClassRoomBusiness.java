package business;

import entity.ClassRoom;
import entity.Student;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ClassRoomBusiness {
    private List<ClassRoom> classrooms = new ArrayList<>();

    public void addClassRoom(Scanner scanner, CourseBusiness courseBusiness, TeacherBusiness teacherBusiness) {
        ClassRoom classroom = new ClassRoom();
        classroom.inputData(scanner);
        if (courseBusiness.findCourseById(classroom.getCourseId()) == null) {
            System.out.println("Không tìm thấy khóa học!");
            return;
        }
        if (teacherBusiness.findTeacherById(classroom.getTeacherId()) == null) {
            System.out.println("Không tìm thấy giảng viên!");
            return;
        }
        classrooms.add(classroom);
        System.out.println("Thêm lớp học thành công!");
    }

    public void displayClassRooms() {
        classrooms.sort(Comparator.comparing(ClassRoom::getCreated, Comparator.reverseOrder()));
        for (ClassRoom classroom : classrooms) {
            System.out.println(classroom);
        }
    }

    public void updateClassRoom(Scanner scanner, int classroomId) {
        ClassRoom classroom = findClassRoomById(classroomId);
        if (classroom != null && classroom.getStatus() != ClassRoom.Status.CLOSE) {
            classroom.inputData(scanner);
            System.out.println("Cập nhật lớp học thành công!");
        } else {
            System.out.println("Không thể cập nhật: lớp học không tồn tại hoặc ở trạng thái CLOSE!");
        }
    }

    public void deleteClassRoom(int classroomId) {
        ClassRoom classroom = findClassRoomById(classroomId);
        if (classroom != null && classroom.getListStudents().isEmpty()) {
            classrooms.remove(classroom);
            System.out.println("Xóa lớp học thành công!");
        } else {
            System.out.println("Không thể xóa: lớp học có sinh viên hoặc không tồn tại!");
        }
    }

    public void assignTeacher(int classroomId, int teacherId, TeacherBusiness teacherBusiness) {
        ClassRoom classroom = findClassRoomById(classroomId);
        if (classroom != null && teacherBusiness.findTeacherById(teacherId) != null) {
            classroom.setTeacherId(teacherId);
            System.out.println("Phân công giảng viên thành công!");
        } else {
            System.out.println("Lớp học hoặc giảng viên không tồn tại!");
        }
    }

    public void addStudentToClass(int classroomId, String studentId, StudentBusiness studentBusiness) {
        ClassRoom classroom = findClassRoomById(classroomId);
        Student student = studentBusiness.findStudentById(studentId);
        if (classroom != null && student != null) {
            classroom.getListStudents().add(student);
            System.out.println("Thêm sinh viên vào lớp thành công!");
        } else {
            System.out.println("Lớp học hoặc sinh viên không tồn tại!");
        }
    }

    public boolean isCourseInUse(String courseId) {
        return classrooms.stream().anyMatch(c -> c.getCourseId().equals(courseId));
    }

    public boolean isTeacherInUse(int teacherId) {
        return classrooms.stream().anyMatch(c -> c.getTeacherId() == teacherId);
    }

    private ClassRoom findClassRoomById(int classroomId) {
        return classrooms.stream().filter(c -> c.getClassroomId() == classroomId).findFirst().orElse(null);
    }
}