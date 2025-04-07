package business;

import entity.CourseRegistration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseRegistrationBusiness {
    private List<CourseRegistration> registrations = new ArrayList<>();

    public void registerCourse(Scanner scanner, StudentBusiness studentBusiness, CourseBusiness courseBusiness) {
        CourseRegistration reg = new CourseRegistration();
        reg.inputData(scanner);
        if (studentBusiness.findStudentById(reg.getStudentId()) == null) {
            System.out.println("Không tìm thấy sinh viên!");
            return;
        }
        if (courseBusiness.findCourseById(reg.getCourseId()) == null) {
            System.out.println("Không tìm thấy khóa học!");
            return;
        }
        registrations.add(reg);
        System.out.println("Đăng ký khóa học thành công!");
    }

    public void cancelRegistration(String studentId, String courseId) {
        CourseRegistration reg = findRegistration(studentId, courseId);
        if (reg != null && reg.getStatus() == CourseRegistration.Status.PENDING) {
            registrations.remove(reg);
            System.out.println("Hủy đăng ký thành công!");
        } else {
            System.out.println("Không thể hủy: đăng ký không tồn tại hoặc không ở trạng thái PENDING!");
        }
    }

    public void approveRegistration(String studentId, String courseId) {
        CourseRegistration reg = findRegistration(studentId, courseId);
        if (reg != null && reg.getStatus() == CourseRegistration.Status.PENDING) {
            reg.setStatus(CourseRegistration.Status.ENROLLED);
            System.out.println("Duyệt đăng ký thành công!");
        } else {
            System.out.println("Không thể duyệt: đăng ký không tồn tại hoặc không ở trạng thái PENDING!");
        }
    }

    public void displayRegistrationsByCourse(String courseId) {
        registrations.stream()
                .filter(r -> r.getCourseId().equals(courseId))
                .forEach(System.out::println);
    }

    public boolean isStudentRegistered(String studentId) {
        return registrations.stream().anyMatch(r -> r.getStudentId().equals(studentId));
    }

    private CourseRegistration findRegistration(String studentId, String courseId) {
        return registrations.stream()
                .filter(r -> r.getStudentId().equals(studentId) && r.getCourseId().equals(courseId))
                .findFirst().orElse(null);
    }
}