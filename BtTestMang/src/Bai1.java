import java.util.Scanner;

class Bai1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[100];
        int n = 0, choice = -1;

        while (choice != 9) {
            System.out.println("*************** MENU ***************");
            System.out.println("1. Nhập giá trị n phần tử của mảng");
            System.out.println("2. In giá trị các phần tử trong mảng");
            System.out.println("3. Tính trung bình các phần tử dương");
            System.out.println("4. In vị trí các phần tử có giá trị bằng k");
            System.out.println("5. Sắp xếp nổi bọt giảm dần");
            System.out.println("6. Đếm số nguyên tố trong mảng");
            System.out.println("7. Sắp xếp các phần tử chia hết cho 3 theo yêu cầu");
            System.out.println("8. Chèn giá trị m vào mảng giảm dần");
            System.out.println("9. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Nhập số phần tử n: ");
                n = sc.nextInt();
                for (int i = 0; i < n; i++) {
                    System.out.print("arr[" + i + "] = ");
                    arr[i] = sc.nextInt();
                }
            }

            if (choice == 2) {
                for (int i = 0; i < n; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }

            if (choice == 3) {
                int sum = 0, count = 0;
                for (int i = 0; i < n; i++) {
                    if (arr[i] > 0) {
                        sum += arr[i];
                        count++;
                    }
                }
                if (count > 0) System.out.println("Trung bình cộng = " + (sum / count));
                else System.out.println("Không có số dương!");
            }

            if (choice == 4) {
                System.out.print("Nhập giá trị k: ");
                int k = sc.nextInt();
                for (int i = 0; i < n; i++) {
                    if (arr[i] == k) System.out.print(i + " ");
                }
                System.out.println();
            }

            if (choice == 5) {
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (arr[j] < arr[j + 1]) {
                            int temp = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = temp;
                        }
                    }
                }
                System.out.println("Mảng đã sắp xếp giảm dần.");
            }

            if (choice == 6) {
                int count = 0;
                for (int i = 0; i < n; i++) {
                    int isPrime = 1;
                    if (arr[i] < 2) isPrime = 0;
                    for (int j = 2; j * j <= arr[i]; j++) {
                        if (arr[i] % j == 0) isPrime = 0;
                    }
                    if (isPrime == 1) count++;
                }
                System.out.println("Số nguyên tố trong mảng: " + count);
            }

            if (choice == 9) {
                System.out.println("Thoát chương trình.");
            }
        }
    }
}
