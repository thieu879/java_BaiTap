import ra.entity.Product;
import ra.util.ProductFilter;

import java.util.*;

public class Main {
    private static List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("**************************MENU*************************");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm theo ID");
            System.out.println("5. Tìm sản phẩm theo tên");
            System.out.println("6. Lọc sản phẩm theo điều kiện");
            System.out.println("7. Sắp xếp sản phẩm theo giá");
            System.out.println("8. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    addProduct(scanner);
                    break;
                case 3:
                    updateProduct(scanner);
                    break;
                case 4:
                    deleteProduct(scanner);
                    break;
                case 5:
                    searchProducts(scanner);
                    break;
                case 6:
                    filterProducts(scanner);
                    break;
                case 7:
                    sortProducts(scanner);
                    break;
                case 8:
                    System.out.println("bye bye!!!");
                    return;
                default:
                    System.out.println("Nhập sai rồi nhập lại đi");
                    break;
            }
        } while (true);
    }
    public static void addProduct( Scanner scanner) {
        Product product = new Product();
        product.inputData(scanner);
        products.add(product);
        System.out.println("Thêm thành công");
    }
    public static void displayProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }
    public static void updateProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());
        Optional<Product> optionalProduct = products.stream()
                .filter(p -> p.getProductId() == id)
                .findFirst();
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.inputData(scanner);
            System.out.println("Cập nhật sản phẩm thành công!");
        } else {
            System.out.println("Không tìm thấy sản phẩm!");
        }
    }
    public static void deleteProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean removed = products.removeIf(p -> p.getProductId() == id); // Sử dụng Lambda Expression
        System.out.println(removed ? "Xóa sản phẩm thành công!" : "Không tìm thấy sản phẩm!");
    }
    public static void searchProducts(Scanner scanner) {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String ten = scanner.nextLine();
        products.stream()
                .filter(p -> p.getProductName().toLowerCase().contains(ten.toLowerCase()))
                .forEach(Product::displayData);
    }
    public static void filterProducts(Scanner scanner) {
        System.out.println("1. Lọc sản phẩm có giá lớn hơn X");
        System.out.println("2. Lọc sản phẩm theo danh mục");
        System.out.print("Chọn kiểu lọc: ");
        int loaiLoc = Integer.parseInt(scanner.nextLine());

        if (loaiLoc == 1) {
            System.out.print("Nhập giá X: ");
            float giaX = Float.parseFloat(scanner.nextLine());
            ProductFilter filter = p -> p.getPrice() > giaX;
            products.stream()
                    .filter(filter::filter)
                    .forEach(Product::displayData);
        } else if (loaiLoc == 2) {
            System.out.print("Nhập danh mục: ");
            String danhMuc = scanner.nextLine();
            ProductFilter filter = p -> p.getCategory().equalsIgnoreCase(danhMuc);
            products.stream()
                    .filter(filter::filter)
                    .forEach(Product::displayData);
        } else {
            System.out.println("Lựa chọn không hợp lệ!");
        }
    }
    public static void sortProducts(Scanner scanner) {
        System.out.println("1. Sắp xếp tăng dần theo giá");
        System.out.println("2. Sắp xếp giảm dần theo giá");
        System.out.print("Chọn kiểu sắp xếp: ");
        int loaiSapXep = Integer.parseInt(scanner.nextLine());

        if (loaiSapXep == 1) {
            products.stream()
                    .sorted(Comparator.comparing(Product::getPrice))
                    .forEach(Product::displayData);
        } else if (loaiSapXep == 2) {
            products.stream()
                    .sorted(Comparator.comparing(Product::getPrice).reversed())
                    .forEach(Product::displayData);
        } else {
            System.out.println("Lựa chọn không hợp lệ!");
        }
    }
}
