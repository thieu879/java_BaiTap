package Bt7;

public class Main {
    public static void main(String[] args) {
        Employee fullTime = new FullTimeEmployee("Nguyễn Văn A",100);
        Employee partTime = new PartTimeEmployee("Nguyễn Văn B",50,5);

        System.out.println(fullTime.getName() + " có lương là: " + fullTime.calculateSalary());
        System.out.println(partTime.getName() + " có lương là: " + partTime.calculateSalary());
    }
}
