package Bt10;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addToCart(Product product, int quantity) throws IllegalArgumentException {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Lỗi: Số lượng không hợp lệ!");
        }

        for (CartItem item : items) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new CartItem(product, quantity));
    }

    public void removeFromCart(String productId) throws IllegalArgumentException {
        boolean found = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct().getId().equals(productId)) {
                items.remove(i);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IllegalArgumentException("Lỗi: Không tìm thấy sản phẩm trong giỏ hàng!");
        }
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Giỏ hàng trống!");
            return;
        }
        System.out.println("Nội dung giỏ hàng:");
        for (CartItem item : items) {
            Product p = item.getProduct();
            System.out.printf("%s - %s: %.2f x %d = %.2f%n",
                    p.getId(), p.getName(), p.getPrice(), item.getQuantity(), item.getSubtotal());
        }
    }

    public double checkout() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getSubtotal();
        }
        System.out.printf("Tổng tiền cần thanh toán: %.2f%n", total);
        return total;
    }
}
