package Bt4;

public class MyThread extends Thread {
    private int threadType;
    private Thread threadToWaitFor;

    public MyThread(String name, int threadType, Thread threadToWaitFor) {
        super(name);
        this.threadType = threadType;
        this.threadToWaitFor = threadToWaitFor;
    }

    @Override
    public void run() {
        if (threadType == 1) {
            // Thread 1: In số từ 1 đến 5, mỗi số cách nhau 1 giây
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 1: " + i);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread 1 kết thúc.");
        } else {
            // Thread 2 hoặc Thread 3: Chờ Thread 1 kết thúc rồi in thông báo
            try {
                threadToWaitFor.join(); // Chờ Thread 1 kết thúc
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread " + threadType + " bắt đầu...");
        }
    }
}
