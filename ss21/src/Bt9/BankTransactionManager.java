package Bt9;

import java.util.ArrayList;

public class BankTransactionManager {
    private ArrayList<BankAccount> accounts;
    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }
    public BankTransactionManager() {
        this.accounts = new ArrayList<>();
    }

    public BankAccount findAccount(String accountId) {
        for (BankAccount account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }
        return null;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }
}
