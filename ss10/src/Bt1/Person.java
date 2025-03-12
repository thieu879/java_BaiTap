package Bt1;
//      1. Tính đóng gói là gì? Tại sao tính đóng gói lại quan trọng trong lập trình đối tượng?
//Tính đóng gói (Encapsulation) là một trong bốn nguyên tắc cơ bản của lập trình hướng đối tượng (OOP),
//cùng với Kế thừa (Inheritance), Đa hình (Polymorphism) và Trừu tượng (Abstraction). Tính đóng gói đề
//cập đến việc ẩn chi tiết triển khai bên trong của một đối tượng và chỉ cung cấp quyền truy cập thông
//qua các phương thức công khai (public methods). Trong Java, điều này thường được thực hiện bằng cách:
//Đặt các thuộc tính (fields) của lớp ở trạng thái private để chúng không thể bị truy cập trực tiếp từ bên ngoài.
//Cung cấp các phương thức công khai (thường là getter và setter) để tương tác với các thuộc tính đó.
//  Tại sao tính đóng gói quan trọng?
//Bảo vệ dữ liệu: Ngăn chặn việc thay đổi trực tiếp hoặc không kiểm soát vào dữ liệu từ bên ngoài, giúp dữ liệu luôn ở trạng thái hợp lệ.
//Tính linh hoạt: Cho phép thay đổi cách triển khai bên trong lớp mà không ảnh hưởng đến mã sử dụng lớp đó.
//Dễ bảo trì: Giảm sự phụ thuộc giữa các phần của chương trình, giúp việc sửa lỗi hoặc mở rộng mã dễ dàng hơn.
//Tính module hóa: Tách biệt các thành phần, giúp mã dễ hiểu và tái sử dụng.
//      2. Làm thế nào để áp dụng tính đóng gói trong Java? Giải thích cách sử dụng getter và setter.
//Trong Java, tính đóng gói được áp dụng bằng cách:
//Sử dụng từ khóa private cho các thuộc tính để hạn chế truy cập trực tiếp.
//Tạo các phương thức công khai getter để lấy giá trị của thuộc tính và setter để thay đổi giá trị của thuộc tính, thường kèm theo kiểm tra hợp lệ nếu cần.
//Getter: Là phương thức trả về giá trị của một thuộc tính private.
//Cú pháp: public <kiểu_dữ_liệu> get<Tên_Thuộc_Tính>()
//Setter: Là phương thức cho phép thay đổi giá trị của một thuộc tính private.
//Cú pháp: public void set<Tên_Thuộc_Tính>(<kiểu_dữ_liệu> giá_trị)
//Ví dụ: Nếu có thuộc tính private String name, bạn sẽ có:
//public String getName() để lấy giá trị name.
//public void setName(String name) để thay đổi giá trị name.
//      3. Ví dụ về cách sử dụng tính đóng gói trong một lớp
public class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name != null && !name.isEmpty()) { // Kiểm tra hợp lệ
            this.name = name;
        } else {
            System.out.println("Tên không hợp lệ!");
        }
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if (age >= 0 && age <= 150) { // Kiểm tra hợp lệ
            this.age = age;
        } else {
            System.out.println("Tuổi không hợp lệ!");
        }
    }
    public static void main(String[] args) {
        Person person = new Person("Nguyen Van A", 25);
        System.out.println("Tên: " + person.getName());
        System.out.println("Tuổi: " + person.getAge());
        person.setName("");
        person.setAge(30);
        System.out.println("Tên mới: " + person.getName());
        System.out.println("Tuổi mới: " + person.getAge());
    }
}
//      4.Lợi ích của việc sử dụng tính đóng gói trong bảo vệ dữ liệu và kiểm soát quyền truy cập
//Bảo vệ dữ liệu:
//Ngăn chặn việc thay đổi dữ liệu trực tiếp từ bên ngoài, tránh lỗi do dữ liệu không hợp lệ
//(như tuổi âm trong ví dụ trên).
//Chỉ có các phương thức trong lớp mới được phép thay đổi dữ liệu, giúp duy trì tính toàn vẹn.
//Kiểm soát quyền truy cập:
//Có thể giới hạn quyền truy cập bằng cách chỉ cung cấp getter mà không cung cấp setter (dữ liệu chỉ đọc).
//Có thể thêm logic kiểm tra trong setter để từ chối các giá trị không mong muốn.
//Tính linh hoạt và bảo trì:
//Nếu cần thay đổi cách lưu trữ dữ liệu (ví dụ: đổi age từ int sang String), chỉ cần chỉnh sửa trong lớp mà không ảnh hưởng đến mã bên ngoài sử dụng lớp đó.
//Dễ dàng thêm logic xử lý trong getter/setter mà không cần thay đổi giao diện công khai.
//Ẩn chi tiết triển khai:
//Người dùng lớp không cần biết dữ liệu được lưu trữ và xử lý như thế nào bên trong, chỉ cần gọi các phương thức công khai.