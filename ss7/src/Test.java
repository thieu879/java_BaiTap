import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chuoi: ");
        String input = sc.nextLine();
        sc.close();

        if (input.isEmpty()) {
            System.out.println("Chuoi rong!");
            return;
        }

        StringBuilder output = new StringBuilder();
        int count = 1;

        for (int i = 0; i < input.length() - 1; i++) {
            char ch = input.charAt(i);
            if (input.charAt(i + 1) == ch) {
                count++;
            } else {
                output.append(ch).append(count);
                count = 1;
            }
        }

        output.append(input.charAt(input.length() - 1)).append(count);

        System.out.println("Chuoi sau khi nen: " + output);
    }
}