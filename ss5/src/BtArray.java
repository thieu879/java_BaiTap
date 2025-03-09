import java.util.Scanner;

public class BtArray {
    public static void main(String[] args) {
        /*
            1. nhập số phần tử của mảng(n) và khai báo mảng số nguyên 1 chiều gồm n phần tử
            2. Nhập giá trị và chỉ số để chèn vào mảng
        */
        // 1. nhập số phần tử của mảng(n) và khai báo mảng số nguyên 1 chiều gồm n phần tử
        System.out.print("Nhập vào số phần tử của mẩng: ");
        int size = new Scanner(System.in).nextInt();
        int [] oldArray = new int[size];
        for (int i = 0; i < oldArray.length; i++) {
            System.out.printf("oldArray[%d] = ", i);
            oldArray[i] = Integer.parseInt(new Scanner(System.in).nextLine());
        }
        // 2. Nhập giá trị và chỉ số để chèn vào mảng
        System.out.printf("Nhập vào giá trị phần tử cần chèn: ");
        int value = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.printf("Nhập vào chỉ số muốn chèn: ");
        int index = Integer.parseInt(new Scanner(System.in).nextLine());
        int [] newArray;
        if (index < 0) {
            newArray = new int[0];
            System.err.printf("Không tồn tại chỉ số "+index);
        } else if (index < oldArray.length) {
            newArray = new int[oldArray.length + 1];
            for (int i = 0; i < newArray.length; i++) {
                if (i < index) {
                    newArray[i] = oldArray[i];
                }else if (i == index) {
                    newArray[i] = value;
                }else {
                    newArray[i] = oldArray[i - 1];
                }
            }
        }else {
            newArray = new int[index + 1];
            // copy các phần tử mảng cũ sang mảng mới
            for (int i = 0; i < oldArray.length; i++) {
                newArray[i] = oldArray[i];
            }
            // gám giá trị phần tử index với giá trị value
            newArray[index] = value;
        }
        for (int element : newArray){
            System.out.print(element + " ");
        }

    }
}
