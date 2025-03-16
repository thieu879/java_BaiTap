package Bt9;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        BankAccount acc1 = new SavingAccount("SA123", 5000);
        BankAccount acc2 = new CheckingAccount("CA456", 2000);

        bank.addAccount(acc1);
        bank.addAccount(acc2);

        acc1.deposit(1000);
        acc2.withdraw(3000);

        bank.displayBalance();
    }
}
