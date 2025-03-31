package Bt6;

public class PriorityThread extends Thread {
    public PriorityThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " (Priority: " + getPriority() + ") - Lần: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " đã hoàn thành.");
    }
}
//Không, mức độ ưu tiên không đảm bảo 100% thứ tự thực thi.
//Lý do:
//Mức ưu tiên chỉ là gợi ý cho bộ lập lịch của JVM và hệ điều hành, nhưng không bắt buộc.
//Bộ lập lịch có thể ưu tiên các yếu tố khác (như tính công bằng, tài nguyên hệ thống).
//Hành vi phụ thuộc vào hệ điều hành và JVM, dẫn đến kết quả không nhất quán.
//Các yếu tố như sleep(), I/O, hoặc chờ tài nguyên có thể làm thay đổi thứ tự thực thi.
