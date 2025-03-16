package Bt9;

public class SavingAccount extends BankAccount {
    public SavingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > getBalance()) {
            System.out.println("Không thể rút quá số dư!");
        } else {
            setBalance(getBalance() - amount);
            System.out.println("Rút tiền thành công: " + amount);
        }
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        System.out.println("Nạp tiền thành công: " + amount);
    }

    @Override
    public void displayBalance() {
        System.out.println("Số dư tài khoản tiết kiệm (" + getAccountNumber() + "): " + getBalance());
    }
}
