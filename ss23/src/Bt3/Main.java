package Bt3;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        AlphabetThread thread1 = new AlphabetThread(sharedResource, "Thread-1");
        AlphabetThread thread2 = new AlphabetThread(sharedResource, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
