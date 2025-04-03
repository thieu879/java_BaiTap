package Bt2;

public class AnimalFactory {
    public Animal createAnimal(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("cat")) {
            return new Cat();
        }else if (type.equalsIgnoreCase("dog")) {
            return new Dog();
        }
        return null;
    }
}
