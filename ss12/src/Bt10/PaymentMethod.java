package Bt10;

public abstract class PaymentMethod {
    protected double amount;

    public PaymentMethod(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFee();

    public double processPayment() {
        return amount + calculateFee();
    }

    public String processPayment(String currency) {
        return processPayment() + " " + currency;
    }
}
