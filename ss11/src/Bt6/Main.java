package Bt6;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        Lion lion = new Lion(10,"lion");
        Elephant elephant = new Elephant(10,"elephant");
        zoo.addAnimal(lion);
        zoo.addAnimal(elephant);
        zoo.printAnimals();
    }
}
