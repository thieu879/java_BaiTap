package Bt1;

public class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Thread đang chạy: " + Thread.currentThread().getName());
    }
}
