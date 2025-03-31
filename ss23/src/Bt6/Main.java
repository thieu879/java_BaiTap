package Bt6;

public class Main {
    public static void main(String[] args) {
        // Tạo 3 luồng với các mức ưu tiên khác nhau
        PriorityThread thread1 = new PriorityThread("Thread-1");
        PriorityThread thread2 = new PriorityThread("Thread-2");
        PriorityThread thread3 = new PriorityThread("Thread-3");

        // Thiết lập mức ưu tiên
        thread1.setPriority(Thread.MIN_PRIORITY); // Ưu tiên thấp nhất (1)
        thread2.setPriority(Thread.NORM_PRIORITY); // Ưu tiên trung bình (5)
        thread3.setPriority(Thread.MAX_PRIORITY); // Ưu tiên cao nhất (10)

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
