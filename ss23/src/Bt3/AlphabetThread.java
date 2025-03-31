package Bt3;

public class AlphabetThread extends Thread {
    private SharedResource resource;

    public AlphabetThread(SharedResource resource, String name) {
        super(name);
        this.resource = resource;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " bắt đầu");
        resource.printAlphabet();
        System.out.println(Thread.currentThread().getName() + " kết thúc");
    }
}