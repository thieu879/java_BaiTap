package Ra.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import Ra.validate.validateStudent;

public class Student implements IApp {
    private String studentId;
    private String studentName;
    private String birthday;
    private String phoneNumber;
    private boolean sex;
    private String email;
    private String major;
    private String className;
    private float gpa;
    private byte status;

    // Constructors
    public Student() {
        this.status = 1; // Mặc định trạng thái là "đang theo học"
    }

    public Student(String studentId, String studentName, String birthday, String phoneNumber, boolean sex,
                   String email, String major, String className, float gpa) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.email = email;
        this.major = major;
        this.className = className;
        this.gpa = gpa;
        this.status = 1;
    }

    // Getters and Setters
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public String getBirthday() { return birthday; }
    public void setBirthday(String birthday) { this.birthday = birthday; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public boolean isSex() { return sex; }
    public void setSex(boolean sex) { this.sex = sex; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }
    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }
    public float getGpa() { return gpa; }
    public void setGpa(float gpa) { this.gpa = gpa; }
    public byte getStatus() { return status; }
    public void setStatus(byte status) { this.status = status; }

    @Override
    public void inputData(Scanner sc) {
        this.studentName = validateStudent.getNonEmptyString(sc, "Nhập tên sinh viên: ");
        this.birthday = validateStudent.getValidDate(sc, "Nhập ngày sinh (dd/MM/yyyy): ");
        this.phoneNumber = validateStudent.getValidPhoneNumber(sc, "Nhập số điện thoại: ");
        this.sex = validateStudent.getBoolean(sc, "Nhập giới tính (true - Nam, false - Nữ): ");
        this.email = validateStudent.getValidEmail(sc, "Nhập email: ");
        this.major = validateStudent.getNonEmptyString(sc, "Nhập ngành học: ");
        this.className = validateStudent.getNonEmptyString(sc, "Nhập tên lớp: ");
        this.gpa = validateStudent.getValidGpa(sc, "Nhập điểm GPA: ");
    }

    @Override
    public void displayData() {
        int age = calculateAge();
        String gender = sex ? "Nam" : "Nữ";
        String statusStr = switch (status) {
            case 1 -> "Đang theo học";
            case 2 -> "Bảo lưu";
            case 3 -> "Đã nghỉ học";
            default -> "Không xác định";
        };
        System.out.printf("Mã SV: %s, Tên: %s, Tuổi: %d, Giới tính: %s, SĐT: %s, Lớp: %s, Trạng thái: %s%n",
                studentId, studentName, age, gender, phoneNumber, className, statusStr);
    }

    private int calculateAge() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date birthDate = sdf.parse(birthday);
            Date currentDate = new Date();
            long diff = currentDate.getTime() - birthDate.getTime();
            return (int) (diff / (1000L * 60 * 60 * 24 * 365));
        } catch (ParseException e) {
            return 0;
        }
    }
}