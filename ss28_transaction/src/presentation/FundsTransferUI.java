package presentation;

import business.sevice.fundsTransfer.FundsTransferService;
import business.sevice.fundsTransfer.FundsTransferServiceImp;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Scanner;

public class FundsTransferUI {
    public static void displayFundsTransferMenu(Scanner scanner){
        FundsTransferService fundsTransferService = new FundsTransferServiceImp();
        boolean running = true;
        do {
            System.out.println("*****************FT MENU***************");
            System.out.println("1. Lịch sử giao dịch");
            System.out.println("2. Thống kê số tiền chuyển trong khoảng từ ngày đến ngày");
            System.out.println("3. Thống kê số tiền nhận theo tài khoản");
            System.out.println("4. Thống kê số giao dịch thành công từ ngày đến ngày");
            System.out.println("5. Thoát");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        showTransactionHistory(fundsTransferService);
                        break;
                    case 2:
                        showTransferAmountByDateRange(scanner, fundsTransferService);
                        break;
                    case 3:
                        showReceivedAmountByAccount(scanner, fundsTransferService);
                        break;
                    case 4:
                        showSuccessfulTransactionsByDateRange(scanner, fundsTransferService);
                        break;
                    case 5:
                        running = false;
                        System.out.println("đã thoát menu chuyển khoản");
                        break;
                    default:
                        System.err.println("vui lòng chọn từ 1-5");
                }
            } catch (NumberFormatException e) {
                System.err.println("vui lòng nhập số từ 1-5");
            }
        }while (true);
    }
    private static void showTransactionHistory(FundsTransferService fundsTransferService) {
        // presentation gọi service
        ResultSet rs = fundsTransferService.getTransactionHistory();
        if (rs == null) {
            System.err.println("không thể lấy lịch sử giao dịch!");
            return;
        }
        try {
            // kết quả từ mysql -> dao -> service -> presentation
            System.out.println("lịch sử giao dịch:");
            System.out.println("id | người gửi | người nhận | số tiền | ngày | trạng thái");
            while (rs.next()) {
                int fdId = rs.getInt("fd_id");
                int senderId = rs.getInt("acc_sender_id");
                int receiverId = rs.getInt("acc_reciver_id");
                BigDecimal amount = rs.getBigDecimal("fd_amount");
                String date = rs.getDate("fd_created").toString();
                int status = rs.getInt("fd_status");
                System.out.printf("%d | %d | %d | %s | %s | %s%n",
                        fdId, senderId, receiverId, amount.toString(), date, status == 1 ? "thành công" : "thất bại");
            }
        } catch (Exception e) {
            System.err.println("lỗi khi hiển thị lịch sử giao dịch: " + e.getMessage());
        }
    }

    // case 2: thống kê số tiền chuyển trong khoảng thời gian
    private static void showTransferAmountByDateRange(Scanner scanner, FundsTransferService fundsTransferService) {
        try {
            // presentation nhận input từ người dùng
            System.out.println("nhập ngày bắt đầu (yyyy-mm-dd):");
            String startDate = scanner.nextLine();
            System.out.println("nhập ngày kết thúc (yyyy-mm-dd):");
            String endDate = scanner.nextLine();

            // presentation -> service -> dao -> mysql
            BigDecimal totalAmount = fundsTransferService.getTransferAmountByDateRange(startDate, endDate);
            // mysql -> dao -> service -> presentation
            System.out.printf("tổng số tiền chuyển từ %s đến %s: %s%n", startDate, endDate, totalAmount.toString());
        } catch (Exception e) {
            System.err.println("vui lòng nhập định dạng ngày đúng (yyyy-mm-dd)!");
        }
    }

    // case 3: thống kê số tiền nhận theo tài khoản
    private static void showReceivedAmountByAccount(Scanner scanner, FundsTransferService fundsTransferService) {
        try {
            // presentation nhận input từ người dùng
            System.out.println("nhập id tài khoản:");
            int accId = Integer.parseInt(scanner.nextLine());

            // presentation -> service -> dao -> mysql
            BigDecimal totalReceived = fundsTransferService.getReceivedAmountByAccount(accId);
            // mysql -> dao -> service -> presentation
            System.out.printf("tổng số tiền nhận của tài khoản %d: %s%n", accId, totalReceived.toString());
        } catch (NumberFormatException e) {
            System.err.println("vui lòng nhập id tài khoản là số!");
        }
    }

    // case 4: thống kê số giao dịch thành công trong khoảng thời gian
    private static void showSuccessfulTransactionsByDateRange(Scanner scanner, FundsTransferService fundsTransferService) {
        try {
            // presentation nhận input từ người dùng
            System.out.println("nhập ngày bắt đầu (yyyy-mm-dd):");
            String startDate = scanner.nextLine();
            System.out.println("nhập ngày kết thúc (yyyy-mm-dd):");
            String endDate = scanner.nextLine();

            // presentation -> service -> dao -> mysql
            int transactionCount = fundsTransferService.getSuccessfulTransactionsByDateRange(startDate, endDate);
            // mysql -> dao -> service -> presentation
            System.out.printf("số giao dịch thành công từ %s đến %s: %d%n", startDate, endDate, transactionCount);
        } catch (Exception e) {
            System.err.println("vui lòng nhập định dạng ngày đúng (yyyy-mm-dd)!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        displayFundsTransferMenu(scanner);
        scanner.close();
    }
}
