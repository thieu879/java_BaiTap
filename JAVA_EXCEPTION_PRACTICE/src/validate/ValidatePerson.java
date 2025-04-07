package validate;

import entity.Person;

import java.util.List;

public class ValidatePerson {
    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty() && name.length() <= 150;
    }

    public static boolean isValidAge(int age) {
        return age >= 18;
    }

    public static boolean isValidAddress(String address) {
        return address != null && !address.trim().isEmpty();
    }

    public static boolean isValidPhone(String phone, List<? extends Person> persons) {
        if (phone == null || !phone.matches("^0[35789]\\d{8}$")) {
            return false;
        }
        return persons.stream().noneMatch(p -> p.getPhone().equals(phone));
    }

    public static boolean isValidEmail(String email, List<? extends Person> persons) {
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            return false;
        }
        return persons.stream().noneMatch(p -> p.getEmail().equals(email));
    }
}
