package Bt9;

import Bt9.exceptionDefinition.AccountNotFoundException;
import Bt9.exceptionDefinition.InsufficientBalanceException;
import Bt9.exceptionDefinition.InvalidAmountException;

public class BankAccount {
    private String accountId;
    private double balance;

    public BankAccount() {}
    public BankAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Số tiền gửi phải lớn hơn 0!");
        }
        this.balance += amount;
        System.out.println("Gửi tiền thành công! Số dư mới: " + String.format("%,.0f", balance));
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidAmountException("Số tiền rút phải lớn hơn 0!");
        }
        if (amount > this.balance) {
            throw new InsufficientBalanceException("Số dư không đủ để rút " + String.format("%,.0f", amount) + "!");
        }
        this.balance -= amount;
        System.out.println("Rút tiền thành công! Số dư mới: " + String.format("%,.0f", balance));
    }

    public void transfer(BankAccount targetAccount, double amount)
            throws InvalidAmountException, InsufficientBalanceException, AccountNotFoundException {
        if (targetAccount == null) {
            throw new AccountNotFoundException("Tài khoản đích không tồn tại!");
        }
        if (amount <= 0) {
            throw new InvalidAmountException("Số tiền chuyển phải lớn hơn 0!");
        }
        if (amount > this.balance) {
            throw new InsufficientBalanceException("Số dư không đủ để chuyển " + String.format("%,.0f", amount) + "!");
        }

        this.balance -= amount;
        targetAccount.balance += amount;
        System.out.println("Chuyển tiền thành công từ " + this.accountId + " đến " + targetAccount.accountId + "!");
        System.out.println("Số dư mới của " + this.accountId + ": " + String.format("%,.0f", this.balance));
        System.out.println("Số dư mới của " + targetAccount.accountId + ": " + String.format("%,.0f", targetAccount.balance));
    }

    @Override
    public String toString() {
        return "Tài khoản: " + accountId + ", Số dư: " + String.format("%,.0f", balance);
    }
}
