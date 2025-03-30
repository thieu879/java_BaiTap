import java.util.Scanner;

public class Bt2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int[] arr = {1,2,3,4,5,6};
            System.out.println("Nhập vị trí của số muốn hiển thị: ");
            int n = sc.nextInt();
            System.out.println(arr[n]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Vị trí không tồn tại trong mảng");
        }
        catch (NumberFormatException e){
            System.err.println("Không đúng định dạng");
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("Bye bye");
        }
    }
}
