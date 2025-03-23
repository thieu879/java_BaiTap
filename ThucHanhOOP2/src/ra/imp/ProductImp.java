package ra.imp;

import ra.entity.Product;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ProductImp {
    private static Product[] products = new Product[100];
    private static int currentIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = getChoice(scanner);

            switch (choice) {
                case 1:
                    inputProducts(scanner);
                    break;
                case 2:
                    displayProducts();
                    break;
                case 3:
                    calculateAllProfits();
                    break;
                case 4:
                    sortByProfit();
                    break;
                case 5:
                    statisticByPrice(scanner);
                    break;
                case 6:
                    searchByProductName(scanner);
                    break;
                case 7:
                    importProduct(scanner);
                    break;
                case 8:
                    sellProduct(scanner);
                    break;
                case 9:
                    updateStatus(scanner);
                    break;
                case 10:
                    System.out.println("Thoát chương trình!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
            System.out.println("\nNhấn Enter để tiếp tục...");
            scanner.nextLine();
        }
    }

    private static void displayMenu() {
        System.out.println("***********************MENU**************************");
        System.out.println("1. Nhập thông tin n sản phẩm");
        System.out.println("2. Hiển thị thông tin các sản phẩm");
        System.out.println("3. Tính lợi nhuận các sản phẩm");
        System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
        System.out.println("5. Thống kê các sản phẩm theo giá");
        System.out.println("6. Tìm các sản phẩm theo tên sản phẩm");
        System.out.println("7. Nhập sản phẩm");
        System.out.println("8. Bán sản phẩm");
        System.out.println("9. Cập nhật trạng thái sản phẩm");
        System.out.println("10. Thoát");
        System.out.print("Lựa chọn của bạn: ");
    }

    private static int getChoice(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void inputProducts(Scanner scanner) {
        System.out.print("Nhập số lượng sản phẩm cần thêm: ");
        int n = getChoice(scanner);
        if (n <= 0 || currentIndex + n > products.length) {
            System.out.println("Số lượng không hợp lệ hoặc vượt quá giới hạn!");
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhập thông tin sản phẩm thứ " + (i + 1) + ":");
            products[currentIndex] = new Product();
            products[currentIndex].inputData(scanner, products);
            currentIndex++;
        }
        System.out.println("Thêm sản phẩm thành công!");
    }

    private static void displayProducts() {
        if (currentIndex == 0) {
            System.out.println("Danh sách sản phẩm trống!");
            return;
        }
        printHeader();
        for (int i = 0; i < currentIndex; i++) {
            products[i].displayData();
        }
    }

    private static void calculateAllProfits() {
        if (currentIndex == 0) {
            System.out.println("Danh sách sản phẩm trống!");
            return;
        }
        for (int i = 0; i < currentIndex; i++) {
            products[i].calProfit();
        }
        System.out.println("Đã tính lợi nhuận cho tất cả sản phẩm!");
    }

    private static void sortByProfit() {
        if (currentIndex == 0) {
            System.out.println("Danh sách sản phẩm trống!");
            return;
        }
        Arrays.sort(products, 0, currentIndex,
                Comparator.comparingDouble(Product::getProfit).reversed());
        System.out.println("Đã sắp xếp theo lợi nhuận giảm dần!");
        displayProducts();
    }

    private static void statisticByPrice(Scanner scanner) {
        if (currentIndex == 0) {
            System.out.println("Danh sách sản phẩm trống!");
            return;
        }
        float fromPrice, toPrice;
        while (true) {
            try {
                System.out.print("Nhập giá thấp nhất: ");
                fromPrice = Float.parseFloat(scanner.nextLine());
                if (fromPrice >= 0) break;
                System.out.println("Giá phải >= 0!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }
        while (true) {
            try {
                System.out.print("Nhập giá cao nhất: ");
                toPrice = Float.parseFloat(scanner.nextLine());
                if (toPrice >= fromPrice) break;
                System.out.println("Giá cao nhất phải >= giá thấp nhất!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }

        int count = 0;
        for (int i = 0; i < currentIndex; i++) {
            if (products[i].getExportPrice() >= fromPrice &&
                    products[i].getExportPrice() <= toPrice) {
                count++;
            }
        }
        System.out.println("Số lượng sản phẩm trong khoảng giá " + fromPrice +
                " - " + toPrice + ": " + count);
    }

    private static void searchByProductName(Scanner scanner) {
        if (currentIndex == 0) {
            System.out.println("Danh sách sản phẩm trống!");
            return;
        }
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String searchName = scanner.nextLine().trim();
        boolean found = false;

        printHeader();
        for (int i = 0; i < currentIndex; i++) {
            if (products[i].getProductName().toLowerCase().contains(searchName.toLowerCase())) {
                products[i].displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm với tên: " + searchName);
        }
    }

    private static void importProduct(Scanner scanner) {
        if (currentIndex == 0) {
            System.out.println("Danh sách sản phẩm trống!");
            return;
        }
        System.out.print("Nhập mã sản phẩm cần nhập: ");
        String productId = scanner.nextLine().trim();

        Product product = findProductById(productId);
        if (product == null) {
            System.out.println("Không tìm thấy sản phẩm!");
            return;
        }

        int quantity;
        while (true) {
            try {
                System.out.print("Nhập số lượng cần nhập: ");
                quantity = Integer.parseInt(scanner.nextLine());
                if (quantity > 0) break;
                System.out.println("Số lượng phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }

        product.setQuantity(product.getQuantity() + quantity);
        System.out.println("Đã nhập thêm " + quantity + " sản phẩm!");
    }

    private static void sellProduct(Scanner scanner) {
        if (currentIndex == 0) {
            System.out.println("Danh sách sản phẩm trống!");
            return;
        }
        System.out.print("Nhập tên sản phẩm cần bán: ");
        String productName = scanner.nextLine().trim();

        Product product = findProductByName(productName);
        if (product == null) {
            System.out.println("Không tìm thấy sản phẩm!");
            return;
        }

        int quantity;
        while (true) {
            try {
                System.out.print("Nhập số lượng cần bán: ");
                quantity = Integer.parseInt(scanner.nextLine());
                if (quantity > 0 && quantity <= product.getQuantity()) break;
                System.out.println("Số lượng không hợp lệ hoặc vượt quá tồn kho (" +
                        product.getQuantity() + ")!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }

        product.setQuantity(product.getQuantity() - quantity);
        System.out.println("Đã bán " + quantity + " sản phẩm!");
    }

    private static void updateStatus(Scanner scanner) {
        if (currentIndex == 0) {
            System.out.println("Danh sách sản phẩm trống!");
            return;
        }
        System.out.print("Nhập mã sản phẩm cần cập nhật trạng thái: ");
        String productId = scanner.nextLine().trim();

        Product product = findProductById(productId);
        if (product == null) {
            System.out.println("Không tìm thấy sản phẩm!");
            return;
        }

        product.setStatus(!product.isStatus());
        System.out.println("Đã cập nhật trạng thái thành: " +
                (product.isStatus() ? "Đang bán" : "Không bán"));
    }

    private static Product findProductById(String productId) {
        for (int i = 0; i < currentIndex; i++) {
            if (products[i].getProductId().equals(productId)) {
                return products[i];
            }
        }
        return null;
    }

    private static Product findProductByName(String productName) {
        for (int i = 0; i < currentIndex; i++) {
            if (products[i].getProductName().equalsIgnoreCase(productName)) {
                return products[i];
            }
        }
        return null;
    }

    private static void printHeader() {
        System.out.println("| Mã SP | Tên sản phẩm        | Giá nhập  | Giá xuất  | Lợi nhuận | SL   | Mô tả               | Trạng thái |");
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }
}