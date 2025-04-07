package business;

import entity.Course;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CourseBusiness {
    private List<Course> courses = new ArrayList<>();
    public void addCourse(Scanner scanner) {
        Course course = new Course();
        course.inputData(scanner);
        courses.add(course);
        System.out.println("Thêm khóa học thành công!");
    }

    public void displayCourses() {
        courses.sort(Comparator.comparing(Course::getCourseName));
        for (Course course : courses) {
            System.out.println(course);
        }
    }
    public void updateCourse(Scanner scanner) {
        System.out.print("Nhập mã khóa học để cập nhật: ");
        String courseId = scanner.nextLine();
        Course course = findCourseById(courseId);
        if (course != null) {
            course.inputData(scanner);
            System.out.println("Cập nhật khóa học thành công!");
        } else {
            System.out.println("Không tìm thấy khóa học!");
        }
    }

    public void deleteCourse(String courseId, ClassRoomBusiness classRoomBusiness) {
        if (classRoomBusiness.isCourseInUse(courseId)) {
            System.out.println("Không thể xóa khóa học: khóa học đã được xếp lớp!");
        } else {
            courses.removeIf(c -> c.getCourseId().equals(courseId));
            System.out.println("Xóa khóa học thành công!");
        }
    }

    public Course findCourseById(String courseId) {
        return courses.stream().filter(c -> c.getCourseId().equals(courseId)).findFirst().orElse(null);
    }

}
