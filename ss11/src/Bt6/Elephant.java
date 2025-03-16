package Bt6;

public class Elephant extends Animal{

    public Elephant(int age, String name) {
        super(age, name);
    }

    @Override
    public void sound() {
        System.out.println("Trumpet!");
    }

    @Override
    public void move() {
        System.out.println("The elephant is walking.");
    }
}
