package Bt4;

public class Main {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("Thread-1", 1, null);
        MyThread thread2 = new MyThread("Thread-2", 2, thread1);
        MyThread thread3 = new MyThread("Thread-3", 3, thread1);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
