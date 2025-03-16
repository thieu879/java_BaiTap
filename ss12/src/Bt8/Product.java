package Bt8;

public class Product {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getDiscount() {
        return 0.0;
    }

    public double getFinalPrice() {
        return price - (price * getDiscount() / 100);
    }

    public double getDiscount(int quantity) {
        if (quantity > 100) return 5.0;
        return getDiscount();
    }

    public double getFinalPrice(int quantity) {
        double discount = getDiscount(quantity);
        double discountedPrice = price - (price * discount / 100);
        return discountedPrice * quantity;
    }
}

