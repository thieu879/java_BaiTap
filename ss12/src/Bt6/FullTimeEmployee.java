package Bt6;

public class FullTimeEmployee extends Employee {
    private double bonus;

    public FullTimeEmployee(String name, int age, double basicSalary, double bonus) {
        super(name, age, basicSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + bonus;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Thưởng: " + bonus);
        System.out.println("Tổng lương: " + calculateSalary());
    }
}

