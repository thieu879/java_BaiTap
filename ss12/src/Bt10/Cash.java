package Bt10;

public class Cash extends PaymentMethod{
    public Cash(double amount) {
        super(amount);
    }

    @Override
    public double calculateFee() {
        return 0;
    }
}
