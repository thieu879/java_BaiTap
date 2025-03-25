import java.util.function.Function;

public class Bt2 {
    public static void main(String[] args) {
        Function<Integer, Integer> fx = x -> x * x + 3 * x + 2;
        System.out.println("f(1): " + fx.apply(1));
        System.out.println("f(2): " + fx.apply(2));
        System.out.println("f(3): " + fx.apply(3));
    }
}
