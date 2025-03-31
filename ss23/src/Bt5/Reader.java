package Bt5;

public class Reader extends Thread {
    private SharedData sharedData;

    public Reader(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        sharedData.readMessage();
    }
}
