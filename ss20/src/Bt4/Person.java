package Bt4;

import java.time.LocalDate;

public class Person {
    private String name;
    private LocalDate birthDate;

    public Person(LocalDate birthDate, String name) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getAge(){
        return LocalDate.now().getYear() - birthDate.getYear();
    }
    public void printInfo(){
        System.out.println("Tên: " + name + ", Ngày sinh: " + birthDate + ", Tuổi: " + getAge());
    }
}
