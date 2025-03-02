public class Bt3 {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        boolean equals =  a == b;
        boolean notEquals =  a != b;
        boolean greaterThan = a>b;
        boolean lessThan = a<b;
        boolean greaterThanOrEqualTo = a>=b;
        boolean lessThanOrEqualTo = a<=b;
        System.out.println("equals: " + equals);
        System.out.println("notEquals: " + notEquals);
        System.out.println("greaterThan: " + greaterThan);
        System.out.println("lessThan: " + lessThan);
        System.out.println("greaterThanOrEqualTo: " + greaterThanOrEqualTo);
        System.out.println("lessThanOrEqualTo: " + lessThanOrEqualTo);

        if (a>b) {
            System.out.println("a lớn hơn b");
        }
        if (a==b) {
            System.out.println("a bằng b");
        }
        if (a!=b){
            System.out.println("a khác b");
        }
        double c = 3.5;
        double d = 4.2;
        System.out.println(c > d);

        String str = "Hello,";
        String str2 = "java";
        System.out.println(str.equals(str2));
        System.out.println(!str.equals(str2));
    }
}
