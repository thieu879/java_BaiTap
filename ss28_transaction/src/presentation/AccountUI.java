package presentation;

import business.model.account.Acount;
import business.model.account.AcountStatus;
import business.sevice.account.AccountService;
import business.sevice.account.AccountServiceImp;

import java.util.List;
import java.util.Scanner;

public class AccountUI {

    public static void displayAccountMenu(Scanner scanner) {
        AccountService accountService = new AccountServiceImp();
        do {
            System.out.println("***************ACCOUNT MENU**************");
            System.out.println("1. Danh sách tài khoản");
            System.out.println("2. Tạo tài khoản");
            System.out.println("3. Cập nhật tài khoản"); //Tên + trạng thái
            System.out.println("4. Xóa tài khoản");//Cập nhật trạng thái là inactive
            System.out.println("5. Chuyển khoản");
            System.out.println("6. Tra cứu số dư tài khoản");
            System.out.println("7. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    listAccounts(accountService);
                    break;
                case 2:
                    createAccount(scanner, accountService);
                    break;
                case 3:
                    updateAccount(scanner, accountService);
                    break;
                case 4:
                    deleteAccount(scanner, accountService);
                    break;
                case 5:
                    fundsTransfer(scanner, accountService);
                    break;
                case 6:
                    checkBalance(scanner, accountService);
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1-7");
            }
        } while (true);
    }

    public static void fundsTransfer(Scanner scanner, AccountService accountService) {
        System.out.println("Nhập số tài khoản người gửi:");
        int accSenderId = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên tài khoản người gửi:");
        String accSenderName = scanner.nextLine();
        System.out.println("Nhập số tài khoản người nhận:");
        int accReceiverId = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên tài khoản người nhận:");
        String accReceiverName = scanner.nextLine();
        System.out.println("Nhập số tiền chuyển:");
        double amount = Double.parseDouble(scanner.nextLine());
        int result = accountService.fundsTransfer(accSenderId, accSenderName, accReceiverId, accReceiverName, amount);
        switch (result) {
            case 1:
                System.err.println("Thông tin tài khoản người gửi không chính xác");
                break;
            case 2:
                System.err.println("Thông tin tài khoản người nhận không chính xác");
                break;
            case 3:
                System.err.println("Số dư tài khoản không đủ để chuyển khoản");
                break;
            case 4:
                System.out.println("Chuyển khoản thành công!!!");
                break;
        }
    }
    private static void listAccounts(AccountService accountService) {
        List<Acount> accounts = accountService.getAllAccounts();
        if (accounts.isEmpty()) {
            System.out.println("Không có tài khoản nào.");
        } else {
            System.out.println("Danh sách tài khoản:");
            for (Acount acc : accounts) {
                System.out.println(acc);
            }
        }
    }
    private static void createAccount(Scanner scanner, AccountService accountService) {
        try {
            System.out.println("Nhập tên tài khoản:");
            String accName = scanner.nextLine();
            System.out.println("Nhập số dư ban đầu:");
            double accBalance = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Nhập trạng thái (active/inactive/blocked):");
            String accStatus = scanner.nextLine().toLowerCase();

            if (!accStatus.equals("active") && !accStatus.equals("inactive") && !accStatus.equals("blocked")) {
                System.err.println("Trạng thái không hợp lệ!");
                return;
            }

            Acount account = new Acount();
            account.setName(accName);
            account.setBalance(accBalance);
            account.setStatus(AcountStatus.valueOf(accStatus.toUpperCase()));

            int result = accountService.createAccount(account);
            switch (result) {
                case 0:
                    System.err.println("Tên tài khoản không hợp lệ!");
                    break;
                case 1:
                    System.err.println("Số dư không thể âm!");
                    break;
                case 2:
                    System.out.println("Tạo tài khoản thành công!");
                    break;
                default:
                    System.err.println("Tạo tài khoản thất bại!");
            }
        } catch (Exception e) {
            System.err.println("Dữ liệu nhập không hợp lệ!");
        }
    }
    private static void updateAccount(Scanner scanner, AccountService accountService) {
        try {
            System.out.println("Nhập ID tài khoản cần cập nhật:");
            int accId = Integer.parseInt(scanner.nextLine());
            Acount account = accountService.getAccountById(accId);
            if (account == null) {
                System.err.println("Tài khoản không tồn tại!");
                return;
            }

            System.out.println("Nhập tên mới (Enter để giữ nguyên):");
            String accName = scanner.nextLine();
            if (!accName.isEmpty()) {
                account.setName(accName);
            }

            System.out.println("Nhập trạng thái mới (active/inactive/blocked, Enter để giữ nguyên):");
            String accStatus = scanner.nextLine().toLowerCase();
            if (!accStatus.isEmpty()) {
                if (!accStatus.equals("active") && !accStatus.equals("inactive") && !accStatus.equals("blocked")) {
                    System.err.println("Trạng thái không hợp lệ!");
                    return;
                }
                account.setStatus(AcountStatus.valueOf(accStatus));
            }

            int result = accountService.updateAccount(account);
            switch (result) {
                case 0:
                    System.err.println("Tài khoản không tồn tại!");
                    break;
                case 1:
                    System.err.println("Tên tài khoản không hợp lệ!");
                    break;
                case 2:
                    System.out.println("Cập nhật tài khoản thành công!");
                    break;
                default:
                    System.err.println("Cập nhật tài khoản thất bại!");
            }
        } catch (Exception e) {
            System.err.println("Dữ liệu nhập không hợp lệ!");
        }
    }
    private static void deleteAccount(Scanner scanner, AccountService accountService) {
        try {
            System.out.println("Nhập ID tài khoản cần xóa:");
            int accId = Integer.parseInt(scanner.nextLine());
            int result = accountService.deleteAccount(accId);
            switch (result) {
                case 0:
                    System.err.println("Tài khoản không tồn tại!");
                    break;
                case 1:
                    System.out.println("Xóa tài khoản thành công (trạng thái: inactive)!");
                    break;
                default:
                    System.err.println("Xóa tài khoản thất bại!");
            }
        } catch (Exception e) {
            System.err.println("Dữ liệu nhập không hợp lệ!");
        }
    }
    private static void checkBalance(Scanner scanner, AccountService accountService) {
        try {
            System.out.println("Nhập ID tài khoản cần tra cứu:");
            int accId = Integer.parseInt(scanner.nextLine());
            Acount account = accountService.getAccountById(accId);
            if (account == null) {
                System.err.println("Tài khoản không tồn tại!");
            } else {
                System.out.println("Thông tin tài khoản: " + account);
            }
        } catch (Exception e) {
            System.err.println("Dữ liệu nhập không hợp lệ!");
        }
    }
}