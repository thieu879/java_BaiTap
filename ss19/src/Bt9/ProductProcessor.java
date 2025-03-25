package Bt9;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public interface ProductProcessor {
    public abstract double calculateTotalValue(List<Product> products);
    static void printProductList(List<Product> products){
        for(Product product:products){
            System.out.println(product);
        }
    }
    default boolean hasExpensiveProduct(List<Product> products){
        Predicate<Product>  hasExpensiveProduct = product -> product.getPrice() > 100;
        List<Product> expensiveProducts = new ArrayList<>();
        for(Product product:products){
            if(hasExpensiveProduct.test(product)){
                expensiveProducts.add(product);
            }
        }
        if (expensiveProducts.isEmpty()) {
            System.out.println("Không có sản phẩm đắt tiền");
            return false;
        } else {
            System.out.println("Các sản phẩm đắt tiền:");
            for (Product product : expensiveProducts) {
                System.out.println(product);
            }
            return true;
        }
    }
}
