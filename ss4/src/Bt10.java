import java.util.Scanner;

public class Bt10 {
    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Kiểm tra số nguyên tố");
            System.out.println("2. Kiểm tra số hoàn hảo");
            System.out.println("3. Tìm và tính tổng các ước của một số");
            System.out.println("4. Thoát chương trình");
            System.out.print("Chọn một chức năng (1-4): ");
            choice = new Scanner(System.in).nextInt();

            if (choice >= 1 && choice <= 3) {
                System.out.print("Nhập một số nguyên dương: ");
                int num = new Scanner(System.in).nextInt();
                if (num <= 0) {
                    System.out.println("Số nhập vào không hợp lệ. Vui lòng nhập lại.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        boolean isPrime = num > 1;
                        for (int i = 2; i * i <= num; i++) {
                            if (num % i == 0) {
                                isPrime = false;
                                break;
                            }
                        }
                        System.out.println(num + (isPrime ? " là số nguyên tố." : " không phải số nguyên tố."));
                        break;

                    case 2:
                        int sumDivisors = 0;
                        for (int i = 1; i < num; i++) {
                            if (num % i == 0) {
                                sumDivisors += i;
                            }
                        }
                        System.out.println(num + (sumDivisors == num ? " là số hoàn hảo." : " không phải số hoàn hảo."));
                        break;

                    case 3:
                        int sumFactors = 0;
                        System.out.print("Các ước của " + num + " là: ");
                        for (int i = 1; i <= num; i++) {
                            if (num % i == 0) {
                                System.out.print(i + " ");
                                sumFactors += i;
                            }
                        }
                        System.out.println("\nTổng các ước của " + num + " là: " + sumFactors);
                        break;
                }
            } else if (choice != 4) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 4);

        System.out.println("Chương trình kết thúc.");
    }
}