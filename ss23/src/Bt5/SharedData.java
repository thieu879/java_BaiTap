package Bt5;

public class SharedData {
    private String message;
    private boolean isMessageReady = false;

    // Phương thức để Writer ghi tin nhắn
    public synchronized void writeMessage(String msg) {
        System.out.println("Writer đang gửi tin nhắn...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.message = msg;
        System.out.println("Writer đã gửi: " + msg);
        isMessageReady = true;
        notify();
    }

    // Phương thức để Reader đọc tin nhắn
    public synchronized void readMessage() {
        // Đợi nếu tin nhắn chưa sẵn sàng
        while (!isMessageReady) {
            try {
                System.out.println("Reader đang đợi tin nhắn...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Reader nhận được: " + message);
    }
}