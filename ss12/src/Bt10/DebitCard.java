package Bt10;

public class DebitCard extends PaymentMethod{
    public DebitCard(double amount) {
        super(amount);
    }

    @Override
    public double calculateFee() {
        return amount * 0.01; // 1% phí giao dịch
    }
}
