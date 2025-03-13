package Bt10;

public class Main {
    public static void main(String[] args) {
        // Khai báo mảng chứa các hình học
        Shape[] shapes = {
                new Circle("Hình tròn",5),
                new Rectangle(4, 6),
                new Triangle(3, 4, 5)
        };

        // Hiển thị thông tin từng hình bằng vòng lặp for
        System.out.println("Danh sách các hình học:");
        for (int i = 0; i < shapes.length; i++) {
            System.out.println(shapes[i]);
        }
    }
}
