package Bt8;

public class Main {
    public static void main(String[] args) {
        Product laptop = new Electronics("Laptop", 1500);
        Product tshirt = new Clothing("T-Shirt", 500);
        Product apple = new Food("Apple", 50);

        Product[] products = {laptop, tshirt, apple};

        System.out.println("Giá sau chiết khấu khi mua 1 sản phẩm:");
        for (Product p : products) {
            System.out.println(p.name + " - Giá cuối: " + p.getFinalPrice() + " VND");
        }

        int quantity = 150;
        System.out.println("\nGiá sau chiết khấu khi mua " + quantity + " sản phẩm:");
        for (Product p : products) {
            System.out.println(p.name + " - Tổng giá: " + p.getFinalPrice(quantity) + " VND");
        }
    }
}
