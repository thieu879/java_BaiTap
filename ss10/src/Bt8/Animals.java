package Bt8;

class Animals {
    private String name;
    private int age;

    public Animals(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getDetails() {
        return "Tên: " + name + " | Tuổi: " + age;
    }

    public String makeSound() {
        return "Some generic sound";
    }
}
