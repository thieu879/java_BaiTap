import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Bt6 {
    public static void main(String[] args) {
        Map<String, Double> studentScores = new LinkedHashMap<>();
        studentScores.put("An", 7.5);
        studentScores.put("Binh", 8.0);
        studentScores.put("Chi", 6.5);
        studentScores.put("Duc", 4.5);
        studentScores.put("Em", 9.0);
        studentScores.put("Hoa", 3.5);
        studentScores.put("Khanh", 7.0);
        studentScores.put("Lam", 5.5);
        studentScores.put("Minh", 6.0);
        studentScores.put("Nhi", 4.0);
        for(Map.Entry<String, Double> entry : studentScores.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        double sum = 0;
        for(Map.Entry<String, Double> entry : studentScores.entrySet()) {
            sum+=entry.getValue();
        }
        double average = sum/studentScores.size();
        System.out.println("Điểm trung bình là: " + average);
        Iterator<Map.Entry<String, Double>> iterator = studentScores.entrySet().iterator();
        while(iterator.hasNext()) {
            if(iterator.next().getValue()<5) {
                iterator.remove();
            }
        }
        for(Map.Entry<String, Double> entry : studentScores.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
