package Bt1;

public class Main {
    public static void main(String[] args) {
        Account account1 = Account.getInstance();
        Account account2 = Account.getInstance();
        Account account3 = Account.getInstance();

        // In thông tin để kiểm tra
        System.out.println("Account 1: " + account1);
        System.out.println("Account 2: " + account2);
        System.out.println("Account 3: " + account3);

        // Kiểm tra xem các tham chiếu có trỏ cùng một đối tượng không
        System.out.println("\nKiểm tra cùng một đối tượng:");
        System.out.println("account1 == account2: " + (account1 == account2));
        System.out.println("account2 == account3: " + (account2 == account3));

        // Thay đổi giá trị của account1
        account1.setName("Thiều");
        account1.setAge(30);

        // Kiểm tra xem các instance khác có bị ảnh hưởng không
        System.out.println("\nSau khi thay đổi account1:");
        System.out.println("Account 1: " + account1);
        System.out.println("Account 2: " + account2);
        System.out.println("Account 3: " + account3);
    }
}
