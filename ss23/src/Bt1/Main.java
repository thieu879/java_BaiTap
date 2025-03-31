package Bt1;

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.setName("Thread1");
        t2.setName("Thread2");
        t1.start();
        t2.start();
    }
}
