package Bt8;

class Dog extends Animals {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " | Giống: " + breed;
    }

    @Override
    public String makeSound() {
        return "Woof Woof";
    }
}
