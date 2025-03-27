package ra.util;

import ra.entity.Product;

public interface ProductFilter {
    boolean filter(Product product);
}
