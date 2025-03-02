public class Bt4 {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        boolean c = true;

        if (a && b) {
            System.out.println("Cả hai đều đúng");
        } else {
            System.out.println("Cả hai không đúng");
        }

        if (a || b) {
            System.out.println("Ít nhất một đúng");
        } else {
            System.out.println("Cả hai đều sai");
        }

        if (!a && b) {
            System.out.println("Không đúng");
        }

        System.out.println("Giá trị ban đầu của c: " + c);
        c = !c;
        System.out.println("Giá trị sau khi đảo ngược của c: " + c);

        if ((a && !b) || (!a && b)) {
            System.out.println("Một trong hai đúng, nhưng không phải cả hai");
        }

        if (!(a || b)) {
            System.out.println("Cả hai đều sai");
        } else {
            System.out.println("Có ít nhất một đúng");
        }
    }
}
