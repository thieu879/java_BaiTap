package Bt8;

public class main {
    public static void main(String[] args) {
        Animals dog = new Dog("Buddy", 3, "Golden Retriever");
        Animals cat = new Cat("Kitty", 2, "Trắng");

        Animals[] animals = {dog, cat};

        for (Animals animal : animals) {
            System.out.println(animal.getDetails());
            System.out.println("Âm thanh: " + animal.makeSound());
        }
    }
}
