import java.util.ArrayList;
import java.util.Scanner;

public class Bt6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> validNumbers = new ArrayList<>();
        int invalidCount = 0;
        System.out.println("Nhập các chuỗi: ");
        String input = scanner.nextLine();
        String[] strings = input.trim().split("\\s+");
        for (String str : strings) {
            try {
                int number = Integer.parseInt(str);
                validNumbers.add(number);
            } catch (NumberFormatException e) {
                invalidCount++;
            }
            System.out.println("Số lượng chuỗi hợp lệ: " + validNumbers.size());
            System.out.println("Số lượng chuỗi không hợp lệ " + invalidCount);
        }
        if (!validNumbers.isEmpty()) {
            System.out.println("Danh sách các số hợp lệ:");
            for (int number : validNumbers) {
                System.out.print(number + " ");
            }
            System.out.println();
        } else {
            System.out.println("Không có số hợp lệ nào.");
        }
    }
}
