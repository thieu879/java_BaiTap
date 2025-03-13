package Bt8;

class Cat extends Animals {
    private String furColor;

    public Cat(String name, int age, String furColor) {
        super(name, age);
        this.furColor = furColor;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " | Màu lông: " + furColor;
    }

    @Override
    public String makeSound() {
        return "Meow Meow";
    }
}
