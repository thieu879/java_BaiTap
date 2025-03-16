package Bt6;

public class Zoo {
    private Animal[] animals;
    private int count;
    public Zoo() {
        animals = new Animal[2];
        count = 0;
    }
    public void addAnimal(Animal animal) {
        if(count < animals.length) {
            animals[count] = animal;
            count++;
        }else {
            System.out.println("Animal Đầy rồi");
        }
    }
    public void printAnimals() {
        for(int i = 0; i < animals.length; i++) {
            animals[i].displayInfo();
            animals[i].sound();
            animals[i].move();
        }
    }
}
