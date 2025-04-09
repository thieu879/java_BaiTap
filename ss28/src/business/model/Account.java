package business.model;

public class Account {
    private int id;
    private String name;
    private double balance;

    public Account() {
    }

    public Account(double balance, int id, String name) {
        this.balance = balance;
        this.id = id;
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
