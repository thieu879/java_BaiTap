package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CourseRegistration implements IApp{
    private int crid;
    private String studentId;
    private String courseId;
    private LocalDate registrationDate;
    private Status status;
    private static int autoId = 1;
    public enum Status {
        PENDING("Đang chờ"), ENROLLED("Đã đăng ký"), DROPPED("Đã hủy");

        private final String value;

        Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    public CourseRegistration() {
        this.crid = autoId++;
        this.registrationDate = LocalDate.now();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getCrid() {
        return crid;
    }

    public void setCrid(int crid) {
        this.crid = crid;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã sinh viên: ");
        this.studentId = scanner.nextLine();

        System.out.print("Nhập mã khóa học: ");
        this.courseId = scanner.nextLine();

        System.out.print("Nhập trạng thái (PENDING/ENROLLED/DROPPED): ");
        this.status = Status.valueOf(scanner.nextLine().toUpperCase());
    }
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Đăng ký khóa học{" +
                "Mã ĐK=" + crid +
                ", Mã SV='" + studentId + '\'' +
                ", Mã khóa học='" + courseId + '\'' +
                ", Ngày đăng ký=" + registrationDate.format(formatter) +
                ", Trạng thái=" + status.getValue() +
                '}';
    }
}
