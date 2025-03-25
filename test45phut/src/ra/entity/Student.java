package ra.entity;

public class Student {
    private String idStudent;
    private String nameStudent;
    private int age;
    private float averageGrade;

    public  Student() {}
    public Student(int age, float averageGrade, String idStudent, String nameStudent) {
        this.age = age;
        this.averageGrade = averageGrade;
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(float averageGrade) {
        this.averageGrade = averageGrade;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }
    @Override
    public String toString() {
        return "idStudent=" + idStudent + ", nameStudent=" + nameStudent + ", age=" + age + ", averageGrade=" + averageGrade;
    }
}
