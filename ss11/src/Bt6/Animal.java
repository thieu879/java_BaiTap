package Bt6;

public abstract class Animal {
    protected String name;
    protected int age;

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public abstract void sound();
    public abstract void move();
    public void displayInfo(){
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
