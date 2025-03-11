public class Bt9 {
    static class Fraction {
        private int numerator;
        private int denominator;

        public Fraction(int numerator, int denominator) {
            if (denominator == 0) {
                throw new IllegalArgumentException("Mẫu số không thể bằng 0");
            }
            int gcd = findGCD(numerator, denominator);
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;
        }

        private int findGCD(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

        public Fraction add(Fraction other) {
            int num = this.numerator * other.denominator + other.numerator * this.denominator;
            int den = this.denominator * other.denominator;
            return new Fraction(num, den);
        }

        public Fraction subtract(Fraction other) {
            int num = this.numerator * other.denominator - other.numerator * this.denominator;
            int den = this.denominator * other.denominator;
            return new Fraction(num, den);
        }

        public Fraction multiply(Fraction other) {
            int num = this.numerator * other.numerator;
            int den = this.denominator * other.denominator;
            return new Fraction(num, den);
        }

        public Fraction divide(Fraction other) {
            if (other.numerator == 0) {
                throw new ArithmeticException("Không thể chia cho phân số có tử số bằng 0");
            }
            int num = this.numerator * other.denominator;
            int den = this.denominator * other.numerator;
            return new Fraction(num, den);
        }

        public String toString() {
            return numerator + "/" + denominator;
        }
    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(3, 4);
        Fraction f2 = new Fraction(2, 5);

        System.out.println("Phân số 1: " + f1);
        System.out.println("Phân số 2: " + f2);

        System.out.println("Cộng: " + f1.add(f2));
        System.out.println("Trừ: " + f1.subtract(f2));
        System.out.println("Nhân: " + f1.multiply(f2));
        System.out.println("Chia: " + f1.divide(f2));
    }
}
