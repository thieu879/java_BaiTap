package Bt10;

public class CreditCard extends PaymentMethod{
    public CreditCard(double amount) {
        super(amount);
    }

    @Override
    public double calculateFee() {
        return amount * 0.02;
    }
}
