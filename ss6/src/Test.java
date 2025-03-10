import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng số điện thoại muốn thêm:");
        int length = sc.nextInt();
        sc.nextLine(); // Loại bỏ ký tự xuống dòng sau nextInt()


        if (length < 1) {
            System.out.println("Mảng không hợp lệ");
        } else {
            String[] phones = new String[length];
            String[] new_phones = new String[length];
            for (int i = 0; i < length; i++) {
                System.out.println("Nhập số thứ " + (i + 1) + ":");
                phones[i] = sc.nextLine();
            }
            if (phones.length < 10) {
                for (int k = 0; k < phones.length; k++) {
                    if (phones[k].charAt(0) == '0') {

                        for (int i = 0; i < length; i++) {
                            if (phones[i].charAt(0) == '0') {
                                new_phones[i] = "+ 84" + phones[i].substring(1)
                                        .replaceAll("[-.]", " ") ;
                            } else {
                                new_phones[i] = phones[i]
                                        .replaceAll("[-.]", " ")
                                        .replaceAll("\\s+", " ");
                            }
                        }
                    }
                    else {
                        System.out.println("Số không hợp lệ ");
                    }
                }


            }
            else {
                System.out.println("Số không hợp lệ");
            }
            // In kết quả
            System.out.println("\nDanh sách số điện thoại đã chuẩn hóa:");
            for (String number : new_phones) {
                System.out.println(number);
            }
        }

        sc.close();
    }
}