import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bt5 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Nhập số lượng muốn nhập vào: ");
        int n = scanner.nextInt();
        List<String> listNames =  new ArrayList<>();
        System.out.println("Nhập đê: ");
        for(int i=0;i<n;i++){
            String name = scanner.next();
            listNames.add(name);
        }
        int count = 0;
        for(String listName: listNames){
            if (listName.startsWith("A") && listName.length()>=5){
                count++;
            }
        }
        System.out.println(count);
    }
}
