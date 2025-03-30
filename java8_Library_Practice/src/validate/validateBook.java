package validate;

import java.util.Scanner;

public class validateBook {
    public static String validateIdBook(Scanner scanner) {
        while (true) {
            System.out.println("Nhập mã sách: ");
            String id = scanner.next();
            if(id.length()!=5 && !id.matches("[B]\\d{4}")){
                System.err.println("Nhập sai rồi nhập lại đi");
            }
            return id;
        }
    }
    public static void validateNameBook(Scanner scanner) {
        while (true) {
            System.out.println("Nhập tên sách: ");
            String name = scanner.next();
            if(name.length()<10 && name.length()>100){

            }
        }
    }
}
