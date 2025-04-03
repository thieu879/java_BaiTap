package Bt2;

public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng factory
        AnimalFactory factory = new AnimalFactory();

        // Tạo các đối tượng Animal thông qua factory
        Animal dog = factory.createAnimal("dog");
        Animal cat = factory.createAnimal("cat");
        // Thử với loại không tồn tại
        Animal unknown = factory.createAnimal("bird");

        System.out.println("Dog says:");
        if (dog != null) {
            dog.speak();
        }

        System.out.println("Cat says:");
        if (cat != null) {
            cat.speak();
        }

        System.out.println("Unknown animal (bird):");
        if (unknown != null) {
            unknown.speak();
        } else {
            System.out.println("This animal type is not supported!");
        }
    }
}
