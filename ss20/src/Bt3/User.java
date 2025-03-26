package Bt3;

import java.util.Optional;

public class User {
    private String name;
    private Optional<String> phoneNumber;

    public User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = Optional.ofNullable(phoneNumber);
    }

    public void printInfo(){
        String phoneInfo = phoneNumber.orElse("Không có");
        System.out.println("Tên: " + name + ", SĐT: " + phoneInfo);
    }
}
