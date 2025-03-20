import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Bt1{
    public static void main(String[] args) {
        ArrayList<String> studentList = new ArrayList<>();
        studentList.add("Nguyễn Văn A");
        studentList.add("Nguyễn Văn B");
        studentList.add("Nguyễn Văn C");
        studentList.add("Nguyễn Văn D");
        studentList.add("Nguyễn Văn E");
        for (String student : studentList) {
            System.out.println(student);
        }
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }
        Iterator<String> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
