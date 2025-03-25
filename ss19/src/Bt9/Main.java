package Bt9;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("bàn",50.00));
        products.add(new Product("ghế",100.00));
        products.add(new Product("chuột",200.00));
        products.add(new Product("laptop",10.00));
        ProductProcessorImpl productProcessor = new ProductProcessorImpl();
        System.out.println("Danh sách sản phẩm: ");
        ProductProcessor.printProductList(products);
        System.out.println("\n Kiểm tra sản phẩm đắt tiền: ");
        productProcessor.hasExpensiveProduct(products);
        System.out.println("\n Tổng giá trị của tất cả sản phẩm: " + productProcessor.calculateTotalValue(products));
    }
}
