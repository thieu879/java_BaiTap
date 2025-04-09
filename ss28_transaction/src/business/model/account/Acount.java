package business.model.account;

public class Acount {
    private int id;
    private String name;
    private double balance;
    private AcountStatus status;

    public Acount() {
    }

    public Acount(int id, String name, double balance, AcountStatus status) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.status = status;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AcountStatus getStatus() {
        return status;
    }

    public void setStatus(AcountStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", status=" + status +
                '}';
    }
}