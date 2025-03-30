package Bt9;

import Bt9.exceptionDefinition.AccountNotFoundException;
import Bt9.exceptionDefinition.InsufficientBalanceException;
import Bt9.exceptionDefinition.InvalidAmountException;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BankTransactionManager manager = new BankTransactionManager();
        Scanner scanner = new Scanner(System.in);

        manager.addAccount(new BankAccount("ACC001", 1000000));
        manager.addAccount(new BankAccount("ACC002", 500000));
        manager.addAccount(new BankAccount("ACC003", 2000000));

        while (true) {
            System.out.println("\n=== HỆ THỐNG QUẢN LÝ GIAO DỊCH NGÂN HÀNG ===");
            System.out.println("1. Gửi tiền");
            System.out.println("2. Rút tiền");
            System.out.println("3. Chuyển tiền");
            System.out.println("4. Xem danh sách tài khoản");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng (1-5): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số hợp lệ!");
                continue;
            }

            if (choice == 5) {
                System.out.println("Cảm ơn bạn đã sử dụng hệ thống!");
                break;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Nhập số tài khoản: ");
                        String depositAccountId = scanner.nextLine();
                        BankAccount depositAccount = manager.findAccount(depositAccountId);
                        if (depositAccount == null) {
                            throw new AccountNotFoundException("Tài khoản không tồn tại!");
                        }
                        System.out.print("Nhập số tiền gửi: ");
                        double depositAmount = Double.parseDouble(scanner.nextLine());
                        depositAccount.deposit(depositAmount);
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi: Số tiền phải là một số hợp lệ!");
                    } catch (InvalidAmountException | AccountNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Nhập số tài khoản: ");
                        String withdrawAccountId = scanner.nextLine();
                        BankAccount withdrawAccount = manager.findAccount(withdrawAccountId);
                        if (withdrawAccount == null) {
                            throw new AccountNotFoundException("Tài khoản không tồn tại!");
                        }
                        System.out.print("Nhập số tiền rút: ");
                        double withdrawAmount = Double.parseDouble(scanner.nextLine());
                        withdrawAccount.withdraw(withdrawAmount);
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi: Số tiền phải là một số hợp lệ!");
                    } catch (InvalidAmountException | InsufficientBalanceException | AccountNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        System.out.print("Nhập số tài khoản nguồn: ");
                        String sourceAccountId = scanner.nextLine();
                        BankAccount sourceAccount = manager.findAccount(sourceAccountId);
                        if (sourceAccount == null) {
                            throw new AccountNotFoundException("Tài khoản nguồn không tồn tại!");
                        }

                        System.out.print("Nhập số tài khoản đích: ");
                        String targetAccountId = scanner.nextLine();
                        BankAccount targetAccount = manager.findAccount(targetAccountId);
                        if (targetAccount == null) {
                            throw new AccountNotFoundException("Tài khoản đích không tồn tại!");
                        }

                        System.out.print("Nhập số tiền chuyển: ");
                        double transferAmount = Double.parseDouble(scanner.nextLine());
                        sourceAccount.transfer(targetAccount, transferAmount);
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi: Số tiền phải là một số hợp lệ!");
                    } catch (InvalidAmountException | InsufficientBalanceException | AccountNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("\nDanh sách tài khoản:");
                    for (BankAccount account : manager.getAccounts()) {
                        System.out.println(account);
                    }
                    break;

                default:
                    System.out.println("Lỗi: Chức năng không hợp lệ! Vui lòng chọn từ 1-5.");
            }
        }

        scanner.close();
    }
}