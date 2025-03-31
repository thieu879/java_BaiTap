package Bt5;

public class Writer extends Thread {
    private SharedData sharedData;
    private String message;

    public Writer(SharedData sharedData, String message) {
        this.sharedData = sharedData;
        this.message = message;
    }

    @Override
    public void run() {
        sharedData.writeMessage(message);
    }
}