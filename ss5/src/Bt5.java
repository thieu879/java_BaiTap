import java.util.Scanner;

public class Bt5 {
    public static void main(String[] args) {
        System.out.print("Nhập kích thước mảng: ");
        int n = new Scanner(System.in).nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            System.out.print("Nhập số đi: ");
            arr[i] = new Scanner(System.in).nextInt();
        }
        int max = arr[0];
        int min = arr[0];
        int count = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] % 2 != 0) {
                count++;
                if (max < arr[i]){
                    max = arr[i];
                }
                if (min > arr[i]){
                    min = arr[i];
                }
            }
        }
        if (count == 0){
            System.out.println("Không có phần tử lẻ trong mảng");
        }else {
            System.out.println("phần tử lẻ lớn nhất trong mảng là: " + max);
            System.out.println("phần tử lẻ nhỏ nhất trong mảng: " + min);
        }
    }
}
