package Bt7;

public class Student {
    private String name;
    private String id;
    private double gpa;

    public Student(double gpa, String id, String name) {
        this.gpa = gpa;
        this.id = id;
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDetails(){
        return name + " || " + id + " || " + gpa;
    }

}
