package entity;

import java.util.Scanner;

public class Student extends Person implements IApp{
    private String studentId;
    private double gpa;

    public Student() {
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã sinh viên (SVxxx): ");
        this.studentId = scanner.nextLine();

        System.out.print("Nhập tên sinh viên (tối đa 150 ký tự): ");
        this.name = scanner.nextLine();

        System.out.print("Nhập tuổi (tối thiểu 18): ");
        this.age = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập địa chỉ: ");
        this.address = scanner.nextLine();

        System.out.print("Nhập số điện thoại (VD: 090xxxxxxx): ");
        this.phone = scanner.nextLine();

        System.out.print("Nhập email: ");
        this.email = scanner.nextLine();

        System.out.print("Nhập giới tính (MALE/FEMALE/OTHER): ");
        this.sex = Sex.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Nhập điểm trung bình (GPA): ");
        this.gpa = Double.parseDouble(scanner.nextLine());
    }
    @Override
    public String toString() {
        return "Sinh viên{" +
                "Mã SV='" + studentId + '\'' +
                ", Tên='" + name + '\'' +
                ", Tuổi=" + age +
                ", Địa chỉ='" + address + '\'' +
                ", SĐT='" + phone + '\'' +
                ", Email='" + email + '\'' +
                ", Giới tính=" + sex.getValue() +
                ", GPA=" + gpa +
                '}';
    }
}
