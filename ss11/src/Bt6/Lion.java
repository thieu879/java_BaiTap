package Bt6;

public class Lion extends Animal{

    public Lion(int age, String name) {
        super(age, name);
    }

    @Override
    public void sound() {
        System.out.println("Roar!");
    }

    @Override
    public void move() {
        System.out.println("The lion is running.");
    }
}
