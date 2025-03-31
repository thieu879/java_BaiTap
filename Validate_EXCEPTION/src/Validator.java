import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^(0[3|5|7|8|9])+([0-9]{8})$");

    public static Integer validateInteger(String input) throws NumberFormatException {
        return Integer.parseInt(input.trim());
    }

    public static Float validateFloat(String input) throws NumberFormatException {
        return Float.parseFloat(input.trim());
    }

    public static Double validateDouble(String input) throws NumberFormatException {
        return Double.parseDouble(input.trim());
    }

    public static Boolean validateBoolean(String input) throws IllegalArgumentException {
        if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
            return Boolean.parseBoolean(input.trim());
        }
        throw new IllegalArgumentException("Lỗi kiểu dữ liệu boolean");
    }

    public static String validateString(String input, int min, int max) throws IllegalArgumentException {
        String trimmed = input.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("Không theer rỗng");
        }
        if (trimmed.length() < min || trimmed.length() > max) {
            throw new IllegalArgumentException("có độ dài từ " + min + " và " + max + " ký tự.");
        }
        return trimmed;
    }

    public static String validateEmail(String input) throws IllegalArgumentException {
        if (!EMAIL_PATTERN.matcher(input.trim()).matches()) {
            throw new IllegalArgumentException("lỗi k đúng định dạng email");
        }
        return input.trim();
    }

    public static String validatePhone(String input) throws IllegalArgumentException {
        if (!PHONE_PATTERN.matcher(input.trim()).matches()) {
            throw new IllegalArgumentException("Không đúng định dạng số điện thoại VN");
        }
        return input.trim();
    }
}
