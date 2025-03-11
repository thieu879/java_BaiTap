public class Bt8 {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public Bt8(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Nạp tiền thành công. Số dư hiện tại: " + balance);
        } else {
            System.out.println("Số tiền nạp không hợp lệ.");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Số dư không đủ.");
        } else {
            balance -= amount;
            System.out.println("Rút tiền thành công. Số dư hiện tại: " + balance);
        }
    }

    public void transfer(Bt8 recipient, double amount) {
        if (amount > balance) {
            System.out.println("Số dư không đủ để chuyển tiền.");
        } else {
            balance -= amount;
            recipient.balance += amount;
            System.out.println("Chuyển tiền thành công. Số dư hiện tại: " + balance);
        }
    }

    public void display() {
        System.out.println("Số tài khoản: " + accountNumber);
        System.out.println("Chủ tài khoản: " + accountHolder);
        System.out.println("Số dư: " + balance);
    }

    public static void main(String[] args) {
        Bt8 account1 = new Bt8("123456", "Nguyen Van A", 1000);
        Bt8 account2 = new Bt8("789012", "Tran Thi B", 500);

        account1.display();
        account2.display();

        account1.deposit(500);
        account1.withdraw(300);
        account1.transfer(account2, 200);

        account1.display();
        account2.display();
    }
}
