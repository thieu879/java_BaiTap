package entity;

import java.util.Scanner;

public class Teacher extends Person implements IApp{
    private int teacherId;
    private String subject;
    private static int autoId = 1;

    public Teacher() {
        this.teacherId = autoId++;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập tên giảng viên (tối đa 150 ký tự): ");
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

        System.out.print("Nhập chuyên môn: ");
        this.subject = scanner.nextLine();
    }
    @Override
    public String toString() {
        return "Giảng viên{" +
                "Mã GV=" + teacherId +
                ", Tên='" + name + '\'' +
                ", Tuổi=" + age +
                ", Địa chỉ='" + address + '\'' +
                ", SĐT='" + phone + '\'' +
                ", Email='" + email + '\'' +
                ", Giới tính=" + sex.getValue() +
                ", Chuyên môn='" + subject + '\'' +
                '}';
    }
}
