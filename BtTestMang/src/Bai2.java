import java.util.Scanner;

class Bai2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int arr[][] = new int[10][10];
        int n = 0, m = 0, choice = -1;

        while (choice != 9) {
            System.out.println("*************** MENU ***************");
            System.out.println("1. Nhập giá trị các phần tử của mảng");
            System.out.println("2. In giá trị các phần tử theo ma trận");
            System.out.println("3. Tính số lượng phần tử chia hết cho 2 và 3");
            System.out.println("4. In phần tử trên đường biên, chéo chính, chéo phụ");
            System.out.println("5. Sắp xếp các cột tăng dần");
            System.out.println("6. In số nguyên tố trong mảng");
            System.out.println("7. Sắp xếp đường chéo chính giảm dần");
            System.out.println("8. Chèn mảng một chiều vào hàng cụ thể");
            System.out.println("9. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Nhập số hàng n: ");
                n = sc.nextInt();
                System.out.print("Nhập số cột m: ");
                m = sc.nextInt();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        System.out.print("arr[" + i + "][" + j + "] = ");
                        arr[i][j] = sc.nextInt();
                    }
                }
            }

            if (choice == 2) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        System.out.print(arr[i][j] + " ");
                    }
                    System.out.println();
                }
            }

            if (choice == 3) {
                int count = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (arr[i][j] % 2 == 0 && arr[i][j] % 3 == 0) {
                            count++;
                        }
                    }
                }
                System.out.println("Số phần tử chia hết cho 2 và 3: " + count);
            }

            if (choice == 4) {
                System.out.print("Đường biên: ");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                            System.out.print(arr[i][j] + " ");
                        }
                    }
                }
                System.out.println();
            }

            if (choice == 9) {
                System.out.println("Thoát chương trình.");
            }
        }
    }
}
