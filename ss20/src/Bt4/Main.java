package Bt4;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person( LocalDate.of(2000, 3, 25), "Quý"),
                new Person( LocalDate.of(1998, 7, 10), "Lan"),
                new Person( LocalDate.of(2005, 12, 1), "Minh")
        );
        for(Person person : people){
            person.printInfo();
        }
    }
}
