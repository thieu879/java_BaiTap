package Bt9;

public class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        setBalance(getBalance() - amount);
        System.out.println("Rút tiền thành công: " + amount);
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        System.out.println("Nạp tiền thành công: " + amount);
    }

    @Override
    public void displayBalance() {
        System.out.println("Số dư tài khoản vãng lai (" + getAccountNumber() + "): " + getBalance());
    }
}
