package Bt9;

public class Bank {
    private BankAccount[] accounts;
    private int count;

    public Bank() {
        accounts = new BankAccount[10];
        count = 0;
    }

    public void addAccount(BankAccount account) {
        if (count < 10) {
            accounts[count++] = account;
            System.out.println("Thêm tài khoản thành công!");
        } else {
            System.out.println("Ngân hàng đã đầy, không thể thêm tài khoản.");
        }
    }

    public void displayBalance() {
        System.out.println("\n--- Danh sách tài khoản ---");
        for (int i = 0; i < count; i++) {
            accounts[i].displayBalance();
        }
    }
}
