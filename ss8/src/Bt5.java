import java.util.Scanner;

public class Bt5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while (n <= 0) {
            System.out.print("Nhập số phần tử của mảng: ");
            n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Kích thước không hợp lệ. Vui lòng nhập lại.");
            }
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        while (true) {
            System.out.println("\n*************** MENU ***************");
            System.out.println("1. In giá trị các phần tử trong mảng");
            System.out.println("2. Tính trung bình các phần tử dương trong mảng");
            System.out.println("3. In ra vị trí các phần tử có giá trị bằng k");
            System.out.println("4. Tính số lượng các phần tử là số nguyên tố trong mảng");
            System.out.println("5. Thoát chương trình");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Mảng: ");
                for (int i = 0; i < n; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
            else if (choice == 2) {
                int sum = 0, count = 0;
                for (int i = 0; i < n; i++) {
                    if (arr[i] > 0) {
                        sum += arr[i];
                        count++;
                    }
                }
                if (count == 0) {
                    System.out.println("Không có phần tử dương trong mảng.");
                } else {
                    System.out.println("Trung bình các số dương: " + (double) sum / count);
                }
            }
            else if (choice == 3) {
                System.out.print("Nhập giá trị k: ");
                int k = scanner.nextInt();
                boolean found = false;
                System.out.print("Vị trí các phần tử có giá trị " + k + ": ");
                for (int i = 0; i < n; i++) {
                    if (arr[i] == k) {
                        System.out.print(i + " ");
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("Không tìm thấy");
                }
                System.out.println();
            }
            else if (choice == 4) {
                int primeCount = 0;
                for (int i = 0; i < n; i++) {
                    int num = arr[i];
                    boolean isPrime = true;
                    if (num < 2) {
                        isPrime = false;
                    } else {
                        for (int j = 2; j * j <= num; j++) {
                            if (num % j == 0) {
                                isPrime = false;
                                break;
                            }
                        }
                    }
                    if (isPrime) {
                        primeCount++;
                    }
                }
                System.out.println("Số lượng số nguyên tố trong mảng: " + primeCount);
            }
            else if (choice == 5) {
                System.out.println("Thoát chương trình.");
                break;
            }
            else {
                System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại.");
            }
        }
        scanner.close();
    }
}
