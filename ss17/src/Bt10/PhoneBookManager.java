package Bt10;
import java.util.*;

public class PhoneBookManager {
    private Set<Contact> phoneBook;

    public PhoneBookManager() {
        phoneBook = new HashSet<>();
    }

    public boolean addContact(String name, String phoneNumber) {
        Contact newContact = new Contact(name, phoneNumber);
        if (phoneBook.contains(newContact)) {
            System.out.println("Số điện thoại " + phoneNumber + " đã tồn tại!");
            return false;
        }
        boolean added = phoneBook.add(newContact);
        if (added) {
            System.out.println("Đã thêm liên lạc: " + newContact);
        }
        return added;
    }

    public boolean removeContact(String phoneNumber) {
        Contact temp = new Contact("", phoneNumber);
        if (phoneBook.remove(temp)) {
            System.out.println("Đã xóa liên lạc với số " + phoneNumber);
            return true;
        } else {
            System.out.println("Không tìm thấy liên lạc với số " + phoneNumber);
            return false;
        }
    }

    public Contact findContact(String phoneNumber) {
        Contact temp = new Contact("", phoneNumber);
        for (Contact contact : phoneBook) {
            if (contact.equals(temp)) {
                return contact;
            }
        }
        return null;
    }

    public void printAllContacts() {
        if (phoneBook.isEmpty()) {
            System.out.println("Danh bạ trống!");
            return;
        }
        System.out.println("\nDanh sách liên lạc:");
        for (Contact contact : phoneBook) {
            System.out.println(contact);
        }
        System.out.println("Tổng số liên lạc: " + phoneBook.size());
    }

    public static void main(String[] args) {
        PhoneBookManager manager = new PhoneBookManager();
        Scanner scanner = new Scanner(System.in);

        manager.addContact("Nguyen Van A", "0912345678");
        manager.addContact("Tran Thi B", "0987654321");
        manager.addContact("Le Van C", "0933445566");

        manager.addContact("Test", "0912345678");

        manager.printAllContacts();

        System.out.println("\nNhập số điện thoại cần tìm: ");
        String searchNumber = scanner.nextLine();
        Contact found = manager.findContact(searchNumber);
        System.out.println(found != null ? "Tìm thấy: " + found : "Không tìm thấy!");

        System.out.println("\nNhập số điện thoại cần xóa: ");
        String removeNumber = scanner.nextLine();
        manager.removeContact(removeNumber);

        manager.printAllContacts();

        scanner.close();
    }
}