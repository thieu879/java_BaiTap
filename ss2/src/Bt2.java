public class Bt2 {
    public static void main(String[] args) {
        float a = 3;
        float b = 5;
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        if (b != 0) {
            System.out.println(a / b);
            System.out.println(a % b);
        } else {
            System.out.println("Không thể thực hiện phép chia và chia lấy dư vì b = 0.");
        }
    }
}
