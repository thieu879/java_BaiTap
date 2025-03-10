public class Bt2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello, Java World!");
        System.out.println(sb.toString());
        sb.delete(5, 9);
        System.out.println(sb.toString());
        int indexSearch = sb.indexOf("World");
        sb.replace(indexSearch, indexSearch + 5, "Universe");
        System.out.println(sb.toString());
    }
}
