import java.util.regex.Pattern;

public class RegularExpression {
    public static void main(String[] args) {
        // so sánh 2 chuổi biểu thức chính quy (regex) và chuổi đâ vào input
        String regex = "(09|03|05)\\d{8}";
        String input = "0912345678";
        System.out.println("Kết quae so khớp của regex và input1: "+ Pattern.matches(regex, input));
        String input2 = "091234567";
        System.out.println("Kết quae so khớp của regex và input2: "+ Pattern.matches(regex, input2));
        System.out.println(Pattern.matches("[^^abcj]ava", "java"));
    }
}
