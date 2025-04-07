package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassRoom implements IApp{
    private int classroomId;
    private String classRoomName;
    private String courseId;
    private int teacherId;
    private List<Student> listStudents;
    private LocalDate created;
    private Status status;
    private static int autoId = 1;
    public enum Status {
        PENDING("Đang chờ"), PROGRESS("Đang học"), CLOSE("Đã đóng");

        private final String value;

        Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    public ClassRoom() {
        this.classroomId = autoId++;
        this.listStudents = new ArrayList<>();
        this.created = LocalDate.now();
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassRoomName() {
        return classRoomName;
    }

    public void setClassRoomName(String classRoomName) {
        this.classRoomName = classRoomName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public List<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(List<Student> listStudents) {
        this.listStudents = listStudents;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập tên lớp học (15-50 ký tự): ");
        this.classRoomName = scanner.nextLine();

        System.out.print("Nhập mã khóa học: ");
        this.courseId = scanner.nextLine();

        System.out.print("Nhập mã giảng viên: ");
        this.teacherId = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập trạng thái (PENDING/PROGRESS/CLOSE): ");
        this.status = Status.valueOf(scanner.nextLine().toUpperCase());
    }
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Lớp học{" +
                "Mã lớp=" + classroomId +
                ", Tên lớp='" + classRoomName + '\'' +
                ", Mã khóa học='" + courseId + '\'' +
                ", Mã GV=" + teacherId +
                ", Số SV=" + listStudents.size() +
                ", Ngày tạo=" + created.format(formatter) +
                ", Trạng thái=" + status.getValue() +
                '}';
    }
}
