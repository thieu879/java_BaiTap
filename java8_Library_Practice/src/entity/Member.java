package entity;

import java.util.Optional;
import java.util.Scanner;

public class Member implements IApp {
    private static int countID = 0;
    private int id;
    private String name;
    private Optional<String> email;

    public Member(Optional<String> email, int id, String name) {
        this.email = email;
        this.id = ++countID;
        this.name = name;
    }
    public Member() {}

    public static int getCountID() {
        return countID;
    }

    public static void setCountID(int countID) {
        Member.countID = countID;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public void setEmail(Optional<String> email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập tên thành viên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập email: ");
        String inputEmail = scanner.nextLine();
        this.email = inputEmail.isEmpty() ? Optional.empty() : Optional.of(inputEmail);
    }
    @Override
    public String toString(){
        return "id=" + id + ", name=" + name + ", email=" + email ;
    }
}
