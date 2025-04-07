package entity;

import java.util.Scanner;

public class Course implements IApp {
    private String courseId;
    private String courseName;
    private boolean status;

    public Course() {}

    public Course(String courseId, String courseName, boolean status) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.status = status;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã khóa học (Cxxxx): ");
        this.courseId = scanner.nextLine();

        System.out.print("Nhập tên khóa học (20-100 ký tự): ");
        this.courseName = scanner.nextLine();

        System.out.print("Nhập trạng thái khóa học (true/false): ");
        this.status = Boolean.parseBoolean(scanner.nextLine());
    }
    @Override
    public String toString() {
        return "Khóa học{" +
                "Mã khóa học='" + courseId + '\'' +
                ", Tên khóa học='" + courseName + '\'' +
                ", Trạng thái=" + (status ? "Hoạt động" : "Không hoạt động") +
                '}';
    }
}
