import java.util.Scanner;

public class Bt7 {
    private static final double INITIAL_BALANCE = 1000000.0;
    private static final double MINIMUM_BALANCE = 50000.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = INITIAL_BALANCE;

        System.out.println("Chào mừng đến với ATM");
        System.out.println("Số dư hiện tại: " + String.format("%,.0f", balance) + " đồng");

        while (true) {
            try {
                System.out.print("\nNhập số tiền muốn rút (0 để thoát): ");
                String input = scanner.nextLine();
                double withdrawAmount = Double.parseDouble(input);
                if (withdrawAmount == 0) {
                    System.out.println("Cảm ơn bạn đã sử dụng dịch vụ!");
                    break;
                }
                if (withdrawAmount < 0) {
                    throw new IllegalArgumentException("Lỗi: Số tiền rút không được âm!");
                }
                if (withdrawAmount > balance) {
                    throw new IllegalArgumentException("Lỗi: Số tiền rút vượt quá số dư!");
                }
                if (balance - withdrawAmount < MINIMUM_BALANCE) {
                    throw new IllegalArgumentException(
                            "Lỗi: Tài khoản phải duy trì số dư tối thiểu " +
                                    String.format("%,.0f", MINIMUM_BALANCE) + " đồng!");
                }
                balance -= withdrawAmount;
                System.out.println("Rút tiền thành công!");
                System.out.println("Số tiền đã rút: " + String.format("%,.0f", withdrawAmount) + " đồng");
                System.out.println("Số dư còn lại: " + String.format("%,.0f", balance) + " đồng");
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                System.out.println("Cảm ơn bạn đã sử dụng dịch vụ!");
            }
        }
    }
}